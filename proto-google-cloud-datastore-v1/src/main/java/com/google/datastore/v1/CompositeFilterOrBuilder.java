/*
 * Copyright 2020 Google LLC
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

public interface CompositeFilterOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.CompositeFilter)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The operator for combining multiple filters.
   * </pre>
   *
   * <code>.google.datastore.v1.CompositeFilter.Operator op = 1;</code>
   *
   * @return The enum numeric value on the wire for op.
   */
  int getOpValue();
  /**
   *
   *
   * <pre>
   * The operator for combining multiple filters.
   * </pre>
   *
   * <code>.google.datastore.v1.CompositeFilter.Operator op = 1;</code>
   *
   * @return The op.
   */
  com.google.datastore.v1.CompositeFilter.Operator getOp();

  /**
   *
   *
   * <pre>
   * The list of filters to combine.
   * Must contain at least one filter.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Filter filters = 2;</code>
   */
  java.util.List<com.google.datastore.v1.Filter> getFiltersList();
  /**
   *
   *
   * <pre>
   * The list of filters to combine.
   * Must contain at least one filter.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Filter filters = 2;</code>
   */
  com.google.datastore.v1.Filter getFilters(int index);
  /**
   *
   *
   * <pre>
   * The list of filters to combine.
   * Must contain at least one filter.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Filter filters = 2;</code>
   */
  int getFiltersCount();
  /**
   *
   *
   * <pre>
   * The list of filters to combine.
   * Must contain at least one filter.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Filter filters = 2;</code>
   */
  java.util.List<? extends com.google.datastore.v1.FilterOrBuilder> getFiltersOrBuilderList();
  /**
   *
   *
   * <pre>
   * The list of filters to combine.
   * Must contain at least one filter.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Filter filters = 2;</code>
   */
  com.google.datastore.v1.FilterOrBuilder getFiltersOrBuilder(int index);
}
