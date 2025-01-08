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
// source: google/datastore/admin/v1/index.proto

// Protobuf Java Version: 3.25.5
package com.google.datastore.admin.v1;

public interface IndexOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.admin.v1.Index)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Output only. Project ID.
   * </pre>
   *
   * <code>string project_id = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The projectId.
   */
  java.lang.String getProjectId();
  /**
   *
   *
   * <pre>
   * Output only. Project ID.
   * </pre>
   *
   * <code>string project_id = 1 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The bytes for projectId.
   */
  com.google.protobuf.ByteString getProjectIdBytes();

  /**
   *
   *
   * <pre>
   * Output only. The resource ID of the index.
   * </pre>
   *
   * <code>string index_id = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The indexId.
   */
  java.lang.String getIndexId();
  /**
   *
   *
   * <pre>
   * Output only. The resource ID of the index.
   * </pre>
   *
   * <code>string index_id = 3 [(.google.api.field_behavior) = OUTPUT_ONLY];</code>
   *
   * @return The bytes for indexId.
   */
  com.google.protobuf.ByteString getIndexIdBytes();

  /**
   *
   *
   * <pre>
   * Required. The entity kind to which this index applies.
   * </pre>
   *
   * <code>string kind = 4 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The kind.
   */
  java.lang.String getKind();
  /**
   *
   *
   * <pre>
   * Required. The entity kind to which this index applies.
   * </pre>
   *
   * <code>string kind = 4 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for kind.
   */
  com.google.protobuf.ByteString getKindBytes();

  /**
   *
   *
   * <pre>
   * Required. The index's ancestor mode.  Must not be
   * ANCESTOR_MODE_UNSPECIFIED.
   * </pre>
   *
   * <code>
   * .google.datastore.admin.v1.Index.AncestorMode ancestor = 5 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return The enum numeric value on the wire for ancestor.
   */
  int getAncestorValue();
  /**
   *
   *
   * <pre>
   * Required. The index's ancestor mode.  Must not be
   * ANCESTOR_MODE_UNSPECIFIED.
   * </pre>
   *
   * <code>
   * .google.datastore.admin.v1.Index.AncestorMode ancestor = 5 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return The ancestor.
   */
  com.google.datastore.admin.v1.Index.AncestorMode getAncestor();

  /**
   *
   *
   * <pre>
   * Required. An ordered sequence of property names and their index attributes.
   *
   * Requires:
   *
   * * A maximum of 100 properties.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.admin.v1.Index.IndexedProperty properties = 6 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  java.util.List<com.google.datastore.admin.v1.Index.IndexedProperty> getPropertiesList();
  /**
   *
   *
   * <pre>
   * Required. An ordered sequence of property names and their index attributes.
   *
   * Requires:
   *
   * * A maximum of 100 properties.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.admin.v1.Index.IndexedProperty properties = 6 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.datastore.admin.v1.Index.IndexedProperty getProperties(int index);
  /**
   *
   *
   * <pre>
   * Required. An ordered sequence of property names and their index attributes.
   *
   * Requires:
   *
   * * A maximum of 100 properties.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.admin.v1.Index.IndexedProperty properties = 6 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  int getPropertiesCount();
  /**
   *
   *
   * <pre>
   * Required. An ordered sequence of property names and their index attributes.
   *
   * Requires:
   *
   * * A maximum of 100 properties.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.admin.v1.Index.IndexedProperty properties = 6 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  java.util.List<? extends com.google.datastore.admin.v1.Index.IndexedPropertyOrBuilder>
      getPropertiesOrBuilderList();
  /**
   *
   *
   * <pre>
   * Required. An ordered sequence of property names and their index attributes.
   *
   * Requires:
   *
   * * A maximum of 100 properties.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.admin.v1.Index.IndexedProperty properties = 6 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.datastore.admin.v1.Index.IndexedPropertyOrBuilder getPropertiesOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * Output only. The state of the index.
   * </pre>
   *
   * <code>
   * .google.datastore.admin.v1.Index.State state = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The enum numeric value on the wire for state.
   */
  int getStateValue();
  /**
   *
   *
   * <pre>
   * Output only. The state of the index.
   * </pre>
   *
   * <code>
   * .google.datastore.admin.v1.Index.State state = 7 [(.google.api.field_behavior) = OUTPUT_ONLY];
   * </code>
   *
   * @return The state.
   */
  com.google.datastore.admin.v1.Index.State getState();
}
