/*
 * Copyright 2019 Google LLC
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
// source: google/datastore/v1/query.proto

package com.google.datastore.v1;

/**
 *
 *
 * <pre>
 * A binding parameter for a GQL query.
 * </pre>
 *
 * Protobuf type {@code google.datastore.v1.GqlQueryParameter}
 */
public final class GqlQueryParameter extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.datastore.v1.GqlQueryParameter)
    GqlQueryParameterOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use GqlQueryParameter.newBuilder() to construct.
  private GqlQueryParameter(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private GqlQueryParameter() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new GqlQueryParameter();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private GqlQueryParameter(
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
          case 18:
            {
              com.google.datastore.v1.Value.Builder subBuilder = null;
              if (parameterTypeCase_ == 2) {
                subBuilder = ((com.google.datastore.v1.Value) parameterType_).toBuilder();
              }
              parameterType_ =
                  input.readMessage(com.google.datastore.v1.Value.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom((com.google.datastore.v1.Value) parameterType_);
                parameterType_ = subBuilder.buildPartial();
              }
              parameterTypeCase_ = 2;
              break;
            }
          case 26:
            {
              parameterTypeCase_ = 3;
              parameterType_ = input.readBytes();
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
    return com.google.datastore.v1.QueryProto
        .internal_static_google_datastore_v1_GqlQueryParameter_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.datastore.v1.QueryProto
        .internal_static_google_datastore_v1_GqlQueryParameter_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.datastore.v1.GqlQueryParameter.class,
            com.google.datastore.v1.GqlQueryParameter.Builder.class);
  }

  private int parameterTypeCase_ = 0;
  private java.lang.Object parameterType_;

  public enum ParameterTypeCase
      implements
          com.google.protobuf.Internal.EnumLite,
          com.google.protobuf.AbstractMessage.InternalOneOfEnum {
    VALUE(2),
    CURSOR(3),
    PARAMETERTYPE_NOT_SET(0);
    private final int value;

    private ParameterTypeCase(int value) {
      this.value = value;
    }
    /**
     * @param value The number of the enum to look for.
     * @return The enum associated with the given number.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ParameterTypeCase valueOf(int value) {
      return forNumber(value);
    }

    public static ParameterTypeCase forNumber(int value) {
      switch (value) {
        case 2:
          return VALUE;
        case 3:
          return CURSOR;
        case 0:
          return PARAMETERTYPE_NOT_SET;
        default:
          return null;
      }
    }

    public int getNumber() {
      return this.value;
    }
  };

  public ParameterTypeCase getParameterTypeCase() {
    return ParameterTypeCase.forNumber(parameterTypeCase_);
  }

  public static final int VALUE_FIELD_NUMBER = 2;
  /**
   *
   *
   * <pre>
   * A value parameter.
   * </pre>
   *
   * <code>.google.datastore.v1.Value value = 2;</code>
   *
   * @return Whether the value field is set.
   */
  public boolean hasValue() {
    return parameterTypeCase_ == 2;
  }
  /**
   *
   *
   * <pre>
   * A value parameter.
   * </pre>
   *
   * <code>.google.datastore.v1.Value value = 2;</code>
   *
   * @return The value.
   */
  public com.google.datastore.v1.Value getValue() {
    if (parameterTypeCase_ == 2) {
      return (com.google.datastore.v1.Value) parameterType_;
    }
    return com.google.datastore.v1.Value.getDefaultInstance();
  }
  /**
   *
   *
   * <pre>
   * A value parameter.
   * </pre>
   *
   * <code>.google.datastore.v1.Value value = 2;</code>
   */
  public com.google.datastore.v1.ValueOrBuilder getValueOrBuilder() {
    if (parameterTypeCase_ == 2) {
      return (com.google.datastore.v1.Value) parameterType_;
    }
    return com.google.datastore.v1.Value.getDefaultInstance();
  }

  public static final int CURSOR_FIELD_NUMBER = 3;
  /**
   *
   *
   * <pre>
   * A query cursor. Query cursors are returned in query
   * result batches.
   * </pre>
   *
   * <code>bytes cursor = 3;</code>
   *
   * @return The cursor.
   */
  public com.google.protobuf.ByteString getCursor() {
    if (parameterTypeCase_ == 3) {
      return (com.google.protobuf.ByteString) parameterType_;
    }
    return com.google.protobuf.ByteString.EMPTY;
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
    if (parameterTypeCase_ == 2) {
      output.writeMessage(2, (com.google.datastore.v1.Value) parameterType_);
    }
    if (parameterTypeCase_ == 3) {
      output.writeBytes(3, (com.google.protobuf.ByteString) parameterType_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (parameterTypeCase_ == 2) {
      size +=
          com.google.protobuf.CodedOutputStream.computeMessageSize(
              2, (com.google.datastore.v1.Value) parameterType_);
    }
    if (parameterTypeCase_ == 3) {
      size +=
          com.google.protobuf.CodedOutputStream.computeBytesSize(
              3, (com.google.protobuf.ByteString) parameterType_);
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
    if (!(obj instanceof com.google.datastore.v1.GqlQueryParameter)) {
      return super.equals(obj);
    }
    com.google.datastore.v1.GqlQueryParameter other =
        (com.google.datastore.v1.GqlQueryParameter) obj;

    if (!getParameterTypeCase().equals(other.getParameterTypeCase())) return false;
    switch (parameterTypeCase_) {
      case 2:
        if (!getValue().equals(other.getValue())) return false;
        break;
      case 3:
        if (!getCursor().equals(other.getCursor())) return false;
        break;
      case 0:
      default:
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
    switch (parameterTypeCase_) {
      case 2:
        hash = (37 * hash) + VALUE_FIELD_NUMBER;
        hash = (53 * hash) + getValue().hashCode();
        break;
      case 3:
        hash = (37 * hash) + CURSOR_FIELD_NUMBER;
        hash = (53 * hash) + getCursor().hashCode();
        break;
      case 0:
      default:
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.datastore.v1.GqlQueryParameter parseFrom(
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

  public static Builder newBuilder(com.google.datastore.v1.GqlQueryParameter prototype) {
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
   * A binding parameter for a GQL query.
   * </pre>
   *
   * Protobuf type {@code google.datastore.v1.GqlQueryParameter}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.datastore.v1.GqlQueryParameter)
      com.google.datastore.v1.GqlQueryParameterOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.datastore.v1.QueryProto
          .internal_static_google_datastore_v1_GqlQueryParameter_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.datastore.v1.QueryProto
          .internal_static_google_datastore_v1_GqlQueryParameter_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.datastore.v1.GqlQueryParameter.class,
              com.google.datastore.v1.GqlQueryParameter.Builder.class);
    }

    // Construct using com.google.datastore.v1.GqlQueryParameter.newBuilder()
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
      parameterTypeCase_ = 0;
      parameterType_ = null;
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.datastore.v1.QueryProto
          .internal_static_google_datastore_v1_GqlQueryParameter_descriptor;
    }

    @java.lang.Override
    public com.google.datastore.v1.GqlQueryParameter getDefaultInstanceForType() {
      return com.google.datastore.v1.GqlQueryParameter.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.datastore.v1.GqlQueryParameter build() {
      com.google.datastore.v1.GqlQueryParameter result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.datastore.v1.GqlQueryParameter buildPartial() {
      com.google.datastore.v1.GqlQueryParameter result =
          new com.google.datastore.v1.GqlQueryParameter(this);
      if (parameterTypeCase_ == 2) {
        if (valueBuilder_ == null) {
          result.parameterType_ = parameterType_;
        } else {
          result.parameterType_ = valueBuilder_.build();
        }
      }
      if (parameterTypeCase_ == 3) {
        result.parameterType_ = parameterType_;
      }
      result.parameterTypeCase_ = parameterTypeCase_;
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
      if (other instanceof com.google.datastore.v1.GqlQueryParameter) {
        return mergeFrom((com.google.datastore.v1.GqlQueryParameter) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.datastore.v1.GqlQueryParameter other) {
      if (other == com.google.datastore.v1.GqlQueryParameter.getDefaultInstance()) return this;
      switch (other.getParameterTypeCase()) {
        case VALUE:
          {
            mergeValue(other.getValue());
            break;
          }
        case CURSOR:
          {
            setCursor(other.getCursor());
            break;
          }
        case PARAMETERTYPE_NOT_SET:
          {
            break;
          }
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
      com.google.datastore.v1.GqlQueryParameter parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.google.datastore.v1.GqlQueryParameter) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int parameterTypeCase_ = 0;
    private java.lang.Object parameterType_;

    public ParameterTypeCase getParameterTypeCase() {
      return ParameterTypeCase.forNumber(parameterTypeCase_);
    }

    public Builder clearParameterType() {
      parameterTypeCase_ = 0;
      parameterType_ = null;
      onChanged();
      return this;
    }

    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.Value,
            com.google.datastore.v1.Value.Builder,
            com.google.datastore.v1.ValueOrBuilder>
        valueBuilder_;
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     *
     * @return Whether the value field is set.
     */
    public boolean hasValue() {
      return parameterTypeCase_ == 2;
    }
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     *
     * @return The value.
     */
    public com.google.datastore.v1.Value getValue() {
      if (valueBuilder_ == null) {
        if (parameterTypeCase_ == 2) {
          return (com.google.datastore.v1.Value) parameterType_;
        }
        return com.google.datastore.v1.Value.getDefaultInstance();
      } else {
        if (parameterTypeCase_ == 2) {
          return valueBuilder_.getMessage();
        }
        return com.google.datastore.v1.Value.getDefaultInstance();
      }
    }
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     */
    public Builder setValue(com.google.datastore.v1.Value value) {
      if (valueBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        parameterType_ = value;
        onChanged();
      } else {
        valueBuilder_.setMessage(value);
      }
      parameterTypeCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     */
    public Builder setValue(com.google.datastore.v1.Value.Builder builderForValue) {
      if (valueBuilder_ == null) {
        parameterType_ = builderForValue.build();
        onChanged();
      } else {
        valueBuilder_.setMessage(builderForValue.build());
      }
      parameterTypeCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     */
    public Builder mergeValue(com.google.datastore.v1.Value value) {
      if (valueBuilder_ == null) {
        if (parameterTypeCase_ == 2
            && parameterType_ != com.google.datastore.v1.Value.getDefaultInstance()) {
          parameterType_ =
              com.google.datastore.v1.Value.newBuilder(
                      (com.google.datastore.v1.Value) parameterType_)
                  .mergeFrom(value)
                  .buildPartial();
        } else {
          parameterType_ = value;
        }
        onChanged();
      } else {
        if (parameterTypeCase_ == 2) {
          valueBuilder_.mergeFrom(value);
        }
        valueBuilder_.setMessage(value);
      }
      parameterTypeCase_ = 2;
      return this;
    }
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     */
    public Builder clearValue() {
      if (valueBuilder_ == null) {
        if (parameterTypeCase_ == 2) {
          parameterTypeCase_ = 0;
          parameterType_ = null;
          onChanged();
        }
      } else {
        if (parameterTypeCase_ == 2) {
          parameterTypeCase_ = 0;
          parameterType_ = null;
        }
        valueBuilder_.clear();
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     */
    public com.google.datastore.v1.Value.Builder getValueBuilder() {
      return getValueFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     */
    public com.google.datastore.v1.ValueOrBuilder getValueOrBuilder() {
      if ((parameterTypeCase_ == 2) && (valueBuilder_ != null)) {
        return valueBuilder_.getMessageOrBuilder();
      } else {
        if (parameterTypeCase_ == 2) {
          return (com.google.datastore.v1.Value) parameterType_;
        }
        return com.google.datastore.v1.Value.getDefaultInstance();
      }
    }
    /**
     *
     *
     * <pre>
     * A value parameter.
     * </pre>
     *
     * <code>.google.datastore.v1.Value value = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.datastore.v1.Value,
            com.google.datastore.v1.Value.Builder,
            com.google.datastore.v1.ValueOrBuilder>
        getValueFieldBuilder() {
      if (valueBuilder_ == null) {
        if (!(parameterTypeCase_ == 2)) {
          parameterType_ = com.google.datastore.v1.Value.getDefaultInstance();
        }
        valueBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.datastore.v1.Value,
                com.google.datastore.v1.Value.Builder,
                com.google.datastore.v1.ValueOrBuilder>(
                (com.google.datastore.v1.Value) parameterType_, getParentForChildren(), isClean());
        parameterType_ = null;
      }
      parameterTypeCase_ = 2;
      onChanged();
      ;
      return valueBuilder_;
    }

    /**
     *
     *
     * <pre>
     * A query cursor. Query cursors are returned in query
     * result batches.
     * </pre>
     *
     * <code>bytes cursor = 3;</code>
     *
     * @return The cursor.
     */
    public com.google.protobuf.ByteString getCursor() {
      if (parameterTypeCase_ == 3) {
        return (com.google.protobuf.ByteString) parameterType_;
      }
      return com.google.protobuf.ByteString.EMPTY;
    }
    /**
     *
     *
     * <pre>
     * A query cursor. Query cursors are returned in query
     * result batches.
     * </pre>
     *
     * <code>bytes cursor = 3;</code>
     *
     * @param value The cursor to set.
     * @return This builder for chaining.
     */
    public Builder setCursor(com.google.protobuf.ByteString value) {
      if (value == null) {
        throw new NullPointerException();
      }
      parameterTypeCase_ = 3;
      parameterType_ = value;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * A query cursor. Query cursors are returned in query
     * result batches.
     * </pre>
     *
     * <code>bytes cursor = 3;</code>
     *
     * @return This builder for chaining.
     */
    public Builder clearCursor() {
      if (parameterTypeCase_ == 3) {
        parameterTypeCase_ = 0;
        parameterType_ = null;
        onChanged();
      }
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

    // @@protoc_insertion_point(builder_scope:google.datastore.v1.GqlQueryParameter)
  }

  // @@protoc_insertion_point(class_scope:google.datastore.v1.GqlQueryParameter)
  private static final com.google.datastore.v1.GqlQueryParameter DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.datastore.v1.GqlQueryParameter();
  }

  public static com.google.datastore.v1.GqlQueryParameter getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GqlQueryParameter> PARSER =
      new com.google.protobuf.AbstractParser<GqlQueryParameter>() {
        @java.lang.Override
        public GqlQueryParameter parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          return new GqlQueryParameter(input, extensionRegistry);
        }
      };

  public static com.google.protobuf.Parser<GqlQueryParameter> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GqlQueryParameter> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.datastore.v1.GqlQueryParameter getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
