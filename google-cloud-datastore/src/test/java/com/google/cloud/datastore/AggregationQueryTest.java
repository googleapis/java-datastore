/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore;

import static com.google.cloud.datastore.AggregationQuery.Mode.GQL;
import static com.google.cloud.datastore.AggregationQuery.Mode.STRUCTURED;
import static com.google.cloud.datastore.StructuredQuery.PropertyFilter.eq;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.datastore.aggregation.CountAggregation;
import com.google.common.collect.ImmutableSet;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.rules.ExpectedException;

public class AggregationQueryTest {

  private static final String KIND = "Task";
  private static final String NAMESPACE = "ns";
  private static final EntityQuery COMPLETED_TASK_QUERY = Query.newEntityQueryBuilder()
      .setNamespace(NAMESPACE)
      .setKind(KIND)
      .setFilter(eq("done", true))
      .build();

  @Rule
  public ExpectedException exceptionRule = ExpectedException.none();

  @Test
  public void testAggregations() {
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .setNamespace(NAMESPACE)
        .addAggregation(new CountAggregation("total_upto_100", 100))
        .over(COMPLETED_TASK_QUERY)
        .build();

    assertThat(aggregationQuery.getNamespace(), equalTo(NAMESPACE));
    assertThat(aggregationQuery.getAggregations(), equalTo(
        ImmutableSet.of(count().limit(100).as("total_upto_100").build())));
    assertThat(aggregationQuery.getNestedStructuredQuery(), equalTo(COMPLETED_TASK_QUERY));
    assertThat(aggregationQuery.getMode(), equalTo(STRUCTURED));
  }


  @Test
  public void testAggregationBuilder() {
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .setNamespace(NAMESPACE)
        .addAggregation(count().as("total"))
        .addAggregation(count().limit(100).as("total_upto_100"))
        .over(COMPLETED_TASK_QUERY)
        .build();

    assertThat(aggregationQuery.getNamespace(), equalTo(NAMESPACE));
    assertThat(aggregationQuery.getAggregations(), equalTo(ImmutableSet.of(
        count().as("total").build(),
        count().limit(100).as("total_upto_100").build()
    )));
    assertThat(aggregationQuery.getNestedStructuredQuery(), equalTo(COMPLETED_TASK_QUERY));
    assertThat(aggregationQuery.getMode(), equalTo(STRUCTURED));
  }

  @Test
  public void testAggregationBuilderWithDuplicateAggregations() {
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .setNamespace(NAMESPACE)
        .addAggregation(count().limit(100).as("total_upto_100"))
        .addAggregation(count().limit(100).as("total_upto_100"))
        .over(COMPLETED_TASK_QUERY)
        .build();

    assertThat(aggregationQuery.getNamespace(), equalTo(NAMESPACE));
    assertThat(aggregationQuery.getAggregations(), equalTo(ImmutableSet.of(
        count().limit(100).as("total_upto_100").build()
    )));
    assertThat(aggregationQuery.getNestedStructuredQuery(), equalTo(COMPLETED_TASK_QUERY));
    assertThat(aggregationQuery.getMode(), equalTo(STRUCTURED));
  }

  @Test
  public void testAggregationQueryBuilderWithoutNamespace() {
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .addAggregation(count().as("total"))
        .over(COMPLETED_TASK_QUERY)
        .build();

    assertNull(aggregationQuery.getNamespace());
    assertThat(aggregationQuery.getAggregations(), equalTo(ImmutableSet.of(
        count().as("total").build()
    )));
    assertThat(aggregationQuery.getNestedStructuredQuery(), equalTo(COMPLETED_TASK_QUERY));
    assertThat(aggregationQuery.getMode(), equalTo(STRUCTURED));
  }

  @Test
  public void testAggregationQueryBuilderWithoutNestedQuery() {
    assertThrows("Nested query is required for an aggregation query to run",
        IllegalArgumentException.class,
        () -> Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .addAggregation(count().as("total"))
            .build());
  }

  @Test
  public void testAggregationQueryBuilderWithoutAggregation() {
    assertThrows("At least one aggregation is required for an aggregation query to run",
        IllegalArgumentException.class,
        () -> Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .over(COMPLETED_TASK_QUERY)
            .build());
  }

  @Test
  public void testAggregationQueryBuilderWithGqlQuery() {
    GqlQuery<?> gqlQuery = Query.newGqlQueryBuilder("SELECT * FROM Task WHERE done = true").build();

    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .setNamespace(NAMESPACE)
        .over(gqlQuery)
        .build();

    assertThat(aggregationQuery.getNestedGqlQuery(), equalTo(gqlQuery));
    assertThat(aggregationQuery.getMode(), equalTo(GQL));
  }

  @Test
  public void testAggregationQueryBuilderWithoutProvidingAnyNestedQuery() {
    assertThrows("Nested query is required for an aggregation query to run",
        IllegalArgumentException.class,
        () -> Query.newAggregationQueryBuilder()
            .setNamespace(NAMESPACE)
            .build());
  }
}