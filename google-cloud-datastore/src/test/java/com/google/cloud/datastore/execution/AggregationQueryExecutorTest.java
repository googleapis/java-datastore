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
package com.google.cloud.datastore.execution;

import static com.google.cloud.datastore.ProtoTestData.intValue;
import static com.google.cloud.datastore.StructuredQuery.PropertyFilter.eq;
import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static java.util.Arrays.asList;
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.AggregationResult;
import com.google.cloud.datastore.AggregationResults;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.EntityQuery;
import com.google.cloud.datastore.LongValue;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.common.collect.ImmutableMap;
import com.google.datastore.v1.AggregationResultBatch;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.Value;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class AggregationQueryExecutorTest {

  private static final String KIND = "Task";
  private static final String NAMESPACE = "ns";

  private DatastoreRpc mockRpc;
  private AggregationQueryExecutor queryExecutor;
  private DatastoreOptions datastoreOptions;

  @Before
  public void setUp() throws Exception {
    mockRpc = EasyMock.createStrictMock(DatastoreRpc.class);
    datastoreOptions = DatastoreOptions.newBuilder().setNamespace(NAMESPACE).build();
    queryExecutor = new AggregationQueryExecutor(mockRpc, datastoreOptions);
  }

  @Test
  public void shouldExecuteAggregationQuery() {
    EntityQuery nestedQuery = Query.newEntityQueryBuilder()
        .setNamespace(NAMESPACE)
        .setKind(KIND)
        .setFilter(eq("done", true))
        .build();

    AggregationQuery aggregationQuery = Query.newAggregationQueryBuilder()
        .setNamespace(NAMESPACE)
        .addAggregation(count().as("total"))
        .over(nestedQuery)
        .build();

    expect(mockRpc.runAggregationQuery(anyObject(RunAggregationQueryRequest.class))).andReturn(dummyAggregationQueryResponse());

    replay(mockRpc);

    AggregationResults aggregationResults = queryExecutor.execute(aggregationQuery);

    verify(mockRpc);
    assertThat(aggregationResults, equalTo(new AggregationResults(asList(
        new AggregationResult(ImmutableMap.of("count", LongValue.of(209), "count_upto_100", LongValue.of(100))),
        new AggregationResult(ImmutableMap.of("count", LongValue.of(509), "count_upto_100", LongValue.of(100)))
    ))));
  }

  private RunAggregationQueryResponse dummyAggregationQueryResponse() {
    Map<String, Value> result1 = new HashMap<String, Value>() {{
      put("count", intValue(209));
      put("count_upto_100", intValue(100));
    }};

    Map<String, Value> result2 = new HashMap<String, Value>() {{
      put("count", intValue(509));
      put("count_upto_100", intValue(100));
    }};

    AggregationResultBatch resultBatch = AggregationResultBatch.newBuilder()
        .addAggregationResults(com.google.datastore.v1.AggregationResult.newBuilder()
            .putAllAggregateProperties(result1).build())
        .addAggregationResults(com.google.datastore.v1.AggregationResult.newBuilder()
            .putAllAggregateProperties(result2).build())
        .build();
    return RunAggregationQueryResponse.newBuilder()
        .setBatch(resultBatch)
        .build();
  }
}