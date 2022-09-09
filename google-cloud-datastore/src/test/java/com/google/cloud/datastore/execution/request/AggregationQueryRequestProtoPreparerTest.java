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
package com.google.cloud.datastore.execution.request;

import static com.google.cloud.datastore.ProtoTestData.booleanValue;
import static com.google.cloud.datastore.ProtoTestData.countAggregation;
import static com.google.cloud.datastore.ProtoTestData.kind;
import static com.google.cloud.datastore.ProtoTestData.propertyFilter;
import static com.google.cloud.datastore.StructuredQuery.PropertyFilter.eq;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.datastore.v1.PropertyFilter.Operator.EQUAL;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.ProtoTestData;
import com.google.cloud.datastore.Query;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.Value;
import java.util.Arrays;
import org.junit.Test;

public class AggregationQueryRequestProtoPreparerTest {

  private static final String KIND = "Task";
  private static final String NAMESPACE = "ns";
  private static final String PROJECT_ID = "project-id";
  private static final DatastoreOptions DATASTORE_OPTIONS = DatastoreOptions.newBuilder()
      .setProjectId(PROJECT_ID)
      .setNamespace(NAMESPACE)
      .build();
  private static final EntityQuery COMPLETED_TASK_QUERY = Query.newEntityQueryBuilder()
      .setNamespace(NAMESPACE).setKind(KIND).setFilter(eq("done", true)).build();

  private final AggregationQueryRequestProtoPreparer protoPreparer = new AggregationQueryRequestProtoPreparer(
      DATASTORE_OPTIONS);

  @Test
  public void shouldPrepareAggregationQueryRequestWithGivenStructuredQuery() {
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .setNamespace(NAMESPACE)
        .addAggregation(count().as("total"))
        .addAggregation(count().limit(100).as("total_upto_100"))
        .over(COMPLETED_TASK_QUERY)
        .build();

    RunAggregationQueryRequest runAggregationQueryRequest = protoPreparer.prepare(aggregationQuery);

    assertThat(runAggregationQueryRequest.getProjectId(), equalTo(PROJECT_ID));

    assertThat(runAggregationQueryRequest.getPartitionId().getProjectId(), equalTo(PROJECT_ID));
    assertThat(runAggregationQueryRequest.getPartitionId().getNamespaceId(), equalTo(NAMESPACE));

    com.google.datastore.v1.AggregationQuery aggregationQueryProto = runAggregationQueryRequest.getAggregationQuery();
    assertThat(aggregationQueryProto.getNestedQuery(),
        equalTo(com.google.datastore.v1.Query.newBuilder()
            .addKind(kind(KIND))
            .setFilter(propertyFilter("done", EQUAL, booleanValue(true)))
            .build()));
    assertThat(aggregationQueryProto.getAggregationsList(), equalTo(asList(
        countAggregation("total"),
        countAggregation("total_upto_100", 100)
    )));
  }
}