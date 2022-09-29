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
import static com.google.cloud.datastore.ProtoTestData.gqlQueryParameter;
import static com.google.cloud.datastore.ProtoTestData.intValue;
import static com.google.cloud.datastore.ProtoTestData.kind;
import static com.google.cloud.datastore.ProtoTestData.propertyFilter;
import static com.google.cloud.datastore.ProtoTestData.stringValue;
import static com.google.cloud.datastore.ReadOption.eventualConsistency;
import static com.google.cloud.datastore.StructuredQuery.PropertyFilter.eq;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.datastore.v1.PropertyFilter.Operator.EQUAL;
import static com.google.datastore.v1.ReadOptions.ReadConsistency.EVENTUAL;
import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

import com.google.cloud.Timestamp;
import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.GqlQuery;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.ReadOption;
import com.google.cloud.datastore.ReadOption.EventualConsistency;
import com.google.cloud.datastore.ReadOption.QueryAndReadOptions;
import com.google.datastore.v1.GqlQueryParameter;
import com.google.datastore.v1.RunAggregationQueryRequest;
import java.util.HashMap;
import org.junit.Test;

public class AggregationQueryRequestProtoPreparerTest {

  private static final String KIND = "Task";
  private static final String NAMESPACE = "ns";
  private static final String PROJECT_ID = "project-id";
  private static final DatastoreOptions DATASTORE_OPTIONS = DatastoreOptions.newBuilder()
      .setProjectId(PROJECT_ID)
      .setNamespace(NAMESPACE)
      .build();
  private static final EntityQuery COMPLETED_TASK_STRUCTURED_QUERY = Query.newEntityQueryBuilder()
      .setNamespace(NAMESPACE).setKind(KIND).setFilter(eq("done", true)).build();

  private static final GqlQuery<?> COMPLETED_TASK_GQL_QUERY = Query.newGqlQueryBuilder(
          "AGGREGATE COUNT AS total_characters OVER ("
              + "SELECT * FROM Character WHERE name = @name and age > @1"
              + ")")
      .setBinding("name", "John Doe")
      .addBinding(27)
      .build();

  private final AggregationQuery AGGREGATION_OVER_STRUCTURED_QUERY = Query.newAggregationQueryBuilder()
      .setNamespace(NAMESPACE)
      .addAggregation(count().as("total"))
      .over(COMPLETED_TASK_STRUCTURED_QUERY)
      .build();

  private final AggregationQuery AGGREGATION_OVER_GQL_QUERY = Query.newAggregationQueryBuilder()
      .setNamespace(NAMESPACE)
      .over(COMPLETED_TASK_GQL_QUERY)
      .build();


  private final AggregationQueryRequestProtoPreparer protoPreparer = new AggregationQueryRequestProtoPreparer(
      DATASTORE_OPTIONS);

  @Test
  public void shouldPrepareAggregationQueryRequestWithGivenStructuredQuery() {
    RunAggregationQueryRequest runAggregationQueryRequest = protoPreparer.prepare(
        QueryAndReadOptions.create(AGGREGATION_OVER_STRUCTURED_QUERY));

    assertThat(runAggregationQueryRequest.getProjectId(), equalTo(PROJECT_ID));

    assertThat(runAggregationQueryRequest.getPartitionId().getProjectId(), equalTo(PROJECT_ID));
    assertThat(runAggregationQueryRequest.getPartitionId().getNamespaceId(), equalTo(NAMESPACE));

    com.google.datastore.v1.AggregationQuery aggregationQueryProto = runAggregationQueryRequest.getAggregationQuery();
    assertThat(aggregationQueryProto.getNestedQuery(),
        equalTo(com.google.datastore.v1.Query.newBuilder()
            .addKind(kind(KIND))
            .setFilter(propertyFilter("done", EQUAL, booleanValue(true)))
            .build()));
    assertThat(aggregationQueryProto.getAggregationsList(),
        equalTo(singletonList(countAggregation("total"))));
  }

