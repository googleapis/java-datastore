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

// [START datastore_v1_generated_DatastoreAdmin_ExportEntities_LRO_async]
import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.datastore.admin.v1.DatastoreAdminClient;
import com.google.datastore.admin.v1.EntityFilter;
import com.google.datastore.admin.v1.ExportEntitiesMetadata;
import com.google.datastore.admin.v1.ExportEntitiesRequest;
import com.google.datastore.admin.v1.ExportEntitiesResponse;
import java.util.HashMap;

public class AsyncExportEntitiesLRO {

  public static void main(String[] args) throws Exception {
    asyncExportEntitiesLRO();
  }

  public static void asyncExportEntitiesLRO() throws Exception {
    // This snippet has been automatically generated and should be regarded as a code template only.
    // It will require modifications to work:
    // - It may require correct/in-range values for request initialization.
    // - It may require specifying regional endpoints when creating the service client as shown in
    // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
    try (DatastoreAdminClient datastoreAdminClient = DatastoreAdminClient.create()) {
      ExportEntitiesRequest request =
          ExportEntitiesRequest.newBuilder()
              .setProjectId("projectId-894832108")
              .putAllLabels(new HashMap<String, String>())
              .setEntityFilter(EntityFilter.newBuilder().build())
              .setOutputUrlPrefix("outputUrlPrefix-1132598048")
              .build();
      OperationFuture<ExportEntitiesResponse, ExportEntitiesMetadata> future =
          datastoreAdminClient.exportEntitiesOperationCallable().futureCall(request);
      // Do something.
      ExportEntitiesResponse response = future.get();
    }
  }
}
// [END datastore_v1_generated_DatastoreAdmin_ExportEntities_LRO_async]
