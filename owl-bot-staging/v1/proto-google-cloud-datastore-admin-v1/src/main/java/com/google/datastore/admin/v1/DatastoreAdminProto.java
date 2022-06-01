// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/admin/v1/datastore_admin.proto

package com.google.datastore.admin.v1;

public final class DatastoreAdminProto {
  private DatastoreAdminProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_CommonMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_CommonMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_CommonMetadata_LabelsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_CommonMetadata_LabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_Progress_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_Progress_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ExportEntitiesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ExportEntitiesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ExportEntitiesRequest_LabelsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ExportEntitiesRequest_LabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ImportEntitiesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ImportEntitiesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ImportEntitiesRequest_LabelsEntry_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ImportEntitiesRequest_LabelsEntry_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ExportEntitiesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ExportEntitiesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ExportEntitiesMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ExportEntitiesMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ImportEntitiesMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ImportEntitiesMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_EntityFilter_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_EntityFilter_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_CreateIndexRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_CreateIndexRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_DeleteIndexRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_DeleteIndexRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_GetIndexRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_GetIndexRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ListIndexesRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ListIndexesRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_ListIndexesResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_ListIndexesResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_IndexOperationMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_IndexOperationMetadata_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n/google/datastore/admin/v1/datastore_ad" +
      "min.proto\022\031google.datastore.admin.v1\032\034go" +
      "ogle/api/annotations.proto\032\027google/api/c" +
      "lient.proto\032\037google/api/field_behavior.p" +
      "roto\032%google/datastore/admin/v1/index.pr" +
      "oto\032)google/datastore/admin/v1/migration" +
      ".proto\032#google/longrunning/operations.pr" +
      "oto\032\037google/protobuf/timestamp.proto\"\364\003\n" +
      "\016CommonMetadata\022.\n\nstart_time\030\001 \001(\0132\032.go" +
      "ogle.protobuf.Timestamp\022,\n\010end_time\030\002 \001(" +
      "\0132\032.google.protobuf.Timestamp\022@\n\016operati" +
      "on_type\030\003 \001(\0162(.google.datastore.admin.v" +
      "1.OperationType\022E\n\006labels\030\004 \003(\01325.google" +
      ".datastore.admin.v1.CommonMetadata.Label" +
      "sEntry\022>\n\005state\030\005 \001(\0162/.google.datastore" +
      ".admin.v1.CommonMetadata.State\032-\n\013Labels" +
      "Entry\022\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\"\213\001" +
      "\n\005State\022\025\n\021STATE_UNSPECIFIED\020\000\022\020\n\014INITIA" +
      "LIZING\020\001\022\016\n\nPROCESSING\020\002\022\016\n\nCANCELLING\020\003" +
      "\022\016\n\nFINALIZING\020\004\022\016\n\nSUCCESSFUL\020\005\022\n\n\006FAIL" +
      "ED\020\006\022\r\n\tCANCELLED\020\007\":\n\010Progress\022\026\n\016work_" +
      "completed\030\001 \001(\003\022\026\n\016work_estimated\030\002 \001(\003\"" +
      "\215\002\n\025ExportEntitiesRequest\022\027\n\nproject_id\030" +
      "\001 \001(\tB\003\340A\002\022L\n\006labels\030\002 \003(\0132<.google.data" +
      "store.admin.v1.ExportEntitiesRequest.Lab" +
      "elsEntry\022>\n\rentity_filter\030\003 \001(\0132\'.google" +
      ".datastore.admin.v1.EntityFilter\022\036\n\021outp" +
      "ut_url_prefix\030\004 \001(\tB\003\340A\002\032-\n\013LabelsEntry\022" +
      "\013\n\003key\030\001 \001(\t\022\r\n\005value\030\002 \001(\t:\0028\001\"\205\002\n\025Impo" +
      "rtEntitiesRequest\022\027\n\nproject_id\030\001 \001(\tB\003\340" +
      "A\002\022L\n\006labels\030\002 \003(\0132<.google.datastore.ad" +
      "min.v1.ImportEntitiesRequest.LabelsEntry" +
      "\022\026\n\tinput_url\030\003 \001(\tB\003\340A\002\022>\n\rentity_filte" +
      "r\030\004 \001(\0132\'.google.datastore.admin.v1.Enti" +
      "tyFilter\032-\n\013LabelsEntry\022\013\n\003key\030\001 \001(\t\022\r\n\005" +
      "value\030\002 \001(\t:\0028\001\",\n\026ExportEntitiesRespons" +
      "e\022\022\n\noutput_url\030\001 \001(\t\"\253\002\n\026ExportEntities" +
      "Metadata\0229\n\006common\030\001 \001(\0132).google.datast" +
      "ore.admin.v1.CommonMetadata\022>\n\021progress_" +
      "entities\030\002 \001(\0132#.google.datastore.admin." +
      "v1.Progress\022;\n\016progress_bytes\030\003 \001(\0132#.go" +
      "ogle.datastore.admin.v1.Progress\022>\n\renti" +
      "ty_filter\030\004 \001(\0132\'.google.datastore.admin" +
      ".v1.EntityFilter\022\031\n\021output_url_prefix\030\005 " +
      "\001(\t\"\243\002\n\026ImportEntitiesMetadata\0229\n\006common" +
      "\030\001 \001(\0132).google.datastore.admin.v1.Commo" +
      "nMetadata\022>\n\021progress_entities\030\002 \001(\0132#.g" +
      "oogle.datastore.admin.v1.Progress\022;\n\016pro" +
      "gress_bytes\030\003 \001(\0132#.google.datastore.adm" +
      "in.v1.Progress\022>\n\rentity_filter\030\004 \001(\0132\'." +
      "google.datastore.admin.v1.EntityFilter\022\021" +
      "\n\tinput_url\030\005 \001(\t\"4\n\014EntityFilter\022\r\n\005kin" +
      "ds\030\001 \003(\t\022\025\n\rnamespace_ids\030\002 \003(\t\"Y\n\022Creat" +
      "eIndexRequest\022\022\n\nproject_id\030\001 \001(\t\022/\n\005ind" +
      "ex\030\003 \001(\0132 .google.datastore.admin.v1.Ind" +
      "ex\":\n\022DeleteIndexRequest\022\022\n\nproject_id\030\001" +
      " \001(\t\022\020\n\010index_id\030\003 \001(\t\"7\n\017GetIndexReques" +
      "t\022\022\n\nproject_id\030\001 \001(\t\022\020\n\010index_id\030\003 \001(\t\"" +
      "_\n\022ListIndexesRequest\022\022\n\nproject_id\030\001 \001(" +
      "\t\022\016\n\006filter\030\003 \001(\t\022\021\n\tpage_size\030\004 \001(\005\022\022\n\n" +
      "page_token\030\005 \001(\t\"a\n\023ListIndexesResponse\022" +
      "1\n\007indexes\030\001 \003(\0132 .google.datastore.admi" +
      "n.v1.Index\022\027\n\017next_page_token\030\002 \001(\t\"\245\001\n\026" +
      "IndexOperationMetadata\0229\n\006common\030\001 \001(\0132)" +
      ".google.datastore.admin.v1.CommonMetadat" +
      "a\022>\n\021progress_entities\030\002 \001(\0132#.google.da" +
      "tastore.admin.v1.Progress\022\020\n\010index_id\030\003 " +
      "\001(\t\"\253\001\n#DatastoreFirestoreMigrationMetad" +
      "ata\022B\n\017migration_state\030\001 \001(\0162).google.da" +
      "tastore.admin.v1.MigrationState\022@\n\016migra" +
      "tion_step\030\002 \001(\0162(.google.datastore.admin" +
      ".v1.MigrationStep*}\n\rOperationType\022\036\n\032OP" +
      "ERATION_TYPE_UNSPECIFIED\020\000\022\023\n\017EXPORT_ENT" +
      "ITIES\020\001\022\023\n\017IMPORT_ENTITIES\020\002\022\020\n\014CREATE_I" +
      "NDEX\020\003\022\020\n\014DELETE_INDEX\020\0042\204\n\n\016DatastoreAd" +
      "min\022\366\001\n\016ExportEntities\0220.google.datastor" +
      "e.admin.v1.ExportEntitiesRequest\032\035.googl" +
      "e.longrunning.Operation\"\222\001\202\323\344\223\002%\" /v1/pr" +
      "ojects/{project_id}:export:\001*\332A1project_" +
      "id,labels,entity_filter,output_url_prefi" +
      "x\312A0\n\026ExportEntitiesResponse\022\026ExportEnti" +
      "tiesMetadata\022\355\001\n\016ImportEntities\0220.google" +
      ".datastore.admin.v1.ImportEntitiesReques" +
      "t\032\035.google.longrunning.Operation\"\211\001\202\323\344\223\002" +
      "%\" /v1/projects/{project_id}:import:\001*\332A" +
      ")project_id,labels,input_url,entity_filt" +
      "er\312A/\n\025google.protobuf.Empty\022\026ImportEnti" +
      "tiesMetadata\022\257\001\n\013CreateIndex\022-.google.da" +
      "tastore.admin.v1.CreateIndexRequest\032\035.go" +
      "ogle.longrunning.Operation\"R\202\323\344\223\002*\"!/v1/" +
      "projects/{project_id}/indexes:\005index\312A\037\n" +
      "\005Index\022\026IndexOperationMetadata\022\263\001\n\013Delet" +
      "eIndex\022-.google.datastore.admin.v1.Delet" +
      "eIndexRequest\032\035.google.longrunning.Opera" +
      "tion\"V\202\323\344\223\002.*,/v1/projects/{project_id}/" +
      "indexes/{index_id}\312A\037\n\005Index\022\026IndexOpera" +
      "tionMetadata\022\216\001\n\010GetIndex\022*.google.datas" +
      "tore.admin.v1.GetIndexRequest\032 .google.d" +
      "atastore.admin.v1.Index\"4\202\323\344\223\002.\022,/v1/pro" +
      "jects/{project_id}/indexes/{index_id}\022\227\001" +
      "\n\013ListIndexes\022-.google.datastore.admin.v" +
      "1.ListIndexesRequest\032..google.datastore." +
      "admin.v1.ListIndexesResponse\")\202\323\344\223\002#\022!/v" +
      "1/projects/{project_id}/indexes\032v\312A\030data" +
      "store.googleapis.com\322AXhttps://www.googl" +
      "eapis.com/auth/cloud-platform,https://ww" +
      "w.googleapis.com/auth/datastoreB\340\001\n\035com." +
      "google.datastore.admin.v1B\023DatastoreAdmi" +
      "nProtoP\001Z>google.golang.org/genproto/goo" +
      "gleapis/datastore/admin/v1;admin\252\002\037Googl" +
      "e.Cloud.Datastore.Admin.V1\312\002\037Google\\Clou" +
      "d\\Datastore\\Admin\\V1\352\002#Google::Cloud::Da" +
      "tastore::Admin::V1b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.api.AnnotationsProto.getDescriptor(),
          com.google.api.ClientProto.getDescriptor(),
          com.google.api.FieldBehaviorProto.getDescriptor(),
          com.google.datastore.admin.v1.IndexProto.getDescriptor(),
          com.google.datastore.admin.v1.MigrationProto.getDescriptor(),
          com.google.longrunning.OperationsProto.getDescriptor(),
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_google_datastore_admin_v1_CommonMetadata_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_google_datastore_admin_v1_CommonMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_CommonMetadata_descriptor,
        new java.lang.String[] { "StartTime", "EndTime", "OperationType", "Labels", "State", });
    internal_static_google_datastore_admin_v1_CommonMetadata_LabelsEntry_descriptor =
      internal_static_google_datastore_admin_v1_CommonMetadata_descriptor.getNestedTypes().get(0);
    internal_static_google_datastore_admin_v1_CommonMetadata_LabelsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_CommonMetadata_LabelsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_google_datastore_admin_v1_Progress_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_google_datastore_admin_v1_Progress_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_Progress_descriptor,
        new java.lang.String[] { "WorkCompleted", "WorkEstimated", });
    internal_static_google_datastore_admin_v1_ExportEntitiesRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_google_datastore_admin_v1_ExportEntitiesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ExportEntitiesRequest_descriptor,
        new java.lang.String[] { "ProjectId", "Labels", "EntityFilter", "OutputUrlPrefix", });
    internal_static_google_datastore_admin_v1_ExportEntitiesRequest_LabelsEntry_descriptor =
      internal_static_google_datastore_admin_v1_ExportEntitiesRequest_descriptor.getNestedTypes().get(0);
    internal_static_google_datastore_admin_v1_ExportEntitiesRequest_LabelsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ExportEntitiesRequest_LabelsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_google_datastore_admin_v1_ImportEntitiesRequest_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_google_datastore_admin_v1_ImportEntitiesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ImportEntitiesRequest_descriptor,
        new java.lang.String[] { "ProjectId", "Labels", "InputUrl", "EntityFilter", });
    internal_static_google_datastore_admin_v1_ImportEntitiesRequest_LabelsEntry_descriptor =
      internal_static_google_datastore_admin_v1_ImportEntitiesRequest_descriptor.getNestedTypes().get(0);
    internal_static_google_datastore_admin_v1_ImportEntitiesRequest_LabelsEntry_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ImportEntitiesRequest_LabelsEntry_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_google_datastore_admin_v1_ExportEntitiesResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_google_datastore_admin_v1_ExportEntitiesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ExportEntitiesResponse_descriptor,
        new java.lang.String[] { "OutputUrl", });
    internal_static_google_datastore_admin_v1_ExportEntitiesMetadata_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_google_datastore_admin_v1_ExportEntitiesMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ExportEntitiesMetadata_descriptor,
        new java.lang.String[] { "Common", "ProgressEntities", "ProgressBytes", "EntityFilter", "OutputUrlPrefix", });
    internal_static_google_datastore_admin_v1_ImportEntitiesMetadata_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_google_datastore_admin_v1_ImportEntitiesMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ImportEntitiesMetadata_descriptor,
        new java.lang.String[] { "Common", "ProgressEntities", "ProgressBytes", "EntityFilter", "InputUrl", });
    internal_static_google_datastore_admin_v1_EntityFilter_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_google_datastore_admin_v1_EntityFilter_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_EntityFilter_descriptor,
        new java.lang.String[] { "Kinds", "NamespaceIds", });
    internal_static_google_datastore_admin_v1_CreateIndexRequest_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_google_datastore_admin_v1_CreateIndexRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_CreateIndexRequest_descriptor,
        new java.lang.String[] { "ProjectId", "Index", });
    internal_static_google_datastore_admin_v1_DeleteIndexRequest_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_google_datastore_admin_v1_DeleteIndexRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_DeleteIndexRequest_descriptor,
        new java.lang.String[] { "ProjectId", "IndexId", });
    internal_static_google_datastore_admin_v1_GetIndexRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_google_datastore_admin_v1_GetIndexRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_GetIndexRequest_descriptor,
        new java.lang.String[] { "ProjectId", "IndexId", });
    internal_static_google_datastore_admin_v1_ListIndexesRequest_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_google_datastore_admin_v1_ListIndexesRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ListIndexesRequest_descriptor,
        new java.lang.String[] { "ProjectId", "Filter", "PageSize", "PageToken", });
    internal_static_google_datastore_admin_v1_ListIndexesResponse_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_google_datastore_admin_v1_ListIndexesResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_ListIndexesResponse_descriptor,
        new java.lang.String[] { "Indexes", "NextPageToken", });
    internal_static_google_datastore_admin_v1_IndexOperationMetadata_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_google_datastore_admin_v1_IndexOperationMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_IndexOperationMetadata_descriptor,
        new java.lang.String[] { "Common", "ProgressEntities", "IndexId", });
    internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_google_datastore_admin_v1_DatastoreFirestoreMigrationMetadata_descriptor,
        new java.lang.String[] { "MigrationState", "MigrationStep", });
    com.google.protobuf.ExtensionRegistry registry =
        com.google.protobuf.ExtensionRegistry.newInstance();
    registry.add(com.google.api.ClientProto.defaultHost);
    registry.add(com.google.api.FieldBehaviorProto.fieldBehavior);
    registry.add(com.google.api.AnnotationsProto.http);
    registry.add(com.google.api.ClientProto.methodSignature);
    registry.add(com.google.api.ClientProto.oauthScopes);
    registry.add(com.google.longrunning.OperationsProto.operationInfo);
    com.google.protobuf.Descriptors.FileDescriptor
        .internalUpdateFileDescriptor(descriptor, registry);
    com.google.api.AnnotationsProto.getDescriptor();
    com.google.api.ClientProto.getDescriptor();
    com.google.api.FieldBehaviorProto.getDescriptor();
    com.google.datastore.admin.v1.IndexProto.getDescriptor();
    com.google.datastore.admin.v1.MigrationProto.getDescriptor();
    com.google.longrunning.OperationsProto.getDescriptor();
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
