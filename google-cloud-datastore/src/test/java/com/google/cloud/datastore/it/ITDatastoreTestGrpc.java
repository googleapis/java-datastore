/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore.it;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.testing.RemoteDatastoreHelper;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.common.truth.Truth;
import org.junit.jupiter.api.AfterAll;

class ITDatastoreTestGrpc extends AbstractITDatastoreTest {
  // setup for default db, grpc transport
  protected static final RemoteDatastoreHelper HELPER_DEFAULT_GRPC =
      RemoteDatastoreHelper.create(GrpcTransportOptions.newBuilder().build());
  private static final DatastoreOptions OPTIONS_DEFAULT_GRPC = HELPER_DEFAULT_GRPC.getOptions();
  private static final Datastore DATASTORE_DEFAULT_GRPC = OPTIONS_DEFAULT_GRPC.getService();

  public ITDatastoreTestGrpc() {
    super(OPTIONS_DEFAULT_GRPC, DATASTORE_DEFAULT_GRPC, "default");
  }

  @AfterAll
  static void afterClass() throws Exception {
    HELPER_DEFAULT_GRPC.deleteNamespace();
    DATASTORE_DEFAULT_GRPC.close();
    Truth.assertThat(DATASTORE_DEFAULT_GRPC.isClosed()).isTrue();
  }
}
