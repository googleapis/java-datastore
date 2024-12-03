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

package com.google.cloud.datastore.aggregation;

import com.google.api.core.InternalExtensionOnly;

/**
 * An interface to represent the builders which build and customize {@link Aggregation} for {@link
 * com.google.cloud.datastore.AggregationQuery}.
 *
 * <p>Used by {@link
 * com.google.cloud.datastore.AggregationQuery.Builder#addAggregation(AggregationBuilder)}.
 */
@InternalExtensionOnly
public interface AggregationBuilder<A extends Aggregation> {
  A build();
}
