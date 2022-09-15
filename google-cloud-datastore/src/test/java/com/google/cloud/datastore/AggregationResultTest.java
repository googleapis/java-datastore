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

import com.google.common.collect.ImmutableMap;
import org.junit.Test;

public class AggregationResultTest {

  @Test
  public void shouldGetAggregationResultValueByAlias() {
    AggregationResult aggregationResult = new AggregationResult(ImmutableMap.of(
        "count", LongValue.of(45),
        "count_upto_30", LongValue.of(30)
    ));

    assertThat(aggregationResult.get("count"), equalTo(45L));
    assertThat(aggregationResult.get("count_upto_30"), equalTo(30L));
  }
}