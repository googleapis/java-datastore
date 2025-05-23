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
import java.util.Arrays;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ITDatastoreTestHttp extends AbstractITDatastoreTest {
  // setup for default db, http transport
  private static final RemoteDatastoreHelper HELPER_DEFAULT_HTTP = RemoteDatastoreHelper.create();

  private static final DatastoreOptions OPTIONS_DEFAULT_HTTP = HELPER_DEFAULT_HTTP.getOptions();
  private static final Datastore DATASTORE_DEFAULT_HTTP = OPTIONS_DEFAULT_HTTP.getService();

  // setup for custom db, http transport
  private static final RemoteDatastoreHelper HELPER_CUSTOM_DB_HTTP =
      RemoteDatastoreHelper.create(CUSTOM_DB_ID);
  private static final DatastoreOptions OPTIONS_CUSTOM_DB_HTTP = HELPER_CUSTOM_DB_HTTP.getOptions();
  private static final Datastore DATASTORE_CUSTOM_DB_HTTP = OPTIONS_CUSTOM_DB_HTTP.getService();

  public ITDatastoreTestHttp(DatastoreOptions options, Datastore datastore, String databaseType) {
    super(options, datastore, databaseType);
  }

  @Parameterized.Parameters(name = "database: {2}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {OPTIONS_DEFAULT_HTTP, DATASTORE_DEFAULT_HTTP, "default"},
          {OPTIONS_CUSTOM_DB_HTTP, DATASTORE_CUSTOM_DB_HTTP, CUSTOM_DB_ID},
        });
  }

  @AfterClass
  public static void afterClass() throws Exception {
    HELPER_DEFAULT_HTTP.deleteNamespace();
    HELPER_CUSTOM_DB_HTTP.deleteNamespace();
  }
}
