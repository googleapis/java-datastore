package com.example.datastore.aggregation;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.GqlQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.common.collect.Iterables;

public class CountAggregationWithGqlQuery {

  public static void invoke() {
    // [START datastore_count_aggregation_query_gql]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Task";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");
    Key task3Key = datastore.newKeyFactory().setKind(kind).newKey("task3");

    // Save all the tasks
    datastore.put(
        Entity.newBuilder(task1Key).set("done", true).build(),
        Entity.newBuilder(task2Key).set("done", false).build(),
        Entity.newBuilder(task3Key).set("done", true).build());

    GqlQuery<?> selectAllTasks =
        Query.newGqlQueryBuilder(
                "AGGREGATE COUNT(*) AS total_count, COUNT_UP_TO(2) AS count_with_limit "
                    + "OVER (SELECT * FROM Task)")
            .setAllowLiteral(true)
            .build();
    // Creating an aggregation query to get the count of all tasks
    AggregationQuery allTasksCountQuery =
        Query.newAggregationQueryBuilder().over(selectAllTasks).build();
    // Executing aggregation query
    AggregationResult allTasksCountQueryResult =
        Iterables.getOnlyElement(datastore.runAggregation(allTasksCountQuery));

    System.out.printf(
        "We have at least %d tasks", allTasksCountQueryResult.get("count_with_limit")); // 2
    System.out.printf("Total tasks count is %d", allTasksCountQueryResult.get("total_count")); // 3

    GqlQuery<?> completedTasks =
        Query.newGqlQueryBuilder(
                "AGGREGATE COUNT(*) AS total_completed_count "
                    + "OVER (SELECT * FROM Task WHERE done = true)")
            .setAllowLiteral(true)
            .build();
    // Creating an aggregation query to get the count of all completed tasks
    AggregationQuery completedTasksCountQuery =
        Query.newAggregationQueryBuilder().over(completedTasks).build();

    // Executing aggregation query
    AggregationResult completedTasksCountQueryResult =
        Iterables.getOnlyElement(datastore.runAggregation(completedTasksCountQuery));

    System.out.printf(
        "Total completed tasks count is %d",
        completedTasksCountQueryResult.get("total_completed_count")); // 2

    // [END datastore_count_aggregation_query_gql]
  }
}
