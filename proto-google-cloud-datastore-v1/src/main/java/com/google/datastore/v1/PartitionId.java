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
// source: google/datastore/v1/entity.proto

// Protobuf Java Version: 3.25.4
package com.google.datastore.v1;

/**
 *
 *
 * <pre>
 * A partition ID identifies a grouping of entities. The grouping is always
 * by project and namespace, however the namespace ID may be empty.
 *
 * A partition ID contains several dimensions:
 * project ID and namespace ID.
 *
 * Partition dimensions:
 *
 * - May be `""`.
 * - Must be valid UTF-8 bytes.
 * - Must have values that match regex `[A-Za-z&#92;d&#92;.&#92;-_]{1,100}`
 * If the value of any dimension matches regex `__.*__`, the partition is
 * reserved/read-only.
 * A reserved/read-only partition ID is forbidden in certain documented
 * contexts.
 *
 * Foreign partition IDs (in which the project ID does
 * not match the context project ID ) are discouraged.
 * Reads and writes of foreign partition IDs may fail if the project is not in
 * an active state.
 * </pre>
 *
 * Protobuf type {@code google.datastore.v1.PartitionId}
 */
public final class PartitionId extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.datastore.v1.PartitionId)
    PartitionIdOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use PartitionId.newBuilder() to construct.
  private PartitionId(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private PartitionId() {
    projectId_ = "";
    databaseId_ = "";
    namespaceId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new PartitionId();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.datastore.v1.EntityProto
        .internal_static_google_datastore_v1_PartitionId_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.v1.EntityProto
        .internal_static_google_datastore_v1_PartitionId_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.v1.PartitionId.class,
            com.google.datastore.v1.PartitionId.Builder.class);
  }

  public static final int PROJECT_ID_FIELD_NUMBER = 2;

  @SuppressWarnings("serial")
  private volatile java.lang.Object projectId_ = "";
  /**
   *
   *
   * <pre>
   * The ID of the project to which the entities belong.
   * </pre>
   *
   * <code>string project_id = 2;</code>
   *
   * @return The projectId.
   */
  @java.lang.Override
  public java.lang.String getProjectId() {
    java.lang.Object ref = projectId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      projectId_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * The ID of the project to which the entities belong.
   * </pre>
   *
   * <code>string project_id = 2;</code>
   *
   * @return The bytes for projectId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getProjectIdBytes() {
    java.lang.Object ref = projectId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      projectId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATABASE_ID_FIELD_NUMBER = 3;

  @SuppressWarnings("serial")
  private volatile java.lang.Object databaseId_ = "";
  /**
   *
   *
   * <pre>
   * If not empty, the ID of the database to which the entities
   * belong.
   * </pre>
   *
   * <code>string database_id = 3;</code>
   *
   * @return The databaseId.
   */
  @java.lang.Override
  public java.lang.String getDatabaseId() {
    java.lang.Object ref = databaseId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      databaseId_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * If not empty, the ID of the database to which the entities
   * belong.
   * </pre>
   *
   * <code>string database_id = 3;</code>
   *
   * @return The bytes for databaseId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getDatabaseIdBytes() {
    java.lang.Object ref = databaseId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      databaseId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NAMESPACE_ID_FIELD_NUMBER = 4;

  @SuppressWarnings("serial")
  private volatile java.lang.Object namespaceId_ = "";
  /**
   *
   *
   * <pre>
   * If not empty, the ID of the namespace to which the entities belong.
   * </pre>
   *
   * <code>string namespace_id = 4;</code>
   *
   * @return The namespaceId.
   */
  @java.lang.Override
  public java.lang.String getNamespaceId() {
    java.lang.Object ref = namespaceId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      namespaceId_ = s;
      return s;
    }
  }
  /**
   *
   *
   * <pre>
   * If not empty, the ID of the namespace to which the entities belong.
   * </pre>
   *
   * <code>string namespace_id = 4;</code>
   *
   * @return The bytes for namespaceId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getNamespaceIdBytes() {
    java.lang.Object ref = namespaceId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b =
          com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
      namespaceId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(projectId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, projectId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(databaseId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, databaseId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(namespaceId_)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, namespaceId_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(projectId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, projectId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(databaseId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, databaseId_);
    }
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(namespaceId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, namespaceId_);
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.datastore.v1.PartitionId)) {
      return super.equals(obj);
    }
    com.google.datastore.v1.PartitionId other = (com.google.datastore.v1.PartitionId) obj;

    if (!getProjectId().equals(other.getProjectId())) return false;
    if (!getDatabaseId().equals(other.getDatabaseId())) return false;
    if (!getNamespaceId().equals(other.getNamespaceId())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PROJECT_ID_FIELD_NUMBER;
    hash = (53 * hash) + getProjectId().hashCode();
    hash = (37 * hash) + DATABASE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getDatabaseId().hashCode();
    hash = (37 * hash) + NAMESPACE_ID_FIELD_NUMBER;
    hash = (53 * hash) + getNamespaceId().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.v1.PartitionId parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.PartitionId parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.PartitionId parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.PartitionId parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.datastore.v1.PartitionId prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * A partition ID identifies a grouping of entities. The grouping is always
   * by project and namespace, however the namespace ID may be empty.
   *
   * A partition ID contains several dimensions:
   * project ID and namespace ID.
   *
   * Partition dimensions:
   *
   * - May be `""`.
   * - Must be valid UTF-8 bytes.
   * - Must have values that match regex `[A-Za-z&#92;d&#92;.&#92;-_]{1,100}`
   * If the value of any dimension matches regex `__.*__`, the partition is
   * reserved/read-only.
   * A reserved/read-only partition ID is forbidden in certain documented
   * contexts.
   *
   * Foreign partition IDs (in which the project ID does
   * not match the context project ID ) are discouraged.
   * Reads and writes of foreign partition IDs may fail if the project is not in
   * an active state.
   * </pre>
   *
   * Protobuf type {@code google.datastore.v1.PartitionId}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.datastore.v1.PartitionId)
      com.google.datastore.v1.PartitionIdOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.datastore.v1.EntityProto
          .internal_static_google_datastore_v1_PartitionId_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.v1.EntityProto
          .internal_static_google_datastore_v1_PartitionId_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.v1.PartitionId.class,
              com.google.datastore.v1.PartitionId.Builder.class);
    }

    // Construct using com.google.datastore.v1.PartitionId.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      projectId_ = "";
      databaseId_ = "";
      namespaceId_ = "";
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.datastore.v1.EntityProto
          .internal_static_google_datastore_v1_PartitionId_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.v1.PartitionId getDefaultInstanceForType() {
      return com.google.datastore.v1.PartitionId.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.v1.PartitionId build() {
      com.google.datastore.v1.PartitionId result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.v1.PartitionId buildPartial() {
      com.google.datastore.v1.PartitionId result = new com.google.datastore.v1.PartitionId(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.datastore.v1.PartitionId result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.projectId_ = projectId_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.databaseId_ = databaseId_;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.namespaceId_ = namespaceId_;
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.datastore.v1.PartitionId) {
        return mergeFrom((com.google.datastore.v1.PartitionId) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.v1.PartitionId other) {
      if (other == com.google.datastore.v1.PartitionId.getDefaultInstance()) return this;
      if (!other.getProjectId().isEmpty()) {
        projectId_ = other.projectId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (!other.getDatabaseId().isEmpty()) {
        databaseId_ = other.databaseId_;
        bitField0_ |= 0x00000002;
        onChanged();
      }
      if (!other.getNamespaceId().isEmpty()) {
        namespaceId_ = other.namespaceId_;
        bitField0_ |= 0x00000004;
        onChanged();
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 18:
              {
                projectId_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000001;
                break;
              } // case 18
            case 26:
              {
                databaseId_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000002;
                break;
              } // case 26
            case 34:
              {
                namespaceId_ = input.readStringRequireUtf8();
                bitField0_ |= 0x00000004;
                break;
              } // case 34
            default:
              {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int bitField0_;

    private java.lang.Object projectId_ = "";
    /**
     *
     *
     * <pre>
     * The ID of the project to which the entities belong.
     * </pre>
     *
     * <code>string project_id = 2;</code>
     *
     * @return The projectId.
     */
    public java.lang.String getProjectId() {
      java.lang.Object ref = projectId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        projectId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The ID of the project to which the entities belong.
     * </pre>
     *
     * <code>string project_id = 2;</code>
     *
     * @return The bytes for projectId.
     */
    public com.google.protobuf.ByteString getProjectIdBytes() {
      java.lang.Object ref = projectId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        projectId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * The ID of the project to which the entities belong.
     * </pre>
     *
     * <code>string project_id = 2;</code>
     *
     * @param value The projectId to set.
     * @return This builder for chaining.
     */
    public Builder setProjectId(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      projectId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The ID of the project to which the entities belong.
     * </pre>
     *
     * <code>string project_id = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearProjectId() {
      projectId_ = getDefaultInstance().getProjectId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The ID of the project to which the entities belong.
     * </pre>
     *
     * <code>string project_id = 2;</code>
     *
     * @param value The bytes for projectId to set.
     * @return This builder for chaining.
     */
    public Builder setProjectIdBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      projectId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private java.lang.Object databaseId_ = "";
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the database to which the entities
     * belong.
     * </pre>
     *
     * <code>string database_id = 3;</code>
     *
     * @return The databaseId.
     */
    public java.lang.String getDatabaseId() {
      java.lang.Object ref = databaseId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        databaseId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the database to which the entities
     * belong.
     * </pre>
     *
     * <code>string database_id = 3;</code>
     *
     * @return The bytes for databaseId.
     */
    public com.google.protobuf.ByteString getDatabaseIdBytes() {
      java.lang.Object ref = databaseId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        databaseId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the database to which the entities
     * belong.
     * </pre>
     *
     * <code>string database_id = 3;</code>
     *
     * @param value The databaseId to set.
     * @return This builder for chaining.
     */
    public Builder setDatabaseId(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      databaseId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the database to which the entities
     * belong.
     * </pre>
     *
     * <code>string database_id = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearDatabaseId() {
      databaseId_ = getDefaultInstance().getDatabaseId();
      bitField0_ = (bitField0_ & ~0x00000002);
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the database to which the entities
     * belong.
     * </pre>
     *
     * <code>string database_id = 3;</code>
     *
     * @param value The bytes for databaseId to set.
     * @return This builder for chaining.
     */
    public Builder setDatabaseIdBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      databaseId_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

    private java.lang.Object namespaceId_ = "";
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the namespace to which the entities belong.
     * </pre>
     *
     * <code>string namespace_id = 4;</code>
     *
     * @return The namespaceId.
     */
    public java.lang.String getNamespaceId() {
      java.lang.Object ref = namespaceId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        namespaceId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the namespace to which the entities belong.
     * </pre>
     *
     * <code>string namespace_id = 4;</code>
     *
     * @return The bytes for namespaceId.
     */
    public com.google.protobuf.ByteString getNamespaceIdBytes() {
      java.lang.Object ref = namespaceId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b =
            com.google.protobuf.ByteString.copyFromUtf8((java.lang.String) ref);
        namespaceId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the namespace to which the entities belong.
     * </pre>
     *
     * <code>string namespace_id = 4;</code>
     *
     * @param value The namespaceId to set.
     * @return This builder for chaining.
     */
    public Builder setNamespaceId(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }
      namespaceId_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the namespace to which the entities belong.
     * </pre>
     *
     * <code>string namespace_id = 4;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearNamespaceId() {
      namespaceId_ = getDefaultInstance().getNamespaceId();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * If not empty, the ID of the namespace to which the entities belong.
     * </pre>
     *
     * <code>string namespace_id = 4;</code>
     *
     * @param value The bytes for namespaceId to set.
     * @return This builder for chaining.
     */
    public Builder setNamespaceIdBytes(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      checkByteStringIsUtf8(value);
      namespaceId_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.datastore.v1.PartitionId)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.v1.PartitionId)
  private static final com.google.datastore.v1.PartitionId DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.datastore.v1.PartitionId();
  }

  public static com.google.datastore.v1.PartitionId getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PartitionId> PARSER =
      new com.google.protobuf.AbstractParser<PartitionId>() {
        @java.lang.Override
        public PartitionId parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          Builder builder = newBuilder();
          try {
            builder.mergeFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(builder.buildPartial());
          } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
          } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
          }
          return builder.buildPartial();
        }
      };

  public static com.google.protobuf.Parser<PartitionId> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PartitionId> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.v1.PartitionId getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
