/*
 * Copyright 2023 Google LLC
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

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.datastore.v1.AggregationQuery;
import com.google.datastore.v1.AggregationQuery.Aggregation.Avg;
import com.google.datastore.v1.PropertyReference;
import java.util.Objects;

/** Represents an {@link Aggregation} which returns average of numerical values. */
@BetaApi
public class AvgAggregation extends Aggregation {

  private final String propertyReference;

  public AvgAggregation(String alias, String propertyReference) {
    super(alias);
    checkArgument(propertyReference != null, "Property reference can't be null");
    this.propertyReference = propertyReference;
  }

  @InternalApi
  @Override
  public AggregationQuery.Aggregation toPb() {
    PropertyReference reference = PropertyReference.newBuilder().setName(this.propertyReference)
        .build();
    Avg avg = Avg.newBuilder().setProperty(reference).build();
    return aggregationBuilder().setAvg(avg).build();
  }

  @Override
  protected boolean sameAs(Aggregation aggregation) {
    AvgAggregation that = (AvgAggregation) aggregation;
    return Objects.equals(this.propertyReference, that.propertyReference) &&
        Objects.equals(getAlias(), that.getAlias());
  }

  @Override
  public int hash() {
    return Objects.hash(getAlias(), this.propertyReference);
  }

  /** A builder class to create and customize a {@link AvgAggregation}. */
  public static class Builder implements AggregationBuilder<AvgAggregation> {

    private String alias;
    private String propertyReference;

    public AvgAggregation.Builder propertyReference(String propertyReference) {
      this.propertyReference = propertyReference;
      return this;
    }

    public AvgAggregation.Builder as(String alias) {
      this.alias = alias;
      return this;
    }

    @Override
    public AvgAggregation build() {
      return new AvgAggregation(alias, propertyReference);
    }
  }
}
