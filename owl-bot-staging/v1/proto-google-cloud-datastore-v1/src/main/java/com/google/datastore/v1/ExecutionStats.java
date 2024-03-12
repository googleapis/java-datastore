// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/query_profile.proto

// Protobuf Java Version: 3.25.2
package com.google.datastore.v1;

/**
 * <pre>
 * Execution statistics for the query.
 * </pre>
 *
 * Protobuf type {@code google.datastore.v1.ExecutionStats}
 */
public final class ExecutionStats extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:google.datastore.v1.ExecutionStats)
    ExecutionStatsOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ExecutionStats.newBuilder() to construct.
  private ExecutionStats(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ExecutionStats() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ExecutionStats();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ExecutionStats_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ExecutionStats_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.v1.ExecutionStats.class, com.google.datastore.v1.ExecutionStats.Builder.class);
  }

  private int bitField0_;
  public static final int RESULTS_RETURNED_FIELD_NUMBER = 1;
  private long resultsReturned_ = 0L;
  /**
   * <pre>
   * Total number of results returned, including documents, projections,
   * aggregation results, keys.
   * </pre>
   *
   * <code>int64 results_returned = 1;</code>
   * @return The resultsReturned.
   */
  @java.lang.Override
  public long getResultsReturned() {
    return resultsReturned_;
  }

  public static final int EXECUTION_DURATION_FIELD_NUMBER = 3;
  private com.google.protobuf.Duration executionDuration_;
  /**
   * <pre>
   * Total time to execute the query in the backend.
   * </pre>
   *
   * <code>.google.protobuf.Duration execution_duration = 3;</code>
   * @return Whether the executionDuration field is set.
   */
  @java.lang.Override
  public boolean hasExecutionDuration() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <pre>
   * Total time to execute the query in the backend.
   * </pre>
   *
   * <code>.google.protobuf.Duration execution_duration = 3;</code>
   * @return The executionDuration.
   */
  @java.lang.Override
  public com.google.protobuf.Duration getExecutionDuration() {
    return executionDuration_ == null ? com.google.protobuf.Duration.getDefaultInstance() : executionDuration_;
  }
  /**
   * <pre>
   * Total time to execute the query in the backend.
   * </pre>
   *
   * <code>.google.protobuf.Duration execution_duration = 3;</code>
   */
  @java.lang.Override
  public com.google.protobuf.DurationOrBuilder getExecutionDurationOrBuilder() {
    return executionDuration_ == null ? com.google.protobuf.Duration.getDefaultInstance() : executionDuration_;
  }

  public static final int READ_OPERATIONS_FIELD_NUMBER = 4;
  private long readOperations_ = 0L;
  /**
   * <pre>
   * Total billable read operations.
   * </pre>
   *
   * <code>int64 read_operations = 4;</code>
   * @return The readOperations.
   */
  @java.lang.Override
  public long getReadOperations() {
    return readOperations_;
  }

  public static final int DEBUG_STATS_FIELD_NUMBER = 5;
  private com.google.protobuf.Struct debugStats_;
  /**
   * <pre>
   * Debugging statistics from the execution of the query. Note that the
   * debugging stats are subject to change as Firestore evolves. It could
   * include:
   *  {
   *    "indexes_entries_scanned": "1000",
   *    "documents_scanned": "20",
   *    "billing_details" : {
   *       "documents_billable": "20",
   *       "index_entries_billable": "1000",
   *       "min_query_cost": "0"
   *    }
   *  }
   * </pre>
   *
   * <code>.google.protobuf.Struct debug_stats = 5;</code>
   * @return Whether the debugStats field is set.
   */
  @java.lang.Override
  public boolean hasDebugStats() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <pre>
   * Debugging statistics from the execution of the query. Note that the
   * debugging stats are subject to change as Firestore evolves. It could
   * include:
   *  {
   *    "indexes_entries_scanned": "1000",
   *    "documents_scanned": "20",
   *    "billing_details" : {
   *       "documents_billable": "20",
   *       "index_entries_billable": "1000",
   *       "min_query_cost": "0"
   *    }
   *  }
   * </pre>
   *
   * <code>.google.protobuf.Struct debug_stats = 5;</code>
   * @return The debugStats.
   */
  @java.lang.Override
  public com.google.protobuf.Struct getDebugStats() {
    return debugStats_ == null ? com.google.protobuf.Struct.getDefaultInstance() : debugStats_;
  }
  /**
   * <pre>
   * Debugging statistics from the execution of the query. Note that the
   * debugging stats are subject to change as Firestore evolves. It could
   * include:
   *  {
   *    "indexes_entries_scanned": "1000",
   *    "documents_scanned": "20",
   *    "billing_details" : {
   *       "documents_billable": "20",
   *       "index_entries_billable": "1000",
   *       "min_query_cost": "0"
   *    }
   *  }
   * </pre>
   *
   * <code>.google.protobuf.Struct debug_stats = 5;</code>
   */
  @java.lang.Override
  public com.google.protobuf.StructOrBuilder getDebugStatsOrBuilder() {
    return debugStats_ == null ? com.google.protobuf.Struct.getDefaultInstance() : debugStats_;
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
    if (resultsReturned_ != 0L) {
      output.writeInt64(1, resultsReturned_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(3, getExecutionDuration());
    }
    if (readOperations_ != 0L) {
      output.writeInt64(4, readOperations_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(5, getDebugStats());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (resultsReturned_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, resultsReturned_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getExecutionDuration());
    }
    if (readOperations_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(4, readOperations_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, getDebugStats());
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
    if (!(obj instanceof com.google.datastore.v1.ExecutionStats)) {
      return super.equals(obj);
    }
    com.google.datastore.v1.ExecutionStats other = (com.google.datastore.v1.ExecutionStats) obj;

    if (getResultsReturned()
        != other.getResultsReturned()) return false;
    if (hasExecutionDuration() != other.hasExecutionDuration()) return false;
    if (hasExecutionDuration()) {
      if (!getExecutionDuration()
          .equals(other.getExecutionDuration())) return false;
    }
    if (getReadOperations()
        != other.getReadOperations()) return false;
    if (hasDebugStats() != other.hasDebugStats()) return false;
    if (hasDebugStats()) {
      if (!getDebugStats()
          .equals(other.getDebugStats())) return false;
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
    hash = (37 * hash) + RESULTS_RETURNED_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getResultsReturned());
    if (hasExecutionDuration()) {
      hash = (37 * hash) + EXECUTION_DURATION_FIELD_NUMBER;
      hash = (53 * hash) + getExecutionDuration().hashCode();
    }
    hash = (37 * hash) + READ_OPERATIONS_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getReadOperations());
    if (hasDebugStats()) {
      hash = (37 * hash) + DEBUG_STATS_FIELD_NUMBER;
      hash = (53 * hash) + getDebugStats().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.v1.ExecutionStats parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.ExecutionStats parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.ExecutionStats parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.google.datastore.v1.ExecutionStats parseFrom(
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
  public static Builder newBuilder(com.google.datastore.v1.ExecutionStats prototype) {
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
   * Execution statistics for the query.
   * </pre>
   *
   * Protobuf type {@code google.datastore.v1.ExecutionStats}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:google.datastore.v1.ExecutionStats)
      com.google.datastore.v1.ExecutionStatsOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ExecutionStats_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ExecutionStats_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.v1.ExecutionStats.class, com.google.datastore.v1.ExecutionStats.Builder.class);
    }

    // Construct using com.google.datastore.v1.ExecutionStats.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getExecutionDurationFieldBuilder();
        getDebugStatsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      resultsReturned_ = 0L;
      executionDuration_ = null;
      if (executionDurationBuilder_ != null) {
        executionDurationBuilder_.dispose();
        executionDurationBuilder_ = null;
      }
      readOperations_ = 0L;
      debugStats_ = null;
      if (debugStatsBuilder_ != null) {
        debugStatsBuilder_.dispose();
        debugStatsBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.google.datastore.v1.QueryProfileProto.internal_static_google_datastore_v1_ExecutionStats_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.v1.ExecutionStats getDefaultInstanceForType() {
      return com.google.datastore.v1.ExecutionStats.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.v1.ExecutionStats build() {
      com.google.datastore.v1.ExecutionStats result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.v1.ExecutionStats buildPartial() {
      com.google.datastore.v1.ExecutionStats result = new com.google.datastore.v1.ExecutionStats(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.datastore.v1.ExecutionStats result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.resultsReturned_ = resultsReturned_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.executionDuration_ = executionDurationBuilder_ == null
            ? executionDuration_
            : executionDurationBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.readOperations_ = readOperations_;
      }
      if (((from_bitField0_ & 0x00000008) != 0)) {
        result.debugStats_ = debugStatsBuilder_ == null
            ? debugStats_
            : debugStatsBuilder_.build();
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ |= to_bitField0_;
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
      if (other instanceof com.google.datastore.v1.ExecutionStats) {
        return mergeFrom((com.google.datastore.v1.ExecutionStats)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.v1.ExecutionStats other) {
      if (other == com.google.datastore.v1.ExecutionStats.getDefaultInstance()) return this;
      if (other.getResultsReturned() != 0L) {
        setResultsReturned(other.getResultsReturned());
      }
      if (other.hasExecutionDuration()) {
        mergeExecutionDuration(other.getExecutionDuration());
      }
      if (other.getReadOperations() != 0L) {
        setReadOperations(other.getReadOperations());
      }
      if (other.hasDebugStats()) {
        mergeDebugStats(other.getDebugStats());
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
            case 8: {
              resultsReturned_ = input.readInt64();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 26: {
              input.readMessage(
                  getExecutionDurationFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 26
            case 32: {
              readOperations_ = input.readInt64();
              bitField0_ |= 0x00000004;
              break;
            } // case 32
            case 42: {
              input.readMessage(
                  getDebugStatsFieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000008;
              break;
            } // case 42
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

    private long resultsReturned_ ;
    /**
     * <pre>
     * Total number of results returned, including documents, projections,
     * aggregation results, keys.
     * </pre>
     *
     * <code>int64 results_returned = 1;</code>
     * @return The resultsReturned.
     */
    @java.lang.Override
    public long getResultsReturned() {
      return resultsReturned_;
    }
    /**
     * <pre>
     * Total number of results returned, including documents, projections,
     * aggregation results, keys.
     * </pre>
     *
     * <code>int64 results_returned = 1;</code>
     * @param value The resultsReturned to set.
     * @return This builder for chaining.
     */
    public Builder setResultsReturned(long value) {

      resultsReturned_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Total number of results returned, including documents, projections,
     * aggregation results, keys.
     * </pre>
     *
     * <code>int64 results_returned = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearResultsReturned() {
      bitField0_ = (bitField0_ & ~0x00000001);
      resultsReturned_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.Duration executionDuration_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Duration, com.google.protobuf.Duration.Builder, com.google.protobuf.DurationOrBuilder> executionDurationBuilder_;
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     * @return Whether the executionDuration field is set.
     */
    public boolean hasExecutionDuration() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     * @return The executionDuration.
     */
    public com.google.protobuf.Duration getExecutionDuration() {
      if (executionDurationBuilder_ == null) {
        return executionDuration_ == null ? com.google.protobuf.Duration.getDefaultInstance() : executionDuration_;
      } else {
        return executionDurationBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     */
    public Builder setExecutionDuration(com.google.protobuf.Duration value) {
      if (executionDurationBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        executionDuration_ = value;
      } else {
        executionDurationBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     */
    public Builder setExecutionDuration(
        com.google.protobuf.Duration.Builder builderForValue) {
      if (executionDurationBuilder_ == null) {
        executionDuration_ = builderForValue.build();
      } else {
        executionDurationBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     */
    public Builder mergeExecutionDuration(com.google.protobuf.Duration value) {
      if (executionDurationBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          executionDuration_ != null &&
          executionDuration_ != com.google.protobuf.Duration.getDefaultInstance()) {
          getExecutionDurationBuilder().mergeFrom(value);
        } else {
          executionDuration_ = value;
        }
      } else {
        executionDurationBuilder_.mergeFrom(value);
      }
      if (executionDuration_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     */
    public Builder clearExecutionDuration() {
      bitField0_ = (bitField0_ & ~0x00000002);
      executionDuration_ = null;
      if (executionDurationBuilder_ != null) {
        executionDurationBuilder_.dispose();
        executionDurationBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     */
    public com.google.protobuf.Duration.Builder getExecutionDurationBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getExecutionDurationFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     */
    public com.google.protobuf.DurationOrBuilder getExecutionDurationOrBuilder() {
      if (executionDurationBuilder_ != null) {
        return executionDurationBuilder_.getMessageOrBuilder();
      } else {
        return executionDuration_ == null ?
            com.google.protobuf.Duration.getDefaultInstance() : executionDuration_;
      }
    }
    /**
     * <pre>
     * Total time to execute the query in the backend.
     * </pre>
     *
     * <code>.google.protobuf.Duration execution_duration = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Duration, com.google.protobuf.Duration.Builder, com.google.protobuf.DurationOrBuilder> 
        getExecutionDurationFieldBuilder() {
      if (executionDurationBuilder_ == null) {
        executionDurationBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Duration, com.google.protobuf.Duration.Builder, com.google.protobuf.DurationOrBuilder>(
                getExecutionDuration(),
                getParentForChildren(),
                isClean());
        executionDuration_ = null;
      }
      return executionDurationBuilder_;
    }

    private long readOperations_ ;
    /**
     * <pre>
     * Total billable read operations.
     * </pre>
     *
     * <code>int64 read_operations = 4;</code>
     * @return The readOperations.
     */
    @java.lang.Override
    public long getReadOperations() {
      return readOperations_;
    }
    /**
     * <pre>
     * Total billable read operations.
     * </pre>
     *
     * <code>int64 read_operations = 4;</code>
     * @param value The readOperations to set.
     * @return This builder for chaining.
     */
    public Builder setReadOperations(long value) {

      readOperations_ = value;
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Total billable read operations.
     * </pre>
     *
     * <code>int64 read_operations = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearReadOperations() {
      bitField0_ = (bitField0_ & ~0x00000004);
      readOperations_ = 0L;
      onChanged();
      return this;
    }

    private com.google.protobuf.Struct debugStats_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> debugStatsBuilder_;
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     * @return Whether the debugStats field is set.
     */
    public boolean hasDebugStats() {
      return ((bitField0_ & 0x00000008) != 0);
    }
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     * @return The debugStats.
     */
    public com.google.protobuf.Struct getDebugStats() {
      if (debugStatsBuilder_ == null) {
        return debugStats_ == null ? com.google.protobuf.Struct.getDefaultInstance() : debugStats_;
      } else {
        return debugStatsBuilder_.getMessage();
      }
    }
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     */
    public Builder setDebugStats(com.google.protobuf.Struct value) {
      if (debugStatsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        debugStats_ = value;
      } else {
        debugStatsBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     */
    public Builder setDebugStats(
        com.google.protobuf.Struct.Builder builderForValue) {
      if (debugStatsBuilder_ == null) {
        debugStats_ = builderForValue.build();
      } else {
        debugStatsBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000008;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     */
    public Builder mergeDebugStats(com.google.protobuf.Struct value) {
      if (debugStatsBuilder_ == null) {
        if (((bitField0_ & 0x00000008) != 0) &&
          debugStats_ != null &&
          debugStats_ != com.google.protobuf.Struct.getDefaultInstance()) {
          getDebugStatsBuilder().mergeFrom(value);
        } else {
          debugStats_ = value;
        }
      } else {
        debugStatsBuilder_.mergeFrom(value);
      }
      if (debugStats_ != null) {
        bitField0_ |= 0x00000008;
        onChanged();
      }
      return this;
    }
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     */
    public Builder clearDebugStats() {
      bitField0_ = (bitField0_ & ~0x00000008);
      debugStats_ = null;
      if (debugStatsBuilder_ != null) {
        debugStatsBuilder_.dispose();
        debugStatsBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     */
    public com.google.protobuf.Struct.Builder getDebugStatsBuilder() {
      bitField0_ |= 0x00000008;
      onChanged();
      return getDebugStatsFieldBuilder().getBuilder();
    }
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     */
    public com.google.protobuf.StructOrBuilder getDebugStatsOrBuilder() {
      if (debugStatsBuilder_ != null) {
        return debugStatsBuilder_.getMessageOrBuilder();
      } else {
        return debugStats_ == null ?
            com.google.protobuf.Struct.getDefaultInstance() : debugStats_;
      }
    }
    /**
     * <pre>
     * Debugging statistics from the execution of the query. Note that the
     * debugging stats are subject to change as Firestore evolves. It could
     * include:
     *  {
     *    "indexes_entries_scanned": "1000",
     *    "documents_scanned": "20",
     *    "billing_details" : {
     *       "documents_billable": "20",
     *       "index_entries_billable": "1000",
     *       "min_query_cost": "0"
     *    }
     *  }
     * </pre>
     *
     * <code>.google.protobuf.Struct debug_stats = 5;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder> 
        getDebugStatsFieldBuilder() {
      if (debugStatsBuilder_ == null) {
        debugStatsBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.Struct, com.google.protobuf.Struct.Builder, com.google.protobuf.StructOrBuilder>(
                getDebugStats(),
                getParentForChildren(),
                isClean());
        debugStats_ = null;
      }
      return debugStatsBuilder_;
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


    // @@protoc_insertion_point(builder_scope:google.datastore.v1.ExecutionStats)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.v1.ExecutionStats)
  private static final com.google.datastore.v1.ExecutionStats DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.google.datastore.v1.ExecutionStats();
  }

  public static com.google.datastore.v1.ExecutionStats getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ExecutionStats>
      PARSER = new com.google.protobuf.AbstractParser<ExecutionStats>() {
    @java.lang.Override
    public ExecutionStats parsePartialFrom(
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

  public static com.google.protobuf.Parser<ExecutionStats> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ExecutionStats> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.v1.ExecutionStats getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

