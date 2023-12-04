/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.v1.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.http.protobuf.ProtoHttpContent;
import com.google.api.client.util.Charsets;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLite;
import com.google.rpc.Code;
import com.google.rpc.Status;
import com.google.testing.junit.testparameterinjector.TestParameter;
import com.google.testing.junit.testparameterinjector.TestParameterInjector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.GZIPOutputStream;
import org.junit.Test;
import org.junit.runner.RunWith;

/** Test for {@link RemoteRpc}. */
@RunWith(TestParameterInjector.class)
public class RemoteRpcTest {

  private static final String METHOD_NAME = "methodName";

  @Test
  public void testException() {
    Status statusProto =
        Status.newBuilder()
            .setCode(Code.UNAUTHENTICATED_VALUE)
            .setMessage("The request does not have valid authentication credentials.")
            .build();
    DatastoreException exception =
        RemoteRpc.makeException(
            "url",
            METHOD_NAME,
            new ByteArrayInputStream(statusProto.toByteArray()),
            "application/x-protobuf",
            Charsets.UTF_8,
            new RuntimeException(),
            401);
    assertEquals(Code.UNAUTHENTICATED, exception.getCode());
    assertEquals(
        "The request does not have valid authentication credentials.", exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }

  @Test
  public void testInvalidProtoException() {
    DatastoreException exception =
        RemoteRpc.makeException(
            "url",
            METHOD_NAME,
            new ByteArrayInputStream("<invalid proto>".getBytes()),
            "application/x-protobuf",
            Charsets.UTF_8,
            new RuntimeException(),
            401);
    assertEquals(Code.INTERNAL, exception.getCode());
    assertEquals(
        "Unable to parse Status protocol buffer: HTTP status code was 401.",
        exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }

  @Test
  public void testEmptyProtoException() {
    Status statusProto = Status.newBuilder().build();
    DatastoreException exception =
        RemoteRpc.makeException(
            "url",
            METHOD_NAME,
            new ByteArrayInputStream(statusProto.toByteArray()),
            "application/x-protobuf",
            Charsets.UTF_8,
            new RuntimeException(),
            404);
    assertEquals(Code.INTERNAL, exception.getCode());
    assertEquals(
        "Unexpected OK error code with HTTP status code of 404. Message: .",
        exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }

  @Test
  public void testEmptyProtoExceptionUnauthenticated() {
    Status statusProto = Status.newBuilder().build();
    DatastoreException exception =
        RemoteRpc.makeException(
            "url",
            METHOD_NAME,
            new ByteArrayInputStream(statusProto.toByteArray()),
            "application/x-protobuf",
            Charsets.UTF_8,
            new RuntimeException(),
            401);
    assertEquals(Code.UNAUTHENTICATED, exception.getCode());
    assertEquals("Unauthenticated.", exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }

  @Test
  public void testPlainTextException() {
    DatastoreException exception =
        RemoteRpc.makeException(
            "url",
            METHOD_NAME,
            new ByteArrayInputStream("Text Error".getBytes()),
            "text/plain",
            Charsets.UTF_8,
            new RuntimeException(),
            401);
    assertEquals(Code.INTERNAL, exception.getCode());
    assertEquals(
        "Non-protobuf error: Text Error. HTTP status code was 401.", exception.getMessage());
    assertEquals(METHOD_NAME, exception.getMethodName());
  }

  @Test
  public void testGzip() throws IOException, DatastoreException {
    BeginTransactionResponse response = newBeginTransactionResponse();
    InjectedTestValues injectedTestValues =
        new InjectedTestValues(gzip(response), new byte[1], true);
    RemoteRpc rpc = newRemoteRpc(injectedTestValues);

    InputStream is =
        rpc.call("beginTransaction", BeginTransactionResponse.getDefaultInstance(), "", "");
    BeginTransactionResponse parsedResponse = BeginTransactionResponse.parseFrom(is);
    is.close();

    assertEquals(response, parsedResponse);
    // Check that the underlying stream is exhausted.
    assertEquals(-1, injectedTestValues.inputStream.read());
  }

  @Test
  public void testE2EChecksum(@TestParameter boolean reqEnabled, @TestParameter boolean respEnabled)
      throws IOException, DatastoreException {
    RemoteRpc.setSystemEnvE2EChecksum(reqEnabled, respEnabled);
    String projectId = "project-id";
    MessageLite request =
        RollbackRequest.newBuilder().setTransaction(ByteString.copyFromUtf8(projectId)).build();

    // Always return invalid response checksum to check that it will raise an exception only when
    // response checksum verification is enabled.
    List<MyHeader> respHeaders =
        Collections.singletonList(
            new MyHeader(
                EndToEndChecksumHandler.HTTP_RESPONSE_CHECKSUM_HEADER, "invalid_checksum"));

    Set<MyHeader> expectedRequestHeaders = new HashSet<>();
    expectedRequestHeaders.add(MyHeader.anyValue(RemoteRpc.API_FORMAT_VERSION_HEADER));

    if (reqEnabled) {
      expectedRequestHeaders.add(
          new MyHeader(
              EndToEndChecksumHandler.HTTP_REQUEST_CHECKSUM_HEADER,
              EndToEndChecksumHandler.computeChecksum(request.toByteArray())));
    } else {
      expectedRequestHeaders.add(
          MyHeader.anyValue(EndToEndChecksumHandler.HTTP_REQUEST_CHECKSUM_HEADER).mustNotExist());
    }

    InjectedTestValues testVals =
        new InjectedTestValues(
            gzip(newBeginTransactionResponse()),
            new byte[1],
            true,
            respHeaders,
            expectedRequestHeaders);
    RemoteRpc rpc = newRemoteRpc(testVals);

    InputStream stream = rpc.call("someMethod", request, projectId, "");
    byte[] buf = new byte[1000];
    if (respEnabled) {
      // Must throw an IOException when verifying response checksum because we provided an invalid
      // checksum in the response header.
      assertThrows(
          IOException.class,
          () -> {
            while (stream.read(buf, 0, 1000) != -1) {
              // Do nothing with the bytes read.
            }
          });
    } else {
      // Must not raise an exception even with invalid response checksum because we did not enable
      // response checksum verification.
      while (stream.read(buf, 0, 1000) != -1) {
        // Do nothing with the bytes read.
      }
    }
  }

  @Test
  public void testE2EChecksum_validResponseChecksum() throws IOException, DatastoreException {
    RemoteRpc.setSystemEnvE2EChecksum(false, true);
    String projectId = "project-id";
    MessageLite request =
        RollbackRequest.newBuilder().setTransaction(ByteString.copyFromUtf8(projectId)).build();

    BeginTransactionResponse response = newBeginTransactionResponse();

    List<MyHeader> respHeaders =
        Collections.singletonList(
            new MyHeader(
                EndToEndChecksumHandler.HTTP_RESPONSE_CHECKSUM_HEADER,
                EndToEndChecksumHandler.computeChecksum(response.toByteArray())));

    InjectedTestValues testVals =
        new InjectedTestValues(gzip(response), new byte[1], true, respHeaders);
    RemoteRpc rpc = newRemoteRpc(testVals);

    InputStream stream = rpc.call("someMethod", request, projectId, "");
    byte[] buf = new byte[1000];
    // Must not raise an exception.
    while (stream.read(buf, 0, 1000) != -1) {
      // Do nothing with the bytes read.
    }
  }

  @Test
  public void testHttpHeaders_prefixHeader() throws IOException {
    String projectId = "my-project";
    String databaseId = "my-db";
    MessageLite request =
        RollbackRequest.newBuilder()
            .setTransaction(ByteString.copyFromUtf8(projectId))
            .setDatabaseId(databaseId)
            .build();
    RemoteRpc rpc =
        newRemoteRpc(
            new InjectedTestValues(gzip(newBeginTransactionResponse()), new byte[1], true));
    HttpRequest httpRequest =
        rpc.getClient().buildPostRequest(rpc.resolveURL("blah"), new ProtoHttpContent(request));
    rpc.setHeaders(request, httpRequest, projectId, databaseId);
    assertEquals(
        "project_id=my-project&database_id=my-db",
        httpRequest.getHeaders().get(RemoteRpc.X_GOOG_REQUEST_PARAMS_HEADER));

    MessageLite request2 =
        RollbackRequest.newBuilder().setTransaction(ByteString.copyFromUtf8(projectId)).build();
    RemoteRpc rpc2 =
        newRemoteRpc(
            new InjectedTestValues(gzip(newBeginTransactionResponse()), new byte[1], true));
    HttpRequest httpRequest2 =
        rpc2.getClient().buildPostRequest(rpc2.resolveURL("blah"), new ProtoHttpContent(request2));
    rpc2.setHeaders(request, httpRequest2, projectId, "");
    assertEquals(
        "project_id=my-project",
        httpRequest2.getHeaders().get(RemoteRpc.X_GOOG_REQUEST_PARAMS_HEADER));
  }

  private static BeginTransactionResponse newBeginTransactionResponse() {
    return BeginTransactionResponse.newBuilder()
        .setTransaction(ByteString.copyFromUtf8("blah-blah-blah"))
        .build();
  }

  private static RemoteRpc newRemoteRpc(InjectedTestValues injectedTestValues) {
    return new RemoteRpc(
        new MyHttpTransport(injectedTestValues).createRequestFactory(),
        null,
        "https://www.example.com/v1/projects/p");
  }

  private byte[] gzip(BeginTransactionResponse response) throws IOException {
    ByteArrayOutputStream bytesOut = new ByteArrayOutputStream();
    try (GZIPOutputStream gzipOut = new GZIPOutputStream(bytesOut)) {
      response.writeTo(gzipOut);
    }
    return bytesOut.toByteArray();
  }

  private static class InjectedTestValues {
    private final InputStream inputStream;
    private final int contentLength;
    private final boolean isGzip;
    private final List<MyHeader> responseHeaders;
    private final Set<MyHeader> expectedRequestHeaders;

    public InjectedTestValues(byte[] messageBytes, byte[] additionalBytes, boolean isGzip) {
      this(
          messageBytes,
          additionalBytes,
          isGzip,
          new ArrayList<MyHeader>(),
          new HashSet<MyHeader>());
    }

    public InjectedTestValues(
        byte[] messageBytes,
        byte[] additionalBytes,
        boolean isGzip,
        List<MyHeader> responseHeaders) {
      this(messageBytes, additionalBytes, isGzip, responseHeaders, new HashSet<MyHeader>());
    }

    public InjectedTestValues(
        byte[] messageBytes,
        byte[] additionalBytes,
        boolean isGzip,
        List<MyHeader> responseHeaders,
        Set<MyHeader> expectedRequestHeaders) {
      byte[] allBytes = concat(messageBytes, additionalBytes);
      this.inputStream = new ByteArrayInputStream(allBytes);
      this.contentLength = allBytes.length;
      this.isGzip = isGzip;
      this.responseHeaders = responseHeaders;
      this.expectedRequestHeaders = expectedRequestHeaders;
    }

    private static byte[] concat(byte[] a, byte[] b) {
      byte[] c = new byte[a.length + b.length];
      System.arraycopy(a, 0, c, 0, a.length);
      System.arraycopy(b, 0, c, a.length, b.length);
      return c;
    }
  }

  /** {@link HttpTransport} that allows injection of the returned {@link LowLevelHttpRequest}. */
  private static class MyHttpTransport extends HttpTransport {

    private final InjectedTestValues injectedTestValues;

    public MyHttpTransport(InjectedTestValues injectedTestValues) {
      this.injectedTestValues = injectedTestValues;
    }

    @Override
    protected LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
      return new MyLowLevelHttpRequest(injectedTestValues);
    }
  }

  private static class MyHeader {
    private final String key;
    private final String value;
    private final boolean ignoreValue;
    private boolean mustExist;

    public static MyHeader anyValue(String key) {
      return new MyHeader(key, "", true);
    }

    public MyHeader(String key, String value) {
      this(key, value, false);
    }

    private MyHeader(String key, String value, boolean ignoreValue) {
      this.key = key.toLowerCase();
      this.value = value;
      this.ignoreValue = ignoreValue;
      this.mustExist = true;
    }

    public MyHeader mustNotExist() {
      mustExist = false;
      return this;
    }

    public boolean matches(MyHeader h) {
      return key.equals(h.key) && (h.ignoreValue || ignoreValue || value.equals(h.value));
    }

    public String toString() {
      String mustExistString = mustExist ? "" : "must not exist: ";
      if (ignoreValue) {
        return String.format("%s\"%s\": ANY", mustExistString, key);
      }
      return String.format("%s\"%s\": \"%s\"", mustExistString, key, value);
    }
  }

  /**
   * {@link LowLevelHttpRequest} that allows injection of the returned {@link LowLevelHttpResponse}.
   */
  private static class MyLowLevelHttpRequest extends LowLevelHttpRequest {

    private final InjectedTestValues injectedTestValues;

    private final List<MyHeader> requestHeaders = new ArrayList<>();

    public MyLowLevelHttpRequest(InjectedTestValues injectedTestValues) {
      this.injectedTestValues = injectedTestValues;
    }

    @Override
    public void addHeader(String name, String value) throws IOException {
      requestHeaders.add(new MyHeader(name, value));
    }

    private void assertHeaders() {
      if (injectedTestValues.expectedRequestHeaders.isEmpty()) {
        return;
      }

      Set<MyHeader> mustExist = new HashSet<>();
      List<MyHeader> mustNotExist = new ArrayList<>();
      for (MyHeader header : injectedTestValues.expectedRequestHeaders) {
        if (header.mustExist) {
          mustExist.add(header);
        } else {
          mustNotExist.add(header);
        }
      }

      for (MyHeader h : requestHeaders) {
        mustExist.removeIf(expected -> expected.matches(h));
      }

      if (!mustExist.isEmpty()) {
        throw new RuntimeException(
            "These request headers were expected but missing:\n"
                + mustExist
                + "\nThese headers were seen:\n"
                + requestHeaders);
      }

      for (MyHeader notExpected : mustNotExist) {
        for (MyHeader h : requestHeaders) {
          if (h.matches(notExpected)) {
            throw new RuntimeException(
                "Expected header " + notExpected.toString() + " but found: " + h.toString());
          }
        }
      }
    }

    @Override
    public LowLevelHttpResponse execute() throws IOException {
      assertHeaders();
      return new MyLowLevelHttpResponse(injectedTestValues);
    }
  }

  /** {@link LowLevelHttpResponse} that allows injected properties. */
  private static class MyLowLevelHttpResponse extends LowLevelHttpResponse {

    private final InjectedTestValues injectedTestValues;

    public MyLowLevelHttpResponse(InjectedTestValues injectedTestValues) {
      this.injectedTestValues = injectedTestValues;
    }

    @Override
    public InputStream getContent() throws IOException {
      return injectedTestValues.inputStream;
    }

    @Override
    public String getContentEncoding() throws IOException {
      return injectedTestValues.isGzip ? "gzip" : "";
    }

    @Override
    public long getContentLength() throws IOException {
      return injectedTestValues.contentLength;
    }

    @Override
    public String getContentType() throws IOException {
      return "application/x-protobuf";
    }

    @Override
    public String getStatusLine() throws IOException {
      return null;
    }

    @Override
    public int getStatusCode() throws IOException {
      return 200;
    }

    @Override
    public String getReasonPhrase() throws IOException {
      return null;
    }

    @Override
    public int getHeaderCount() throws IOException {
      return injectedTestValues.responseHeaders.size();
    }

    @Override
    public String getHeaderName(int index) throws IOException {
      return injectedTestValues.responseHeaders.get(index).key;
    }

    @Override
    public String getHeaderValue(int index) throws IOException {
      return injectedTestValues.responseHeaders.get(index).value;
    }
  }
}
