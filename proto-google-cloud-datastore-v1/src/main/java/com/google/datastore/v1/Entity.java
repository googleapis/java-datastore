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

/**
 *
 *
 * <pre>
 * A Datastore data object.
 * An entity is limited to 1 megabyte when stored. That _roughly_
 * corresponds to a limit of 1 megabyte for the serialized form of this
 * message.
 * </pre>
 *
 * Protobuf type {@code google.datastore.v1.Entity}
 */
public final class Entity extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.datastore.v1.Entity)
    EntityOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use Entity.newBuilder() to construct.
  private Entity(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private Entity() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new Entity();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private Entity(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
              com.google.datastore.v1.Key.Builder subBuilder = null;
              if (key_ != null) {
                subBuilder = key_.toBuilder();
              }
              key_ = input.readMessage(com.google.datastore.v1.Key.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(key_);
                key_ = subBuilder.buildPartial();
              }

              break;
            }
          case 26:
            {
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                properties_ =
                    com.google.protobuf.MapField.newMapField(
                        PropertiesDefaultEntryHolder.defaultEntry);
                mutable_bitField0_ |= 0x00000001;
              }
              com.google.protobuf.MapEntry<java.lang.String, com.google.datastore.v1.Value>
                  properties__ =
                      input.readMessage(
                          PropertiesDefaultEntryHolder.defaultEntry.getParserForType(),
                          extensionRegistry);
              properties_.getMutableMap().put(properties__.getKey(), properties__.getValue());
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
    } catch (com.google.protobuf.UninitializedMessageException e) {
      throw e.asInvalidProtocolBufferException().setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.datastore.v1.EntityProto
        .internal_static_google_datastore_v1_Entity_descriptor;
  }

  @SuppressWarnings({"rawtypes"})
  @java.lang.Override
  protected com.google.protobuf.MapField internalGetMapField(int number) {
    switch (number) {
      case 3:
        return internalGetProperties();
      default:
        throw new RuntimeException("Invalid map field number: " + number);
    }
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.v1.EntityProto
        .internal_static_google_datastore_v1_Entity_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.v1.Entity.class, com.google.datastore.v1.Entity.Builder.class);
  }

  public static final int KEY_FIELD_NUMBER = 1;
  private com.google.datastore.v1.Key key_;
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
  @java.lang.Override
  public boolean hasKey() {
    return key_ != null;
  }
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
  @java.lang.Override
  public com.google.datastore.v1.Key getKey() {
    return key_ == null ? com.google.datastore.v1.Key.getDefaultInstance() : key_;
  }
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
  @java.lang.Override
  public com.google.datastore.v1.KeyOrBuilder getKeyOrBuilder() {
    return getKey();
  }

  public static final int PROPERTIES_FIELD_NUMBER = 3;

  private static final class PropertiesDefaultEntryHolder {
    static final com.google.protobuf.MapEntry<java.lang.String, com.google.datastore.v1.Value>
        defaultEntry =
            com.google.protobuf.MapEntry
                .<java.lang.String, com.google.datastore.v1.Value>newDefaultInstance(
                    com.google.datastore.v1.EntityProto
                        .internal_static_google_datastore_v1_Entity_PropertiesEntry_descriptor,
                    com.google.protobuf.WireFormat.FieldType.STRING,
                    "",
                    com.google.protobuf.WireFormat.FieldType.MESSAGE,
                    com.google.datastore.v1.Value.getDefaultInstance());
  }

  private com.google.protobuf.MapField<java.lang.String, com.google.datastore.v1.Value> properties_;

  private com.google.protobuf.MapField<java.lang.String, com.google.datastore.v1.Value>
      internalGetProperties() {
    if (properties_ == null) {
      return com.google.protobuf.MapField.emptyMapField(PropertiesDefaultEntryHolder.defaultEntry);
    }
    return properties_;
  }

  public int getPropertiesCount() {
    return internalGetProperties().getMap().size();
  }
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
  @java.lang.Override
  public boolean containsProperties(java.lang.String key) {
    if (key == null) {
      throw new NullPointerException("map key");
    }
    return internalGetProperties().getMap().containsKey(key);
  }
  /** Use {@link #getPropertiesMap()} instead. */
  @java.lang.Override
  @java.lang.Deprecated
  public java.util.Map<java.lang.String, com.google.datastore.v1.Value> getProperties() {
    return getPropertiesMap();
  }
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
  @java.lang.Override
  public java.util.Map<java.lang.String, com.google.datastore.v1.Value> getPropertiesMap() {
    return internalGetProperties().getMap();
  }
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
  @java.lang.Override
  public com.google.datastore.v1.Value getPropertiesOrDefault(
      java.lang.String key, com.google.datastore.v1.Value defaultValue) {
    if (key == null) {
      throw new NullPointerException("map key");
    }
    java.util.Map<java.lang.String, com.google.datastore.v1.Value> map =
        internalGetProperties().getMap();
    return map.containsKey(key) ? map.get(key) : defaultValue;
  }
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
  @java.lang.Override
  public com.google.datastore.v1.Value getPropertiesOrThrow(java.lang.String key) {
    if (key == null) {
      throw new NullPointerException("map key");
    }
    java.util.Map<java.lang.String, com.google.datastore.v1.Value> map =
        internalGetProperties().getMap();
    if (!map.containsKey(key)) {
      throw new java.lang.IllegalArgumentException();
    }
    return map.get(key);
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
    if (key_ != null) {
      output.writeMessage(1, getKey());
    }
    com.google.protobuf.GeneratedMessageV3.serializeStringMapTo(
        output, internalGetProperties(), PropertiesDefaultEntryHolder.defaultEntry, 3);
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (key_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getKey());
    }
    for (java.util.Map.Entry<java.lang.String, com.google.datastore.v1.Value> entry :
        internalGetProperties().getMap().entrySet()) {
      com.google.protobuf.MapEntry<java.lang.String, com.google.datastore.v1.Value> properties__ =
          PropertiesDefaultEntryHolder.defaultEntry
              .newBuilderForType()
              .setKey(entry.getKey())
              .setValue(entry.getValue())
              .build();
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(3, properties__);
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
    if (!(obj instanceof com.google.datastore.v1.Entity)) {
      return super.equals(obj);
    }
    com.google.datastore.v1.Entity other = (com.google.datastore.v1.Entity) obj;

    if (hasKey() != other.hasKey()) return false;
    if (hasKey()) {
      if (!getKey().equals(other.getKey())) return false;
    }
    if (!internalGetProperties().equals(other.internalGetProperties())) return false;
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
    if (hasKey()) {
      hash = (37 * hash) + KEY_FIELD_NUMBER;
      hash = (53 * hash) + getKey().hashCode();
    }
    if (!internalGetProperties().getMap().isEmpty()) {
      hash = (37 * hash) + PROPERTIES_FIELD_NUMBER;
      hash = (53 * hash) + internalGetProperties().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.v1.Entity parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.Entity parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.Entity parseFrom(com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.Entity parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.Entity parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.Entity parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.Entity parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.Entity parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.Entity parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.Entity parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.Entity parseFrom(com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.Entity parseFrom(
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

  public static Builder newBuilder(com.google.datastore.v1.Entity prototype) {
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
   * A Datastore data object.
   * An entity is limited to 1 megabyte when stored. That _roughly_
   * corresponds to a limit of 1 megabyte for the serialized form of this
   * message.
   * </pre>
   *
   * Protobuf type {@code google.datastore.v1.Entity}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.datastore.v1.Entity)
      com.google.datastore.v1.EntityOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.datastore.v1.EntityProto
          .internal_static_google_datastore_v1_Entity_descriptor;
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMapField(int number) {
      switch (number) {
        case 3:
          return internalGetProperties();
        default:
          throw new RuntimeException("Invalid map field number: " + number);
      }
    }

    @SuppressWarnings({"rawtypes"})
    protected com.google.protobuf.MapField internalGetMutableMapField(int number) {
      switch (number) {
        case 3:
          return internalGetMutableProperties();
        default:
          throw new RuntimeException("Invalid map field number: " + number);
      }
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.v1.EntityProto
          .internal_static_google_datastore_v1_Entity_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.v1.Entity.class, com.google.datastore.v1.Entity.Builder.class);
    }

    // Construct using com.google.datastore.v1.Entity.newBuilder()
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
      if (keyBuilder_ == null) {
        key_ = null;
      } else {
        key_ = null;
        keyBuilder_ = null;
      }
      internalGetMutableProperties().clear();
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.datastore.v1.EntityProto
          .internal_static_google_datastore_v1_Entity_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.v1.Entity getDefaultInstanceForType() {
      return com.google.datastore.v1.Entity.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.v1.Entity build() {
      com.google.datastore.v1.Entity result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.v1.Entity buildPartial() {
      com.google.datastore.v1.Entity result = new com.google.datastore.v1.Entity(this);
      int from_bitField0_ = bitField0_;
      if (keyBuilder_ == null) {
        result.key_ = key_;
      } else {
        result.key_ = keyBuilder_.build();
      }
      result.properties_ = internalGetProperties();
      result.properties_.makeImmutable();
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
      if (other instanceof com.google.datastore.v1.Entity) {
        return mergeFrom((com.google.datastore.v1.Entity) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.v1.Entity other) {
      if (other == com.google.datastore.v1.Entity.getDefaultInstance()) return this;
      if (other.hasKey()) {
        mergeKey(other.getKey());
      }
      internalGetMutableProperties().mergeFrom(other.internalGetProperties());
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
      com.google.datastore.v1.Entity parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.datastore.v1.Entity) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int bitField0_;

    private com.google.datastore.v1.Key key_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.Key,
            com.google.datastore.v1.Key.Builder,
            com.google.datastore.v1.KeyOrBuilder>
        keyBuilder_;
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
    public boolean hasKey() {
      return keyBuilder_ != null || key_ != null;
    }
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
    public com.google.datastore.v1.Key getKey() {
      if (keyBuilder_ == null) {
        return key_ == null ? com.google.datastore.v1.Key.getDefaultInstance() : key_;
      } else {
        return keyBuilder_.getMessage();
      }
    }
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
    public Builder setKey(com.google.datastore.v1.Key value) {
      if (keyBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        key_ = value;
        onChanged();
      } else {
        keyBuilder_.setMessage(value);
      }

      return this;
    }
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
    public Builder setKey(com.google.datastore.v1.Key.Builder builderForValue) {
      if (keyBuilder_ == null) {
        key_ = builderForValue.build();
        onChanged();
      } else {
        keyBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
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
    public Builder mergeKey(com.google.datastore.v1.Key value) {
      if (keyBuilder_ == null) {
        if (key_ != null) {
          key_ = com.google.datastore.v1.Key.newBuilder(key_).mergeFrom(value).buildPartial();
        } else {
          key_ = value;
        }
        onChanged();
      } else {
        keyBuilder_.mergeFrom(value);
      }

      return this;
    }
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
    public Builder clearKey() {
      if (keyBuilder_ == null) {
        key_ = null;
        onChanged();
      } else {
        key_ = null;
        keyBuilder_ = null;
      }

      return this;
    }
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
    public com.google.datastore.v1.Key.Builder getKeyBuilder() {

      onChanged();
      return getKeyFieldBuilder().getBuilder();
    }
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
    public com.google.datastore.v1.KeyOrBuilder getKeyOrBuilder() {
      if (keyBuilder_ != null) {
        return keyBuilder_.getMessageOrBuilder();
      } else {
        return key_ == null ? com.google.datastore.v1.Key.getDefaultInstance() : key_;
      }
    }
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
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.Key,
            com.google.datastore.v1.Key.Builder,
            com.google.datastore.v1.KeyOrBuilder>
        getKeyFieldBuilder() {
      if (keyBuilder_ == null) {
        keyBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.datastore.v1.Key,
                com.google.datastore.v1.Key.Builder,
                com.google.datastore.v1.KeyOrBuilder>(getKey(), getParentForChildren(), isClean());
        key_ = null;
      }
      return keyBuilder_;
    }

    private com.google.protobuf.MapField<java.lang.String, com.google.datastore.v1.Value>
        properties_;

    private com.google.protobuf.MapField<java.lang.String, com.google.datastore.v1.Value>
        internalGetProperties() {
      if (properties_ == null) {
        return com.google.protobuf.MapField.emptyMapField(
            PropertiesDefaultEntryHolder.defaultEntry);
      }
      return properties_;
    }

    private com.google.protobuf.MapField<java.lang.String, com.google.datastore.v1.Value>
        internalGetMutableProperties() {
      onChanged();
      ;
      if (properties_ == null) {
        properties_ =
            com.google.protobuf.MapField.newMapField(PropertiesDefaultEntryHolder.defaultEntry);
      }
      if (!properties_.isMutable()) {
        properties_ = properties_.copy();
      }
      return properties_;
    }

    public int getPropertiesCount() {
      return internalGetProperties().getMap().size();
    }
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
    @java.lang.Override
    public boolean containsProperties(java.lang.String key) {
      if (key == null) {
        throw new NullPointerException("map key");
      }
      return internalGetProperties().getMap().containsKey(key);
    }
    /** Use {@link #getPropertiesMap()} instead. */
    @java.lang.Override
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, com.google.datastore.v1.Value> getProperties() {
      return getPropertiesMap();
    }
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
    @java.lang.Override
    public java.util.Map<java.lang.String, com.google.datastore.v1.Value> getPropertiesMap() {
      return internalGetProperties().getMap();
    }
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
    @java.lang.Override
    public com.google.datastore.v1.Value getPropertiesOrDefault(
        java.lang.String key, com.google.datastore.v1.Value defaultValue) {
      if (key == null) {
        throw new NullPointerException("map key");
      }
      java.util.Map<java.lang.String, com.google.datastore.v1.Value> map =
          internalGetProperties().getMap();
      return map.containsKey(key) ? map.get(key) : defaultValue;
    }
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
    @java.lang.Override
    public com.google.datastore.v1.Value getPropertiesOrThrow(java.lang.String key) {
      if (key == null) {
        throw new NullPointerException("map key");
      }
      java.util.Map<java.lang.String, com.google.datastore.v1.Value> map =
          internalGetProperties().getMap();
      if (!map.containsKey(key)) {
        throw new java.lang.IllegalArgumentException();
      }
      return map.get(key);
    }

    public Builder clearProperties() {
      internalGetMutableProperties().getMutableMap().clear();
      return this;
    }
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
    public Builder removeProperties(java.lang.String key) {
      if (key == null) {
        throw new NullPointerException("map key");
      }
      internalGetMutableProperties().getMutableMap().remove(key);
      return this;
    }
    /** Use alternate mutation accessors instead. */
    @java.lang.Deprecated
    public java.util.Map<java.lang.String, com.google.datastore.v1.Value> getMutableProperties() {
      return internalGetMutableProperties().getMutableMap();
    }
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
    public Builder putProperties(java.lang.String key, com.google.datastore.v1.Value value) {
      if (key == null) {
        throw new NullPointerException("map key");
      }
      if (value == null) {
        throw new NullPointerException("map value");
      }

      internalGetMutableProperties().getMutableMap().put(key, value);
      return this;
    }
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
    public Builder putAllProperties(
        java.util.Map<java.lang.String, com.google.datastore.v1.Value> values) {
      internalGetMutableProperties().getMutableMap().putAll(values);
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

    // @@protoc_insertion_point(builder_scope:google.datastore.v1.Entity)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.v1.Entity)
  private static final com.google.datastore.v1.Entity DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.datastore.v1.Entity();
  }

  public static com.google.datastore.v1.Entity getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Entity> PARSER =
      new com.google.protobuf.AbstractParser<Entity>() {
        @java.lang.Override
        public Entity parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new Entity(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<Entity> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Entity> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.v1.Entity getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
