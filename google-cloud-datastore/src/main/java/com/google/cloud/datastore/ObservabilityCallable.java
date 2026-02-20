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

package com.google.cloud.datastore;

import com.google.cloud.datastore.telemetry.MetricsRecorder;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * A wrapper for {@link Callable} that records observability metrics, such as the latency of the
 * first attempt of an RPC call. This is meant to be used in conjunction with {@link
 * com.google.cloud.RetryHelper#runWithRetries}.
 *
 * @param <V> The return type of the wrapped Callable.
 */
class ObservabilityCallable<V> implements Callable<V> {

  private final Callable<V> delegate;
  private final MetricsRecorder metricsRecorder;
  private final String methodName;
  private int attempt = 0;

  ObservabilityCallable(Callable<V> delegate, MetricsRecorder metricsRecorder, String methodName) {
    this.delegate = delegate;
    this.metricsRecorder = metricsRecorder;
    this.methodName = methodName;
  }

  @Override
  public V call() throws Exception {
    attempt++;
    if (attempt == 1) {
      Stopwatch stopwatch = Stopwatch.createStarted();
      try {
        V result = delegate.call();
        metricsRecorder.recordFirstResponseLatency(
            stopwatch.elapsed(TimeUnit.MILLISECONDS),
            ImmutableMap.of("status", "OK", "method", methodName));
        return result;
      } catch (Exception e) {
        metricsRecorder.recordFirstResponseLatency(
            stopwatch.elapsed(TimeUnit.MILLISECONDS),
            ImmutableMap.of(
                "status", DatastoreException.getStatusFromException(e), "method", methodName));
        throw e;
      }
    } else {
      return delegate.call();
    }
  }

  /** Returns the number of times this {@link Callable} has been called. */
  public int getAttempts() {
    return attempt;
  }
}
