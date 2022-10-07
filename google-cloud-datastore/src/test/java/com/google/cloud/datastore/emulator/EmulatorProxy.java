/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.datastore.emulator;

import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.spi.v1.HttpDatastoreRpc;
import java.io.IOException;
import okhttp3.mockwebserver.MockWebServer;

public class EmulatorProxy {

  private final MockWebServer mockWebServer;
  private final DatastoreOptions emulatorDataStoreOptions;

  public EmulatorProxy(DatastoreOptions emulatorDataStoreOptions) {
    this.emulatorDataStoreOptions = emulatorDataStoreOptions;
    this.mockWebServer = new MockWebServer();
    init();
  }

  private void init() {
    this.mockWebServer.setDispatcher(
        new ProxyDispatcher(new HttpDatastoreRpc(emulatorDataStoreOptions)));
  }

  public void start() throws IOException {
    this.mockWebServer.start();
  }

  public void stop() throws IOException {
    this.mockWebServer.shutdown();
  }

  public DatastoreOptions getOptions() {
    DatastoreOptions.Builder builder = this.emulatorDataStoreOptions.toBuilder();
    builder.setHost(this.mockWebServer.getHostName() + ":" + this.mockWebServer.getPort());
    return builder.build();
  }
}
