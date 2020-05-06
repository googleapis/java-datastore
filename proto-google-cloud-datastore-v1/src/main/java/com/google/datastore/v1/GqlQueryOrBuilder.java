/*
 * Copyright 2019 Google LLC
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

public interface GqlQueryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.GqlQuery)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * A string of the format described
   * [here](https://cloud.google.com/datastore/docs/apis/gql/gql_reference).
   * </pre>
   *
   * <code>string query_string = 1;</code>
   * @return The queryString.
   */
  java.lang.String getQueryString();
  /**
   * <pre>
   * A string of the format described
   * [here](https://cloud.google.com/datastore/docs/apis/gql/gql_reference).
   * </pre>
   *
   * <code>string query_string = 1;</code>
   * @return The bytes for queryString.
   */
  com.google.protobuf.ByteString
      getQueryStringBytes();

  /**
   * <pre>
   * When false, the query string must not contain any literals and instead must
   * bind all values. For example,
   * `SELECT * FROM Kind WHERE a = 'string literal'` is not allowed, while
   * `SELECT * FROM Kind WHERE a = &#64;value` is.
   * </pre>
   *
   * <code>bool allow_literals = 2;</code>
   * @return The allowLiterals.
   */
  boolean getAllowLiterals();

  /**
   * <pre>
   * For each non-reserved named binding site in the query string, there must be
   * a named parameter with that name, but not necessarily the inverse.
   * Key must match regex `[A-Za-z_$][A-Za-z_$0-9]*`, must not match regex
   * `__.*__`, and must not be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.GqlQueryParameter&gt; named_bindings = 5;</code>
   */
  int getNamedBindingsCount();
  /**
   * <pre>
   * For each non-reserved named binding site in the query string, there must be
   * a named parameter with that name, but not necessarily the inverse.
   * Key must match regex `[A-Za-z_$][A-Za-z_$0-9]*`, must not match regex
   * `__.*__`, and must not be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.GqlQueryParameter&gt; named_bindings = 5;</code>
   */
  boolean containsNamedBindings(
      java.lang.String key);
  /**
   * Use {@link #getNamedBindingsMap()} instead.
   */
  @java.lang.Deprecated
  java.util.Map<java.lang.String, com.google.datastore.v1.GqlQueryParameter>
  getNamedBindings();
  /**
   * <pre>
   * For each non-reserved named binding site in the query string, there must be
   * a named parameter with that name, but not necessarily the inverse.
   * Key must match regex `[A-Za-z_$][A-Za-z_$0-9]*`, must not match regex
   * `__.*__`, and must not be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.GqlQueryParameter&gt; named_bindings = 5;</code>
   */
  java.util.Map<java.lang.String, com.google.datastore.v1.GqlQueryParameter>
  getNamedBindingsMap();
  /**
   * <pre>
   * For each non-reserved named binding site in the query string, there must be
   * a named parameter with that name, but not necessarily the inverse.
   * Key must match regex `[A-Za-z_$][A-Za-z_$0-9]*`, must not match regex
   * `__.*__`, and must not be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.GqlQueryParameter&gt; named_bindings = 5;</code>
   */

  com.google.datastore.v1.GqlQueryParameter getNamedBindingsOrDefault(
      java.lang.String key,
      com.google.datastore.v1.GqlQueryParameter defaultValue);
  /**
   * <pre>
   * For each non-reserved named binding site in the query string, there must be
   * a named parameter with that name, but not necessarily the inverse.
   * Key must match regex `[A-Za-z_$][A-Za-z_$0-9]*`, must not match regex
   * `__.*__`, and must not be `""`.
   * </pre>
   *
   * <code>map&lt;string, .google.datastore.v1.GqlQueryParameter&gt; named_bindings = 5;</code>
   */

  com.google.datastore.v1.GqlQueryParameter getNamedBindingsOrThrow(
      java.lang.String key);

  /**
   * <pre>
   * Numbered binding site &#64;1 references the first numbered parameter,
   * effectively using 1-based indexing, rather than the usual 0.
   * For each binding site numbered i in `query_string`, there must be an i-th
   * numbered parameter. The inverse must also be true.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.GqlQueryParameter positional_bindings = 4;</code>
   */
  java.util.List<com.google.datastore.v1.GqlQueryParameter> 
      getPositionalBindingsList();
  /**
   * <pre>
   * Numbered binding site &#64;1 references the first numbered parameter,
   * effectively using 1-based indexing, rather than the usual 0.
   * For each binding site numbered i in `query_string`, there must be an i-th
   * numbered parameter. The inverse must also be true.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.GqlQueryParameter positional_bindings = 4;</code>
   */
  com.google.datastore.v1.GqlQueryParameter getPositionalBindings(int index);
  /**
   * <pre>
   * Numbered binding site &#64;1 references the first numbered parameter,
   * effectively using 1-based indexing, rather than the usual 0.
   * For each binding site numbered i in `query_string`, there must be an i-th
   * numbered parameter. The inverse must also be true.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.GqlQueryParameter positional_bindings = 4;</code>
   */
  int getPositionalBindingsCount();
  /**
   * <pre>
   * Numbered binding site &#64;1 references the first numbered parameter,
   * effectively using 1-based indexing, rather than the usual 0.
   * For each binding site numbered i in `query_string`, there must be an i-th
   * numbered parameter. The inverse must also be true.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.GqlQueryParameter positional_bindings = 4;</code>
   */
  java.util.List<? extends com.google.datastore.v1.GqlQueryParameterOrBuilder> 
      getPositionalBindingsOrBuilderList();
  /**
   * <pre>
   * Numbered binding site &#64;1 references the first numbered parameter,
   * effectively using 1-based indexing, rather than the usual 0.
   * For each binding site numbered i in `query_string`, there must be an i-th
   * numbered parameter. The inverse must also be true.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.GqlQueryParameter positional_bindings = 4;</code>
   */
  com.google.datastore.v1.GqlQueryParameterOrBuilder getPositionalBindingsOrBuilder(
      int index);
}
