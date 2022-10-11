/*
 * Copyright 2020 Google LLC
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
// source: google/datastore/v1/entity.proto

package com.google.datastore.v1;

public interface EntityOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.Entity)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The entity's key.
   * An entity must have a key, unless otherwise documented (for example,
   * an entity in `Value.entity_value` may have no key).
   * An entity's kind is its key path's last element's kind,
   * or null if it has no key.
   * </pre>
   *
   * <code>.google.datastore.v1.Key key = 1;</code>
   *
   * @return Whether the key field is set.
   */
  boolean hasKey();
  /**
   *
   *
   * <pre>
   * The entity's key.
   * An entity must have a key, unless otherwise documented (for example,
   * an entity in `Value.entity_value` may have no key).
   * An entity's kind is its key path's last element's kind,
   * or null if it has no key.
   * </pre>
   *
   * <code>.google.datastore.v1.Key key = 1;</code>
   *
   * @return The key.
   */
  com.google.datastore.v1.Key getKey();
  /**
   *
   *
   * <pre>
   * The entity's key.
   * An entity must have a key, unless otherwise documented (for example,
   * an entity in `Value.entity_value` may have no key).
   * An entity's kind is its key path's last element's kind,
   * or null if it has no key.
   * </pre>
   *
   * <code>.google.datastore.v1.Key key = 1;</code>
   */
  com.google.datastore.v1.KeyOrBuilder getKeyOrBuilder();

  /**
   *
   *
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The name must not contain more than 500 characters.
   * The name cannot be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  int getPropertiesCount();
  /**
   *
   *
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The name must not contain more than 500 characters.
   * The name cannot be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  boolean containsProperties(java.lang.String key);
  /** Use {@link #getPropertiesMap()} instead. */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.google.datastore.v1.Value> getProperties();
  /**
   *
   *
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The name must not contain more than 500 characters.
   * The name cannot be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  java.util.Map<java.lang.String, com.google.datastore.v1.Value> getPropertiesMap();
  /**
   *
   *
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The name must not contain more than 500 characters.
   * The name cannot be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  com.google.datastore.v1.Value getPropertiesOrDefault(
      java.lang.String key, com.google.datastore.v1.Value defaultValue);
  /**
   *
   *
   * <pre>
   * The entity's properties.
   * The map's keys are property names.
   * A property name matching regex `__.*__` is reserved.
   * A reserved property name is forbidden in certain documented contexts.
   * The name must not contain more than 500 characters.
   * The name cannot be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.Value&gt; properties = 3;</code>
   */
  com.google.datastore.v1.Value getPropertiesOrThrow(java.lang.String key);
}
