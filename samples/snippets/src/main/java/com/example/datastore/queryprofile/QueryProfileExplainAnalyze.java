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

// [START datastore_query_explain_analyze_entity]
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.models.QueryPlan;
import com.google.cloud.datastore.models.QueryProfile;
import java.util.Map;

public class QueryProfileExplainAnalyze {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Build the query
    Query<Entity> query = Query.newEntityQueryBuilder().setKind("Task").build();

    // Set the query mode to EXPLAIN_ANALYZE to get back the query stats, plan info, and query
    // results
    QueryResults<Entity> results = datastore.run(query, QueryProfile.QueryMode.EXPLAIN_ANALYZE);

    // Get the result set stats
    if (!results.getResultSetStats().isPresent()) {
      throw new Exception("No result set stats returned");
    }
    ResultSetStats resultSetStats = results.getResultSetStats().get();

    // Get the query stats
    if (!resultSetStats.getQueryStats().isPresent()) {
      throw new Exception("No query stats returned");
    }

    Map<String, Object> queryStats = resultSetStats.getQueryStats().get();
    System.out.println("----- Query Stats -----");
    queryStats.forEach((stat, value) -> System.out.println("Stat: " + stat + ", Value: " + value));

    // Get the query plan
    QueryPlan queryPlan = resultSetStats.getQueryPlan();
    Map<String, Object> planInfo = queryPlan.getPlanInfo();
    System.out.println("----- Plan Info -----");
    planInfo.forEach(
        (plan, value) -> System.out.println("Plan Info: " + plan + ", Value: " + value));

    if (!results.hasNext()) {
      throw new Exception("query yielded no results");
    }

    // Get the query results
    System.out.println("----- Query Results -----");
    while (results.hasNext()) {
      Entity entity = results.next();
      System.out.printf("Entity: %s%n", entity);
    }
  }
}
// [END datastore_query_explain_analyze_entity]
