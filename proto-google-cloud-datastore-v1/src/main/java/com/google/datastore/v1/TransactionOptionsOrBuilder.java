/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/datastore.proto

// Protobuf Java Version: 3.25.4
package com.google.datastore.v1;

public interface TransactionOptionsOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.TransactionOptions)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The transaction should allow both reads and writes.
   * </pre>
   *
   * <code>.google.datastore.v1.TransactionOptions.ReadWrite read_write = 1;</code>
   *
   * @return Whether the readWrite field is set.
   */
  boolean hasReadWrite();
  /**
   *
   *
   * <pre>
   * The transaction should allow both reads and writes.
   * </pre>
   *
   * <code>.google.datastore.v1.TransactionOptions.ReadWrite read_write = 1;</code>
   *
   * @return The readWrite.
   */
  com.google.datastore.v1.TransactionOptions.ReadWrite getReadWrite();
  /**
   *
   *
   * <pre>
   * The transaction should allow both reads and writes.
   * </pre>
   *
   * <code>.google.datastore.v1.TransactionOptions.ReadWrite read_write = 1;</code>
   */
  com.google.datastore.v1.TransactionOptions.ReadWriteOrBuilder getReadWriteOrBuilder();

  /**
   *
   *
   * <pre>
   * The transaction should only allow reads.
   * </pre>
   *
   * <code>.google.datastore.v1.TransactionOptions.ReadOnly read_only = 2;</code>
   *
   * @return Whether the readOnly field is set.
   */
  boolean hasReadOnly();
  /**
   *
   *
   * <pre>
   * The transaction should only allow reads.
   * </pre>
   *
   * <code>.google.datastore.v1.TransactionOptions.ReadOnly read_only = 2;</code>
   *
   * @return The readOnly.
   */
  com.google.datastore.v1.TransactionOptions.ReadOnly getReadOnly();
  /**
   *
   *
   * <pre>
   * The transaction should only allow reads.
   * </pre>
   *
   * <code>.google.datastore.v1.TransactionOptions.ReadOnly read_only = 2;</code>
   */
  com.google.datastore.v1.TransactionOptions.ReadOnlyOrBuilder getReadOnlyOrBuilder();

  com.google.datastore.v1.TransactionOptions.ModeCase getModeCase();
}
