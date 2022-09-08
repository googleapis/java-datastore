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
package com.google.cloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.cloud.datastore.aggregation.AggregationBuilder;
import java.util.ArrayList;
import java.util.List;

public class AggregationQuery implements Query<AggregationResult> {

  private final String namespace;
  private final List<Aggregation> aggregations;
  private final RecordQuery<?> nestedQuery;

  AggregationQuery(String namespace, List<Aggregation> aggregations, RecordQuery<?> nestedQuery) {
    checkArgument(nestedQuery != null,
        "Nested query is required for an aggregation query to run");
    checkArgument(!aggregations.isEmpty(),
        "At least one aggregation is required for an aggregation query to run");
    this.namespace = checkNotNull(namespace);
    this.aggregations = aggregations;
    this.nestedQuery = nestedQuery;
  }

  @Override
  public String getNamespace() {
    return namespace;
  }

  public List<Aggregation> getAggregations() {
    return aggregations;
  }

  public RecordQuery<?> getNestedQuery() {
    return nestedQuery;
  }

  public static class Builder {

    private String namespace;
    private List<Aggregation> aggregations;
    private RecordQuery<?> nestedQuery;

    public Builder() {
      this.aggregations = new ArrayList<>();
    }

    public Builder setNamespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    public Builder addAggregation(AggregationBuilder<?> aggregationBuilder) {
      this.aggregations.add(aggregationBuilder.build());
      return this;
    }

    public Builder over(RecordQuery<?> nestedQuery) {
      this.nestedQuery = nestedQuery;
      return this;
    }

    public AggregationQuery build() {
      return new AggregationQuery(namespace, aggregations, nestedQuery);
    }
  }
}
