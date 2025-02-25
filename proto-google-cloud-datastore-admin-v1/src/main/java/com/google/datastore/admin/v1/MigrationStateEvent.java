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
// source: google/datastore/admin/v1/migration.proto

// Protobuf Java Version: 3.25.5
package com.google.datastore.admin.v1;

/**
 *
 *
 * <pre>
 * An event signifying a change in state of a [migration from Cloud Datastore to
 * Cloud Firestore in Datastore
 * mode](https://cloud.google.com/datastore/docs/upgrade-to-firestore).
 * </pre>
 *
 * Protobuf type {@code google.datastore.admin.v1.MigrationStateEvent}
 */
public final class MigrationStateEvent extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.datastore.admin.v1.MigrationStateEvent)
    MigrationStateEventOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use MigrationStateEvent.newBuilder() to construct.
  private MigrationStateEvent(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private MigrationStateEvent() {
    state_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new MigrationStateEvent();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.datastore.admin.v1.MigrationProto
        .internal_static_google_datastore_admin_v1_MigrationStateEvent_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.admin.v1.MigrationProto
        .internal_static_google_datastore_admin_v1_MigrationStateEvent_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.admin.v1.MigrationStateEvent.class,
            com.google.datastore.admin.v1.MigrationStateEvent.Builder.class);
  }

  public static final int STATE_FIELD_NUMBER = 1;
  private int state_ = 0;
  /**
   *
   *
   * <pre>
   * The new state of the migration.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.MigrationState state = 1;</code>
   *
   * @return The enum numeric value on the wire for state.
   */
  @java.lang.Override
  public int getStateValue() {
    return state_;
  }
  /**
   *
   *
   * <pre>
   * The new state of the migration.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.MigrationState state = 1;</code>
   *
   * @return The state.
   */
  @java.lang.Override
  public com.google.datastore.admin.v1.MigrationState getState() {
    com.google.datastore.admin.v1.MigrationState result =
        com.google.datastore.admin.v1.MigrationState.forNumber(state_);
    return result == null ? com.google.datastore.admin.v1.MigrationState.UNRECOGNIZED : result;
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
    if (state_
        != com.google.datastore.admin.v1.MigrationState.MIGRATION_STATE_UNSPECIFIED.getNumber()) {
      output.writeEnum(1, state_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (state_
        != com.google.datastore.admin.v1.MigrationState.MIGRATION_STATE_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(1, state_);
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
    if (!(obj instanceof com.google.datastore.admin.v1.MigrationStateEvent)) {
      return super.equals(obj);
    }
    com.google.datastore.admin.v1.MigrationStateEvent other =
        (com.google.datastore.admin.v1.MigrationStateEvent) obj;

    if (state_ != other.state_) return false;
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
    hash = (37 * hash) + STATE_FIELD_NUMBER;
    hash = (53 * hash) + state_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent parseFrom(
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

  public static Builder newBuilder(com.google.datastore.admin.v1.MigrationStateEvent prototype) {
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
   * An event signifying a change in state of a [migration from Cloud Datastore to
   * Cloud Firestore in Datastore
   * mode](https://cloud.google.com/datastore/docs/upgrade-to-firestore).
   * </pre>
   *
   * Protobuf type {@code google.datastore.admin.v1.MigrationStateEvent}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.datastore.admin.v1.MigrationStateEvent)
      com.google.datastore.admin.v1.MigrationStateEventOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.datastore.admin.v1.MigrationProto
          .internal_static_google_datastore_admin_v1_MigrationStateEvent_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.admin.v1.MigrationProto
          .internal_static_google_datastore_admin_v1_MigrationStateEvent_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.admin.v1.MigrationStateEvent.class,
              com.google.datastore.admin.v1.MigrationStateEvent.Builder.class);
    }

    // Construct using com.google.datastore.admin.v1.MigrationStateEvent.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      state_ = 0;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.datastore.admin.v1.MigrationProto
          .internal_static_google_datastore_admin_v1_MigrationStateEvent_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.MigrationStateEvent getDefaultInstanceForType() {
      return com.google.datastore.admin.v1.MigrationStateEvent.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.MigrationStateEvent build() {
      com.google.datastore.admin.v1.MigrationStateEvent result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.MigrationStateEvent buildPartial() {
      com.google.datastore.admin.v1.MigrationStateEvent result =
          new com.google.datastore.admin.v1.MigrationStateEvent(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.datastore.admin.v1.MigrationStateEvent result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.state_ = state_;
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
      if (other instanceof com.google.datastore.admin.v1.MigrationStateEvent) {
        return mergeFrom((com.google.datastore.admin.v1.MigrationStateEvent) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.admin.v1.MigrationStateEvent other) {
      if (other == com.google.datastore.admin.v1.MigrationStateEvent.getDefaultInstance())
        return this;
      if (other.state_ != 0) {
        setStateValue(other.getStateValue());
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
            case 8:
              {
                state_ = input.readEnum();
                bitField0_ |= 0x00000001;
                break;
              } // case 8
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

    private int state_ = 0;
    /**
     *
     *
     * <pre>
     * The new state of the migration.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState state = 1;</code>
     *
     * @return The enum numeric value on the wire for state.
     */
    @java.lang.Override
    public int getStateValue() {
      return state_;
    }
    /**
     *
     *
     * <pre>
     * The new state of the migration.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState state = 1;</code>
     *
     * @param value The enum numeric value on the wire for state to set.
     * @return This builder for chaining.
     */
    public Builder setStateValue(int value) {
      state_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The new state of the migration.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState state = 1;</code>
     *
     * @return The state.
     */
    @java.lang.Override
    public com.google.datastore.admin.v1.MigrationState getState() {
      com.google.datastore.admin.v1.MigrationState result =
          com.google.datastore.admin.v1.MigrationState.forNumber(state_);
      return result == null ? com.google.datastore.admin.v1.MigrationState.UNRECOGNIZED : result;
    }
    /**
     *
     *
     * <pre>
     * The new state of the migration.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState state = 1;</code>
     *
     * @param value The state to set.
     * @return This builder for chaining.
     */
    public Builder setState(com.google.datastore.admin.v1.MigrationState value) {
      if (value == null) {
        throw new NullPointerException();
      }
      bitField0_ |= 0x00000001;
      state_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The new state of the migration.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState state = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearState() {
      bitField0_ = (bitField0_ & ~0x00000001);
      state_ = 0;
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

    // @@protoc_insertion_point(builder_scope:google.datastore.admin.v1.MigrationStateEvent)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.admin.v1.MigrationStateEvent)
  private static final com.google.datastore.admin.v1.MigrationStateEvent DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.datastore.admin.v1.MigrationStateEvent();
  }

  public static com.google.datastore.admin.v1.MigrationStateEvent getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MigrationStateEvent> PARSER =
      new com.google.protobuf.AbstractParser<MigrationStateEvent>() {
        @java.lang.Override
        public MigrationStateEvent parsePartialFrom(
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

  public static com.google.protobuf.Parser<MigrationStateEvent> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MigrationStateEvent> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.admin.v1.MigrationStateEvent getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
