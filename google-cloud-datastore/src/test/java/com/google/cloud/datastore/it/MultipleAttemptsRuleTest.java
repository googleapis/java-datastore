/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.datastore.it;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

final class MultipleAttemptsRuleTest {

  private static final int NUMBER_OF_ATTEMPTS = 5;

  private final AtomicInteger numberAttempted = new AtomicInteger();

  @Test
  void wontPassUntil5() {
    assertThrows(
        AssertionError.class,
        () -> {
          for (int i = 0; i < NUMBER_OF_ATTEMPTS; i++) {
            int currentAttempt = numberAttempted.incrementAndGet();
            if (currentAttempt < NUMBER_OF_ATTEMPTS) {
              assertEquals(
                  NUMBER_OF_ATTEMPTS, currentAttempt); // This will fail until the last attempt
            } else {
              assertEquals(
                  NUMBER_OF_ATTEMPTS, currentAttempt); // This will pass on the last attempt
            }
          }
        });
  }
}
