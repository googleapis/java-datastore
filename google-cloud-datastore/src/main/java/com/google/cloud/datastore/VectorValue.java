/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/**
 * A Google Cloud Datastore Vector value. A Vector value is a list of Double {@link Value} objects.
 */
public final class VectorValue extends Value<List<Value<Double>>> {

  private static final long serialVersionUID = -5121887228607148859L;

  public static final int VECTOR_MEANING = 31;

  static final BaseMarshaller<List<Value<Double>>, VectorValue, Builder> MARSHALLER =
      new BaseMarshaller<List<Value<Double>>, VectorValue, Builder>() {
        private static final long serialVersionUID = 7720473855548179943L;

        @Override
        public int getProtoFieldId() {
          return -1;
        }

        @Override
        public Builder newBuilder(List<Value<Double>> values) {
          return VectorValue.newBuilder().set(values);
        }

        @Override
        protected List<Value<Double>> getValue(com.google.datastore.v1.Value from) {
          List<Value<Double>> properties = new ArrayList<>(from.getArrayValue().getValuesCount());
          for (com.google.datastore.v1.Value valuePb : from.getArrayValue().getValuesList()) {
            properties.add((Value<Double>) Value.fromPb(valuePb));
          }
          return properties;
        }

        @Override
        protected void setValue(VectorValue from, com.google.datastore.v1.Value.Builder to) {
          List<com.google.datastore.v1.Value> propertiesPb = new ArrayList<>();
          for (Value<Double> property : from.get()) {
            propertiesPb.add(property.toPb());
          }
          to.setArrayValue(
              com.google.datastore.v1.ArrayValue.newBuilder().addAllValues(propertiesPb));
        }
      };

  public static final class Builder
      extends Value.BaseBuilder<List<Value<Double>>, VectorValue, Builder> {
    private ImmutableList.Builder<Value<Double>> vectorBuilder = ImmutableList.builder();

    private Builder() {
      super(ValueType.VECTOR);
    }

    /** Adds the provided double values to the {@code VectorValue} builder. */
    public VectorValue.Builder addValue(Value<Double> first, Value<Double>... other) {
      vectorBuilder.add(first);
      for (Value<Double> value : other) {
        vectorBuilder.add(value);
      }
      return this;
    }

    public VectorValue.Builder addValue(double first, double... other) {
      vectorBuilder.add(DoubleValue.of(first));
      for (double value : other) {
        vectorBuilder.add(DoubleValue.of(value));
      }
      return this;
    }

    /**
     * Sets the list of values of this {@code VectorValue} builder to {@code values}. The provided
     * list is copied.
     *
     * @see com.google.cloud.datastore.Value.BaseBuilder#set(java.lang.Object)
     */
    @Override
    public Builder set(List<Value<Double>> values) {
      vectorBuilder = ImmutableList.builder();
      for (Value<Double> value : values) {
        addValue(value);
      }
      return this;
    }

    @Override
    public List<Value<Double>> get() {
      return vectorBuilder.build();
    }

    /** Creates a {@code VectorValue} object. */
    @Override
    public VectorValue build() {
      return new VectorValue(this);
    }
  }

  public VectorValue(List<Value<Double>> values) {
    this(newBuilder().set(values));
  }

  private VectorValue(Builder builder) {
    super(builder);
  }

  /** Returns a builder for the vector value object. */
  @Override
  public Builder toBuilder() {
    return new Builder().mergeFrom(this);
  }

  /** Creates a {@code VectorValue} object given a number of double values. */
  public static VectorValue of(double first, double... other) {
    return newBuilder().addValue(first, other).build();
  }

  /** Creates a {@code VectorValue} object given a list of {@code Value} objects. */
  public static VectorValue of(List<Value<Double>> values) {
    return new VectorValue(values);
  }

  /** Returns a builder for {@code VectorValue} objects. */
  public static Builder newBuilder() {
    Builder builder = new VectorValue.Builder();
    builder.setMeaning(VECTOR_MEANING);
    return builder;
  }

  public static Builder newBuilder(double first, double... other) {
    VectorValue.Builder builder = new VectorValue.Builder();
    builder.setMeaning(VECTOR_MEANING);
    return builder.addValue(first, other);
  }
}
