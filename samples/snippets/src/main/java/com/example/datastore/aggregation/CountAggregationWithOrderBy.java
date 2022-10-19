package com.example.datastore.aggregation;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.common.collect.Iterables;

public class CountAggregationWithOrderBy {
  public static void invoke() {
    // [START datastore_count_aggregation_query_with_order_by]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Task";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");
    Key task3Key = datastore.newKeyFactory().setKind(kind).newKey("task3");

    // Save all the tasks
    datastore.put(
        Entity.newBuilder(task1Key).set("done", true).set("priority", 1).build(),
        Entity.newBuilder(task2Key).set("done", false).build(), // no priority specified
        Entity.newBuilder(task3Key).set("done", true).set("priority", 2).build());

    EntityQuery selectAllTasks =
        Query.newEntityQueryBuilder()
            .setKind(kind)
            .addOrderBy(OrderBy.asc("priority")) // OrderBy acts as an existence filter
            .build();
    // Creating an aggregation query to get the count of all tasks
    AggregationQuery allTasksCountQuery =
        Query.newAggregationQueryBuilder()
            .over(selectAllTasks)
            .addAggregation(Aggregation.count().as("count"))
            .build();
    // Executing aggregation query
    AggregationResult limitQueryResult =
        Iterables.getOnlyElement(datastore.runAggregation(allTasksCountQuery));

    System.out.printf(
        "Total %d tasks found with priority field", limitQueryResult.get("count")); // 2

    // [END datastore_count_aggregation_query_with_order_by]
  }
}
