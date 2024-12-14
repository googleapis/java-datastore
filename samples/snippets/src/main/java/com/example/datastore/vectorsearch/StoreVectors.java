/*
 * Copyright 2024 Google LLC
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

package com.example.datastore.vectorsearch;

// [START datastore_store_vectors]

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.VectorValue;

public class StoreVectors {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The Cloud Datastore key for the new entity
    Key key = datastore.newKeyFactory().setKind("CoffeeBean").newKey("Kahawa");

    // Prepares the entity with a vector embedding
    Entity entity =
        Entity.newBuilder(key)
            .set("name", "Kahawa")
            .set("description", "Information about the Kahawa coffee beans.")
            .set("roast", "dark")
            .set("embedding_field", VectorValue.newBuilder(1.0, 7.0, 11.1).build())
            .build();

    // Saves the entity
    datastore.put(entity);
    System.out.printf("Saved %s: %s%n", entity.getKey().getName(), entity.getString("description"));

    // Retrieve entity
    Entity retrieved = datastore.get(key);
    System.out.printf(
        "Retrieved %s with embedding_field: %s%n",
        key.getName(), retrieved.getVector("embedding_field"));
  }
}
// [END datastore_store_vectors]
