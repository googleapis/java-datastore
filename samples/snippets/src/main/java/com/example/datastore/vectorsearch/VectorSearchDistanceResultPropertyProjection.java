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

// [START datastore_vector_search_distance_result_property_projection]

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.FindNearest;
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.VectorValue;

public class VectorSearchDistanceResultPropertyProjection {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Create vector search query with projection
    Query<ProjectionEntity> vectorSearchQuery =
        Query.newProjectionEntityQueryBuilder()
            .setKind("CoffeeBean")
            .setFindNearest(
                new FindNearest(
                    "embedding_field",
                    VectorValue.newBuilder(1, 9, 11.1).build(),
                    FindNearest.DistanceMeasure.EUCLIDEAN,
                    3,
                    "vector_distance"))
            .setProjection("roast")
            .build();

    // Execute vector search query
    QueryResults<ProjectionEntity> results = datastore.run(vectorSearchQuery);

    if (!results.hasNext()) {
      throw new Exception("query yielded no results");
    }

    while (results.hasNext()) {
      ProjectionEntity entity = results.next();
      System.out.printf(
          "Entity: %s, Distance: %s%n",
          entity.getKey().getName(), entity.getDouble("vector_distance"));
    }
  }
}
// [END datastore_vector_search_distance_result_property_projection]
