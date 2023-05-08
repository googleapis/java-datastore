package com.google.cloud.datastore.aggregation;

import static com.google.common.base.Preconditions.checkArgument;

import com.google.api.core.BetaApi;
import com.google.datastore.v1.AggregationQuery;
import com.google.datastore.v1.AggregationQuery.Aggregation.Sum;
import com.google.datastore.v1.PropertyReference;
import java.util.Objects;

/** Represents an {@link Aggregation} which returns sum of numerical values. */
@BetaApi
public class SumAggregation extends Aggregation {

  private final String propertyReference;

  public SumAggregation(String alias, String propertyReference) {
    super(alias);
    checkArgument(propertyReference != null, "Property reference can't be null");
    this.propertyReference = propertyReference;
  }

  @Override
  public AggregationQuery.Aggregation toPb() {
    PropertyReference reference = PropertyReference.newBuilder().setName(this.propertyReference)
        .build();
    Sum sum = Sum.newBuilder().setProperty(reference).build();
    return aggregationBuilder().setSum(sum).build();
  }

  @Override
  protected boolean sameAs(Aggregation aggregation) {
    SumAggregation that = (SumAggregation) aggregation;
    if (!this.propertyReference.equals(that.propertyReference)) {
      return false;
    }
    boolean bothAliasAreNull = getAlias() == null && that.getAlias() == null;
    if (bothAliasAreNull) {
      return true;
    } else {
      boolean bothArePresent = getAlias() != null && that.getAlias() != null;
      return bothArePresent && getAlias().equals(that.getAlias());
    }
  }

  @Override
  public int hash() {
    return Objects.hash(getAlias());
  }

  /** A builder class to create and customize a {@link SumAggregation}. */
  public static class Builder implements AggregationBuilder<SumAggregation> {

    private String alias;
    private String propertyReference;

    public SumAggregation.Builder propertyReference(String propertyReference) {
      this.propertyReference = propertyReference;
      return this;
    }

    public SumAggregation.Builder as(String alias) {
      this.alias = alias;
      return this;
    }

    @Override
    public SumAggregation build() {
      return new SumAggregation(alias, propertyReference);
    }
  }
}
