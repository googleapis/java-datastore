package com.google.cloud.datastore.aggregation;

import static com.google.cloud.datastore.aggregation.Aggregation.count;
import static com.google.cloud.datastore.aggregation.Aggregation.sum;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.common.truth.Truth;
import com.google.datastore.v1.AggregationQuery;
import org.junit.Test;

public class SumAggregationTest {

  @Test
  public void shouldThrowExceptionWhenPropertyReferenceIsNull() {
    assertThrows(IllegalArgumentException.class, () -> sum(null).build());
  }

  @Test
  public void testSumAggregationWithDefaultValues() {
    AggregationQuery.Aggregation sumAggregation = sum("marks").build().toPb();

    assertThat(sumAggregation.getSum().getProperty().getName()).isEqualTo("marks");
    assertThat(sumAggregation.getAlias()).isEqualTo("");
  }

  @Test
  public void testCountAggregationWithAlias() {
    AggregationQuery.Aggregation sumAggregation = sum("marks").as("total_marks").build().toPb();

    assertThat(sumAggregation.getSum().getProperty().getName()).isEqualTo("marks");
    assertThat(sumAggregation.getAlias()).isEqualTo("total_marks");
  }

  @Test
  public void testEqualsWithAliasVariations() {
    SumAggregation.Builder aggregationWithAlias1 = sum("marks").as("total");
    SumAggregation.Builder aggregationWithAlias2 = sum("marks").as("total");
    SumAggregation.Builder aggregationWithoutAlias1 = sum("marks");
    SumAggregation.Builder aggregationWithoutAlias2 = sum("marks");

    // same aliases
    assertThat(aggregationWithAlias1.build()).isEqualTo(aggregationWithAlias2.build());
    assertThat(aggregationWithAlias2.build()).isEqualTo(aggregationWithAlias1.build());

    // with and without aliases
    assertThat(aggregationWithAlias1.build()).isNotEqualTo(aggregationWithoutAlias1.build());
    assertThat(aggregationWithoutAlias1.build()).isNotEqualTo(aggregationWithAlias1.build());

    // no aliases
    assertThat(aggregationWithoutAlias1.build()).isEqualTo(aggregationWithoutAlias2.build());
    assertThat(aggregationWithoutAlias2.build()).isEqualTo(aggregationWithoutAlias1.build());

    // different aliases
    assertThat(aggregationWithAlias1.as("new-alias").build())
        .isNotEqualTo(aggregationWithAlias2.build());
    assertThat(aggregationWithAlias2.build())
        .isNotEqualTo(aggregationWithAlias1.as("new-alias").build());
  }

  @Test
  public void testEqualsWithPropertyReferenceVariations() {
    SumAggregation totalMarks1 = sum("marks").build();
    SumAggregation totalMarks2 = sum("marks").build();

    SumAggregation totalQuantities = sum("quantity").build();

    assertThat(totalMarks1).isEqualTo(totalMarks2);
    assertThat(totalMarks2).isEqualTo(totalMarks1);

    assertThat(totalMarks1).isNotEqualTo(totalQuantities);
    assertThat(totalQuantities).isNotEqualTo(totalMarks1);
  }
}