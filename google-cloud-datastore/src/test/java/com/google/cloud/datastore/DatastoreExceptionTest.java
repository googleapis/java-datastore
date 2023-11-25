/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import static com.google.common.truth.Truth.assertThat;
import static com.google.rpc.Code.FAILED_PRECONDITION;
import static java.util.Collections.singletonMap;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper;
import com.google.protobuf.Any;
import com.google.rpc.ErrorInfo;
import io.grpc.Status;
import java.io.IOException;
import java.net.SocketTimeoutException;
import org.junit.Test;

public class DatastoreExceptionTest {

  @Test
  public void testDatastoreException() {
    DatastoreException exception = new DatastoreException(10, "message", "ABORTED");
    assertEquals(10, exception.getCode());
    assertEquals("ABORTED", exception.getReason());
    assertEquals("message", exception.getMessage());
    assertTrue(exception.isRetryable());

    exception = new DatastoreException(4, "message", "DEADLINE_EXCEEDED");
    assertEquals(4, exception.getCode());
    assertEquals("DEADLINE_EXCEEDED", exception.getReason());
    assertEquals("message", exception.getMessage());
    assertTrue(exception.isRetryable());

    exception = new DatastoreException(14, "message", "UNAVAILABLE");
    assertEquals(14, exception.getCode());
    assertEquals("UNAVAILABLE", exception.getReason());
    assertEquals("message", exception.getMessage());
    assertTrue(exception.isRetryable());

    exception = new DatastoreException(2, "message", "INTERNAL");
    assertEquals(2, exception.getCode());
    assertEquals("INTERNAL", exception.getReason());
    assertEquals("message", exception.getMessage());
    assertFalse(exception.isRetryable());

    IOException cause = new SocketTimeoutException("socketTimeoutMessage");
    exception = new DatastoreException(cause);
    assertEquals(DatastoreException.UNKNOWN_CODE, exception.getCode());
    assertNull(exception.getReason());
    assertEquals("socketTimeoutMessage", exception.getMessage());
    assertEquals(cause, exception.getCause());
    assertTrue(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new DatastoreException(2, "message", "INTERNAL", cause);
    assertEquals(2, exception.getCode());
    assertEquals("INTERNAL", exception.getReason());
    assertEquals("message", exception.getMessage());
    assertFalse(exception.isRetryable());
    assertSame(cause, exception.getCause());

    exception = new DatastoreException(2, "message", "INTERNAL", true, cause);
    assertEquals(2, exception.getCode());
    assertEquals("INTERNAL", exception.getReason());
    assertEquals("message", exception.getMessage());
    assertFalse(exception.isRetryable());
    assertSame(cause, exception.getCause());

    ApiException apiException =
        new ApiException("message", cause, GrpcStatusCode.of(Status.Code.NOT_FOUND), true);
    exception = new DatastoreException(apiException);
    assertEquals(404, exception.getCode());
    assertEquals("NOT_FOUND", exception.getReason());
    assertEquals("message", exception.getMessage());
    assertTrue(exception.isRetryable());
    assertSame(apiException, exception.getCause());
  }

  @Test
  public void testApiException() {
    ApiException apiException = createApiException();
    DatastoreException datastoreException = new DatastoreException(apiException);

    assertThat(datastoreException.getReason()).isEqualTo("FAILED_PRECONDITION");
    assertThat(datastoreException.getDomain()).isEqualTo("datastore.googleapis.com");
    assertThat(datastoreException.getMetadata())
        .isEqualTo(singletonMap("missing_indexes_url", "__some__url__"));
    assertThat(datastoreException.getErrorDetails()).isEqualTo(apiException.getErrorDetails());
  }

  @Test
  public void testTranslateAndThrow() {
    Exception cause = new DatastoreException(14, "message", "UNAVAILABLE");
    final RetryHelper.RetryHelperException exceptionMock =
        createMock(RetryHelper.RetryHelperException.class);
    expect(exceptionMock.getCause()).andReturn(cause).times(2);
    replay(exceptionMock);
    BaseServiceException ex =
        assertThrows(
            BaseServiceException.class, () -> DatastoreException.translateAndThrow(exceptionMock));
    assertEquals(14, ex.getCode());
    assertEquals("message", ex.getMessage());
    assertTrue(ex.isRetryable());
    verify(exceptionMock);

    cause = createApiException();
    final RetryHelper.RetryHelperException exceptionMock2 =
        createMock(RetryHelper.RetryHelperException.class);
    expect(exceptionMock2.getCause()).andReturn(cause).times(3);
    replay(exceptionMock2);
    DatastoreException ex2 =
        assertThrows(
            DatastoreException.class, () -> DatastoreException.translateAndThrow(exceptionMock2));
    assertThat(ex2.getReason()).isEqualTo("FAILED_PRECONDITION");
    assertThat(ex2.getDomain()).isEqualTo("datastore.googleapis.com");
    assertThat(ex2.getMetadata()).isEqualTo(singletonMap("missing_indexes_url", "__some__url__"));
    assertThat(ex2.getErrorDetails()).isEqualTo(((ApiException) cause).getErrorDetails());
    verify(exceptionMock2);

    cause = new IllegalArgumentException("message");
    final RetryHelper.RetryHelperException exceptionMock3 =
        createMock(RetryHelper.RetryHelperException.class);
    expect(exceptionMock3.getMessage()).andReturn("message").times(1);
    expect(exceptionMock3.getCause()).andReturn(cause).times(3);
    replay(exceptionMock3);
    BaseServiceException ex3 =
        assertThrows(
            BaseServiceException.class, () -> DatastoreException.translateAndThrow(exceptionMock3));
    assertEquals(DatastoreException.UNKNOWN_CODE, ex3.getCode());
    assertEquals("message", ex3.getMessage());
    assertFalse(ex3.isRetryable());
    assertSame(cause, ex3.getCause());
    verify(exceptionMock3);
  }

  @Test
  public void testThrowInvalidRequest() {
    try {
      DatastoreException.throwInvalidRequest("message %s %d", "a", 1);
      fail("Exception expected");
    } catch (DatastoreException ex) {
      assertEquals("FAILED_PRECONDITION", ex.getReason());
      assertEquals("message a 1", ex.getMessage());
    }
  }

  private ApiException createApiException() {
    // Simulating google.rpc.Status with an ErrorInfo
    ErrorInfo errorInfo =
        ErrorInfo.newBuilder()
            .setDomain("datastore.googleapis.com")
            .setReason("MISSING_INDEXES")
            .putMetadata("missing_indexes_url", "__some__url__")
            .build();
    com.google.rpc.Status status =
        com.google.rpc.Status.newBuilder()
            .setCode(FAILED_PRECONDITION.getNumber())
            .setMessage("The query requires indexes.")
            .addDetails(Any.pack(errorInfo))
            .build();

    // Using Gax to convert to ApiException
    StatusCode statusCode = GrpcStatusCode.of(Status.fromCodeValue(status.getCode()).getCode());
    ErrorDetails errorDetails =
        ErrorDetails.builder().setRawErrorMessages(status.getDetailsList()).build();
    return ApiExceptionFactory.createException(null, statusCode, true, errorDetails);
  }
}
