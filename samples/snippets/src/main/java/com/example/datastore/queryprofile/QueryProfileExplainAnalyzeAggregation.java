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

// [START datastore_query_explain_analyze_aggregation]

import static com.google.cloud.datastore.aggregation.Aggregation.count;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.models.QueryPlan;
import com.google.cloud.datastore.models.QueryProfile.QueryMode;
import com.google.common.collect.Iterables;
import java.util.Map;

public class QueryProfileExplainAnalyzeAggregation {
  public static void invoke() throws Exception {
    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // Build the query
    StructuredQuery<Entity> query = Query.newEntityQueryBuilder().setKind("Task").build();

    // Build the aggregation query
    AggregationQuery aggregationQuery =
        Query.newAggregationQueryBuilder()
            .over(query)
            .addAggregation(count().as("countVal"))
            .build();

    // Set the query mode to EXPLAIN_ANALYZE to get back the query stats, plan info, and aggregation
    // results
    AggregationResults results =
        datastore.runAggregation(aggregationQuery, QueryMode.EXPLAIN_ANALYZE);

    Map<String, Object> queryStats = results.getResultSetStats().getQueryStats();
    System.out.println("----- Query Stats -----");
    queryStats.forEach((stat, value) -> System.out.println("Stat: " + stat + ", Value: " + value));

    QueryPlan queryPlan = results.getResultSetStats().getQueryPlan();
    Map<String, Object> planInfo = queryPlan.getPlanInfo();
    System.out.println("----- Plan Info -----");
    planInfo.forEach(
        (plan, value) -> System.out.println("Plan Info: " + plan + ", Value: " + value));

    System.out.println("----- Aggregation Results -----");
    AggregationResult result = Iterables.getOnlyElement(results);
    System.out.println("Count: " + result.getLong("countVal"));
  }
}
// [END datastore_query_explain_analyze_aggregation]
