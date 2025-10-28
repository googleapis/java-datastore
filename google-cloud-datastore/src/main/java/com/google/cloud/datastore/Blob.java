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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.protobuf.ByteString;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

/**
 * A Google Cloud Datastore Blob. This class is immutable.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/entities">Google Cloud Datastore
 *     Entities, Properties, and Keys</a>
 */
public final class Blob implements Serializable {

  private static final long serialVersionUID = 7311366042557240313L;

  private final ByteString byteString;

  Blob(ByteString byteString) {
    this.byteString = checkNotNull(byteString);
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    StringBuilder stBuilder = new StringBuilder();
    for (int i = 0; i < Math.min(256, byteString.size()); i++) {
      stBuilder.append(String.format("%02x", byteString.byteAt(i)));
    }
    if (byteString.size() > 256) {
      stBuilder.append("...");
    }
    return toStringHelper.add("bytes", stBuilder.toString()).toString();
  }

  @Override
  public int hashCode() {
    return byteString.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this || obj instanceof Blob && byteString.equals(((Blob) obj).byteString);
  }

  /** Returns the size of this blob. */
  public int getLength() {
    return byteString.size();
  }

  /** Returns a copy as byte array. */
  public byte[] toByteArray() {
    return byteString.toByteArray();
  }

  /** Returns a read-only {@link ByteBuffer} for this blob content. */
  public ByteBuffer asReadOnlyByteBuffer() {
    return byteString.asReadOnlyByteBuffer();
  }

  /** Returns an {@link InputStream} for this blob content. */
  public InputStream asInputStream() {
    final ByteBuffer byteBuffer = asReadOnlyByteBuffer();
    return new InputStream() {
      @Override
      public int read() {
        return !byteBuffer.hasRemaining() ? -1 : byteBuffer.get() & 0xFF;
      }
    };
  }

  /**
   * Copies bytes into a ByteBuffer.
   *
   * @throws java.nio.ReadOnlyBufferException if the target is read-only
   * @throws java.nio.BufferOverflowException if the target's remaining() space is not large enough
   *     to hold the data
   */
  public void copyTo(ByteBuffer target) {
    byteString.copyTo(target);
  }

  /**
   * Copies bytes into a buffer.
   *
   * @throws IndexOutOfBoundsException if an offset or size is negative or too large
   */
  public void copyTo(byte[] target) {
    byteString.copyTo(target, 0);
  }

  ByteString getByteString() {
    return byteString;
  }

  public static Blob copyFrom(byte[] bytes) {
    return new Blob(ByteString.copyFrom(bytes));
  }

  public static Blob copyFrom(ByteBuffer bytes) {
    return new Blob(ByteString.copyFrom(bytes));
  }

  public static Blob copyFrom(InputStream input) throws IOException {
    BufferedInputStream bufferedInput = new BufferedInputStream(input);
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    int value;
    while ((value = bufferedInput.read()) != -1) {
      bytes.write(value);
    }
    return copyFrom(bytes.toByteArray());
  }

  public com.google.datastore.v1.Value toPb() {
    return com.google.datastore.v1.Value.newBuilder().setBlobValue(byteString).build();
  }
}
