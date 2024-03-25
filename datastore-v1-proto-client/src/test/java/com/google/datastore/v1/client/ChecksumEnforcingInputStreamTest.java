/*
 * Copyright 2021 Google LLC
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

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/** Test for {@link ChecksumEnforcingInputStream}. */
@RunWith(JUnit4.class)
public class ChecksumEnforcingInputStreamTest {
  public long[] test(int payloadSize) throws Exception {
    int chunkSize = 10240;
    byte[] payload = preparePayload(payloadSize);
    long start = System.nanoTime();
    String expectedChecksum = EndToEndChecksumHandler.computeChecksum(payload);
    long computeTime = System.nanoTime() - start;
    long checksumTime = 0, noChecksumTime = 0;
    try (ChecksumEnforcingInputStream testInstance = createStream(expectedChecksum, payload)) {
      byte[] buf = new byte[chunkSize];
      start = System.nanoTime();
      while (testInstance.read(buf, 0, chunkSize) != -1) {
        // do nothing with the bytes read
      }
      checksumTime = System.nanoTime() - start;
    } catch (IOException e) {
      fail("checksum verification failed! " + e.getMessage());
    }

    try (ByteArrayInputStream testInstance = new ByteArrayInputStream(payload)) {
      byte[] buf = new byte[chunkSize];
      start = System.nanoTime();
      while (testInstance.read(buf, 0, chunkSize) != -1) {
        // do nothing with the bytes read
      }
      noChecksumTime = System.nanoTime() - start;
    } catch (IOException e) {
      fail("checksum verification failed! " + e.getMessage());
    }

    return new long[] {noChecksumTime, checksumTime, computeTime};
  }

  @Test
  public void read_withValidChecksum_differentPayloadSizes() throws Exception {
    int iterations = 3;
    int median = iterations / 2;
    int minPower = 15;
    int maxPower = 29;
    long[][] readNoChecksum = new long[maxPower][];
    long[][] readAndChecksum = new long[maxPower][];
    long[][] compute = new long[maxPower][];

    for (int j = minPower - 1; j < maxPower; j++) {
      readNoChecksum[j] = new long[iterations];
      readAndChecksum[j] = new long[iterations];
      compute[j] = new long[iterations];
    }

    for (int i = 0; i < iterations; i++) {
      // test with various payload sizes (1, 2, 2**2, 2**3 etc upto 2**28 = 256MB)
      for (int j = minPower - 1; j < maxPower; j++) {
        long[] result = test((int) Math.pow(2, j));
        readNoChecksum[j][i] = result[0];
        readAndChecksum[j][i] = result[1];
        compute[j][i] = result[2];
      }
    }

    for (int j = minPower; j < maxPower; j++) {
      Arrays.sort(readNoChecksum[j]);
      Arrays.sort(readAndChecksum[j]);
      Arrays.sort(compute[j]);
      System.out.println(
          "Payload "
              + (int) Math.pow(2, j) / 1024
              + " KB stream read: "
              + readNoChecksum[j][median] / 1000.0
              + " μs; stream read and calculate checksum: "
              + readAndChecksum[j][median] / 1000.0
              + " μs; stream checksum overhead: "
              + (readAndChecksum[j][median] - readNoChecksum[j][median]) / 1000.0
              + " μs; calculate checksum: "
              + compute[j][median] / 1000.0
              + " μs.");
    }
  }

  @Test
  public void read_withInvalidChecksum() {
    // Build a test instance with an invalid checksum.
    // Read 1000 bytes at a time.
    // Since checksum is invalid, do expect IOException.
    try (ChecksumEnforcingInputStream instance =
        new ChecksumEnforcingInputStream(
            new ByteArrayInputStream("hello there".getBytes(UTF_8)), "this checksum is invalid")) {
      byte[] buf = new byte[1000];
      while (instance.read(buf, 0, 1000) != -1) {
        // do nothing with the bytes read
      }
    } catch (IOException e) {
      // this is expected
      return;
    }
    fail("should have raised IOException");
  }

  @Test
  public void markNotSupported() throws Exception {
    byte[] payload = preparePayload(1);
    String expectedChecksum = EndToEndChecksumHandler.computeChecksum(payload);
    try (ChecksumEnforcingInputStream testInstance = createStream(expectedChecksum, payload)) {
      assertFalse(testInstance.markSupported());
    }
  }

  private byte[] preparePayload(int payloadSize) {
    // setup a String of size = input param: payloadSize
    String str = "This is a repeating string.";
    String payload;
    if (payloadSize > str.length()) {
      int num = payloadSize / str.length();
      StringBuilder buf = new StringBuilder();
      for (int i = 0; i < num; i++) {
        buf.append(str);
      }
      payload = buf.toString();
    } else {
      payload = str.substring(0, payloadSize);
    }
    return payload.getBytes(UTF_8);
  }

  private ChecksumEnforcingInputStream createStream(String checksum, byte[] bytes)
      throws Exception {
    return new ChecksumEnforcingInputStream(new ByteArrayInputStream(bytes), checksum);
  }
}
