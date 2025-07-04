/*
 * Copyright 2025 Google LLC
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

// Protobuf Java Version: 3.25.8
package com.google.datastore.v1;

public interface PropertyOrderOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.PropertyOrder)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The property to order by.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyReference property = 1;</code>
   *
   * @return Whether the property field is set.
   */
  boolean hasProperty();

  /**
   *
   *
   * <pre>
   * The property to order by.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyReference property = 1;</code>
   *
   * @return The property.
   */
  com.google.datastore.v1.PropertyReference getProperty();

  /**
   *
   *
   * <pre>
   * The property to order by.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyReference property = 1;</code>
   */
  com.google.datastore.v1.PropertyReferenceOrBuilder getPropertyOrBuilder();

  /**
   *
   *
   * <pre>
   * The direction to order by. Defaults to `ASCENDING`.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
   *
   * @return The enum numeric value on the wire for direction.
   */
  int getDirectionValue();

  /**
   *
   *
   * <pre>
   * The direction to order by. Defaults to `ASCENDING`.
   * </pre>
   *
   * <code>.google.datastore.v1.PropertyOrder.Direction direction = 2;</code>
   *
   * @return The direction.
   */
  com.google.datastore.v1.PropertyOrder.Direction getDirection();
}
