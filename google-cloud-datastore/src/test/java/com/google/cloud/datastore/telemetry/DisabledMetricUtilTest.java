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

import static com.google.common.truth.Truth.assertThat;

import java.util.Collections;
import java.util.Map;
import org.junit.Test;

public class DisabledMetricUtilTest {

  // TODO: This test is not very useful, we should add a test that verifies that
  // the metrics are
  // not recorded.
  @Test
  public void testGetMetricsRecorderReturnsNoOpRecorder() {
    DisabledMetricUtil metricUtil = new DisabledMetricUtil();
    MetricUtil.MetricsRecorder recorder = metricUtil.getMetricsRecorder();
    assertThat(recorder).isNotNull();

    Map<String, String> attributes = Collections.emptyMap();
    // Verifying it runs without throwing exceptions
    recorder.recordFirstResponseLatency(100, attributes);
    recorder.recordTransactionLatency(200, attributes);
    recorder.recordTransactionAttemptCount(1, attributes);
  }
}
