/*
 * Copyright 2022 Google LLC
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

package com.example.datastore;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Datastore.TransactionCallable;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DatastoreReaderWriter;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.GqlQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.common.collect.Iterables;

public class AggregationQuerySample {

  public void aggregationQueryAndCountAggregationOnKind() {
    // [START datastore_count_aggregation_query_on_kind]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Candidate";

    Key candidate1Key = datastore.newKeyFactory().setKind(kind).newKey("candidate1");
    Key candidate2Key = datastore.newKeyFactory().setKind(kind).newKey("candidate2");
    Key candidate3Key = datastore.newKeyFactory().setKind(kind).newKey("candidate3");

    // Save all the candidates
    datastore.put(
        Entity.newBuilder(candidate1Key).set("qualified", true).build(),
        Entity.newBuilder(candidate2Key).set("qualified", false).build(),
        Entity.newBuilder(candidate3Key).set("qualified", true).build()
    );

    EntityQuery selectAllCandidates = Query.newEntityQueryBuilder()
        .setKind(kind)
        .build();
    // Creating an aggregation query to get the count of all candidates
    AggregationQuery allCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllCandidates)
        .addAggregation(Aggregation.count())
        .addAggregation(Aggregation.count().as("total_count"))
        .build();
    // Executing aggregation query
    AggregationResult allCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allCandidatesCountQuery));

    System.out.printf("Total candidates count is %d",
        allCandidatesCountQueryResult.get("total_count")); // 3
    System.out.printf("Total candidates (accessible from default alias) is %d",
        allCandidatesCountQueryResult.get("property_1")); // 3

    // [END datastore_count_aggregation_query_on_kind]
  }

  public void aggregationQueryAndCountAggregationWithLimit() {
    // [START datastore_count_aggregation_query_with_limit]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Candidate";

    Key candidate1Key = datastore.newKeyFactory().setKind(kind).newKey("candidate1");
    Key candidate2Key = datastore.newKeyFactory().setKind(kind).newKey("candidate2");
    Key candidate3Key = datastore.newKeyFactory().setKind(kind).newKey("candidate3");

    // Save all the candidates
    datastore.put(
        Entity.newBuilder(candidate1Key).set("qualified", true).build(),
        Entity.newBuilder(candidate2Key).set("qualified", false).build(),
        Entity.newBuilder(candidate3Key).set("qualified", true).build()
    );

    EntityQuery selectAllCandidates = Query.newEntityQueryBuilder()
        .setKind(kind)
        .setLimit(2)
        .build();
    // Creating an aggregation query to get the count of all candidates
    AggregationQuery allCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllCandidates)
        .addAggregation(Aggregation.count().as("at_least"))
        .build();
    // Executing aggregation query
    AggregationResult limitQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allCandidatesCountQuery));

    System.out.printf("We have at least %d candidates", limitQueryResult.get("at_least")); // 2

    // [END datastore_count_aggregation_query_with_limit]
  }

  public void aggregationQueryAndCountAggregationWithOrderBy() {
    // [START datastore_count_aggregation_query_with_order_by]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Candidate";

    Key candidate1Key = datastore.newKeyFactory().setKind(kind).newKey("candidate1");
    Key candidate2Key = datastore.newKeyFactory().setKind(kind).newKey("candidate2");
    Key candidate3Key = datastore.newKeyFactory().setKind(kind).newKey("candidate3");

    // Save all the candidates
    datastore.put(
        Entity.newBuilder(candidate1Key).set("qualified", true).set("rank", 1).build(),
        Entity.newBuilder(candidate2Key).set("qualified", false).build(),  // no rank specified
        Entity.newBuilder(candidate3Key).set("qualified", true).set("rank", 2).build()
    );

    EntityQuery selectAllCandidates = Query.newEntityQueryBuilder()
        .setKind(kind)
        .addOrderBy(OrderBy.asc("rank"))    // OrderBy acts as an existence filter
        .build();
    // Creating an aggregation query to get the count of all candidates
    AggregationQuery allCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllCandidates)
        .addAggregation(Aggregation.count().as("count"))
        .build();
    // Executing aggregation query
    AggregationResult limitQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allCandidatesCountQuery));

    System.out.printf("Total %d candidates found with rank field",
        limitQueryResult.get("count")); // 2

    // [END datastore_count_aggregation_query_with_order_by]
  }

  public void aggregationQueryAndCountAggregationWithPropertyFilter() {
    // [START datastore_count_aggregation_query_with_filters]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Candidate";

    Key candidate1Key = datastore.newKeyFactory().setKind(kind).newKey("candidate1");
    Key candidate2Key = datastore.newKeyFactory().setKind(kind).newKey("candidate2");
    Key candidate3Key = datastore.newKeyFactory().setKind(kind).newKey("candidate3");

    // Save all the candidates
    datastore.put(
        Entity.newBuilder(candidate1Key).set("qualified", true).build(),
        Entity.newBuilder(candidate2Key).set("qualified", false).build(),
        Entity.newBuilder(candidate3Key).set("qualified", true).build()
    );

    EntityQuery qualifiedCandidates = Query.newEntityQueryBuilder()
        .setKind(kind)
        .setFilter(PropertyFilter.eq("qualified", true))
        .build();
    EntityQuery unQualifiedCandidates = Query.newEntityQueryBuilder()
        .setKind(kind)
        .setFilter(PropertyFilter.eq("qualified", false))
        .build();
    // Creating an aggregation query to get the count of all qualified candidates
    AggregationQuery qualifiedCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(qualifiedCandidates)
        .addAggregation(Aggregation.count().as("total_qualified_count"))
        .build();
    // Creating an aggregation query to get the count of all unqualified candidates
    AggregationQuery unqualifiedCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(unQualifiedCandidates)
        .addAggregation(Aggregation.count().as("total_unqualified_count"))
        .build();

    // Executing aggregation query
    AggregationResult qualifiedCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(qualifiedCandidatesCountQuery));
    AggregationResult unQualifiedCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(unqualifiedCandidatesCountQuery));

    System.out.printf("Total qualified candidates count is %d",
        qualifiedCandidatesCountQueryResult.get("total_qualified_count")); // 2
    System.out.printf("Total unqualified candidates count is %d",
        unQualifiedCandidatesCountQueryResult.get("total_unqualified_count")); // 1

    // [END datastore_count_aggregation_query_with_filters]
  }

  public void aggregationQueryAndCountAggregationWithGqlQuery() {
    // [START datastore_count_aggregation_query_gql]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Candidate";

    Key candidate1Key = datastore.newKeyFactory().setKind(kind).newKey("candidate1");
    Key candidate2Key = datastore.newKeyFactory().setKind(kind).newKey("candidate2");
    Key candidate3Key = datastore.newKeyFactory().setKind(kind).newKey("candidate3");

    // Save all the candidates
    datastore.put(
        Entity.newBuilder(candidate1Key).set("qualified", true).build(),
        Entity.newBuilder(candidate2Key).set("qualified", false).build(),
        Entity.newBuilder(candidate3Key).set("qualified", true).build()
    );

    GqlQuery<?> selectAllCandidates = Query.newGqlQueryBuilder(
            "AGGREGATE COUNT(*) AS total_count, COUNT_UP_TO(2) AS count_with_limit "
                + "OVER (SELECT * FROM Candidate)")
        .setAllowLiteral(true)
        .build();
    // Creating an aggregation query to get the count of all candidates
    AggregationQuery allCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllCandidates)
        .build();
    // Executing aggregation query
    AggregationResult allCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allCandidatesCountQuery));

    System.out.printf("We have at least %d candidates",
        allCandidatesCountQueryResult.get("count_with_limit")); // 2
    System.out.printf("Total candidates count is %d",
        allCandidatesCountQueryResult.get("total_count")); // 3

    GqlQuery<?> qualifiedCandidates = Query.newGqlQueryBuilder(
            "AGGREGATE COUNT(*) AS total_qualified_count "
                + "OVER (SELECT * FROM Candidate WHERE qualified = true)")
        .setAllowLiteral(true)
        .build();
    // Creating an aggregation query to get the count of all qualified candidates
    AggregationQuery qualifiedCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(qualifiedCandidates)
        .build();

    // Executing aggregation query
    AggregationResult qualifiedCandidatesCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(qualifiedCandidatesCountQuery));

    System.out.printf("Total qualified candidates count is %d",
        qualifiedCandidatesCountQueryResult.get("total_qualified_count")); // 2

    // [END datastore_count_aggregation_query_gql]
  }

  public void aggregationQueryAndCountAggregationWithStaleRead() throws InterruptedException {
    // [START datastore_count_aggregation_query_stale_read]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Candidate";

    Key candidate1Key = datastore.newKeyFactory().setKind(kind).newKey("candidate1");
    Key candidate2Key = datastore.newKeyFactory().setKind(kind).newKey("candidate2");

    // Saving only two candidates
    datastore.put(
        Entity.newBuilder(candidate1Key).set("qualified", true).build(),
        Entity.newBuilder(candidate2Key).set("qualified", false).build()
    );
    Thread.sleep(1000);
    final Timestamp pastTimestamp =
        Timestamp.now(); // we have two candidates in database at this time.

    Thread.sleep(1000);
    // Saving third candidates
    Key candidate3Key = datastore.newKeyFactory().setKind(kind).newKey("candidate3");
    datastore.put(Entity.newBuilder(candidate3Key).set("qualified", false).build());

    EntityQuery selectAllCandidates = Query.newEntityQueryBuilder()
        .setKind(kind)
        .build();

    // Creating an aggregation query to get the count of all candidates
    AggregationQuery allCandidatesCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllCandidates)
        .addAggregation(Aggregation.count().as("total_count"))
        .build();

    // Executing aggregation query
    AggregationResult candidatesCountLatest = Iterables.getOnlyElement(
        datastore.runAggregation(allCandidatesCountQuery));
    System.out.printf("Latest candidates count is %d",
        candidatesCountLatest.get("total_count")); // 3

    // Executing aggregation query with past timestamp
    AggregationResult candidatesCountInPast = Iterables.getOnlyElement(
        datastore.runAggregation(allCandidatesCountQuery, ReadOption.readTime(pastTimestamp)));
    System.out.printf("Stale candidates count is %d",
        candidatesCountInPast.get("total_count")); // 2

    // [END datastore_count_aggregation_query_stale_read]
  }

  public void aggregationQueryInTransaction() {
    // [START datastore_count_aggregation_query_in_transaction]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Operations";

    Key operation1Key = datastore.newKeyFactory().setKind(kind).newKey("operation1");
    Key operation2Key = datastore.newKeyFactory().setKind(kind).newKey("operation2");

    // Save all the candidates
    datastore.put(
        Entity.newBuilder(operation1Key).set("owner", "john").build(),
        Entity.newBuilder(operation2Key).set("owner", "john").build()
    );

    // Using transactions to maintain consistent application state.
    datastore.runInTransaction((TransactionCallable<Void>) transaction -> {
      EntityQuery operationsOfJohn = Query.newEntityQueryBuilder()
          .setKind(kind)
          .setFilter(PropertyFilter.eq("owner", "john"))
          .build();
      AggregationQuery totalOperationsQuery = Query.newAggregationQueryBuilder()
          .over(operationsOfJohn)
          .addAggregation(Aggregation.count().as("operations_count"))
          .build();

      Long operationsCount = Iterables.getOnlyElement(
          datastore.runAggregation(totalOperationsQuery)).get("operations_count");

      if (operationsCount < 2) {
        Key newOperationKey = datastore.newKeyFactory().setKind(kind).newKey("operation3");
        Entity newOperation = Entity.newBuilder(newOperationKey).set("owner", "john").build();
        transaction.put(newOperation);
      } else {
        System.out.printf("Found existing %d operations, rolling back", operationsCount);
        throw new Exception("User 'John' cannot have more than 2 operations");
      }
      return null;
    });
    // [END datastore_count_aggregation_query_in_transaction]
  }

}
