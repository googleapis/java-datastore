// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/admin/v1/index.proto

package com.google.datastore.admin.v1;

public final class IndexProto {
  private IndexProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_Index_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_Index_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_Index_IndexedProperty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_Index_IndexedProperty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n%google/datastore/admin/v1/index.proto\022" +
      "\031google.datastore.admin.v1\032\037google/api/f" +
      "ield_behavior.proto\"\356\004\n\005Index\022\030\n\nproject" +
      "_id\030\001 \001(\tB\004\342A\001\003\022\026\n\010index_id\030\003 \001(\tB\004\342A\001\003\022" +
      "\022\n\004kind\030\004 \001(\tB\004\342A\001\002\022E\n\010ancestor\030\005 \001(\0162-." +
      "google.datastore.admin.v1.Index.Ancestor" +
      "ModeB\004\342A\001\002\022J\n\nproperties\030\006 \003(\01320.google." +
      "datastore.admin.v1.Index.IndexedProperty" +
      "B\004\342A\001\002\022;\n\005state\030\007 \001(\0162&.google.datastore" +
      ".admin.v1.Index.StateB\004\342A\001\003\032j\n\017IndexedPr" +
      "operty\022\022\n\004name\030\001 \001(\tB\004\342A\001\002\022C\n\tdirection\030" +
      "\002 \001(\0162*.google.datastore.admin.v1.Index." +
      "DirectionB\004\342A\001\002\"J\n\014AncestorMode\022\035\n\031ANCES" +
      "TOR_MODE_UNSPECIFIED\020\000\022\010\n\004NONE\020\001\022\021\n\rALL_" +
      "ANCESTORS\020\002\"E\n\tDirection\022\031\n\025DIRECTION_UN" +
      "SPECIFIED\020\000\022\r\n\tASCENDING\020\001\022\016\n\nDESCENDING" +
      "\020\002\"P\n\005State\022\025\n\021STATE_UNSPECIFIED\020\000\022\014\n\010CR" +
      "EATING\020\001\022\t\n\005READY\020\002\022\014\n\010DELETING\020\003\022\t\n\005ERR" +
      "OR\020\004B\322\001\n\035com.google.datastore.admin.v1B\n" +
      "IndexProtoP\001Z9cloud.google.com/go/datast" +
      "ore/admin/apiv1/adminpb;adminpb\252\002\037Google" +
      ".Cloud.Datastore.Admin.V1\312\002\037Google\\Cloud" +
      "\\Datastore\\Admin\\V1\352\002#Google::Cloud::Dat" +
      "astore::Admin::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.FieldBehaviorProto.getDescriptor(),
        });
    internal_static_google_datastore_admin_v1_Index_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_datastore_admin_v1_Index_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_Index_descriptor,
        new java.lang.String[] { "ProjectId", "IndexId", "Kind", "Ancestor", "Properties", "State", });
    internal_static_google_datastore_admin_v1_Index_IndexedProperty_descriptor =
      internal_static_google_datastore_admin_v1_Index_descriptor.getNestedTypes().get(0);
    internal_static_google_datastore_admin_v1_Index_IndexedProperty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_Index_IndexedProperty_descriptor,
        new java.lang.String[] { "Name", "Direction", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.FieldBehaviorProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
