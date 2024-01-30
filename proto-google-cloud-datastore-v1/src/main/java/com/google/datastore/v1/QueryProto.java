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

package com.google.datastore.v1;

public final class QueryProto {
  private QueryProto() {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistryLite registry) {}

  public static void registerAllExtensions(com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions((com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_EntityResult_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_EntityResult_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_Query_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_Query_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_AggregationQuery_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_AggregationQuery_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_AggregationQuery_Aggregation_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_AggregationQuery_Aggregation_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_AggregationQuery_Aggregation_Count_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_AggregationQuery_Aggregation_Count_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_AggregationQuery_Aggregation_Sum_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_AggregationQuery_Aggregation_Sum_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_AggregationQuery_Aggregation_Avg_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_AggregationQuery_Aggregation_Avg_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_KindExpression_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_KindExpression_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_PropertyReference_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_PropertyReference_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_Projection_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_Projection_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_PropertyOrder_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_PropertyOrder_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_Filter_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_Filter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_CompositeFilter_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_CompositeFilter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_PropertyFilter_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_PropertyFilter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_GqlQuery_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_GqlQuery_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_GqlQuery_NamedBindingsEntry_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_GqlQuery_NamedBindingsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_GqlQueryParameter_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_GqlQueryParameter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
      internal_static_google_datastore_v1_QueryResultBatch_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_v1_QueryResultBatch_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;

  static {
    java.lang.String[] descriptorData = {
      "\n\037google/datastore/v1/query.proto\022\023googl"
          + "e.datastore.v1\032\037google/api/field_behavio"
          + "r.proto\032 google/datastore/v1/entity.prot"
          + "o\032\037google/protobuf/timestamp.proto\032\036goog"
          + "le/protobuf/wrappers.proto\"\221\002\n\014EntityRes"
          + "ult\022+\n\006entity\030\001 \001(\0132\033.google.datastore.v"
          + "1.Entity\022\017\n\007version\030\004 \001(\003\022/\n\013create_time"
          + "\030\006 \001(\0132\032.google.protobuf.Timestamp\022/\n\013up"
          + "date_time\030\005 \001(\0132\032.google.protobuf.Timest"
          + "amp\022\016\n\006cursor\030\003 \001(\014\"Q\n\nResultType\022\033\n\027RES"
          + "ULT_TYPE_UNSPECIFIED\020\000\022\010\n\004FULL\020\001\022\016\n\nPROJ"
          + "ECTION\020\002\022\014\n\010KEY_ONLY\020\003\"\362\002\n\005Query\0223\n\nproj"
          + "ection\030\002 \003(\0132\037.google.datastore.v1.Proje"
          + "ction\0221\n\004kind\030\003 \003(\0132#.google.datastore.v"
          + "1.KindExpression\022+\n\006filter\030\004 \001(\0132\033.googl"
          + "e.datastore.v1.Filter\0221\n\005order\030\005 \003(\0132\".g"
          + "oogle.datastore.v1.PropertyOrder\022;\n\013dist"
          + "inct_on\030\006 \003(\0132&.google.datastore.v1.Prop"
          + "ertyReference\022\024\n\014start_cursor\030\007 \001(\014\022\022\n\ne"
          + "nd_cursor\030\010 \001(\014\022\016\n\006offset\030\n \001(\005\022*\n\005limit"
          + "\030\014 \001(\0132\033.google.protobuf.Int32Value\"\347\004\n\020"
          + "AggregationQuery\0222\n\014nested_query\030\001 \001(\0132\032"
          + ".google.datastore.v1.QueryH\000\022M\n\014aggregat"
          + "ions\030\003 \003(\01321.google.datastore.v1.Aggrega"
          + "tionQuery.AggregationB\004\342A\001\001\032\301\003\n\013Aggregat"
          + "ion\022H\n\005count\030\001 \001(\01327.google.datastore.v1"
          + ".AggregationQuery.Aggregation.CountH\000\022D\n"
          + "\003sum\030\002 \001(\01325.google.datastore.v1.Aggrega"
          + "tionQuery.Aggregation.SumH\000\022D\n\003avg\030\003 \001(\013"
          + "25.google.datastore.v1.AggregationQuery."
          + "Aggregation.AvgH\000\022\023\n\005alias\030\007 \001(\tB\004\342A\001\001\0329"
          + "\n\005Count\0220\n\005up_to\030\001 \001(\0132\033.google.protobuf"
          + ".Int64ValueB\004\342A\001\001\032?\n\003Sum\0228\n\010property\030\001 \001"
          + "(\0132&.google.datastore.v1.PropertyReferen"
          + "ce\032?\n\003Avg\0228\n\010property\030\001 \001(\0132&.google.dat"
          + "astore.v1.PropertyReferenceB\n\n\010operatorB"
          + "\014\n\nquery_type\"\036\n\016KindExpression\022\014\n\004name\030"
          + "\001 \001(\t\"!\n\021PropertyReference\022\014\n\004name\030\002 \001(\t"
          + "\"F\n\nProjection\0228\n\010property\030\001 \001(\0132&.googl"
          + "e.datastore.v1.PropertyReference\"\321\001\n\rPro"
          + "pertyOrder\0228\n\010property\030\001 \001(\0132&.google.da"
          + "tastore.v1.PropertyReference\022?\n\tdirectio"
          + "n\030\002 \001(\0162,.google.datastore.v1.PropertyOr"
          + "der.Direction\"E\n\tDirection\022\031\n\025DIRECTION_"
          + "UNSPECIFIED\020\000\022\r\n\tASCENDING\020\001\022\016\n\nDESCENDI"
          + "NG\020\002\"\231\001\n\006Filter\022@\n\020composite_filter\030\001 \001("
          + "\0132$.google.datastore.v1.CompositeFilterH"
          + "\000\022>\n\017property_filter\030\002 \001(\0132#.google.data"
          + "store.v1.PropertyFilterH\000B\r\n\013filter_type"
          + "\"\261\001\n\017CompositeFilter\0229\n\002op\030\001 \001(\0162-.googl"
          + "e.datastore.v1.CompositeFilter.Operator\022"
          + ",\n\007filters\030\002 \003(\0132\033.google.datastore.v1.F"
          + "ilter\"5\n\010Operator\022\030\n\024OPERATOR_UNSPECIFIE"
          + "D\020\000\022\007\n\003AND\020\001\022\006\n\002OR\020\002\"\352\002\n\016PropertyFilter\022"
          + "8\n\010property\030\001 \001(\0132&.google.datastore.v1."
          + "PropertyReference\0228\n\002op\030\002 \001(\0162,.google.d"
          + "atastore.v1.PropertyFilter.Operator\022)\n\005v"
          + "alue\030\003 \001(\0132\032.google.datastore.v1.Value\"\270"
          + "\001\n\010Operator\022\030\n\024OPERATOR_UNSPECIFIED\020\000\022\r\n"
          + "\tLESS_THAN\020\001\022\026\n\022LESS_THAN_OR_EQUAL\020\002\022\020\n\014"
          + "GREATER_THAN\020\003\022\031\n\025GREATER_THAN_OR_EQUAL\020"
          + "\004\022\t\n\005EQUAL\020\005\022\006\n\002IN\020\006\022\r\n\tNOT_EQUAL\020\t\022\020\n\014H"
          + "AS_ANCESTOR\020\013\022\n\n\006NOT_IN\020\r\"\245\002\n\010GqlQuery\022\024"
          + "\n\014query_string\030\001 \001(\t\022\026\n\016allow_literals\030\002"
          + " \001(\010\022H\n\016named_bindings\030\005 \003(\01320.google.da"
          + "tastore.v1.GqlQuery.NamedBindingsEntry\022C"
          + "\n\023positional_bindings\030\004 \003(\0132&.google.dat"
          + "astore.v1.GqlQueryParameter\032\\\n\022NamedBind"
          + "ingsEntry\022\013\n\003key\030\001 \001(\t\0225\n\005value\030\002 \001(\0132&."
          + "google.datastore.v1.GqlQueryParameter:\0028"
          + "\001\"d\n\021GqlQueryParameter\022+\n\005value\030\002 \001(\0132\032."
          + "google.datastore.v1.ValueH\000\022\020\n\006cursor\030\003 "
          + "\001(\014H\000B\020\n\016parameter_type\"\215\004\n\020QueryResultB"
          + "atch\022\027\n\017skipped_results\030\006 \001(\005\022\026\n\016skipped"
          + "_cursor\030\003 \001(\014\022H\n\022entity_result_type\030\001 \001("
          + "\0162,.google.datastore.v1.EntityResult.Res"
          + "ultType\0229\n\016entity_results\030\002 \003(\0132!.google"
          + ".datastore.v1.EntityResult\022\022\n\nend_cursor"
          + "\030\004 \001(\014\022K\n\014more_results\030\005 \001(\01625.google.da"
          + "tastore.v1.QueryResultBatch.MoreResultsT"
          + "ype\022\030\n\020snapshot_version\030\007 \001(\003\022-\n\tread_ti"
          + "me\030\010 \001(\0132\032.google.protobuf.Timestamp\"\230\001\n"
          + "\017MoreResultsType\022!\n\035MORE_RESULTS_TYPE_UN"
          + "SPECIFIED\020\000\022\020\n\014NOT_FINISHED\020\001\022\034\n\030MORE_RE"
          + "SULTS_AFTER_LIMIT\020\002\022\035\n\031MORE_RESULTS_AFTE"
          + "R_CURSOR\020\004\022\023\n\017NO_MORE_RESULTS\020\003B\274\001\n\027com."
          + "google.datastore.v1B\nQueryProtoP\001Z<googl"
          + "e.golang.org/genproto/googleapis/datasto"
          + "re/v1;datastore\252\002\031Google.Cloud.Datastore"
          + ".V1\312\002\031Google\\Cloud\\Datastore\\V1\352\002\034Google"
          + "::Cloud::Datastore::V1b\006proto3"
    };
    descriptor =
        com.google.protobuf.Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(
            descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
              com.google.api.FieldBehaviorProto.getDescriptor(),
              com.google.datastore.v1.EntityProto.getDescriptor(),
              com.google.protobuf.TimestampProto.getDescriptor(),
              com.google.protobuf.WrappersProto.getDescriptor(),
            });
    internal_static_google_datastore_v1_EntityResult_descriptor =
        getDescriptor().getMessageTypes().get(0);
    internal_static_google_datastore_v1_EntityResult_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_EntityResult_descriptor,
            new java.lang.String[] {
              "Entity", "Version", "CreateTime", "UpdateTime", "Cursor",
            });
    internal_static_google_datastore_v1_Query_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_google_datastore_v1_Query_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_Query_descriptor,
            new java.lang.String[] {
              "Projection",
              "Kind",
              "Filter",
              "Order",
              "DistinctOn",
              "StartCursor",
              "EndCursor",
              "Offset",
              "Limit",
            });
    internal_static_google_datastore_v1_AggregationQuery_descriptor =
        getDescriptor().getMessageTypes().get(2);
    internal_static_google_datastore_v1_AggregationQuery_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_AggregationQuery_descriptor,
            new java.lang.String[] {
              "NestedQuery", "Aggregations", "QueryType",
            });
    internal_static_google_datastore_v1_AggregationQuery_Aggregation_descriptor =
        internal_static_google_datastore_v1_AggregationQuery_descriptor.getNestedTypes().get(0);
    internal_static_google_datastore_v1_AggregationQuery_Aggregation_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_AggregationQuery_Aggregation_descriptor,
            new java.lang.String[] {
              "Count", "Sum", "Avg", "Alias", "Operator",
            });
    internal_static_google_datastore_v1_AggregationQuery_Aggregation_Count_descriptor =
        internal_static_google_datastore_v1_AggregationQuery_Aggregation_descriptor
            .getNestedTypes()
            .get(0);
    internal_static_google_datastore_v1_AggregationQuery_Aggregation_Count_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_AggregationQuery_Aggregation_Count_descriptor,
            new java.lang.String[] {
              "UpTo",
            });
    internal_static_google_datastore_v1_AggregationQuery_Aggregation_Sum_descriptor =
        internal_static_google_datastore_v1_AggregationQuery_Aggregation_descriptor
            .getNestedTypes()
            .get(1);
    internal_static_google_datastore_v1_AggregationQuery_Aggregation_Sum_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_AggregationQuery_Aggregation_Sum_descriptor,
            new java.lang.String[] {
              "Property",
            });
    internal_static_google_datastore_v1_AggregationQuery_Aggregation_Avg_descriptor =
        internal_static_google_datastore_v1_AggregationQuery_Aggregation_descriptor
            .getNestedTypes()
            .get(2);
    internal_static_google_datastore_v1_AggregationQuery_Aggregation_Avg_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_AggregationQuery_Aggregation_Avg_descriptor,
            new java.lang.String[] {
              "Property",
            });
    internal_static_google_datastore_v1_KindExpression_descriptor =
        getDescriptor().getMessageTypes().get(3);
    internal_static_google_datastore_v1_KindExpression_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_KindExpression_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_datastore_v1_PropertyReference_descriptor =
        getDescriptor().getMessageTypes().get(4);
    internal_static_google_datastore_v1_PropertyReference_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_PropertyReference_descriptor,
            new java.lang.String[] {
              "Name",
            });
    internal_static_google_datastore_v1_Projection_descriptor =
        getDescriptor().getMessageTypes().get(5);
    internal_static_google_datastore_v1_Projection_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_Projection_descriptor,
            new java.lang.String[] {
              "Property",
            });
    internal_static_google_datastore_v1_PropertyOrder_descriptor =
        getDescriptor().getMessageTypes().get(6);
    internal_static_google_datastore_v1_PropertyOrder_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_PropertyOrder_descriptor,
            new java.lang.String[] {
              "Property", "Direction",
            });
    internal_static_google_datastore_v1_Filter_descriptor =
        getDescriptor().getMessageTypes().get(7);
    internal_static_google_datastore_v1_Filter_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_Filter_descriptor,
            new java.lang.String[] {
              "CompositeFilter", "PropertyFilter", "FilterType",
            });
    internal_static_google_datastore_v1_CompositeFilter_descriptor =
        getDescriptor().getMessageTypes().get(8);
    internal_static_google_datastore_v1_CompositeFilter_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_CompositeFilter_descriptor,
            new java.lang.String[] {
              "Op", "Filters",
            });
    internal_static_google_datastore_v1_PropertyFilter_descriptor =
        getDescriptor().getMessageTypes().get(9);
    internal_static_google_datastore_v1_PropertyFilter_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_PropertyFilter_descriptor,
            new java.lang.String[] {
              "Property", "Op", "Value",
            });
    internal_static_google_datastore_v1_GqlQuery_descriptor =
        getDescriptor().getMessageTypes().get(10);
    internal_static_google_datastore_v1_GqlQuery_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_GqlQuery_descriptor,
            new java.lang.String[] {
              "QueryString", "AllowLiterals", "NamedBindings", "PositionalBindings",
            });
    internal_static_google_datastore_v1_GqlQuery_NamedBindingsEntry_descriptor =
        internal_static_google_datastore_v1_GqlQuery_descriptor.getNestedTypes().get(0);
    internal_static_google_datastore_v1_GqlQuery_NamedBindingsEntry_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_GqlQuery_NamedBindingsEntry_descriptor,
            new java.lang.String[] {
              "Key", "Value",
            });
    internal_static_google_datastore_v1_GqlQueryParameter_descriptor =
        getDescriptor().getMessageTypes().get(11);
    internal_static_google_datastore_v1_GqlQueryParameter_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_GqlQueryParameter_descriptor,
            new java.lang.String[] {
              "Value", "Cursor", "ParameterType",
            });
    internal_static_google_datastore_v1_QueryResultBatch_descriptor =
        getDescriptor().getMessageTypes().get(12);
    internal_static_google_datastore_v1_QueryResultBatch_fieldAccessorTable =
        new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_google_datastore_v1_QueryResultBatch_descriptor,
            new java.lang.String[] {
              "SkippedResults",
              "SkippedCursor",
              "EntityResultType",
              "EntityResults",
              "EndCursor",
              "MoreResults",
              "SnapshotVersion",
              "ReadTime",
            });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    com.google.protobuf.Descriptors.FileDescriptor.internalUpdateFileDescriptor(
        descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.datastore.v1.EntityProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
