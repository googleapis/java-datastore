package com.example.datastore.aggregation;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.common.collect.Iterables;

public class CountAggregationWithStaleRead {

  public static void invoke() throws InterruptedException {
    // [START datastore_count_aggregation_query_stale_read]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Task";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");

    // Saving only two tasks
    datastore.put(
        Entity.newBuilder(task1Key).set("done", true).build(),
        Entity.newBuilder(task2Key).set("done", false).build()
    );
    Thread.sleep(1000);
    final Timestamp pastTimestamp =
        Timestamp.now(); // we have two tasks in database at this time.

    Thread.sleep(1000);
    // Saving third tasks
    Key task3Key = datastore.newKeyFactory().setKind(kind).newKey("task3");
    datastore.put(Entity.newBuilder(task3Key).set("done", false).build());

    EntityQuery selectAllTasks = Query.newEntityQueryBuilder()
        .setKind(kind)
        .build();

    // Creating an aggregation query to get the count of all tasks
    AggregationQuery allTasksCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllTasks)
        .addAggregation(Aggregation.count().as("total_count"))
        .build();

    // Executing aggregation query
    AggregationResult tasksCountLatest = Iterables.getOnlyElement(
        datastore.runAggregation(allTasksCountQuery));
    System.out.printf("Latest tasks count is %d",
        tasksCountLatest.get("total_count")); // 3

    // Executing aggregation query with past timestamp
    AggregationResult tasksCountInPast = Iterables.getOnlyElement(
        datastore.runAggregation(allTasksCountQuery, ReadOption.readTime(pastTimestamp)));
    System.out.printf("Stale tasks count is %d",
        tasksCountInPast.get("total_count")); // 2

    // [END datastore_count_aggregation_query_stale_read]
  }

}
