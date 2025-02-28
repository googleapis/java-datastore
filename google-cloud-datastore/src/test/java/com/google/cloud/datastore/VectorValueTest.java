/*
 * Copyright 2024 Google LLC
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class VectorValueTest {
  private static final List<Value<Double>> vectorList =
      ImmutableList.of(DoubleValue.of(1.2), DoubleValue.of(3.6));

  @Test
  public void testToBuilder() {
    VectorValue value = VectorValue.of(0.3, 4.2, 3.7);
    assertEquals(value, value.toBuilder().build());
  }

  @Test
  public void testOf() {
    VectorValue value = VectorValue.of(0.3, 4.2, 3.7);
    assertEquals(
        ImmutableList.of(DoubleValue.of(0.3), DoubleValue.of(4.2), DoubleValue.of(3.7)),
        value.get());
    assertEquals(31, value.getMeaning());
    VectorValue vectorListValue = VectorValue.of(vectorList);
    assertEquals(vectorList, vectorListValue.get());
    assertEquals(31, vectorListValue.getMeaning());
  }

  @SuppressWarnings("deprecation")
  @Test
  public void testBuilder() {
    VectorValue.Builder builder = VectorValue.newBuilder(0.3, 4.2, 3.7);
    VectorValue value = builder.setExcludeFromIndexes(true).build();
    assertEquals(
        ImmutableList.of(DoubleValue.of(0.3), DoubleValue.of(4.2), DoubleValue.of(3.7)),
        value.get());
    assertEquals(31, value.getMeaning());
    assertTrue(value.excludeFromIndexes());
  }
}
