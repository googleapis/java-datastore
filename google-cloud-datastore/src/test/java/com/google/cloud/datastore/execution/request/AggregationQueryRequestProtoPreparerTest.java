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

import static com.google.cloud.datastore.StructuredQuery.PropertyFilter.eq;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.Query;
import com.google.datastore.v1.RunAggregationQueryRequest;
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

  private ProtoPreparer<AggregationQuery, RunAggregationQueryRequest> protoPreparer = new AggregationQueryRequestProtoPreparer(DATASTORE_OPTIONS);

  @Test
  public void shouldPrepareAggregationQueryRequestWithGivenStructuredQuery() {
    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .setNamespace(NAMESPACE)
        .addAggregation(count().as("total"))
        .over(COMPLETED_TASK_QUERY)
        .build();

    RunAggregationQueryRequest runAggregationQueryRequest = protoPreparer.prepare(aggregationQuery);

    assertThat(runAggregationQueryRequest.getProjectId(), equalTo(PROJECT_ID));

    assertThat(runAggregationQueryRequest.getPartitionId().getProjectId(), equalTo(PROJECT_ID));
    assertThat(runAggregationQueryRequest.getPartitionId().getNamespaceId(), equalTo(NAMESPACE));


    //TODO verify the complete aggregation query
    assertThat(runAggregationQueryRequest.getAggregationQuery(), equalTo(com.google.datastore.v1.AggregationQuery.newBuilder().build()));

  }
}