  @Test
  public void shouldPrepareAggregationQueryRequestWithGivenGqlQuery() {
    RunAggregationQueryRequest runAggregationQueryRequest = protoPreparer.prepare(
        QueryAndReadOptions.create(
            AGGREGATION_OVER_GQL_QUERY));

    assertThat(runAggregationQueryRequest.getProjectId(), equalTo(PROJECT_ID));

    assertThat(runAggregationQueryRequest.getPartitionId().getProjectId(), equalTo(PROJECT_ID));
    assertThat(runAggregationQueryRequest.getPartitionId().getNamespaceId(), equalTo(NAMESPACE));

    com.google.datastore.v1.GqlQuery gqlQueryProto = runAggregationQueryRequest.getGqlQuery();

    assertThat(gqlQueryProto.getQueryString(), equalTo(COMPLETED_TASK_GQL_QUERY.getQueryString()));
    assertThat(gqlQueryProto.getNamedBindingsMap(),
        equalTo(new HashMap<String, GqlQueryParameter>() {{
          put("name", gqlQueryParameter(stringValue("John Doe")));
        }}));
    assertThat(gqlQueryProto.getPositionalBindingsList(), equalTo(asList(
        gqlQueryParameter(intValue(27))
    )));
  }

  @Test
  public void shouldPrepareReadOptionsWithGivenStructuredQuery() {
    RunAggregationQueryRequest eventualConsistencyAggregationRequest = prepareQuery(
        AGGREGATION_OVER_STRUCTURED_QUERY, eventualConsistency());
    assertThat(eventualConsistencyAggregationRequest.getReadOptions().getReadConsistency(),
        equalTo(EVENTUAL));

    Timestamp now = Timestamp.now();
    RunAggregationQueryRequest readTimeAggregationRequest = prepareQuery(
        AGGREGATION_OVER_STRUCTURED_QUERY, ReadOption.readTime(now));
    assertThat(Timestamp.fromProto(readTimeAggregationRequest.getReadOptions().getReadTime()),
        equalTo(now));
  }

  @Test
  public void shouldPrepareReadOptionsWithGivenGqlQuery() {
    RunAggregationQueryRequest eventualConsistencyAggregationRequest = prepareQuery(
        AGGREGATION_OVER_GQL_QUERY, eventualConsistency());
    assertThat(eventualConsistencyAggregationRequest.getReadOptions().getReadConsistency(),
        equalTo(EVENTUAL));

    Timestamp now = Timestamp.now();
    RunAggregationQueryRequest readTimeAggregationRequest = prepareQuery(
        AGGREGATION_OVER_GQL_QUERY, ReadOption.readTime(now));
    assertThat(Timestamp.fromProto(readTimeAggregationRequest.getReadOptions().getReadTime()),
        equalTo(now));
  }

  @Test
  public void shouldPrepareAggregationQueryWithoutNamespace() {
    AggregationQuery structuredQueryWithoutNamespace = Query.newAggregationQueryBuilder()
        .addAggregation(count().as("total"))
        .over(COMPLETED_TASK_STRUCTURED_QUERY)
        .build();
    AggregationQuery gqlQueryWithoutNamespace = Query.newAggregationQueryBuilder()
        .over(COMPLETED_TASK_GQL_QUERY)
        .build();

    RunAggregationQueryRequest runAggregationQueryFromStructuredQuery = protoPreparer.prepare(
        QueryAndReadOptions.create(structuredQueryWithoutNamespace));
    RunAggregationQueryRequest runAggregationQueryFromGqlQuery = protoPreparer.prepare(
        QueryAndReadOptions.create(gqlQueryWithoutNamespace));

    assertThat(runAggregationQueryFromStructuredQuery.getPartitionId().getNamespaceId(), is(""));
    assertThat(runAggregationQueryFromGqlQuery.getPartitionId().getNamespaceId(), is(""));

  }

  private RunAggregationQueryRequest prepareQuery(AggregationQuery query, ReadOption readOption) {
    return protoPreparer.prepare(
        QueryAndReadOptions.create(query,
            singletonList(readOption)));
  }

}