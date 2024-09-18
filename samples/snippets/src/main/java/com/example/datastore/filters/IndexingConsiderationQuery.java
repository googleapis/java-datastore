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

package com.example.datastore.filters;

// sample-metadata:
//   title: Queries with indexing considerations
//   description: The following query produces a result set
//   that is ordered according to the index definition.

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.Filter;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;

public class IndexingConsiderationQuery {
  public static void invoke() throws Exception {

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Build a query with multi inequal filters and optimized index order of index properties.
    // [START datastore_query_indexing_considerations]
    Query<Entity> query = Query.newEntityQueryBuilder()
            .setKind("employees")
            .setFilter(CompositeFilter.and(PropertyFilter.gt("salary", 100000), PropertyFilter.gt("experience", 0)))
            .setOrderBy(OrderBy("salary"), OrderBy("experience"))
            .build();
    // [END datastore_query_indexing_considerations]

    // Get the results back from Datastore
    QueryResults<Entity> results = datastore.run(query);

    if (!results.hasNext()) {
      throw new Exception("query yielded no results");
    }

    while (results.hasNext()) {
      Entity entity = results.next();
      System.out.printf("Entity: %s%n", entity);
    }

    AggregationResult customer1SalesAvgQueryResult = Iterables.getOnlyElement(datastore.runAggregation(customer1SalesAvg));

    System.out.printf("Customer 1 sales avg is %d", customer1SalesAvgQueryResult.getLong("total_sales")); // 92
  }
}
