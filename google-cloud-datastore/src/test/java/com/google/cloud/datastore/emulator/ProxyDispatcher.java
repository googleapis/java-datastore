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
package com.google.cloud.datastore.emulator;

import static com.google.cloud.datastore.ProtoTestData.intValue;

import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.datastore.v1.AggregationQuery.Aggregation;
import com.google.datastore.v1.AggregationQuery.Aggregation.Count;
import com.google.datastore.v1.AggregationResult;
import com.google.datastore.v1.AggregationResultBatch;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.datastore.v1.Value;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

public class ProxyDispatcher extends Dispatcher {

  private final DatastoreRpc datastoreRpc;

  public ProxyDispatcher(DatastoreRpc datastoreRpc) {
    this.datastoreRpc = datastoreRpc;
  }

  @NotNull
  @Override
  public MockResponse dispatch(@NotNull RecordedRequest recordedRequest) {
    String methodName = recordedRequest.getPath().split(":")[1];
    if (!"runAggregationQuery".equals(methodName)) {
      throw new IllegalStateException(
          String.format("Proxy only supports RunAggregationQuery method, Found %s method.",
              methodName));
    }

    try {
      RunAggregationQueryRequest runAggregationQueryRequest = RunAggregationQueryRequest.parseFrom(
          recordedRequest.getBody().inputStream());

      RunQueryRequest runQueryRequest = getRunQueryRequest(runAggregationQueryRequest);
      RunQueryResponse runQueryResponse = this.datastoreRpc.runQuery(runQueryRequest);

      RunAggregationQueryResponse runAggregationQueryResponse = getRunAggregationQueryResponse(
          runAggregationQueryRequest, runQueryResponse);
      Buffer buffer = new Buffer();
      runAggregationQueryResponse.writeTo(buffer.outputStream());
      return new MockResponse().setBody(buffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new MockResponse();
  }

  @NotNull
  private RunAggregationQueryResponse getRunAggregationQueryResponse(
      RunAggregationQueryRequest runAggregationQueryRequest, RunQueryResponse runQueryResponse) {
    AggregationResult aggregationResult = AggregationResult.newBuilder()
        .putAllAggregateProperties(getProperties(
            runAggregationQueryRequest.getAggregationQuery().getAggregationsList(),
            runQueryResponse))
        .build();
    return RunAggregationQueryResponse.newBuilder()
        .setBatch(
            AggregationResultBatch.newBuilder().addAggregationResults(aggregationResult).build())
        .build();
  }

  @NotNull
  private RunQueryRequest getRunQueryRequest(RunAggregationQueryRequest runAggregationQueryRequest) {
    Query nestedQuery = runAggregationQueryRequest.getAggregationQuery().getNestedQuery();
    RunQueryRequest.Builder builder = RunQueryRequest.newBuilder().setQuery(nestedQuery);
    if (runAggregationQueryRequest.hasReadOptions()) {
      builder.setReadOptions(runAggregationQueryRequest.getReadOptions());
    }
    return builder.build();
  }

  private Map<String, Value> getProperties(List<Aggregation> aggregationsList,
      RunQueryResponse runQueryResponse) {
    HashMap<String, Value> map = new HashMap<>();
    for (Aggregation aggregation : aggregationsList) {
      map.put(aggregation.getAlias(), getValue(runQueryResponse, aggregation.getCount()));
    }
    return map;
  }

  private Value getValue(RunQueryResponse runQueryResponse, Count count) {
    int totalEntityCount = runQueryResponse.getBatch().getEntityResultsCount();
    if (count.hasUpTo()) {
      return intValue(Math.min(count.getUpTo().getValue(), totalEntityCount));
    } else {
      return intValue(totalEntityCount);
    }
  }
}
