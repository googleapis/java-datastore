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
package com.example.datastore;

import com.rule.SystemsOutRule;
import org.junit.Rule;
import org.junit.Test;

public class AggregationQuerySampleTestIT {

  @Rule
  public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  private final AggregationQuerySample sample = new AggregationQuerySample();


  @Test
  public void testAggregationQueryAndCountAggregationSample() {
    sample.aggregationQueryAndCountAggregation();

    systemsOutRule.assertContains("Total candidates count is 3");
  }

  @Test
  public void testAggregationQueryAndCountAggregationWithPropertyFilterSample() {
    sample.aggregationQueryAndCountAggregationWithPropertyFilter();

    systemsOutRule.assertContains("Total qualified candidates count is 2");
    systemsOutRule.assertContains("Total unqualified candidates count is 1");
  }

  @Test
  public void testAggregationQueryAndCountAggregationSampleWithGqlQuery() {
    sample.aggregationQueryAndCountAggregationWithGqlQuery();

    systemsOutRule.assertContains("We have at least 2 candidates");
    systemsOutRule.assertContains("Total candidates count is 3");
    systemsOutRule.assertContains("Total qualified candidates count is 2");
  }

  @Test
  public void testAggregationQueryAndCountWithStaleRead() throws InterruptedException {
    sample.aggregationQueryAndCountAggregationWithStaleRead();

    systemsOutRule.assertContains("Latest candidates count is 3");
    systemsOutRule.assertContains("Stale candidates count is 2");
  }
}