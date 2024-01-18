/*
 * Copyright 2023 Google LLC
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
package com.example.datastore.queryprofile;

// [START datastore_query_explain_entity]

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.models.QueryPlan;
import java.util.Map;
import java.util.Optional;

public class QueryProfileExplain {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Build the query
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("Task").build();

    // Set the query mode to EXPLAIN to get back *only* the plan info
    QueryResults<Entity> results = datastore.run(query, QueryProfile.QueryMode.EXPLAIN);

    // Get the query plan
    Optional<ResultSetStats> resultSetStats = results.getResultSetStats();
    if (!resultSetStats.isPresent()) {
      throw new Exception("No result set stats returned");
    }
    QueryPlan queryPlan = resultSetStats.get().getQueryPlan();
    Map<String, Object> planInfo = queryPlan.getPlanInfo();
    System.out.println("----- Plan Info -----");
    planInfo.forEach(
        (plan, value) -> System.out.println("Plan Info: " + plan + ", Value: " + value));
  }
}
// [END datastore_query_explain_entity]
