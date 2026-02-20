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
  private final boolean isTransactional;
  private int attempt = 0;
  private Stopwatch transactionStopwatch;

  ObservabilityCallable(Callable<V> delegate, MetricsRecorder metricsRecorder, String methodName) {
    this(delegate, metricsRecorder, methodName, false);
  }

  ObservabilityCallable(
      Callable<V> delegate,
      MetricsRecorder metricsRecorder,
      String methodName,
      boolean isTransactional) {
    this.delegate = delegate;
    this.metricsRecorder = metricsRecorder;
    this.methodName = methodName;
    this.isTransactional = isTransactional;
  }

  @Override
  public V call() throws Exception {
    attempt++;
    if (attempt == 1) {
      if (isTransactional) {
        transactionStopwatch = Stopwatch.createStarted();
      }
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

  /**
   * Finalizes and records transaction metrics (latency and attempt count) if this
   * operation
   * was marked as transactional. This should be called after the retry loop
   * completes (either
   * successfully or throwing an exception).
   */
  public void recordTransactionMetrics(Throwable e) {
    if (isTransactional && transactionStopwatch != null) {
      String status = "OK";
      if (e != null) {
        status = DatastoreException.getStatusFromException(
            e instanceof Exception ? (Exception) e : new Exception(e));
      }
      metricsRecorder.recordTransactionLatency(
          transactionStopwatch.elapsed(TimeUnit.MILLISECONDS),
          ImmutableMap.of("status", status, "method", methodName));
      metricsRecorder.recordTransactionAttemptCount(
          attempt, ImmutableMap.of("status", status, "method", methodName));
    }
  }
}
