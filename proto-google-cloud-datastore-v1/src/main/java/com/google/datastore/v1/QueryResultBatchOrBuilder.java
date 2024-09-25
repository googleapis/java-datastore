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
// source: google/datastore/v1/query.proto

// Protobuf Java Version: 3.25.5
package com.google.datastore.v1;

public interface QueryResultBatchOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.QueryResultBatch)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The number of results skipped, typically because of an offset.
   * </pre>
   *
   * <code>int32 skipped_results = 6;</code>
   *
   * @return The skippedResults.
   */
  int getSkippedResults();

  /**
   *
   *
   * <pre>
   * A cursor that points to the position after the last skipped result.
   * Will be set when `skipped_results` != 0.
   * </pre>
   *
   * <code>bytes skipped_cursor = 3;</code>
   *
   * @return The skippedCursor.
   */
  com.google.protobuf.ByteString getSkippedCursor();

  /**
   *
   *
   * <pre>
   * The result type for every entity in `entity_results`.
   * </pre>
   *
   * <code>.google.datastore.v1.EntityResult.ResultType entity_result_type = 1;</code>
   *
   * @return The enum numeric value on the wire for entityResultType.
   */
  int getEntityResultTypeValue();
  /**
   *
   *
   * <pre>
   * The result type for every entity in `entity_results`.
   * </pre>
   *
   * <code>.google.datastore.v1.EntityResult.ResultType entity_result_type = 1;</code>
   *
   * @return The entityResultType.
   */
  com.google.datastore.v1.EntityResult.ResultType getEntityResultType();

  /**
   *
   *
   * <pre>
   * The results for this batch.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.EntityResult entity_results = 2;</code>
   */
  java.util.List<com.google.datastore.v1.EntityResult> getEntityResultsList();
  /**
   *
   *
   * <pre>
   * The results for this batch.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.EntityResult entity_results = 2;</code>
   */
  com.google.datastore.v1.EntityResult getEntityResults(int index);
  /**
   *
   *
   * <pre>
   * The results for this batch.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.EntityResult entity_results = 2;</code>
   */
  int getEntityResultsCount();
  /**
   *
   *
   * <pre>
   * The results for this batch.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.EntityResult entity_results = 2;</code>
   */
  java.util.List<? extends com.google.datastore.v1.EntityResultOrBuilder>
      getEntityResultsOrBuilderList();
  /**
   *
   *
   * <pre>
   * The results for this batch.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.EntityResult entity_results = 2;</code>
   */
  com.google.datastore.v1.EntityResultOrBuilder getEntityResultsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * A cursor that points to the position after the last result in the batch.
   * </pre>
   *
   * <code>bytes end_cursor = 4;</code>
   *
   * @return The endCursor.
   */
  com.google.protobuf.ByteString getEndCursor();

  /**
   *
   *
   * <pre>
   * The state of the query after the current batch.
   * </pre>
   *
   * <code>.google.datastore.v1.QueryResultBatch.MoreResultsType more_results = 5;</code>
   *
   * @return The enum numeric value on the wire for moreResults.
   */
  int getMoreResultsValue();
  /**
   *
   *
   * <pre>
   * The state of the query after the current batch.
   * </pre>
   *
   * <code>.google.datastore.v1.QueryResultBatch.MoreResultsType more_results = 5;</code>
   *
   * @return The moreResults.
   */
  com.google.datastore.v1.QueryResultBatch.MoreResultsType getMoreResults();

  /**
   *
   *
   * <pre>
   * The version number of the snapshot this batch was returned from.
   * This applies to the range of results from the query's `start_cursor` (or
   * the beginning of the query if no cursor was given) to this batch's
   * `end_cursor` (not the query's `end_cursor`).
   *
   * In a single transaction, subsequent query result batches for the same query
   * can have a greater snapshot version number. Each batch's snapshot version
   * is valid for all preceding batches.
   * The value will be zero for eventually consistent queries.
   * </pre>
   *
   * <code>int64 snapshot_version = 7;</code>
   *
   * @return The snapshotVersion.
   */
  long getSnapshotVersion();

  /**
   *
   *
   * <pre>
   * Read timestamp this batch was returned from.
   * This applies to the range of results from the query's `start_cursor` (or
   * the beginning of the query if no cursor was given) to this batch's
   * `end_cursor` (not the query's `end_cursor`).
   *
   * In a single transaction, subsequent query result batches for the same query
   * can have a greater timestamp. Each batch's read timestamp
   * is valid for all preceding batches.
   * This value will not be set for eventually consistent queries in Cloud
   * Datastore.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp read_time = 8;</code>
   *
   * @return Whether the readTime field is set.
   */
  boolean hasReadTime();
  /**
   *
   *
   * <pre>
   * Read timestamp this batch was returned from.
   * This applies to the range of results from the query's `start_cursor` (or
   * the beginning of the query if no cursor was given) to this batch's
   * `end_cursor` (not the query's `end_cursor`).
   *
   * In a single transaction, subsequent query result batches for the same query
   * can have a greater timestamp. Each batch's read timestamp
   * is valid for all preceding batches.
   * This value will not be set for eventually consistent queries in Cloud
   * Datastore.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp read_time = 8;</code>
   *
   * @return The readTime.
   */
  com.google.protobuf.Timestamp getReadTime();
  /**
   *
   *
   * <pre>
   * Read timestamp this batch was returned from.
   * This applies to the range of results from the query's `start_cursor` (or
   * the beginning of the query if no cursor was given) to this batch's
   * `end_cursor` (not the query's `end_cursor`).
   *
   * In a single transaction, subsequent query result batches for the same query
   * can have a greater timestamp. Each batch's read timestamp
   * is valid for all preceding batches.
   * This value will not be set for eventually consistent queries in Cloud
   * Datastore.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp read_time = 8;</code>
   */
  com.google.protobuf.TimestampOrBuilder getReadTimeOrBuilder();
}
