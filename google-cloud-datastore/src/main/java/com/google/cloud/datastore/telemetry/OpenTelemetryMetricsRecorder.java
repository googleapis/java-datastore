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

import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.api.metrics.DoubleHistogram;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import java.util.Map;

import javax.annotation.Nonnull;

/**
 * OpenTelemetry metrics recorder implementation, used to record metrics when
 * metrics are enabled.
 */
class OpenTelemetryMetricsRecorder implements MetricsRecorder {
  private final OpenTelemetry openTelemetry;
  private final Meter meter;

  private final DoubleHistogram firstResponseLatency;
  private final DoubleHistogram transactionLatency;
  private final LongCounter transactionAttemptCount;

  OpenTelemetryMetricsRecorder(@Nonnull OpenTelemetry openTelemetry) {
    this.openTelemetry = openTelemetry;
    this.meter = openTelemetry.getMeter(METER_NAME);

    this.firstResponseLatency = meter
        .histogramBuilder("first_response_latency")
        .setDescription("Latency of the first response from the Datastore service")
        .setUnit("ms")
        .build();

    this.transactionLatency = meter
        .histogramBuilder("transaction_latency")
        .setDescription("Total latency for successful transaction operations")
        .setUnit("ms")
        .build();

    this.transactionAttemptCount = meter
        .counterBuilder("transaction_attempt_count")
        .setDescription("Number of attempts performed for a transaction")
        .build();
  }

  OpenTelemetry getOpenTelemetry() {
    return openTelemetry;
  }

  @Override
  public void recordFirstResponseLatency(double latencyMs, Map<String, String> attributes) {
    firstResponseLatency.record(latencyMs, toOtelAttributes(attributes));
  }

  @Override
  public void recordTransactionLatency(double latencyMs, Map<String, String> attributes) {
    transactionLatency.record(latencyMs, toOtelAttributes(attributes));
  }

  @Override
  public void recordTransactionAttemptCount(long count, Map<String, String> attributes) {
    transactionAttemptCount.add(count, toOtelAttributes(attributes));
  }

  private static Attributes toOtelAttributes(Map<String, String> attributes) {
    AttributesBuilder builder = Attributes.builder();
    if (attributes != null) {
      attributes.forEach(builder::put);
    }
    return builder.build();
  }
}
