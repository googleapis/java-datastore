/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.admin.v1.samples;

// [START datastore_v1_generated_DatastoreAdmin_ExportEntities_StringMapstringstringEntityfilterString_sync]
import com.google.cloud.datastore.admin.v1.DatastoreAdminClient;
import com.google.datastore.admin.v1.EntityFilter;
import com.google.datastore.admin.v1.ExportEntitiesResponse;
import java.util.HashMap;
import java.util.Map;

public class SyncExportEntitiesStringMapstringstringEntityfilterString {

  public static void main(String[] args) throws Exception {
    syncExportEntitiesStringMapstringstringEntityfilterString();
  }

  public static void syncExportEntitiesStringMapstringstringEntityfilterString() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
      String projectId = "projectId-894832108";
      Map<String, String> labels = new HashMap<>();
      EntityFilter entityFilter = EntityFilter.newBuilder().build();
      String outputUrlPrefix = "outputUrlPrefix-1132598048";
      ExportEntitiesResponse response =
          datastoreAdminClient
              .exportEntitiesAsync(projectId, labels, entityFilter, outputUrlPrefix)
              .get();
    }
  }
}
// [END datastore_v1_generated_DatastoreAdmin_ExportEntities_StringMapstringstringEntityfilterString_sync]
