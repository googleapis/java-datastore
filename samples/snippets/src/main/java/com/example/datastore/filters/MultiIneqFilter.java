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
//   title: Range and inequality filters on multiple properties
//   description: The following query uses range filters on
//   priority and days to return all tasks with priority greater
//   than four and with less than three days to complete.

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import java.util.ArrayList;
import java.util.List;

public class MultiIneqFilter {
  public static void invoke() throws Exception {
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // [START datastore_query_filter_compound_multi_ineq]
    Query<Entity> query =
        Query.newEntityQueryBuilder()
            .setKind("Task")
            .setFilter(
                CompositeFilter.and(
                    PropertyFilter.gt("priority", 4), PropertyFilter.lt("days", 3)))
            .build();
    // [END datastore_query_filter_compound_multi_ineq]

    // Get the results back from Datastore.
    QueryResults<Entity> results = datastore.run(query);

    if (!results.hasNext()) {
      throw new Exception("query yielded no results");
    }

    List<Entity> entities = new ArrayList<>();
    while (results.hasNext()) {
      entities.add(results.next());
    }

    return entities;
  }
}
