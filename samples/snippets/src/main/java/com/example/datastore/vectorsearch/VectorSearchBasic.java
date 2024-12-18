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

// [START datastore_vector_search_basic]

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FindNearest;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.VectorValue;

public class VectorSearchBasic {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Create vector search query
    Query<Entity> vectorSearchQuery =
        Query.newEntityQueryBuilder()
            .setKind("CoffeeBean")
            .setFindNearest(
                new FindNearest(
                    "embedding_field",
                    VectorValue.newBuilder(1, 9, 11.1).build(),
                    FindNearest.DistanceMeasure.EUCLIDEAN,
                    1))
            .build();

    // Execute vector search query
    QueryResults<Entity> results = datastore.run(vectorSearchQuery);

    if (!results.hasNext()) {
      throw new Exception("query yielded no results");
    }

    while (results.hasNext()) {
      Entity entity = results.next();
      System.out.printf("Entity: %s%n", entity.getKey().getName());
    }
  }
}
// [END datastore_vector_search_basic]
