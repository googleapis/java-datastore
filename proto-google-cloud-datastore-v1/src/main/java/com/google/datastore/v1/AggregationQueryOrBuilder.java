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
// source: google/datastore/v1/query.proto

// Protobuf Java Version: 3.25.5
package com.google.datastore.v1;

public interface AggregationQueryOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.AggregationQuery)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Nested query for aggregation
   * </pre>
   *
   * <code>.google.datastore.v1.Query nested_query = 1;</code>
   *
   * @return Whether the nestedQuery field is set.
   */
  boolean hasNestedQuery();
  /**
   *
   *
   * <pre>
   * Nested query for aggregation
   * </pre>
   *
   * <code>.google.datastore.v1.Query nested_query = 1;</code>
   *
   * @return The nestedQuery.
   */
  com.google.datastore.v1.Query getNestedQuery();
  /**
   *
   *
   * <pre>
   * Nested query for aggregation
   * </pre>
   *
   * <code>.google.datastore.v1.Query nested_query = 1;</code>
   */
  com.google.datastore.v1.QueryOrBuilder getNestedQueryOrBuilder();

  /**
   *
   *
   * <pre>
   * Optional. Series of aggregations to apply over the results of the
   * `nested_query`.
   *
   * Requires:
   *
   * * A minimum of one and maximum of five aggregations per query.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.v1.AggregationQuery.Aggregation aggregations = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  java.util.List<com.google.datastore.v1.AggregationQuery.Aggregation> getAggregationsList();
  /**
   *
   *
   * <pre>
   * Optional. Series of aggregations to apply over the results of the
   * `nested_query`.
   *
   * Requires:
   *
   * * A minimum of one and maximum of five aggregations per query.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.v1.AggregationQuery.Aggregation aggregations = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  com.google.datastore.v1.AggregationQuery.Aggregation getAggregations(int index);
  /**
   *
   *
   * <pre>
   * Optional. Series of aggregations to apply over the results of the
   * `nested_query`.
   *
   * Requires:
   *
   * * A minimum of one and maximum of five aggregations per query.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.v1.AggregationQuery.Aggregation aggregations = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  int getAggregationsCount();
  /**
   *
   *
   * <pre>
   * Optional. Series of aggregations to apply over the results of the
   * `nested_query`.
   *
   * Requires:
   *
   * * A minimum of one and maximum of five aggregations per query.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.v1.AggregationQuery.Aggregation aggregations = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  java.util.List<? extends com.google.datastore.v1.AggregationQuery.AggregationOrBuilder>
      getAggregationsOrBuilderList();
  /**
   *
   *
   * <pre>
   * Optional. Series of aggregations to apply over the results of the
   * `nested_query`.
   *
   * Requires:
   *
   * * A minimum of one and maximum of five aggregations per query.
   * </pre>
   *
   * <code>
   * repeated .google.datastore.v1.AggregationQuery.Aggregation aggregations = 3 [(.google.api.field_behavior) = OPTIONAL];
   * </code>
   */
  com.google.datastore.v1.AggregationQuery.AggregationOrBuilder getAggregationsOrBuilder(int index);

  com.google.datastore.v1.AggregationQuery.QueryTypeCase getQueryTypeCase();
}
