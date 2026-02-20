/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore.telemetry;

import com.google.api.core.InternalApi;

/**
 * Internal telemetry constants shared between OpenTelemetry tracing and
 * metrics.
 */
@InternalApi
public class TelemetryConstants {
  public static final String METHOD_ALLOCATE_IDS = "allocateIds";
  public static final String METHOD_BEGIN_TRANSACTION = "beginTransaction";
  public static final String METHOD_COMMIT = "commit";
  public static final String METHOD_LOOKUP = "lookup";
  public static final String METHOD_RESERVE_IDS = "reserveIds";
  public static final String METHOD_ROLLBACK = "rollback";
  public static final String METHOD_RUN_QUERY = "runQuery";
  public static final String METHOD_TRANSACTION_COMMIT = "transactionCommit";
  public static final String METHOD_TRANSACTION_LOOKUP = "transactionLookup";
  public static final String METHOD_TRANSACTION_RUN = "transactionRun";
  public static final String METHOD_TRANSACTION_RUN_QUERY = "transactionRunQuery";
  public static final String METHOD_RUN_AGGREGATION_QUERY = "runAggregationQuery";
  public static final String METHOD_ADD = "add";
  public static final String METHOD_PUT = "put";
  public static final String METHOD_UPDATE = "update";
  public static final String METHOD_DELETE = "delete";
  public static final String METHOD_SUBMIT = "submit";

  public static final String SPAN_NAME_LOOKUP = "Lookup";
  public static final String SPAN_NAME_ALLOCATE_IDS = "AllocateIds";
  public static final String SPAN_NAME_RESERVE_IDS = "ReserveIds";
  public static final String SPAN_NAME_COMMIT = "Commit";
  public static final String SPAN_NAME_RUN_QUERY = "RunQuery";
  public static final String SPAN_NAME_RUN_AGGREGATION_QUERY = "RunAggregationQuery";
  public static final String SPAN_NAME_TRANSACTION_RUN = "Transaction.Run";
  public static final String SPAN_NAME_BEGIN_TRANSACTION = "Transaction.Begin";
  public static final String SPAN_NAME_TRANSACTION_LOOKUP = "Transaction.Lookup";
  public static final String SPAN_NAME_TRANSACTION_COMMIT = "Transaction.Commit";
  public static final String SPAN_NAME_TRANSACTION_RUN_QUERY = "Transaction.RunQuery";
  public static final String SPAN_NAME_ROLLBACK = "Transaction.Rollback";
  public static final String SPAN_NAME_TRANSACTION_RUN_AGGREGATION_QUERY = "Transaction.RunAggregationQuery";

  private TelemetryConstants() {
  }
}
