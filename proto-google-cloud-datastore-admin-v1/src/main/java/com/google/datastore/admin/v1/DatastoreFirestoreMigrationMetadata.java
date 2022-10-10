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
 * Metadata for Datastore to Firestore migration operations.
 * The DatastoreFirestoreMigration operation is not started by the end-user via
 * an explicit "creation" method. This is an intentional deviation from the LRO
 * design pattern.
 * This singleton resource can be accessed at:
 * "projects/{project_id}/operations/datastore-firestore-migration"
 * </pre>
 *
 * Protobuf type {@code google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata}
 */
public final class DatastoreFirestoreMigrationMetadata
    extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata)
    DatastoreFirestoreMigrationMetadataOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use DatastoreFirestoreMigrationMetadata.newBuilder() to construct.
  private DatastoreFirestoreMigrationMetadata(
      com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private DatastoreFirestoreMigrationMetadata() {
    migrationState_ = 0;
    migrationStep_ = 0;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new DatastoreFirestoreMigrationMetadata();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.datastore.admin.v1.DatastoreAdminProto
        .internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.admin.v1.DatastoreAdminProto
        .internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata.class,
            com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata.Builder.class);
  }

  public static final int MIGRATION_STATE_FIELD_NUMBER = 1;
  private int migrationState_;
  /**
   *
   *
   * <pre>
   * The current state of migration from Cloud Datastore to Cloud Firestore in
   * Datastore mode.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.MigrationState migration_state = 1;</code>
   *
   * @return The enum numeric value on the wire for migrationState.
   */
  @java.lang.Override
  public int getMigrationStateValue() {
    return migrationState_;
  }
  /**
   *
   *
   * <pre>
   * The current state of migration from Cloud Datastore to Cloud Firestore in
   * Datastore mode.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.MigrationState migration_state = 1;</code>
   *
   * @return The migrationState.
   */
  @java.lang.Override
  public com.google.datastore.admin.v1.MigrationState getMigrationState() {
    @SuppressWarnings("deprecation")
    com.google.datastore.admin.v1.MigrationState result =
        com.google.datastore.admin.v1.MigrationState.valueOf(migrationState_);
    return result == null ? com.google.datastore.admin.v1.MigrationState.UNRECOGNIZED : result;
  }

  public static final int MIGRATION_STEP_FIELD_NUMBER = 2;
  private int migrationStep_;
  /**
   *
   *
   * <pre>
   * The current step of migration from Cloud Datastore to Cloud Firestore in
   * Datastore mode.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.MigrationStep migration_step = 2;</code>
   *
   * @return The enum numeric value on the wire for migrationStep.
   */
  @java.lang.Override
  public int getMigrationStepValue() {
    return migrationStep_;
  }
  /**
   *
   *
   * <pre>
   * The current step of migration from Cloud Datastore to Cloud Firestore in
   * Datastore mode.
   * </pre>
   *
   * <code>.google.datastore.admin.v1.MigrationStep migration_step = 2;</code>
   *
   * @return The migrationStep.
   */
  @java.lang.Override
  public com.google.datastore.admin.v1.MigrationStep getMigrationStep() {
    @SuppressWarnings("deprecation")
    com.google.datastore.admin.v1.MigrationStep result =
        com.google.datastore.admin.v1.MigrationStep.valueOf(migrationStep_);
    return result == null ? com.google.datastore.admin.v1.MigrationStep.UNRECOGNIZED : result;
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
    if (migrationState_
        != com.google.datastore.admin.v1.MigrationState.MIGRATION_STATE_UNSPECIFIED.getNumber()) {
      output.writeEnum(1, migrationState_);
    }
    if (migrationStep_
        != com.google.datastore.admin.v1.MigrationStep.MIGRATION_STEP_UNSPECIFIED.getNumber()) {
      output.writeEnum(2, migrationStep_);
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (migrationState_
        != com.google.datastore.admin.v1.MigrationState.MIGRATION_STATE_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(1, migrationState_);
    }
    if (migrationStep_
        != com.google.datastore.admin.v1.MigrationStep.MIGRATION_STEP_UNSPECIFIED.getNumber()) {
      size += com.google.protobuf.CodedOutputStream.computeEnumSize(2, migrationStep_);
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
    if (!(obj instanceof com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata)) {
      return super.equals(obj);
    }
    com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata other =
        (com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata) obj;

    if (migrationState_ != other.migrationState_) return false;
    if (migrationStep_ != other.migrationStep_) return false;
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
    hash = (37 * hash) + MIGRATION_STATE_FIELD_NUMBER;
    hash = (53 * hash) + migrationState_;
    hash = (37 * hash) + MIGRATION_STEP_FIELD_NUMBER;
    hash = (53 * hash) + migrationStep_;
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      byte[] data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata
      parseDelimitedFrom(java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata
      parseDelimitedFrom(
          java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata parseFrom(
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

  public static Builder newBuilder(
      com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata prototype) {
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
   * Metadata for Datastore to Firestore migration operations.
   * The DatastoreFirestoreMigration operation is not started by the end-user via
   * an explicit "creation" method. This is an intentional deviation from the LRO
   * design pattern.
   * This singleton resource can be accessed at:
   * "projects/{project_id}/operations/datastore-firestore-migration"
   * </pre>
   *
   * Protobuf type {@code google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata)
      com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadataOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.datastore.admin.v1.DatastoreAdminProto
          .internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.admin.v1.DatastoreAdminProto
          .internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata.class,
              com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata.Builder.class);
    }

    // Construct using
    // com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      migrationState_ = 0;

      migrationStep_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.datastore.admin.v1.DatastoreAdminProto
          .internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata
        getDefaultInstanceForType() {
      return com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata build() {
      com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata buildPartial() {
      com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata result =
          new com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata(this);
      result.migrationState_ = migrationState_;
      result.migrationStep_ = migrationStep_;
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
      if (other instanceof com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata) {
        return mergeFrom((com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(
        com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata other) {
      if (other
          == com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata.getDefaultInstance())
        return this;
      if (other.migrationState_ != 0) {
        setMigrationStateValue(other.getMigrationStateValue());
      }
      if (other.migrationStep_ != 0) {
        setMigrationStepValue(other.getMigrationStepValue());
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
                migrationState_ = input.readEnum();

                break;
              } // case 8
            case 16:
              {
                migrationStep_ = input.readEnum();

                break;
              } // case 16
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

    private int migrationState_ = 0;
    /**
     *
     *
     * <pre>
     * The current state of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState migration_state = 1;</code>
     *
     * @return The enum numeric value on the wire for migrationState.
     */
    @java.lang.Override
    public int getMigrationStateValue() {
      return migrationState_;
    }
    /**
     *
     *
     * <pre>
     * The current state of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState migration_state = 1;</code>
     *
     * @param value The enum numeric value on the wire for migrationState to set.
     * @return This builder for chaining.
     */
    public Builder setMigrationStateValue(int value) {

      migrationState_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The current state of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState migration_state = 1;</code>
     *
     * @return The migrationState.
     */
    @java.lang.Override
    public com.google.datastore.admin.v1.MigrationState getMigrationState() {
      @SuppressWarnings("deprecation")
      com.google.datastore.admin.v1.MigrationState result =
          com.google.datastore.admin.v1.MigrationState.valueOf(migrationState_);
      return result == null ? com.google.datastore.admin.v1.MigrationState.UNRECOGNIZED : result;
    }
    /**
     *
     *
     * <pre>
     * The current state of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState migration_state = 1;</code>
     *
     * @param value The migrationState to set.
     * @return This builder for chaining.
     */
    public Builder setMigrationState(com.google.datastore.admin.v1.MigrationState value) {
      if (value == null) {
        throw new NullPointerException();
      }

      migrationState_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The current state of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationState migration_state = 1;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearMigrationState() {

      migrationState_ = 0;
      onChanged();
      return this;
    }

    private int migrationStep_ = 0;
    /**
     *
     *
     * <pre>
     * The current step of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationStep migration_step = 2;</code>
     *
     * @return The enum numeric value on the wire for migrationStep.
     */
    @java.lang.Override
    public int getMigrationStepValue() {
      return migrationStep_;
    }
    /**
     *
     *
     * <pre>
     * The current step of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationStep migration_step = 2;</code>
     *
     * @param value The enum numeric value on the wire for migrationStep to set.
     * @return This builder for chaining.
     */
    public Builder setMigrationStepValue(int value) {

      migrationStep_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The current step of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationStep migration_step = 2;</code>
     *
     * @return The migrationStep.
     */
    @java.lang.Override
    public com.google.datastore.admin.v1.MigrationStep getMigrationStep() {
      @SuppressWarnings("deprecation")
      com.google.datastore.admin.v1.MigrationStep result =
          com.google.datastore.admin.v1.MigrationStep.valueOf(migrationStep_);
      return result == null ? com.google.datastore.admin.v1.MigrationStep.UNRECOGNIZED : result;
    }
    /**
     *
     *
     * <pre>
     * The current step of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationStep migration_step = 2;</code>
     *
     * @param value The migrationStep to set.
     * @return This builder for chaining.
     */
    public Builder setMigrationStep(com.google.datastore.admin.v1.MigrationStep value) {
      if (value == null) {
        throw new NullPointerException();
      }

      migrationStep_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * The current step of migration from Cloud Datastore to Cloud Firestore in
     * Datastore mode.
     * </pre>
     *
     * <code>.google.datastore.admin.v1.MigrationStep migration_step = 2;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearMigrationStep() {

      migrationStep_ = 0;
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

    // @@protoc_insertion_point(builder_scope:google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata)
  private static final com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata
      DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata();
  }

  public static com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata
      getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DatastoreFirestoreMigrationMetadata> PARSER =
      new com.google.protobuf.AbstractParser<DatastoreFirestoreMigrationMetadata>() {
        @java.lang.Override
        public DatastoreFirestoreMigrationMetadata parsePartialFrom(
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

  public static com.google.protobuf.Parser<DatastoreFirestoreMigrationMetadata> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DatastoreFirestoreMigrationMetadata> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.admin.v1.DatastoreFirestoreMigrationMetadata
      getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
