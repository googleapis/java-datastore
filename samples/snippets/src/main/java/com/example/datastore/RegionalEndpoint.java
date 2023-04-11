/*
 * Copyright 2023 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datastore;

// Imports the Google Cloud client library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

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

public class RegionalEndpoint {


  public Datastore createClient() throws Exception {
    // Instantiates a client
    // [START datastore_regional_endpoint]
    DatastoreOptions options = DatastoreOptions.newBuilder()
        .setHost("https://nam5-datastore.googleapis.com")
        .build();
    Datastore datastore = options.getService();
    // [END datastore_regional_endpoint]
    return datastore;

  }
}
