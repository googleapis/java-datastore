/*
 * Copyright 2022 Google LLC
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
package com.google.cloud.datastore;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import java.util.concurrent.Callable;
import org.junit.Test;

public class RetryExecutorTest {

  private RetryExecutor retryExecutor = new RetryExecutor();

  @Test
  public void shouldRetryWhenErrorOccurred() {
    RetrySettings retrySettings = RetrySettings.newBuilder()
        .setMaxAttempts(4)
        .build();
    CustomErrorCallable callable = new CustomErrorCallable(3);

    retryExecutor.execute(callable, retrySettings, new BasicResultRetryAlgorithm<>(),
        NanoClock.getDefaultClock());

    assertThat(callable.invokedTimes(), equalTo(4));
  }

  private static class CustomErrorCallable implements Callable<String> {

    private final int errorThreshold;
    private int numberOfInvocations;

    public CustomErrorCallable(int errorThreshold) {
      this.errorThreshold = errorThreshold;
      this.numberOfInvocations = 0;
    }

    @Override
    public String call() throws Exception {
      this.numberOfInvocations++;
      if (this.numberOfInvocations <= errorThreshold) {
        throw new RuntimeException("error");
      }
      return "success";
    }

    public int invokedTimes() {
      return this.numberOfInvocations;
    }
  }
}

