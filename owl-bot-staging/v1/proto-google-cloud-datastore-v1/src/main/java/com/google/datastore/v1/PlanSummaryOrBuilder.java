// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/query_profile.proto

// Protobuf Java Version: 3.25.2
package com.google.datastore.v1;

public interface PlanSummaryOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.PlanSummary)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The indexes selected for the query. For example:
   *  [
   *    {"query_scope": "Collection", "properties": "(foo ASC, __name__ ASC)"},
   *    {"query_scope": "Collection", "properties": "(bar ASC, __name__ ASC)"}
   *  ]
   * </pre>
   *
   * <code>repeated .google.protobuf.Struct indexes_used = 1;</code>
   */
  java.util.List<com.google.protobuf.Struct> 
      getIndexesUsedList();
  /**
   * <pre>
   * The indexes selected for the query. For example:
   *  [
   *    {"query_scope": "Collection", "properties": "(foo ASC, __name__ ASC)"},
   *    {"query_scope": "Collection", "properties": "(bar ASC, __name__ ASC)"}
   *  ]
   * </pre>
   *
   * <code>repeated .google.protobuf.Struct indexes_used = 1;</code>
   */
  com.google.protobuf.Struct getIndexesUsed(int index);
  /**
   * <pre>
   * The indexes selected for the query. For example:
   *  [
   *    {"query_scope": "Collection", "properties": "(foo ASC, __name__ ASC)"},
   *    {"query_scope": "Collection", "properties": "(bar ASC, __name__ ASC)"}
   *  ]
   * </pre>
   *
   * <code>repeated .google.protobuf.Struct indexes_used = 1;</code>
   */
  int getIndexesUsedCount();
  /**
   * <pre>
   * The indexes selected for the query. For example:
   *  [
   *    {"query_scope": "Collection", "properties": "(foo ASC, __name__ ASC)"},
   *    {"query_scope": "Collection", "properties": "(bar ASC, __name__ ASC)"}
   *  ]
   * </pre>
   *
   * <code>repeated .google.protobuf.Struct indexes_used = 1;</code>
   */
  java.util.List<? extends com.google.protobuf.StructOrBuilder> 
      getIndexesUsedOrBuilderList();
  /**
   * <pre>
   * The indexes selected for the query. For example:
   *  [
   *    {"query_scope": "Collection", "properties": "(foo ASC, __name__ ASC)"},
   *    {"query_scope": "Collection", "properties": "(bar ASC, __name__ ASC)"}
   *  ]
   * </pre>
   *
   * <code>repeated .google.protobuf.Struct indexes_used = 1;</code>
   */
  com.google.protobuf.StructOrBuilder getIndexesUsedOrBuilder(
      int index);
}
