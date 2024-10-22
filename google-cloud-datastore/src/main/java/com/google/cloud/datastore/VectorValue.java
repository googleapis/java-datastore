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

import static com.google.datastore.v1.Value.ARRAY_VALUE_FIELD_NUMBER;

import com.google.cloud.Timestamp;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/** A Google Cloud Datastore Vector value. A list value is a list of {@link Value} objects. */
//public final class VectorValue extends Value<List<? extends Value<?>>> { {
public final class VectorValue extends Value<List<Value<Double>>> {

    private static final long serialVersionUID = -5121887228607148859L;

    static final BaseMarshaller<List<Value<Double>>, VectorValue, Builder> MARSHALLER =
            new BaseMarshaller<List<Value<Double>>, VectorValue, Builder>() {
              private static final long serialVersionUID = 7720473855548179943L;

              @Override
              public int getProtoFieldId() {
                return ARRAY_VALUE_FIELD_NUMBER;
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
       * Sets the list of values of this {@code ListValue} builder to {@code values}. The provided
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

      /**
       * Creates a {@code ListValue} object.
       */
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

      /**
       * Returns a builder for the list value object.
       */
      @Override
      public Builder toBuilder() {
        return new Builder().mergeFrom(this);
      }

      /**
       * Creates a {@code ListValue} object given a number of double values.
       */
      public static VectorValue of(double first, double... other) {
        return newBuilder().addValue(first, other).build();
      }

      /**
       * Returns a builder for {@code ListValue} objects.
       */
      public static Builder newBuilder() {
        return new Builder();
      }

      public static VectorValue.Builder newBuilder(double first, double... other) {
        return new VectorValue.Builder().addValue(first, other);
      }
    }

