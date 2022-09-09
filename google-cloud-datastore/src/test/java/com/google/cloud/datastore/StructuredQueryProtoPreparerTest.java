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

import static com.google.cloud.datastore.Query.newEntityQueryBuilder;
import static com.google.datastore.v1.PropertyFilter.Operator.EQUAL;
import static com.google.datastore.v1.PropertyOrder.Direction.ASCENDING;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import com.google.cloud.datastore.StructuredQuery.OrderBy;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.google.datastore.v1.Filter;
import com.google.datastore.v1.KindExpression;
import com.google.datastore.v1.Projection;
import com.google.datastore.v1.PropertyFilter.Operator;
import com.google.datastore.v1.PropertyOrder;
import com.google.datastore.v1.PropertyReference;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.Int32Value;
import org.junit.Test;

public class StructuredQueryProtoPreparerTest {

  private final StructuredQueryProtoPreparer protoPreparer = new StructuredQueryProtoPreparer();

  @Test
  public void testKind() {
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder().setKind("kind").build());

    assertThat(queryProto.getKind(0), equalTo(KindExpression.newBuilder().setName("kind").build()));
  }

  @Test
  public void testStartCursor() {
    byte[] bytes = {1, 2};
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder().setStartCursor(
        Cursor.copyFrom(bytes)).build());

    assertThat(queryProto.getStartCursor(), equalTo(ByteString.copyFrom(bytes)));
  }

  @Test
  public void testEndCursor() {
    byte[] bytes = {1, 2};
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder().setEndCursor(
        Cursor.copyFrom(bytes)).build());

    assertThat(queryProto.getEndCursor(), equalTo(ByteString.copyFrom(bytes)));
  }

  @Test
  public void testOffset() {
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder().setOffset(5).build());

    assertThat(queryProto.getOffset(), equalTo(5));
  }

  @Test
  public void testLimit() {
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder().setLimit(5).build());

    assertThat(queryProto.getLimit(), equalTo(Int32Value.of(5)));
  }

  @Test
  public void testFilter() {
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder()
        .setFilter(PropertyFilter.eq("done", true))
        .build());

    assertThat(queryProto.getFilter(), equalTo(
        propertyFilter("done", EQUAL, Value.newBuilder().setBooleanValue(true).build())
    ));
  }

  @Test
  public void testOrderBy() {
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder()
        .setOrderBy(OrderBy.asc("dept-id"), OrderBy.asc("rank"))
        .build());

    assertThat(queryProto.getOrder(0), equalTo(propertyOrder("dept-id")));
    assertThat(queryProto.getOrder(1), equalTo(propertyOrder("rank")));
  }

  @Test
  public void testDistinctOn() {
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder()
        .setDistinctOn("dept-id", "rank")
        .build());

    assertThat(queryProto.getDistinctOn(0), equalTo(propertyReference("dept-id")));
    assertThat(queryProto.getDistinctOn(1), equalTo(propertyReference("rank")));
  }

  @Test
  public void testProjections() {
    Query queryProto = protoPreparer.prepare(newEntityQueryBuilder()
        .setProjection("dept-id", "rank")
        .build());

    assertThat(queryProto.getProjection(0), equalTo(projection("dept-id")));
    assertThat(queryProto.getProjection(1), equalTo(projection("rank")));
  }

  private Filter propertyFilter(String propertyName, Operator operator, Value value) {
    return Filter.newBuilder().setPropertyFilter(
        com.google.datastore.v1.PropertyFilter.newBuilder()
            .setProperty(propertyReference(propertyName))
            .setOp(operator)
            .setValue(value)
            .build()
    ).build();
  }

  private PropertyOrder propertyOrder(String value) {
    return PropertyOrder.newBuilder()
        .setProperty(propertyReference(value))
        .setDirection(ASCENDING)
        .build();
  }

  private Projection projection(String value) {
    return Projection.newBuilder()
        .setProperty(propertyReference(value))
        .build();
  }

  private PropertyReference propertyReference(String value) {
    return PropertyReference.newBuilder().setName(value).build();
  }
}