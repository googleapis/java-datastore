package com.example.datastore.aggregation;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Datastore.TransactionCallable;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.common.collect.Iterables;

public class CountAggregationInTransaction {

  public static void invoke() {
    // [START datastore_count_aggregation_query_in_transaction]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Task";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");

    // Save all the tasks
    datastore.put(
        Entity.newBuilder(task1Key).set("owner", "john").build(),
        Entity.newBuilder(task2Key).set("owner", "john").build());

    // Using transactions to maintain consistent application state.
    datastore.runInTransaction(
        (TransactionCallable<Void>)
            transaction -> {
              EntityQuery tasksOfJohn =
                  Query.newEntityQueryBuilder()
                      .setKind(kind)
                      .setFilter(PropertyFilter.eq("owner", "john"))
                      .build();
              AggregationQuery totalTasksQuery =
                  Query.newAggregationQueryBuilder()
                      .over(tasksOfJohn)
                      .addAggregation(Aggregation.count().as("tasks_count"))
                      .build();

              Long tasksCount =
                  Iterables.getOnlyElement(datastore.runAggregation(totalTasksQuery))
                      .get("tasks_count");

              if (tasksCount < 2) {
                Key newTaskKey = datastore.newKeyFactory().setKind(kind).newKey("task3");
                Entity newTask = Entity.newBuilder(newTaskKey).set("owner", "john").build();
                transaction.put(newTask);
              } else {
                System.out.printf("Found existing %d tasks, rolling back", tasksCount);
                throw new Exception("User 'John' cannot have more than 2 tasks");
              }
              return null;
            });
    // [END datastore_count_aggregation_query_in_transaction]

  }
}
