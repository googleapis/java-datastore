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
    String kind = "Task";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");
    Key task3Key = datastore.newKeyFactory().setKind(kind).newKey("task3");

    // Save all the tasks
    datastore.put(
        Entity.newBuilder(task1Key).set("done", true).build(),
        Entity.newBuilder(task2Key).set("done", false).build(),
        Entity.newBuilder(task3Key).set("done", true).build()
    );

    EntityQuery selectAllTasks = Query.newEntityQueryBuilder()
        .setKind(kind)
        .build();
    // Creating an aggregation query to get the count of all tasks
    AggregationQuery allTasksCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllTasks)
        .addAggregation(Aggregation.count())
        .addAggregation(Aggregation.count().as("total_count"))
        .build();
    // Executing aggregation query
    AggregationResult allTasksCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allTasksCountQuery));

    System.out.printf("Total tasks count is %d",
        allTasksCountQueryResult.get("total_count")); // 3
    System.out.printf("Total tasks (accessible from default alias) is %d",
        allTasksCountQueryResult.get("property_1")); // 3

    // [END datastore_count_aggregation_query_on_kind]
  }

  public void aggregationQueryAndCountAggregationWithLimit() {
    // [START datastore_count_aggregation_query_with_limit]

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
        Entity.newBuilder(task3Key).set("done", true).build()
    );

    EntityQuery selectAllTasks = Query.newEntityQueryBuilder()
        .setKind(kind)
        .setLimit(2)
        .build();
    // Creating an aggregation query to get the count of all tasks
    AggregationQuery allTasksCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllTasks)
        .addAggregation(Aggregation.count().as("at_least"))
        .build();
    // Executing aggregation query
    AggregationResult limitQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allTasksCountQuery));

    System.out.printf("We have at least %d tasks", limitQueryResult.get("at_least")); // 2

    // [END datastore_count_aggregation_query_with_limit]
  }

  public void aggregationQueryAndCountAggregationWithOrderBy() {
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
        Entity.newBuilder(task2Key).set("done", false).build(),  // no priority specified
        Entity.newBuilder(task3Key).set("done", true).set("priority", 2).build()
    );

    EntityQuery selectAllTasks = Query.newEntityQueryBuilder()
        .setKind(kind)
        .addOrderBy(OrderBy.asc("priority"))    // OrderBy acts as an existence filter
        .build();
    // Creating an aggregation query to get the count of all tasks
    AggregationQuery allTasksCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllTasks)
        .addAggregation(Aggregation.count().as("count"))
        .build();
    // Executing aggregation query
    AggregationResult limitQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allTasksCountQuery));

    System.out.printf("Total %d tasks found with priority field",
        limitQueryResult.get("count")); // 2

    // [END datastore_count_aggregation_query_with_order_by]
  }

  public void aggregationQueryAndCountAggregationWithPropertyFilter() {
    // [START datastore_count_aggregation_query_with_filters]

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
        Entity.newBuilder(task3Key).set("done", true).build()
    );

    EntityQuery completedTasks = Query.newEntityQueryBuilder()
        .setKind(kind)
        .setFilter(PropertyFilter.eq("done", true))
        .build();
    EntityQuery remainingTasks = Query.newEntityQueryBuilder()
        .setKind(kind)
        .setFilter(PropertyFilter.eq("done", false))
        .build();
    // Creating an aggregation query to get the count of all completed tasks
    AggregationQuery completedTasksCountQuery = Query.newAggregationQueryBuilder()
        .over(completedTasks)
        .addAggregation(Aggregation.count().as("total_completed_count"))
        .build();
    // Creating an aggregation query to get the count of all remaining tasks
    AggregationQuery remainingTasksCountQuery = Query.newAggregationQueryBuilder()
        .over(remainingTasks)
        .addAggregation(Aggregation.count().as("total_remaining_count"))
        .build();

    // Executing aggregation query
    AggregationResult completedTasksCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(completedTasksCountQuery));
    AggregationResult remainingTasksCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(remainingTasksCountQuery));

    System.out.printf("Total completed tasks count is %d",
        completedTasksCountQueryResult.get("total_completed_count")); // 2
    System.out.printf("Total remaining tasks count is %d",
        remainingTasksCountQueryResult.get("total_remaining_count")); // 1

    // [END datastore_count_aggregation_query_with_filters]
  }

  public void aggregationQueryAndCountAggregationWithGqlQuery() {
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
        Entity.newBuilder(task3Key).set("done", true).build()
    );

    GqlQuery<?> selectAllTasks = Query.newGqlQueryBuilder(
            "AGGREGATE COUNT(*) AS total_count, COUNT_UP_TO(2) AS count_with_limit "
                + "OVER (SELECT * FROM Task)")
        .setAllowLiteral(true)
        .build();
    // Creating an aggregation query to get the count of all tasks
    AggregationQuery allTasksCountQuery = Query.newAggregationQueryBuilder()
        .over(selectAllTasks)
        .build();
    // Executing aggregation query
    AggregationResult allTasksCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(allTasksCountQuery));

    System.out.printf("We have at least %d tasks",
        allTasksCountQueryResult.get("count_with_limit")); // 2
    System.out.printf("Total tasks count is %d",
        allTasksCountQueryResult.get("total_count")); // 3

    GqlQuery<?> completedTasks = Query.newGqlQueryBuilder(
            "AGGREGATE COUNT(*) AS total_completed_count "
                + "OVER (SELECT * FROM Task WHERE done = true)")
        .setAllowLiteral(true)
        .build();
    // Creating an aggregation query to get the count of all completed tasks
    AggregationQuery completedTasksCountQuery = Query.newAggregationQueryBuilder()
        .over(completedTasks)
        .build();

    // Executing aggregation query
    AggregationResult completedTasksCountQueryResult = Iterables.getOnlyElement(
        datastore.runAggregation(completedTasksCountQuery));

    System.out.printf("Total completed tasks count is %d",
        completedTasksCountQueryResult.get("total_completed_count")); // 2

    // [END datastore_count_aggregation_query_gql]
  }

  public void aggregationQueryAndCountAggregationWithStaleRead() throws InterruptedException {
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

  public void aggregationQueryInTransaction() {
    // [START datastore_count_aggregation_query_in_transaction]

    // Instantiates a client
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    // The kind for the new entity
    String kind = "Tasks";

    Key task1Key = datastore.newKeyFactory().setKind(kind).newKey("task1");
    Key task2Key = datastore.newKeyFactory().setKind(kind).newKey("task2");

    // Save all the tasks
    datastore.put(
        Entity.newBuilder(task1Key).set("owner", "john").build(),
        Entity.newBuilder(task2Key).set("owner", "john").build()
    );

    // Using transactions to maintain consistent application state.
    datastore.runInTransaction((TransactionCallable<Void>) transaction -> {
      EntityQuery tasksOfJohn = Query.newEntityQueryBuilder()
          .setKind(kind)
          .setFilter(PropertyFilter.eq("owner", "john"))
          .build();
      AggregationQuery totalTasksQuery = Query.newAggregationQueryBuilder()
          .over(tasksOfJohn)
          .addAggregation(Aggregation.count().as("tasks_count"))
          .build();

      Long tasksCount = Iterables.getOnlyElement(
          datastore.runAggregation(totalTasksQuery)).get("tasks_count");

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
