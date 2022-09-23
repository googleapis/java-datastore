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
// source: google/datastore/v1/datastore.proto

package com.google.datastore.v1;

public interface AllocateIdsResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.AllocateIdsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The keys specified in the request (in the same order), each with
   * its key path completed with a newly allocated ID.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  java.util.List<com.google.datastore.v1.Key> getKeysList();
  /**
   *
   *
   * <pre>
   * The keys specified in the request (in the same order), each with
   * its key path completed with a newly allocated ID.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  com.google.datastore.v1.Key getKeys(int index);
  /**
   *
   *
   * <pre>
   * The keys specified in the request (in the same order), each with
   * its key path completed with a newly allocated ID.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  int getKeysCount();
  /**
   *
   *
   * <pre>
   * The keys specified in the request (in the same order), each with
   * its key path completed with a newly allocated ID.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  java.util.List<? extends com.google.datastore.v1.KeyOrBuilder> getKeysOrBuilderList();
  /**
   *
   *
   * <pre>
   * The keys specified in the request (in the same order), each with
   * its key path completed with a newly allocated ID.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  com.google.datastore.v1.KeyOrBuilder getKeysOrBuilder(int index);
}
