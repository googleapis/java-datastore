// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/query_profile.proto

package com.google.datastore.v1;

/**
 * <pre>
 * Planning and execution statistics for the query.
 * </pre>
 *
 * Protobuf type {@code google.datastore.v1.ResultSetStats}
 */
public final class ResultSetStats extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.datastore.v1.ResultSetStats)
    ResultSetStatsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ResultSetStats.newBuilder() to construct.
  private ResultSetStats(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ResultSetStats() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ResultSetStats();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ResultSetStats_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ResultSetStats_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.v1.ResultSetStats.class, com.google.datastore.v1.ResultSetStats.Builder.class);
  }

  public static final int QUERY_PLAN_FIELD_NUMBER = 1;
  private com.google.datastore.v1.QueryPlan queryPlan_;
  /**
   * <pre>
   * Plan for the query.
   * </pre>
   *
   * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
   * @return Whether the queryPlan field is set.
   */
  @java.lang.Override
  public boolean hasQueryPlan() {
    return queryPlan_ != null;
  }
  /**
   * <pre>
   * Plan for the query.
   * </pre>
   *
   * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
   * @return The queryPlan.
   */
  @java.lang.Override
  public com.google.datastore.v1.QueryPlan getQueryPlan() {
    return queryPlan_ == null ? com.google.datastore.v1.QueryPlan.getDefaultInstance() : queryPlan_;
  }
  /**
   * <pre>
   * Plan for the query.
   * </pre>
   *
   * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
   */
  @java.lang.Override
  public com.google.datastore.v1.QueryPlanOrBuilder getQueryPlanOrBuilder() {
    return queryPlan_ == null ? com.google.datastore.v1.QueryPlan.getDefaultInstance() : queryPlan_;
  }

  public static final int QUERY_STATS_FIELD_NUMBER = 2;
  private com.google.protobuf.Struct queryStats_;
  /**
   * <pre>
   * Aggregated statistics from the execution of the query.
   *
   * This will only be present when the request specifies `PROFILE` mode.
   * For example, a query will return the statistics including:
   *
   * {
   *   "results_returned": "20",
   *   "documents_scanned": "20",
   *   "indexes_entries_scanned": "10050",
   *   "total_execution_time": "100.7 msecs"
   * }
   * </pre>
   *
   * <code>.google.protobuf.Struct query_stats = 2;</code>
   * @return Whether the queryStats field is set.
   */
  @java.lang.Override
  public boolean hasQueryStats() {
    return queryStats_ != null;
  }
  /**
   * <pre>
   * Aggregated statistics from the execution of the query.
   *
   * This will only be present when the request specifies `PROFILE` mode.
   * For example, a query will return the statistics including:
   *
   * {
   *   "results_returned": "20",
   *   "documents_scanned": "20",
   *   "indexes_entries_scanned": "10050",
   *   "total_execution_time": "100.7 msecs"
   * }
   * </pre>
   *
   * <code>.google.protobuf.Struct query_stats = 2;</code>
   * @return The queryStats.
   */
  @java.lang.Override
  public com.google.protobuf.Struct getQueryStats() {
    return queryStats_ == null ? com.google.protobuf.Struct.getDefaultInstance() : queryStats_;
  }
  /**
   * <pre>
   * Aggregated statistics from the execution of the query.
   *
   * This will only be present when the request specifies `PROFILE` mode.
   * For example, a query will return the statistics including:
   *
   * {
   *   "results_returned": "20",
   *   "documents_scanned": "20",
   *   "indexes_entries_scanned": "10050",
   *   "total_execution_time": "100.7 msecs"
   * }
   * </pre>
   *
   * <code>.google.protobuf.Struct query_stats = 2;</code>
   */
  @java.lang.Override
  public com.google.protobuf.StructOrBuilder getQueryStatsOrBuilder() {
    return queryStats_ == null ? com.google.protobuf.Struct.getDefaultInstance() : queryStats_;
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
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (queryPlan_ != null) {
      output.writeMessage(1, getQueryPlan());
    }
    if (queryStats_ != null) {
      output.writeMessage(2, getQueryStats());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (queryPlan_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getQueryPlan());
    }
    if (queryStats_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getQueryStats());
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
    if (!(obj instanceof com.google.datastore.v1.ResultSetStats)) {
      return super.equals(obj);
    }
    com.google.datastore.v1.ResultSetStats other = (com.google.datastore.v1.ResultSetStats) obj;

    if (hasQueryPlan() != other.hasQueryPlan()) return false;
    if (hasQueryPlan()) {
      if (!getQueryPlan()
          .equals(other.getQueryPlan())) return false;
    }
    if (hasQueryStats() != other.hasQueryStats()) return false;
    if (hasQueryStats()) {
      if (!getQueryStats()
          .equals(other.getQueryStats())) return false;
    }
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
    if (hasQueryPlan()) {
      hash = (37 * hash) + QUERY_PLAN_FIELD_NUMBER;
      hash = (53 * hash) + getQueryPlan().hashCode();
    }
    if (hasQueryStats()) {
      hash = (37 * hash) + QUERY_STATS_FIELD_NUMBER;
      hash = (53 * hash) + getQueryStats().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.v1.ResultSetStats parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.ResultSetStats parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.ResultSetStats parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.datastore.v1.ResultSetStats parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.google.datastore.v1.ResultSetStats prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * Planning and execution statistics for the query.
   * </pre>
   *
   * Protobuf type {@code google.datastore.v1.ResultSetStats}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.datastore.v1.ResultSetStats)
      com.google.datastore.v1.ResultSetStatsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ResultSetStats_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ResultSetStats_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.v1.ResultSetStats.class, com.google.datastore.v1.ResultSetStats.Builder.class);
    }

    // Construct using com.google.datastore.v1.ResultSetStats.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      queryPlan_ = null;
      if (queryPlanBuilder_ != null) {
        queryPlanBuilder_.dispose();
        queryPlanBuilder_ = null;
      }
      queryStats_ = null;
      if (queryStatsBuilder_ != null) {
        queryStatsBuilder_.dispose();
        queryStatsBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ResultSetStats_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.v1.ResultSetStats getDefaultInstanceForType() {
      return com.google.datastore.v1.ResultSetStats.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.v1.ResultSetStats build() {
      com.google.datastore.v1.ResultSetStats result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.v1.ResultSetStats buildPartial() {
      com.google.datastore.v1.ResultSetStats result = new com.google.datastore.v1.ResultSetStats(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.datastore.v1.ResultSetStats result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.queryPlan_ = queryPlanBuilder_ == null
            ? queryPlan_
            : queryPlanBuilder_.build();
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.queryStats_ = queryStatsBuilder_ == null
            ? queryStats_
            : queryStatsBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.datastore.v1.ResultSetStats) {
        return mergeFrom((com.google.datastore.v1.ResultSetStats)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.v1.ResultSetStats other) {
      if (other == com.google.datastore.v1.ResultSetStats.getDefaultInstance()) return this;
      if (other.hasQueryPlan()) {
        mergeQueryPlan(other.getQueryPlan());
      }
      if (other.hasQueryStats()) {
        mergeQueryStats(other.getQueryStats());
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
            case 10: {
              input.readMessage(
                  getQueryPlanFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getQueryStatsFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            default: {
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

    private com.google.datastore.v1.QueryPlan queryPlan_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.datastore.v1.QueryPlan, com.google.datastore.v1.QueryPlan.Builder, com.google.datastore.v1.QueryPlanOrBuilder> queryPlanBuilder_;
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     * @return Whether the queryPlan field is set.
     */
    public boolean hasQueryPlan() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     * @return The queryPlan.
     */
    public com.google.datastore.v1.QueryPlan getQueryPlan() {
      if (queryPlanBuilder_ == null) {
        return queryPlan_ == null ? com.google.datastore.v1.QueryPlan.getDefaultInstance() : queryPlan_;
      } else {
        return queryPlanBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     */
    public Builder setQueryPlan(com.google.datastore.v1.QueryPlan value) {
      if (queryPlanBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        queryPlan_ = value;
      } else {
        queryPlanBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     */
    public Builder setQueryPlan(
        com.google.datastore.v1.QueryPlan.Builder builderForValue) {
      if (queryPlanBuilder_ == null) {
        queryPlan_ = builderForValue.build();
      } else {
        queryPlanBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     */
    public Builder mergeQueryPlan(com.google.datastore.v1.QueryPlan value) {
      if (queryPlanBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0) &&
          queryPlan_ != null &&
          queryPlan_ != com.google.datastore.v1.QueryPlan.getDefaultInstance()) {
          getQueryPlanBuilder().mergeFrom(value);
        } else {
          queryPlan_ = value;
        }
      } else {
        queryPlanBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     */
    public Builder clearQueryPlan() {
      bitField0_ = (bitField0_ & ~0x00000001);
      queryPlan_ = null;
      if (queryPlanBuilder_ != null) {
        queryPlanBuilder_.dispose();
        queryPlanBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     */
    public com.google.datastore.v1.QueryPlan.Builder getQueryPlanBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getQueryPlanFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     */
    public com.google.datastore.v1.QueryPlanOrBuilder getQueryPlanOrBuilder() {
      if (queryPlanBuilder_ != null) {
        return queryPlanBuilder_.getMessageOrBuilder();
      } else {
        return queryPlan_ == null ?
            com.google.datastore.v1.QueryPlan.getDefaultInstance() : queryPlan_;
      }
    }
    /**
     * <pre>
     * Plan for the query.
     * </pre>
     *
     * <code>.google.datastore.v1.QueryPlan query_plan = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.datastore.v1.QueryPlan, com.google.datastore.v1.QueryPlan.Builder, com.google.datastore.v1.QueryPlanOrBuilder> 
        getQueryPlanFieldBuilder() {
      if (queryPlanBuilder_ == null) {
        queryPlanBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.QueryPlan, com.google.datastore.v1.QueryPlan.Builder, com.google.datastore.v1.QueryPlanOrBuilder>(
                getQueryPlan(),
                getParentForChildren(),
                isClean());
        queryPlan_ = null;
      }
      return queryPlanBuilder_;
    }

    private com.google.protobuf.Struct queryStats_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> queryStatsBuilder_;
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     * @return Whether the queryStats field is set.
     */
    public boolean hasQueryStats() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     * @return The queryStats.
     */
    public com.google.protobuf.Struct getQueryStats() {
      if (queryStatsBuilder_ == null) {
        return queryStats_ == null ? com.google.protobuf.Struct.getDefaultInstance() : queryStats_;
      } else {
        return queryStatsBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     */
    public Builder setQueryStats(com.google.protobuf.Struct value) {
      if (queryStatsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        queryStats_ = value;
      } else {
        queryStatsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     */
    public Builder setQueryStats(
        com.google.protobuf.Struct.Builder builderForValue) {
      if (queryStatsBuilder_ == null) {
        queryStats_ = builderForValue.build();
      } else {
        queryStatsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     */
    public Builder mergeQueryStats(com.google.protobuf.Struct value) {
      if (queryStatsBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          queryStats_ != null &&
          queryStats_ != com.google.protobuf.Struct.getDefaultInstance()) {
          getQueryStatsBuilder().mergeFrom(value);
        } else {
          queryStats_ = value;
        }
      } else {
        queryStatsBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     */
    public Builder clearQueryStats() {
      bitField0_ = (bitField0_ & ~0x00000002);
      queryStats_ = null;
      if (queryStatsBuilder_ != null) {
        queryStatsBuilder_.dispose();
        queryStatsBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     */
    public com.google.protobuf.Struct.Builder getQueryStatsBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getQueryStatsFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     */
    public com.google.protobuf.StructOrBuilder getQueryStatsOrBuilder() {
      if (queryStatsBuilder_ != null) {
        return queryStatsBuilder_.getMessageOrBuilder();
      } else {
        return queryStats_ == null ?
            com.google.protobuf.Struct.getDefaultInstance() : queryStats_;
      }
    }
    /**
     * <pre>
     * Aggregated statistics from the execution of the query.
     *
     * This will only be present when the request specifies `PROFILE` mode.
     * For example, a query will return the statistics including:
     *
     * {
     *   "results_returned": "20",
     *   "documents_scanned": "20",
     *   "indexes_entries_scanned": "10050",
     *   "total_execution_time": "100.7 msecs"
     * }
     * </pre>
     *
     * <code>.google.protobuf.Struct query_stats = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> 
        getQueryStatsFieldBuilder() {
      if (queryStatsBuilder_ == null) {
        queryStatsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder>(
                getQueryStats(),
                getParentForChildren(),
                isClean());
        queryStats_ = null;
      }
      return queryStatsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:google.datastore.v1.ResultSetStats)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.v1.ResultSetStats)
  private static final com.google.datastore.v1.ResultSetStats DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.datastore.v1.ResultSetStats();
  }

  public static com.google.datastore.v1.ResultSetStats getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ResultSetStats>
      PARSER = new com.google.protobuf.AbstractParser<ResultSetStats>() {
    @java.lang.Override
    public ResultSetStats parsePartialFrom(
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

  public static com.google.protobuf.Parser<ResultSetStats> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ResultSetStats> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.v1.ResultSetStats getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

