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

// [START datastore_vector_search_large_response]

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FindNearest;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.VectorValue;
import com.google.common.collect.Iterators;
import java.util.Iterator;

public class VectorSearchLargeResponse {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Create a keys-only vector search query
    Query<Key> vectorSearchKeyOnlyQuery =
        Query.newKeyQueryBuilder()
            .setKind("CoffeeBean")
            .setFindNearest(
                new FindNearest(
                    "embedding_field",
                    VectorValue.newBuilder(1, 9, 11.1).build(),
                    FindNearest.DistanceMeasure.EUCLIDEAN,
                    3,
                    "vector_distance",
                    2.0))
            .build();

    QueryResults<Key> keyResults = datastore.run(vectorSearchKeyOnlyQuery);
    Key[] keys = Iterators.toArray(keyResults, Key.class);

    // Next, perform a second query for the remaining data
    Iterator<Entity> entities = datastore.get(keys);

    if (!keyResults.hasNext()) {
      throw new Exception("query yielded no results");
    }

    // Combine and print results
    while (keyResults.hasNext()) {
      Key keyResult = keyResults.next();
      System.out.printf(
          "Entity: %s, Distance: %s%n",
          keyResult.getName(), entities.next().getDouble("vector_distance"));
    }
  }
}
// [END datastore_vector_search_large_response]
