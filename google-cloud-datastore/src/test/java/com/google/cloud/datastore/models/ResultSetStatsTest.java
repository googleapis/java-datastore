/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.datastore.models;

import com.google.cloud.Structs;
import com.google.common.truth.Truth;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import org.junit.Test;

public class ResultSetStatsTest {

  @Test
  public void testResultSetStatsModel() {
    Struct planInfoStruct =
        Struct.newBuilder()
            .putFields("indexes_used", Value.newBuilder().setStringValue("val").build())
            .build();
    com.google.datastore.v1.QueryPlan queryPlanProto =
        com.google.datastore.v1.QueryPlan.newBuilder().setPlanInfo(planInfoStruct).build();

    Struct statsProto =
        Struct.newBuilder()
            .putFields("bytes_returned", Value.newBuilder().setStringValue("bytes").build())
            .build();
    com.google.datastore.v1.ResultSetStats proto =
        com.google.datastore.v1.ResultSetStats.newBuilder()
            .setQueryStats(statsProto)
            .setQueryPlan(queryPlanProto)
            .build();
    ResultSetStats resultSetStats = new ResultSetStats(proto);

    Truth.assertThat(resultSetStats.getQueryPlan()).isEqualTo(new QueryPlan(queryPlanProto));
    Truth.assertThat(resultSetStats.getQueryStats()).isEqualTo(Structs.asMap(statsProto));
  }

  @Test
  public void testEqualsAndHashcode() {
    Struct planInfoStruct =
        Struct.newBuilder()
            .putFields("indexes_used", Value.newBuilder().setStringValue("val").build())
            .build();
    com.google.datastore.v1.QueryPlan queryPlanProto =
        com.google.datastore.v1.QueryPlan.newBuilder().setPlanInfo(planInfoStruct).build();

    Struct statsProto =
        Struct.newBuilder()
            .putFields("bytes_returned", Value.newBuilder().setStringValue("bytes").build())
            .build();
    com.google.datastore.v1.ResultSetStats proto =
        com.google.datastore.v1.ResultSetStats.newBuilder()
            .setQueryStats(statsProto)
            .setQueryPlan(queryPlanProto)
            .build();
    ResultSetStats resultSetStats = new ResultSetStats(proto);
    ResultSetStats resultSetStats2 = new ResultSetStats(proto);

    Truth.assertThat(resultSetStats).isEqualTo(resultSetStats2);
    Truth.assertThat(resultSetStats.hashCode()).isEqualTo(resultSetStats2.hashCode());

    Struct planInfoStruct2 =
        Struct.newBuilder()
            .putFields("indexes_used", Value.newBuilder().setStringValue("val").build())
            .build();
    com.google.datastore.v1.QueryPlan queryPlanProto2 =
        com.google.datastore.v1.QueryPlan.newBuilder().setPlanInfo(planInfoStruct2).build();

    Struct statsProto2 =
        Struct.newBuilder()
            .putFields("bytes_returned", Value.newBuilder().setStringValue("other bytes").build())
            .build();
    com.google.datastore.v1.ResultSetStats proto2 =
        com.google.datastore.v1.ResultSetStats.newBuilder()
            .setQueryStats(statsProto2)
            .setQueryPlan(queryPlanProto2)
            .build();
    ResultSetStats resultSetStats3 = new ResultSetStats(proto2);

    Truth.assertThat(resultSetStats3).isNotEqualTo(resultSetStats);
    Truth.assertThat(resultSetStats3).isNotEqualTo(resultSetStats2);
    Truth.assertThat(resultSetStats3.hashCode()).isNotEqualTo(resultSetStats.hashCode());
    Truth.assertThat(resultSetStats3.hashCode()).isNotEqualTo(resultSetStats2.hashCode());
  }
}
