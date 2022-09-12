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

import static com.google.cloud.datastore.AggregationQuery.Mode.GQL;
import static com.google.cloud.datastore.AggregationQuery.Mode.STRUCTURED;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.cloud.datastore.aggregation.AggregationBuilder;
import java.util.ArrayList;
import java.util.List;

public class AggregationQuery extends Query<AggregationResult> {

  private List<Aggregation> aggregations;
  private StructuredQuery<?> nestedStructuredQuery;
  private final Mode mode;
  private GqlQuery<?> nestedGqlQuery;

  AggregationQuery(String namespace, List<Aggregation> aggregations,
      StructuredQuery<?> nestedQuery) {
    super(checkNotNull(namespace));
    checkArgument(!aggregations.isEmpty(),
        "At least one aggregation is required for an aggregation query to run");
    this.aggregations = aggregations;
    this.nestedStructuredQuery = nestedQuery;
    this.mode = STRUCTURED;
  }

  AggregationQuery(String namespace, GqlQuery<?> gqlQuery) {
    super(checkNotNull(namespace));
    this.nestedGqlQuery = gqlQuery;
    this.mode = GQL;
  }

  public List<Aggregation> getAggregations() {
    return aggregations;
  }

  public StructuredQuery<?> getNestedStructuredQuery() {
    return nestedStructuredQuery;
  }

  public GqlQuery<?> getNestedGqlQuery() {
    return nestedGqlQuery;
  }

  public Mode getMode() {
    return mode;
  }

  public static class Builder {

    private String namespace;
    private Mode mode;
    private final List<Aggregation> aggregations;
    private StructuredQuery<?> nestedStructuredQuery;
    private GqlQuery<?> nestedGqlQuery;

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

    public Builder over(StructuredQuery<?> nestedQuery) {
      this.nestedStructuredQuery = nestedQuery;
      this.mode = STRUCTURED;
      return this;
    }

    public Builder over(GqlQuery<?> nestedQuery) {
      this.nestedGqlQuery = nestedQuery;
      this.mode = GQL;
      return this;
    }

    public AggregationQuery build() {
      boolean nestedQueryProvided = nestedGqlQuery != null || nestedStructuredQuery != null;
      checkArgument(nestedQueryProvided,
          "Nested query is required for an aggregation query to run");

      if (mode == GQL) {
        return new AggregationQuery(namespace, nestedGqlQuery);
      }
      return new AggregationQuery(namespace, aggregations, nestedStructuredQuery);
    }
  }

  public enum Mode {
    STRUCTURED,
    GQL,
  }
}
