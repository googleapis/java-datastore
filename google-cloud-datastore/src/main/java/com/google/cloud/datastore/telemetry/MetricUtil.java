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

import com.google.cloud.datastore.DatastoreOptions;
import javax.annotation.Nonnull;

/** Utility interface to manage OpenTelemetry metrics instrumentation based on the configuration. */
interface MetricUtil {
  static final String METER_NAME = "com.google.cloud.datastore";

  /**
   * Creates and returns an instance of the MetricUtil class.
   *
   * @param datastoreOptions The DatastoreOptions object that is requesting an instance of
   *     MetricUtil.
   * @return An instance of the MetricUtil class.
   */
  static MetricUtil getInstance(@Nonnull DatastoreOptions datastoreOptions) {
    boolean isMetricsEnabled = datastoreOptions.getOpenTelemetryOptions().isMetricsEnabled();

    if (isMetricsEnabled) {
      return new EnabledMetricUtil(datastoreOptions);
    } else {
      return new DisabledMetricUtil();
    }
  }

  /**
   * Returns a metrics recorder to perform recording operations.
   */
  MetricsRecorder getMetricsRecorder();

  /** Interface to record specific metric operations. */
  interface MetricsRecorder {
    /** Records the latency of the first response from the server in milliseconds. */
    void recordFirstResponseLatency(long latencyMs);

    /** Records the total latency of a transaction in milliseconds. */
    void recordTransactionLatency(long latencyMs);

    /** Records the number of attempts a transaction took. */
    void recordTransactionAttemptCount(long count);
  }
}
