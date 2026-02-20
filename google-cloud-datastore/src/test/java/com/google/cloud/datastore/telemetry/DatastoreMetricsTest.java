/*
 * Copyright 2024 Google LLC
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
import static org.easymock.EasyMock.anyObject;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.google.cloud.NoCredentials;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.DatastoreOpenTelemetryOptions;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;

public class DatastoreMetricsTest {

  private DatastoreRpc rpcMock;
  private Datastore datastore;
  private InMemoryMetricReader metricReader;

  @Before
  public void setUp() {
    rpcMock = createStrictMock(DatastoreRpc.class);
    metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider = SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetrySdk openTelemetry = OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    DatastoreOptions options = DatastoreOptions.newBuilder()
        .setProjectId("test-project")
        .setCredentials(NoCredentials.getInstance())
        .setServiceRpcFactory(options1 -> rpcMock)
        .setOpenTelemetryOptions(
            DatastoreOpenTelemetryOptions.newBuilder()
                .setMetricsEnabled(true)
                .setOpenTelemetry(openTelemetry)
                .build())
        .build();

    datastore = options.getService();
  }

  @Test
  public void testLookupMetrics() {
    Key key = Key.newBuilder("test-project", "Kind", "name").build();
    com.google.datastore.v1.LookupResponse response = com.google.datastore.v1.LookupResponse.newBuilder().build();
    expect(rpcMock.lookup(anyObject())).andReturn(response);
    replay(rpcMock);

    datastore.get(key);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    assertThat(metrics).isNotEmpty();
    MetricData latencyMetric = metrics.stream()
        .filter(m -> m.getName().equals("first_response_latency"))
        .findFirst()
        .orElse(null);
    assertThat(latencyMetric).isNotNull();

    HistogramPointData point = (HistogramPointData) latencyMetric.getHistogramData().getPoints().iterator().next();
    assertThat(point.getAttributes().get(AttributeKey.stringKey("method"))).isEqualTo(TelemetryConstants.METHOD_LOOKUP);
    assertThat(point.getAttributes().get(AttributeKey.stringKey("status"))).isEqualTo("OK");

    verify(rpcMock);
  }
}
