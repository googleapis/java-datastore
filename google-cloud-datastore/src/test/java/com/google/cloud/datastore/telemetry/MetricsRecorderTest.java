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

import static org.junit.Assert.assertTrue;

import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.DatastoreOptions;
import org.junit.Before;
import org.junit.Test;
import org.easymock.EasyMock;

public class MetricsRecorderTest {

  private DatastoreOptions.Builder optionsBuilder;

  @Before
  public void setUp() {
    optionsBuilder = DatastoreOptions.newBuilder().setProjectId("project-id");
  }

  @Test
  public void testGetInstanceMetricsEnabled() {
    DatastoreOptions datastoreOptions =
        optionsBuilder
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setOpenTelemetry(io.opentelemetry.api.OpenTelemetry.noop())
                    .setMetricsEnabled(true)
                    .build())
            .build();
    MetricsRecorder datastoreMetricsRecorder = MetricsRecorder.getInstance(datastoreOptions.getOpenTelemetryOptions());

    assertTrue(datastoreMetricsRecorder instanceof OpenTelemetryMetricsRecorder);
  }

  @Test
  public void testGetInstanceWhenMetricsAreDisabled() {

    DatastoreOptions datastoreOptions = DatastoreOptions.newBuilder()
        .setProjectId("project-id")
            .setOpenTelemetryOptions(
            DatastoreOpenTelemetryOptions.newBuilder()
                .setOpenTelemetry(io.opentelemetry.api.OpenTelemetry.noop())
                .setMetricsEnabled(false)
                .build())
            .build();

    MetricsRecorder datastoreMetricsRecorder = MetricsRecorder.getInstance(datastoreOptions.getOpenTelemetryOptions());
    assertTrue(datastoreMetricsRecorder instanceof NoOpMetricsRecorder);
  }
}
