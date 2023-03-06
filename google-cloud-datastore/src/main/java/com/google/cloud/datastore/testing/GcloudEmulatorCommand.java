/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.datastore.testing;

import static com.google.cloud.datastore.testing.LocalDatastoreHelper.CONSISTENCY_FLAG;
import static com.google.cloud.datastore.testing.LocalDatastoreHelper.PROJECT_FLAG;
import static com.google.common.base.MoreObjects.firstNonNull;

import com.google.api.core.InternalApi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/** Utility to configure gcloud datastore emulator command. */
@InternalApi
public class GcloudEmulatorCommand {

  // Gcloud emulator settings
  private static final String GCLOUD_CMD_TEXT = "gcloud --quiet beta emulators datastore start";
  private static final String GCLOUD_CMD_PORT_FLAG = "--host-port=";
  public static final String VERSION_PREFIX = "cloud-datastore-emulator ";

  private static final String PROJECT_ID_PREFIX = "test-project-";
  private static final String DEFAULT_PROJECT_ID = PROJECT_ID_PREFIX + UUID.randomUUID();

  public static List<String> get(LocalDatastoreHelper.Builder builder, int port) {
    String projectId = firstNonNull(builder.getProjectId(), DEFAULT_PROJECT_ID);
    List<String> gcloudCommand = new ArrayList<>(Arrays.asList(GCLOUD_CMD_TEXT.split(" ")));
    gcloudCommand.add(GCLOUD_CMD_PORT_FLAG + "localhost:" + port);
    gcloudCommand.add(CONSISTENCY_FLAG + builder.getConsistency());
    gcloudCommand.add(PROJECT_FLAG + projectId);
    if (!builder.isStoreOnDisk()) {
      gcloudCommand.add("--no-store-on-disk");
    }
    if (builder.getDataDir() != null) {
      gcloudCommand.add("--data-dir=" + builder.getDataDir());
    }
    return gcloudCommand;
  }
}
