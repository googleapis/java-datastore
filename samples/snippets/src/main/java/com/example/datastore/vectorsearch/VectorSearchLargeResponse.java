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
import com.google.cloud.datastore.ProjectionEntity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.VectorValue;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import java.util.Iterator;

public class VectorSearchLargeResponse {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Create a keys-only vector search query
    StructuredQuery<ProjectionEntity> keyOnlyVectorQuery =
        Query.newProjectionEntityQueryBuilder()
            .setKind("CoffeeBean")
            .setProjection("__key__")
            .setFindNearest(
                new FindNearest(
                    "embedding_field",
                    VectorValue.newBuilder(1, 9, 11.1).build(),
                    FindNearest.DistanceMeasure.EUCLIDEAN,
                    3,
                    "vector_distance",
                    2.0))
            .build();

    QueryResults<ProjectionEntity> keyOnlyResults = datastore.run(keyOnlyVectorQuery);
    ProjectionEntity[] keyEntities = Iterators.toArray(keyOnlyResults, ProjectionEntity.class);
    Key[] keys =
        ImmutableList.copyOf(keyEntities).stream().map(e -> e.getKey()).toArray(Key[]::new);
    System.out.printf("Key query result size: %s%n", keys.length);

    // Lookup the full entities using the result of the keys only query.
    Iterator<Entity> entities = datastore.get(keys);
    Entity[] entitiesArray = Iterators.toArray(entities, Entity.class);
    System.out.printf("Entity query result size: %s%n", entitiesArray.length);

    // Combine and print results
    for (int i = 0; i < keyEntities.length; i++) {
      System.out.printf(
          "Entity: %s, Distance: %s, Roast: %s%n",
          keyEntities[i].getKey().getName(),
          keyEntities[i].getDouble("vector_distance"),
          entitiesArray[i].getString("roast"));
    }
  }
}
// [END datastore_vector_search_large_response]
