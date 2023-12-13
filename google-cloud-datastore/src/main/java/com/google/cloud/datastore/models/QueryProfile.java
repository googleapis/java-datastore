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
import com.google.common.annotations.VisibleForTesting;

public class QueryProfile {

  /*
   * Model enums for query mode.
   */
  public enum QueryMode {
    /*
     * The default mode. Only the query results are returned.
     */
    NORMAL(com.google.datastore.v1.QueryMode.NORMAL),

    /*
     * This mode returns only the query plan, without any results or execution statistics information.
     */
    EXPLAIN(com.google.datastore.v1.QueryMode.PLAN),

    /*
     * This mode returns both the query plan and the execution statistics along with the results.
     */
    EXPLAIN_ANALYZE(com.google.datastore.v1.QueryMode.PROFILE),

    /*
     * Unrecognized enum specified; please update your client.
     */
    UNRECOGZNIED(com.google.datastore.v1.QueryMode.UNRECOGNIZED);

    private final com.google.datastore.v1.QueryMode proto;

    QueryMode(com.google.datastore.v1.QueryMode proto) {
      this.proto = proto;
    }

    @InternalApi
    @VisibleForTesting
    public com.google.datastore.v1.QueryMode toPb() {
      return this.proto;
    }
  }
}
