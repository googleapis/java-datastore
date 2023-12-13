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
import java.util.Map;
import org.junit.Test;

public class QueryPlanTest {

  @Test
  public void testQueryPlanModel() {
    Struct planInfoStruct =
        Struct.newBuilder()
            .putFields("indexes_used", Value.newBuilder().setStringValue("val").build())
            .build();
    com.google.datastore.v1.QueryPlan proto =
        com.google.datastore.v1.QueryPlan.newBuilder().setPlanInfo(planInfoStruct).build();
    QueryPlan queryPlan = new QueryPlan(proto);

    Map<String, Object> planInfo = queryPlan.getPlanInfo();
    Truth.assertThat(planInfo).isEqualTo(Structs.asMap(planInfoStruct));
  }

  @Test
  public void testEqualsAndHashcode() {
    Struct planInfoStruct =
        Struct.newBuilder()
            .putFields("indexes_used", Value.newBuilder().setStringValue("val").build())
            .build();
    com.google.datastore.v1.QueryPlan proto =
        com.google.datastore.v1.QueryPlan.newBuilder().setPlanInfo(planInfoStruct).build();
    QueryPlan queryPlan1 = new QueryPlan(proto);
    QueryPlan queryPlan2 = new QueryPlan(proto);

    Truth.assertThat(queryPlan1).isEqualTo(queryPlan2);
    Truth.assertThat(queryPlan1.hashCode()).isEqualTo(queryPlan2.hashCode());

    Struct planInfoStruct2 =
        Struct.newBuilder()
            .putFields("indexes_used", Value.newBuilder().setStringValue("12345").build())
            .build();
    com.google.datastore.v1.QueryPlan proto2 =
        com.google.datastore.v1.QueryPlan.newBuilder().setPlanInfo(planInfoStruct2).build();
    QueryPlan queryPlan3 = new QueryPlan(proto2);

    Truth.assertThat(queryPlan3).isNotEqualTo(queryPlan1);
    Truth.assertThat(queryPlan3.hashCode()).isNotEqualTo(queryPlan1.hashCode());
  }
}
