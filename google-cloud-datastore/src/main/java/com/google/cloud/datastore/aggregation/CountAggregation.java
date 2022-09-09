/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.datastore.aggregation;

import com.google.datastore.v1.AggregationQuery;
import com.google.datastore.v1.AggregationQuery.Aggregation.Count;
import com.google.protobuf.Int64Value;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public class CountAggregation extends Aggregation {

  private final long limit;

  private CountAggregation(String alias, long limit) {
    super(alias);
    this.limit = limit;
  }

  @Override
  public AggregationQuery.Aggregation toPb() {
    Count.Builder countBuilder = Count.newBuilder();
    if(limit > 0) {
      countBuilder.setUpTo(Int64Value.of(limit));
    }

    AggregationQuery.Aggregation.Builder aggregationBuilder = AggregationQuery.Aggregation.newBuilder()
        .setCount(countBuilder);
    if (this.getAlias() != null) {
      aggregationBuilder.setAlias(this.getAlias());
    }
    return aggregationBuilder.build();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CountAggregation that = (CountAggregation) o;
    return limit == that.limit && getAlias().equals(that.getAlias());
  }

  @Override
  public int hashCode() {
    return Objects.hash(limit, getAlias());
  }

  public static class Builder implements AggregationBuilder<CountAggregation> {

    private String alias;
    private long limit;

    public Builder as(String alias) {
      this.alias = alias;
      return this;
    }

    public Builder limit(long limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public CountAggregation build() {
      return new CountAggregation(alias, limit);
    }
  }

}
