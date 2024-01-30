/*
 * Copyright 2024 Google LLC
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
// source: google/datastore/v1/datastore.proto

package com.google.datastore.v1;

public interface RunAggregationQueryRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.RunAggregationQueryRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The ID of the project against which to make the request.
   * </pre>
   *
   * <code>string project_id = 8 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The projectId.
   */
  java.lang.String getProjectId();
  /**
   *
   *
   * <pre>
   * Required. The ID of the project against which to make the request.
   * </pre>
   *
   * <code>string project_id = 8 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The bytes for projectId.
   */
  com.google.protobuf.ByteString getProjectIdBytes();

  /**
   *
   *
   * <pre>
   * The ID of the database against which to make the request.
   *
   * '(default)' is not allowed; please use empty string '' to refer the default
   * database.
   * </pre>
   *
   * <code>string database_id = 9;</code>
   *
   * @return The databaseId.
   */
  java.lang.String getDatabaseId();
  /**
   *
   *
   * <pre>
   * The ID of the database against which to make the request.
   *
   * '(default)' is not allowed; please use empty string '' to refer the default
   * database.
   * </pre>
   *
   * <code>string database_id = 9;</code>
   *
   * @return The bytes for databaseId.
   */
  com.google.protobuf.ByteString getDatabaseIdBytes();

  /**
   *
   *
   * <pre>
   * Entities are partitioned into subsets, identified by a partition ID.
   * Queries are scoped to a single partition.
   * This partition ID is normalized with the standard default context
   * partition ID.
   * </pre>
   *
   * <code>.google.datastore.v1.PartitionId partition_id = 2;</code>
   *
   * @return Whether the partitionId field is set.
   */
  boolean hasPartitionId();
  /**
   *
   *
   * <pre>
   * Entities are partitioned into subsets, identified by a partition ID.
   * Queries are scoped to a single partition.
   * This partition ID is normalized with the standard default context
   * partition ID.
   * </pre>
   *
   * <code>.google.datastore.v1.PartitionId partition_id = 2;</code>
   *
   * @return The partitionId.
   */
  com.google.datastore.v1.PartitionId getPartitionId();
  /**
   *
   *
   * <pre>
   * Entities are partitioned into subsets, identified by a partition ID.
   * Queries are scoped to a single partition.
   * This partition ID is normalized with the standard default context
   * partition ID.
   * </pre>
   *
   * <code>.google.datastore.v1.PartitionId partition_id = 2;</code>
   */
  com.google.datastore.v1.PartitionIdOrBuilder getPartitionIdOrBuilder();

  /**
   *
   *
   * <pre>
   * The options for this query.
   * </pre>
   *
   * <code>.google.datastore.v1.ReadOptions read_options = 1;</code>
   *
   * @return Whether the readOptions field is set.
   */
  boolean hasReadOptions();
  /**
   *
   *
   * <pre>
   * The options for this query.
   * </pre>
   *
   * <code>.google.datastore.v1.ReadOptions read_options = 1;</code>
   *
   * @return The readOptions.
   */
  com.google.datastore.v1.ReadOptions getReadOptions();
  /**
   *
   *
   * <pre>
   * The options for this query.
   * </pre>
   *
   * <code>.google.datastore.v1.ReadOptions read_options = 1;</code>
   */
  com.google.datastore.v1.ReadOptionsOrBuilder getReadOptionsOrBuilder();

  /**
   *
   *
   * <pre>
   * The query to run.
   * </pre>
   *
   * <code>.google.datastore.v1.AggregationQuery aggregation_query = 3;</code>
   *
   * @return Whether the aggregationQuery field is set.
   */
  boolean hasAggregationQuery();
  /**
   *
   *
   * <pre>
   * The query to run.
   * </pre>
   *
   * <code>.google.datastore.v1.AggregationQuery aggregation_query = 3;</code>
   *
   * @return The aggregationQuery.
   */
  com.google.datastore.v1.AggregationQuery getAggregationQuery();
  /**
   *
   *
   * <pre>
   * The query to run.
   * </pre>
   *
   * <code>.google.datastore.v1.AggregationQuery aggregation_query = 3;</code>
   */
  com.google.datastore.v1.AggregationQueryOrBuilder getAggregationQueryOrBuilder();

  /**
   *
   *
   * <pre>
   * The GQL query to run. This query must be an aggregation query.
   * </pre>
   *
   * <code>.google.datastore.v1.GqlQuery gql_query = 7;</code>
   *
   * @return Whether the gqlQuery field is set.
   */
  boolean hasGqlQuery();
  /**
   *
   *
   * <pre>
   * The GQL query to run. This query must be an aggregation query.
   * </pre>
   *
   * <code>.google.datastore.v1.GqlQuery gql_query = 7;</code>
   *
   * @return The gqlQuery.
   */
  com.google.datastore.v1.GqlQuery getGqlQuery();
  /**
   *
   *
   * <pre>
   * The GQL query to run. This query must be an aggregation query.
   * </pre>
   *
   * <code>.google.datastore.v1.GqlQuery gql_query = 7;</code>
   */
  com.google.datastore.v1.GqlQueryOrBuilder getGqlQueryOrBuilder();

  com.google.datastore.v1.RunAggregationQueryRequest.QueryTypeCase getQueryTypeCase();
}
