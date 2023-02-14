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
// source: google/datastore/v1/datastore.proto

package com.google.datastore.v1;

/**
 *
 *
 * <pre>
 * The response for
 * [Datastore.RunQuery][google.datastore.v1.Datastore.RunQuery].
 * </pre>
 *
 * Protobuf type {@code google.datastore.v1.RunQueryResponse}
 */
public final class RunQueryResponse extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.datastore.v1.RunQueryResponse)
    RunQueryResponseOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use RunQueryResponse.newBuilder() to construct.
  private RunQueryResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private RunQueryResponse() {
    transaction_ = com.google.protobuf.ByteString.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new RunQueryResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.datastore.v1.DatastoreProto
        .internal_static_google_datastore_v1_RunQueryResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.v1.DatastoreProto
        .internal_static_google_datastore_v1_RunQueryResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.v1.RunQueryResponse.class,
            com.google.datastore.v1.RunQueryResponse.Builder.class);
  }

  public static final int BATCH_FIELD_NUMBER = 1;
  private com.google.datastore.v1.QueryResultBatch batch_;
  /**
   *
   *
   * <pre>
   * A batch of query results (always present).
   * </pre>
   *
   * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
   *
   * @return Whether the batch field is set.
   */
  @java.lang.Override
  public boolean hasBatch() {
    return batch_ != null;
  }
  /**
   *
   *
   * <pre>
   * A batch of query results (always present).
   * </pre>
   *
   * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
   *
   * @return The batch.
   */
  @java.lang.Override
  public com.google.datastore.v1.QueryResultBatch getBatch() {
    return batch_ == null ? com.google.datastore.v1.QueryResultBatch.getDefaultInstance() : batch_;
  }
  /**
   *
   *
   * <pre>
   * A batch of query results (always present).
   * </pre>
   *
   * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
   */
  @java.lang.Override
  public com.google.datastore.v1.QueryResultBatchOrBuilder getBatchOrBuilder() {
    return batch_ == null ? com.google.datastore.v1.QueryResultBatch.getDefaultInstance() : batch_;
  }

  public static final int QUERY_FIELD_NUMBER = 2;
  private com.google.datastore.v1.Query query_;
  /**
   *
   *
   * <pre>
   * The parsed form of the `GqlQuery` from the request, if it was set.
   * </pre>
   *
   * <code>.google.datastore.v1.Query query = 2;</code>
   *
   * @return Whether the query field is set.
   */
  @java.lang.Override
  public boolean hasQuery() {
    return query_ != null;
  }
  /**
   *
   *
   * <pre>
   * The parsed form of the `GqlQuery` from the request, if it was set.
   * </pre>
   *
   * <code>.google.datastore.v1.Query query = 2;</code>
   *
   * @return The query.
   */
  @java.lang.Override
  public com.google.datastore.v1.Query getQuery() {
    return query_ == null ? com.google.datastore.v1.Query.getDefaultInstance() : query_;
  }
  /**
   *
   *
   * <pre>
   * The parsed form of the `GqlQuery` from the request, if it was set.
   * </pre>
   *
   * <code>.google.datastore.v1.Query query = 2;</code>
   */
  @java.lang.Override
  public com.google.datastore.v1.QueryOrBuilder getQueryOrBuilder() {
    return query_ == null ? com.google.datastore.v1.Query.getDefaultInstance() : query_;
  }

  public static final int TRANSACTION_FIELD_NUMBER = 5;
  private com.google.protobuf.ByteString transaction_ = com.google.protobuf.ByteString.EMPTY;
  /**
   *
   *
   * <pre>
   * The identifier of the transaction that was started as part of this
   * RunQuery request.
   * Set only when
   * [ReadOptions.new_transaction][google.datastore.v1.ReadOptions.new_transaction]
   * was set in
   * [RunQueryRequest.read_options][google.datastore.v1.RunQueryRequest.read_options].
   * </pre>
   *
   * <code>bytes transaction = 5;</code>
   *
   * @return The transaction.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString getTransaction() {
    return transaction_;
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
    if (batch_ != null) {
      output.writeMessage(1, getBatch());
    }
    if (query_ != null) {
      output.writeMessage(2, getQuery());
    }
    if (!transaction_.isEmpty()) {
      output.writeBytes(5, transaction_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (batch_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getBatch());
    }
    if (query_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getQuery());
    }
    if (!transaction_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream.computeBytesSize(5, transaction_);
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
    if (!(obj instanceof com.google.datastore.v1.RunQueryResponse)) {
      return super.equals(obj);
    }
    com.google.datastore.v1.RunQueryResponse other = (com.google.datastore.v1.RunQueryResponse) obj;

    if (hasBatch() != other.hasBatch()) return false;
    if (hasBatch()) {
      if (!getBatch().equals(other.getBatch())) return false;
    }
    if (hasQuery() != other.hasQuery()) return false;
    if (hasQuery()) {
      if (!getQuery().equals(other.getQuery())) return false;
    }
    if (!getTransaction().equals(other.getTransaction())) return false;
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
    if (hasBatch()) {
      hash = (37 * hash) + BATCH_FIELD_NUMBER;
      hash = (53 * hash) + getBatch().hashCode();
    }
    if (hasQuery()) {
      hash = (37 * hash) + QUERY_FIELD_NUMBER;
      hash = (53 * hash) + getQuery().hashCode();
    }
    hash = (37 * hash) + TRANSACTION_FIELD_NUMBER;
    hash = (53 * hash) + getTransaction().hashCode();
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.RunQueryResponse parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.RunQueryResponse parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.RunQueryResponse parseFrom(
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

  public static Builder newBuilder(com.google.datastore.v1.RunQueryResponse prototype) {
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
   * The response for
   * [Datastore.RunQuery][google.datastore.v1.Datastore.RunQuery].
   * </pre>
   *
   * Protobuf type {@code google.datastore.v1.RunQueryResponse}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.datastore.v1.RunQueryResponse)
      com.google.datastore.v1.RunQueryResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.datastore.v1.DatastoreProto
          .internal_static_google_datastore_v1_RunQueryResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.v1.DatastoreProto
          .internal_static_google_datastore_v1_RunQueryResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.v1.RunQueryResponse.class,
              com.google.datastore.v1.RunQueryResponse.Builder.class);
    }

    // Construct using com.google.datastore.v1.RunQueryResponse.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      batch_ = null;
      if (batchBuilder_ != null) {
        batchBuilder_.dispose();
        batchBuilder_ = null;
      }
      query_ = null;
      if (queryBuilder_ != null) {
        queryBuilder_.dispose();
        queryBuilder_ = null;
      }
      transaction_ = com.google.protobuf.ByteString.EMPTY;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.datastore.v1.DatastoreProto
          .internal_static_google_datastore_v1_RunQueryResponse_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.v1.RunQueryResponse getDefaultInstanceForType() {
      return com.google.datastore.v1.RunQueryResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.v1.RunQueryResponse build() {
      com.google.datastore.v1.RunQueryResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.v1.RunQueryResponse buildPartial() {
      com.google.datastore.v1.RunQueryResponse result =
          new com.google.datastore.v1.RunQueryResponse(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.datastore.v1.RunQueryResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.batch_ = batchBuilder_ == null ? batch_ : batchBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.query_ = queryBuilder_ == null ? query_ : queryBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.transaction_ = transaction_;
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
      if (other instanceof com.google.datastore.v1.RunQueryResponse) {
        return mergeFrom((com.google.datastore.v1.RunQueryResponse) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.v1.RunQueryResponse other) {
      if (other == com.google.datastore.v1.RunQueryResponse.getDefaultInstance()) return this;
      if (other.hasBatch()) {
        mergeBatch(other.getBatch());
      }
      if (other.hasQuery()) {
        mergeQuery(other.getQuery());
      }
      if (other.getTransaction() != com.google.protobuf.ByteString.EMPTY) {
        setTransaction(other.getTransaction());
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
            case 10:
              {
                input.readMessage(getBatchFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000001;
                break;
              } // case 10
            case 18:
              {
                input.readMessage(getQueryFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000002;
                break;
              } // case 18
            case 42:
              {
                transaction_ = input.readBytes();
                bitField0_ |= 0x00000004;
                break;
              } // case 42
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

    private com.google.datastore.v1.QueryResultBatch batch_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.QueryResultBatch,
            com.google.datastore.v1.QueryResultBatch.Builder,
            com.google.datastore.v1.QueryResultBatchOrBuilder>
        batchBuilder_;
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     *
     * @return Whether the batch field is set.
     */
    public boolean hasBatch() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     *
     * @return The batch.
     */
    public com.google.datastore.v1.QueryResultBatch getBatch() {
      if (batchBuilder_ == null) {
        return batch_ == null
            ? com.google.datastore.v1.QueryResultBatch.getDefaultInstance()
            : batch_;
      } else {
        return batchBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     */
    public Builder setBatch(com.google.datastore.v1.QueryResultBatch value) {
      if (batchBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        batch_ = value;
      } else {
        batchBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     */
    public Builder setBatch(com.google.datastore.v1.QueryResultBatch.Builder builderForValue) {
      if (batchBuilder_ == null) {
        batch_ = builderForValue.build();
      } else {
        batchBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     */
    public Builder mergeBatch(com.google.datastore.v1.QueryResultBatch value) {
      if (batchBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)
            && batch_ != null
            && batch_ != com.google.datastore.v1.QueryResultBatch.getDefaultInstance()) {
          getBatchBuilder().mergeFrom(value);
        } else {
          batch_ = value;
        }
      } else {
        batchBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     */
    public Builder clearBatch() {
      bitField0_ = (bitField0_ & ~0x00000001);
      batch_ = null;
      if (batchBuilder_ != null) {
        batchBuilder_.dispose();
        batchBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     */
    public com.google.datastore.v1.QueryResultBatch.Builder getBatchBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getBatchFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     */
    public com.google.datastore.v1.QueryResultBatchOrBuilder getBatchOrBuilder() {
      if (batchBuilder_ != null) {
        return batchBuilder_.getMessageOrBuilder();
      } else {
        return batch_ == null
            ? com.google.datastore.v1.QueryResultBatch.getDefaultInstance()
            : batch_;
      }
    }
    /**
     *
     *
     * <pre>
     * A batch of query results (always present).
     * </pre>
     *
     * <code>.google.datastore.v1.QueryResultBatch batch = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.QueryResultBatch,
            com.google.datastore.v1.QueryResultBatch.Builder,
            com.google.datastore.v1.QueryResultBatchOrBuilder>
        getBatchFieldBuilder() {
      if (batchBuilder_ == null) {
        batchBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.datastore.v1.QueryResultBatch,
                com.google.datastore.v1.QueryResultBatch.Builder,
                com.google.datastore.v1.QueryResultBatchOrBuilder>(
                getBatch(), getParentForChildren(), isClean());
        batch_ = null;
      }
      return batchBuilder_;
    }

    private com.google.datastore.v1.Query query_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.Query,
            com.google.datastore.v1.Query.Builder,
            com.google.datastore.v1.QueryOrBuilder>
        queryBuilder_;
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     *
     * @return Whether the query field is set.
     */
    public boolean hasQuery() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     *
     * @return The query.
     */
    public com.google.datastore.v1.Query getQuery() {
      if (queryBuilder_ == null) {
        return query_ == null ? com.google.datastore.v1.Query.getDefaultInstance() : query_;
      } else {
        return queryBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     */
    public Builder setQuery(com.google.datastore.v1.Query value) {
      if (queryBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        query_ = value;
      } else {
        queryBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     */
    public Builder setQuery(com.google.datastore.v1.Query.Builder builderForValue) {
      if (queryBuilder_ == null) {
        query_ = builderForValue.build();
      } else {
        queryBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     */
    public Builder mergeQuery(com.google.datastore.v1.Query value) {
      if (queryBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)
            && query_ != null
            && query_ != com.google.datastore.v1.Query.getDefaultInstance()) {
          getQueryBuilder().mergeFrom(value);
        } else {
          query_ = value;
        }
      } else {
        queryBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     */
    public Builder clearQuery() {
      bitField0_ = (bitField0_ & ~0x00000002);
      query_ = null;
      if (queryBuilder_ != null) {
        queryBuilder_.dispose();
        queryBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     */
    public com.google.datastore.v1.Query.Builder getQueryBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getQueryFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     */
    public com.google.datastore.v1.QueryOrBuilder getQueryOrBuilder() {
      if (queryBuilder_ != null) {
        return queryBuilder_.getMessageOrBuilder();
      } else {
        return query_ == null ? com.google.datastore.v1.Query.getDefaultInstance() : query_;
      }
    }
    /**
     *
     *
     * <pre>
     * The parsed form of the `GqlQuery` from the request, if it was set.
     * </pre>
     *
     * <code>.google.datastore.v1.Query query = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.Query,
            com.google.datastore.v1.Query.Builder,
            com.google.datastore.v1.QueryOrBuilder>
        getQueryFieldBuilder() {
      if (queryBuilder_ == null) {
        queryBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.datastore.v1.Query,
                com.google.datastore.v1.Query.Builder,
                com.google.datastore.v1.QueryOrBuilder>(
                getQuery(), getParentForChildren(), isClean());
        query_ = null;
      }
      return queryBuilder_;
    }

    private com.google.protobuf.ByteString transaction_ = com.google.protobuf.ByteString.EMPTY;
    /**
     *
     *
     * <pre>
     * The identifier of the transaction that was started as part of this
     * RunQuery request.
     * Set only when
     * [ReadOptions.new_transaction][google.datastore.v1.ReadOptions.new_transaction]
     * was set in
     * [RunQueryRequest.read_options][google.datastore.v1.RunQueryRequest.read_options].
     * </pre>
     *
     * <code>bytes transaction = 5;</code>
     *
     * @return The transaction.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getTransaction() {
      return transaction_;
    }
    /**
     *
     *
     * <pre>
     * The identifier of the transaction that was started as part of this
     * RunQuery request.
     * Set only when
     * [ReadOptions.new_transaction][google.datastore.v1.ReadOptions.new_transaction]
     * was set in
     * [RunQueryRequest.read_options][google.datastore.v1.RunQueryRequest.read_options].
     * </pre>
     *
     * <code>bytes transaction = 5;</code>
     *
     * @param value The transaction to set.
     * @return This builder for chaining.
     */
    public Builder setTransaction(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      transaction_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The identifier of the transaction that was started as part of this
     * RunQuery request.
     * Set only when
     * [ReadOptions.new_transaction][google.datastore.v1.ReadOptions.new_transaction]
     * was set in
     * [RunQueryRequest.read_options][google.datastore.v1.RunQueryRequest.read_options].
     * </pre>
     *
     * <code>bytes transaction = 5;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearTransaction() {
      bitField0_ = (bitField0_ & ~0x00000004);
      transaction_ = getDefaultInstance().getTransaction();
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

    // @@protoc_insertion_point(builder_scope:google.datastore.v1.RunQueryResponse)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.v1.RunQueryResponse)
  private static final com.google.datastore.v1.RunQueryResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.datastore.v1.RunQueryResponse();
  }

  public static com.google.datastore.v1.RunQueryResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RunQueryResponse> PARSER =
      new com.google.protobuf.AbstractParser<RunQueryResponse>() {
        @java.lang.Override
        public RunQueryResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<RunQueryResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RunQueryResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.v1.RunQueryResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
