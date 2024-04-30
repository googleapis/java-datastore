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

// Protobuf Java Version: 3.25.3
package com.google.datastore.v1;

public interface CommitResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.CommitResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The result of performing the mutations.
   * The i-th mutation result corresponds to the i-th mutation in the request.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.MutationResult mutation_results = 3;</code>
   */
  java.util.List<com.google.datastore.v1.MutationResult> getMutationResultsList();
  /**
   *
   *
   * <pre>
   * The result of performing the mutations.
   * The i-th mutation result corresponds to the i-th mutation in the request.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.MutationResult mutation_results = 3;</code>
   */
  com.google.datastore.v1.MutationResult getMutationResults(int index);
  /**
   *
   *
   * <pre>
   * The result of performing the mutations.
   * The i-th mutation result corresponds to the i-th mutation in the request.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.MutationResult mutation_results = 3;</code>
   */
  int getMutationResultsCount();
  /**
   *
   *
   * <pre>
   * The result of performing the mutations.
   * The i-th mutation result corresponds to the i-th mutation in the request.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.MutationResult mutation_results = 3;</code>
   */
  java.util.List<? extends com.google.datastore.v1.MutationResultOrBuilder>
      getMutationResultsOrBuilderList();
  /**
   *
   *
   * <pre>
   * The result of performing the mutations.
   * The i-th mutation result corresponds to the i-th mutation in the request.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.MutationResult mutation_results = 3;</code>
   */
  com.google.datastore.v1.MutationResultOrBuilder getMutationResultsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * The number of index entries updated during the commit, or zero if none were
   * updated.
   * </pre>
   *
   * <code>int32 index_updates = 4;</code>
   *
   * @return The indexUpdates.
   */
  int getIndexUpdates();

  /**
   *
   *
   * <pre>
   * The transaction commit timestamp. Not set for non-transactional commits.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp commit_time = 8;</code>
   *
   * @return Whether the commitTime field is set.
   */
  boolean hasCommitTime();
  /**
   *
   *
   * <pre>
   * The transaction commit timestamp. Not set for non-transactional commits.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp commit_time = 8;</code>
   *
   * @return The commitTime.
   */
  com.google.protobuf.Timestamp getCommitTime();
  /**
   *
   *
   * <pre>
   * The transaction commit timestamp. Not set for non-transactional commits.
   * </pre>
   *
   * <code>.google.protobuf.Timestamp commit_time = 8;</code>
   */
  com.google.protobuf.TimestampOrBuilder getCommitTimeOrBuilder();
}
