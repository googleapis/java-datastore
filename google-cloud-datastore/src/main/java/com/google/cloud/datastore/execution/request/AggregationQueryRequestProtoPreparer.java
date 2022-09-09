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

import com.google.cloud.datastore.AggregationQuery;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQueryProtoPreparer;
import com.google.cloud.datastore.aggregation.Aggregation;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.RunAggregationQueryRequest;

public class AggregationQueryRequestProtoPreparer implements
    ProtoPreparer<AggregationQuery, RunAggregationQueryRequest> {

  private final DatastoreOptions datastoreOptions;
  private final StructuredQueryProtoPreparer structuredQueryProtoPreparer;

  public AggregationQueryRequestProtoPreparer(DatastoreOptions datastoreOptions) {
    this.datastoreOptions = datastoreOptions;
    this.structuredQueryProtoPreparer = new StructuredQueryProtoPreparer();
  }

  @Override
  public RunAggregationQueryRequest prepare(AggregationQuery aggregationQuery) {
    PartitionId partitionId = getPartitionId(aggregationQuery);
    com.google.datastore.v1.AggregationQuery aggregationQueryProtoBuilder = getAggregationQuery(aggregationQuery);

    return RunAggregationQueryRequest.newBuilder()
        .setPartitionId(partitionId)
        .setProjectId(datastoreOptions.getProjectId())
        .setAggregationQuery(aggregationQueryProtoBuilder)
        .build();
  }

  private com.google.datastore.v1.AggregationQuery getAggregationQuery(AggregationQuery aggregationQuery) {
    Query nestedQueryProto = structuredQueryProtoPreparer.prepare(
        (StructuredQuery<?>) aggregationQuery.getNestedQuery());

    com.google.datastore.v1.AggregationQuery.Builder aggregationQueryProtoBuilder = com.google.datastore.v1.AggregationQuery.newBuilder()
        .setNestedQuery(nestedQueryProto);
    for (Aggregation aggregation : aggregationQuery.getAggregations()) {
      aggregationQueryProtoBuilder.addAggregations(aggregation.toPb());
    }
    return aggregationQueryProtoBuilder.build();
  }

  private PartitionId getPartitionId(AggregationQuery aggregationQuery) {
    return PartitionId.newBuilder()
        .setProjectId(datastoreOptions.getProjectId())
        .setNamespaceId(aggregationQuery.getNamespace())
        .build();
  }
}
