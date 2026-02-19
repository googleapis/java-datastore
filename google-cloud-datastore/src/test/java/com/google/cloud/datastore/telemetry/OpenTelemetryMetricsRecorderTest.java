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

import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOptions;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import java.util.Collections;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class OpenTelemetryMetricsRecorderTest {
  @Before
  public void setUp() {
    GlobalOpenTelemetry.resetForTest();
  }

  DatastoreOptions.Builder getBaseOptions() {
    return DatastoreOptions.newBuilder()
        .setProjectId("test-project")
        .setCredentials(NoCredentials.getInstance());
  }

  @Test
  public void testUsesOpenTelemetryFromOptions() {
    OpenTelemetrySdk myOpenTelemetrySdk = OpenTelemetrySdk.builder().build();
    DatastoreOptions options =
        getBaseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setMetricsEnabled(true)
                    .setOpenTelemetry(myOpenTelemetrySdk)
                    .build())
            .build();
    OpenTelemetryMetricsRecorder recorder =
        new OpenTelemetryMetricsRecorder(options.getOpenTelemetryOptions().getOpenTelemetry());
    assertThat(recorder.getOpenTelemetry()).isEqualTo(myOpenTelemetrySdk);
  }

  // TODO: This test is not very useful, we should add a test that verifies that
  // the metrics are recorded.
  @Test
  public void testRecorderDoesNotThrowExceptions() {
    DatastoreOptions options =
        getBaseOptions()
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setMetricsEnabled(true)
                    .setOpenTelemetry(OpenTelemetry.noop())
                    .build())
            .build();
    OpenTelemetryMetricsRecorder recorder =
        new OpenTelemetryMetricsRecorder(options.getOpenTelemetryOptions().getOpenTelemetry());

    Map<String, String> attributes = Collections.emptyMap();

    // Verifying it runs without throwing exceptions
    recorder.recordFirstResponseLatency(100.0, attributes);
    recorder.recordTransactionLatency(200.0, attributes);
    recorder.recordTransactionAttemptCount(1, attributes);
  }
}
