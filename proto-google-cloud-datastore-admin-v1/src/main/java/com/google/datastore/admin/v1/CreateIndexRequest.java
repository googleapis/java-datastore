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
// source: google/datastore/admin/v1/datastore_admin.proto

package com.google.datastore.admin.v1;

/**
 *
 *
 * <pre>
 * The request for
 * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex][google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
 * </pre>
 *
 * Protobuf type {@code google.datastore.admin.v1.CreateIndexRequest}
 */
public final class CreateIndexRequest extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.datastore.admin.v1.CreateIndexRequest)
    CreateIndexRequestOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use CreateIndexRequest.newBuilder() to construct.
  private CreateIndexRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private CreateIndexRequest() {
    projectId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new CreateIndexRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private CreateIndexRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10:
            {
              java.lang.String s = input.readStringRequireUtf8();

              projectId_ = s;
              break;
            }
          case 26:
            {
              com.google.datastore.admin.v1.Index.Builder subBuilder = null;
              if (index_ != null) {
                subBuilder = index_.toBuilder();
              }
              index_ =
                  input.readMessage(
                      com.google.datastore.admin.v1.Index.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(index_);
                index_ = subBuilder.buildPartial();
              }

              break;
            }
          default:
            {
              if (!parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.datastore.admin.v1.DatastoreAdminProto
        .internal_static_google_datastore_admin_v1_CreateIndexRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.admin.v1.DatastoreAdminProto
        .internal_static_google_datastore_admin_v1_CreateIndexRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.admin.v1.CreateIndexRequest.class,
            com.google.datastore.admin.v1.CreateIndexRequest.Builder.class);
  }

  public static final int PROJECT_ID_FIELD_NUMBER = 1;
  private volatile java.lang.Object projectId_;
  /**
   *
   *
   * <pre>
   * Project ID against which to make the request.
   * </pre>
   *
   * <code>string project_id = 1;</code>
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
   * Project ID against which to make the request.
   * </pre>
   *
   * <code>string project_id = 1;</code>
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

  public static final int INDEX_FIELD_NUMBER = 3;
  private com.google.datastore.admin.v1.Index index_;
  /**
   *
   *
   * <pre>
   * The index to create. The name and state fields are output only and will be
   * ignored. Single property indexes cannot be created or deleted.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.Index index = 3;</code>
   *
   * @return Whether the index field is set.
   */
  @java.lang.Override
  public boolean hasIndex() {
    return index_ != null;
  }
  /**
   *
   *
   * <pre>
   * The index to create. The name and state fields are output only and will be
   * ignored. Single property indexes cannot be created or deleted.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.Index index = 3;</code>
   *
   * @return The index.
   */
  @java.lang.Override
  public com.google.datastore.admin.v1.Index getIndex() {
    return index_ == null ? com.google.datastore.admin.v1.Index.getDefaultInstance() : index_;
  }
  /**
   *
   *
   * <pre>
   * The index to create. The name and state fields are output only and will be
   * ignored. Single property indexes cannot be created or deleted.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.Index index = 3;</code>
   */
  @java.lang.Override
  public com.google.datastore.admin.v1.IndexOrBuilder getIndexOrBuilder() {
    return getIndex();
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
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, projectId_);
    }
    if (index_ != null) {
      output.writeMessage(3, getIndex());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!com.google.protobuf.GeneratedMessageV3.isStringEmpty(projectId_)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, projectId_);
    }
    if (index_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, getIndex());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.datastore.admin.v1.CreateIndexRequest)) {
      return super.equals(obj);
    }
    com.google.datastore.admin.v1.CreateIndexRequest other =
        (com.google.datastore.admin.v1.CreateIndexRequest) obj;

    if (!getProjectId().equals(other.getProjectId())) return false;
    if (hasIndex() != other.hasIndex()) return false;
    if (hasIndex()) {
      if (!getIndex().equals(other.getIndex())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
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
    if (hasIndex()) {
      hash = (37 * hash) + INDEX_FIELD_NUMBER;
      hash = (53 * hash) + getIndex().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest parseFrom(
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

  public static Builder newBuilder(com.google.datastore.admin.v1.CreateIndexRequest prototype) {
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
   * The request for
   * [google.datastore.admin.v1.DatastoreAdmin.CreateIndex][google.datastore.admin.v1.DatastoreAdmin.CreateIndex].
   * </pre>
   *
   * Protobuf type {@code google.datastore.admin.v1.CreateIndexRequest}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.datastore.admin.v1.CreateIndexRequest)
      com.google.datastore.admin.v1.CreateIndexRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.datastore.admin.v1.DatastoreAdminProto
          .internal_static_google_datastore_admin_v1_CreateIndexRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.admin.v1.DatastoreAdminProto
          .internal_static_google_datastore_admin_v1_CreateIndexRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.admin.v1.CreateIndexRequest.class,
              com.google.datastore.admin.v1.CreateIndexRequest.Builder.class);
    }

    // Construct using com.google.datastore.admin.v1.CreateIndexRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {}
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      projectId_ = "";

      if (indexBuilder_ == null) {
        index_ = null;
      } else {
        index_ = null;
        indexBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.datastore.admin.v1.DatastoreAdminProto
          .internal_static_google_datastore_admin_v1_CreateIndexRequest_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.CreateIndexRequest getDefaultInstanceForType() {
      return com.google.datastore.admin.v1.CreateIndexRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.CreateIndexRequest build() {
      com.google.datastore.admin.v1.CreateIndexRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.CreateIndexRequest buildPartial() {
      com.google.datastore.admin.v1.CreateIndexRequest result =
          new com.google.datastore.admin.v1.CreateIndexRequest(this);
      result.projectId_ = projectId_;
      if (indexBuilder_ == null) {
        result.index_ = index_;
      } else {
        result.index_ = indexBuilder_.build();
      }
      onBuilt();
      return result;
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
      if (other instanceof com.google.datastore.admin.v1.CreateIndexRequest) {
        return mergeFrom((com.google.datastore.admin.v1.CreateIndexRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.admin.v1.CreateIndexRequest other) {
      if (other == com.google.datastore.admin.v1.CreateIndexRequest.getDefaultInstance())
        return this;
      if (!other.getProjectId().isEmpty()) {
        projectId_ = other.projectId_;
        onChanged();
      }
      if (other.hasIndex()) {
        mergeIndex(other.getIndex());
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.google.datastore.admin.v1.CreateIndexRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.datastore.admin.v1.CreateIndexRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object projectId_ = "";
    /**
     *
     *
     * <pre>
     * Project ID against which to make the request.
     * </pre>
     *
     * <code>string project_id = 1;</code>
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
     * Project ID against which to make the request.
     * </pre>
     *
     * <code>string project_id = 1;</code>
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
     * Project ID against which to make the request.
     * </pre>
     *
     * <code>string project_id = 1;</code>
     *
     * @param value The projectId to set.
     * @return This builder for chaining.
     */
    public Builder setProjectId(java.lang.String value) {
      if (value == null) {
        throw new NullPointerException();
      }

      projectId_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Project ID against which to make the request.
     * </pre>
     *
     * <code>string project_id = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearProjectId() {

      projectId_ = getDefaultInstance().getProjectId();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Project ID against which to make the request.
     * </pre>
     *
     * <code>string project_id = 1;</code>
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
      onChanged();
      return this;
    }

    private com.google.datastore.admin.v1.Index index_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.admin.v1.Index,
            com.google.datastore.admin.v1.Index.Builder,
            com.google.datastore.admin.v1.IndexOrBuilder>
        indexBuilder_;
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     *
     * @return Whether the index field is set.
     */
    public boolean hasIndex() {
      return indexBuilder_ != null || index_ != null;
    }
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     *
     * @return The index.
     */
    public com.google.datastore.admin.v1.Index getIndex() {
      if (indexBuilder_ == null) {
        return index_ == null ? com.google.datastore.admin.v1.Index.getDefaultInstance() : index_;
      } else {
        return indexBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     */
    public Builder setIndex(com.google.datastore.admin.v1.Index value) {
      if (indexBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        index_ = value;
        onChanged();
      } else {
        indexBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     */
    public Builder setIndex(com.google.datastore.admin.v1.Index.Builder builderForValue) {
      if (indexBuilder_ == null) {
        index_ = builderForValue.build();
        onChanged();
      } else {
        indexBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     */
    public Builder mergeIndex(com.google.datastore.admin.v1.Index value) {
      if (indexBuilder_ == null) {
        if (index_ != null) {
          index_ =
              com.google.datastore.admin.v1.Index.newBuilder(index_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          index_ = value;
        }
        onChanged();
      } else {
        indexBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     */
    public Builder clearIndex() {
      if (indexBuilder_ == null) {
        index_ = null;
        onChanged();
      } else {
        index_ = null;
        indexBuilder_ = null;
      }

      return this;
    }
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     */
    public com.google.datastore.admin.v1.Index.Builder getIndexBuilder() {

      onChanged();
      return getIndexFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     */
    public com.google.datastore.admin.v1.IndexOrBuilder getIndexOrBuilder() {
      if (indexBuilder_ != null) {
        return indexBuilder_.getMessageOrBuilder();
      } else {
        return index_ == null ? com.google.datastore.admin.v1.Index.getDefaultInstance() : index_;
      }
    }
    /**
     *
     *
     * <pre>
     * The index to create. The name and state fields are output only and will be
     * ignored. Single property indexes cannot be created or deleted.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.Index index = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.admin.v1.Index,
            com.google.datastore.admin.v1.Index.Builder,
            com.google.datastore.admin.v1.IndexOrBuilder>
        getIndexFieldBuilder() {
      if (indexBuilder_ == null) {
        indexBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.datastore.admin.v1.Index,
                com.google.datastore.admin.v1.Index.Builder,
                com.google.datastore.admin.v1.IndexOrBuilder>(
                getIndex(), getParentForChildren(), isClean());
        index_ = null;
      }
      return indexBuilder_;
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

    // @@protoc_insertion_point(builder_scope:google.datastore.admin.v1.CreateIndexRequest)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.admin.v1.CreateIndexRequest)
  private static final com.google.datastore.admin.v1.CreateIndexRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.datastore.admin.v1.CreateIndexRequest();
  }

  public static com.google.datastore.admin.v1.CreateIndexRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateIndexRequest> PARSER =
      new com.google.protobuf.AbstractParser<CreateIndexRequest>() {
        @java.lang.Override
        public CreateIndexRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new CreateIndexRequest(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<CreateIndexRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateIndexRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.admin.v1.CreateIndexRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
