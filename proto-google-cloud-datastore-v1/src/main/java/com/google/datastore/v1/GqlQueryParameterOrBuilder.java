/*
 * Copyright 2019 Google LLC
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
// source: google/datastore/v1/query.proto

package com.google.datastore.v1;

public interface GqlQueryParameterOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.GqlQueryParameter)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * A value parameter.
   * </pre>
   *
   * <code>.google.datastore.v1.Value value = 2;</code>
   *
   * @return Whether the value field is set.
   */
  boolean hasValue();
  /**
   *
   *
   * <pre>
   * A value parameter.
   * </pre>
   *
   * <code>.google.datastore.v1.Value value = 2;</code>
   *
   * @return The value.
   */
  com.google.datastore.v1.Value getValue();
  /**
   *
   *
   * <pre>
   * A value parameter.
   * </pre>
   *
   * <code>.google.datastore.v1.Value value = 2;</code>
   */
  com.google.datastore.v1.ValueOrBuilder getValueOrBuilder();

  /**
   *
   *
   * <pre>
   * A query cursor. Query cursors are returned in query
   * result batches.
   * </pre>
   *
   * <code>bytes cursor = 3;</code>
   *
   * @return Whether the cursor field is set.
   */
  boolean hasCursor();
  /**
   *
   *
   * <pre>
   * A query cursor. Query cursors are returned in query
   * result batches.
   * </pre>
   *
   * <code>bytes cursor = 3;</code>
   *
   * @return The cursor.
   */
  com.google.protobuf.ByteString getCursor();

  public com.google.datastore.v1.GqlQueryParameter.ParameterTypeCase getParameterTypeCase();
}
