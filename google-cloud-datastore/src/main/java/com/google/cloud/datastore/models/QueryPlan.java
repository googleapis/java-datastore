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

import com.google.api.core.InternalApi;
import com.google.cloud.Structs;
import com.google.common.base.Objects;
import java.util.Map;

/*
 * Class to model the returned plan for the query. This includes plan info - a map containing phase information for the query.
 */
public class QueryPlan {
  private final Map<String, Object> planInfo;

  @InternalApi
  public QueryPlan(com.google.datastore.v1.QueryPlan proto) {
    this.planInfo = Structs.asMap(proto.getPlanInfo());
  }

  /*
   * Returns the plan info as a map.
   */
  public Map<String, Object> getPlanInfo() {
    return this.planInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof QueryPlan)) {
      return false;
    }
    QueryPlan queryPlan = (QueryPlan) o;
    return Objects.equal(planInfo, queryPlan.planInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(planInfo);
  }
}
