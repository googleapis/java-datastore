/*
 * Copyright 2015 Google LLC
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

import static com.google.cloud.datastore.VectorValue.VECTOR_MEANING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.cloud.Timestamp;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class BaseEntityTest {

  private static final Blob BLOB = Blob.copyFrom(new byte[] {1, 2});
  private static final Timestamp TIMESTAMP = Timestamp.now();
  private static final LatLng LAT_LNG = new LatLng(37.422035, -122.084124);
  private static final VectorValue VECTOR = VectorValue.newBuilder(1.78, 2.56, 3.88).setMeaning(VECTOR_MEANING).setExcludeFromIndexes(true).build();
  private static final Key KEY = Key.newBuilder("ds1", "k1", "n1").build();
  private static final Entity ENTITY = Entity.newBuilder(KEY).set("name", "foo").build();
  private static final IncompleteKey INCOMPLETE_KEY = IncompleteKey.newBuilder("ds1", "k1").build();
  private static final FullEntity<IncompleteKey> PARTIAL_ENTITY =
      Entity.newBuilder(INCOMPLETE_KEY).build();

  private Builder builder;

  private class Builder extends BaseEntity.Builder<Key, Builder> {

    @Override
    public BaseEntity<Key> build() {

      return new BaseEntity<Key>(this) {};
    }
  }

  @Before
  public void setUp() {
    builder = new Builder();
    builder.set("blob", BLOB).set("boolean", true).set("timestamp", TIMESTAMP);
    builder.set("double", 1.25).set("key", KEY).set("string", "hello world");
    builder.set("long", 125).setNull("null").set("entity", ENTITY).set("latLng", LAT_LNG);
    builder.set("partialEntity", PARTIAL_ENTITY).set("stringValue", StringValue.of("bla"));
    builder.set("list1", NullValue.of(), StringValue.of("foo"), LatLngValue.of(LAT_LNG));
    builder.set("list2", ImmutableList.of(LongValue.of(10), DoubleValue.of(2)));
    builder.set("list3", Collections.singletonList(BooleanValue.of(true)));
    builder.set(
        "blobList", BLOB, Blob.copyFrom(new byte[] {3, 4}), Blob.copyFrom(new byte[] {5, 6}));
    builder.set("booleanList", true, false, true);
    builder.set("timestampList", Timestamp.now(), Timestamp.now(), Timestamp.now());
    builder.set("doubleList", 12.3, 4.56, .789);
    builder.set(
        "keyList",
        KEY,
        Key.newBuilder("ds2", "k2", "n2").build(),
        Key.newBuilder("ds3", "k3", "n3").build());
    builder.set("entityList", ENTITY, PARTIAL_ENTITY);
    builder.set("stringList", "s1", "s2", "s3");
    builder.set("longList", 1, 23, 456);
    builder.set("latLngList", LAT_LNG, LAT_LNG);
    builder.set("vector", VECTOR);
  }

  @Test
  public void testContains() {
    BaseEntity<Key> entity = builder.build();
    assertTrue(entity.contains("list1"));
    assertFalse(entity.contains("bla"));
    entity = builder.clear().build();
    assertFalse(entity.contains("list1"));
  }

  @Test
  public void testGetValue() {
    BaseEntity<Key> entity = builder.build();
    assertEquals(BlobValue.of(BLOB), entity.getValue("blob"));
  }

  @Test(expected = DatastoreException.class)
  public void testGetValueNotFound() {
    BaseEntity<Key> entity = builder.clear().build();
    entity.getValue("blob");
  }

  @Test
  public void testIsNull() {
    BaseEntity<Key> entity = builder.build();
    assertTrue(entity.isNull("null"));
    assertFalse(entity.isNull("blob"));
    entity = builder.setNull("blob").build();
    assertTrue(entity.isNull("blob"));
  }

  @Test(expected = DatastoreException.class)
  public void testIsNullNotFound() {
    BaseEntity<Key> entity = builder.clear().build();
    entity.isNull("null");
  }

  @Test
  public void testGetString() {
    BaseEntity<Key> entity = builder.build();
    assertEquals("hello world", entity.getString("string"));
    assertEquals("bla", entity.getString("stringValue"));
    entity = builder.set("string", "foo").build();
    assertEquals("foo", entity.getString("string"));
  }

  @Test
  public void testGetLong() {
    BaseEntity<Key> entity = builder.build();
    assertEquals(125, entity.getLong("long"));
    entity = builder.set("long", LongValue.of(10)).build();
    assertEquals(10, entity.getLong("long"));
  }

  @Test
  public void testGetDouble() {
    BaseEntity<Key> entity = builder.build();
    assertEquals(1.25, entity.getDouble("double"), 0);
    entity = builder.set("double", DoubleValue.of(10)).build();
    assertEquals(10, entity.getDouble("double"), 0);
  }

  @Test
  public void testGetBoolean() throws Exception {
    BaseEntity<Key> entity = builder.build();
    assertTrue(entity.getBoolean("boolean"));
    entity = builder.set("boolean", BooleanValue.of(false)).build();
    assertFalse(entity.getBoolean("boolean"));
  }

  @Test
  public void testGetTimestamp() {
    BaseEntity<Key> entity = builder.build();
    assertEquals(TIMESTAMP, entity.getTimestamp("timestamp"));
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DATE, -1);
    Timestamp timestamp = Timestamp.of(cal.getTime());
    entity = builder.set("timestamp", TimestampValue.of(timestamp)).build();
    assertEquals(timestamp, entity.getTimestamp("timestamp"));
  }

  @Test
  public void testGetLatLng() {
    BaseEntity<Key> entity = builder.build();
    assertEquals(LAT_LNG, entity.getLatLng("latLng"));
  }

  @Test
  public void testGetKey() {
    BaseEntity<Key> entity = builder.build();
    assertEquals(KEY, entity.getKey("key"));
    Key key = Key.newBuilder(KEY).setName("BLA").build();
    entity = builder.set("key", key).build();
    assertEquals(key, entity.getKey("key"));
  }

  @Test
  public void testGetEntity() {
    BaseEntity<Key> entity = builder.build();
    assertEquals(ENTITY, entity.getEntity("entity"));
    assertEquals(PARTIAL_ENTITY, entity.getEntity("partialEntity"));
    entity = builder.set("entity", EntityValue.of(PARTIAL_ENTITY)).build();
    assertEquals(PARTIAL_ENTITY, entity.getEntity("entity"));
  }

  @Test
  public void testGetVector() {
    BaseEntity<Key> entity = builder.build();
    List<DoubleValue> vectorList = entity.getVector("vector");
    assertEquals(3, vectorList.size());
    assertEquals(Double.valueOf(1.78), vectorList.get(0).get());
    assertEquals(Double.valueOf(2.56), vectorList.get(1).get());
    assertEquals(Double.valueOf(3.88), vectorList.get(2).get());
  }

  @Test
  public void testGetList() {
    BaseEntity<Key> entity = builder.build();
    List<? extends Value<?>> list = entity.getList("list1");
    assertEquals(3, list.size());
    assertEquals(NullValue.of(), list.get(0));
    assertEquals("foo", list.get(1).get());
    assertEquals(LAT_LNG, list.get(2).get());
    list = entity.getList("list2");
    assertEquals(2, list.size());
    assertEquals(Long.valueOf(10), list.get(0).get());
    assertEquals(Double.valueOf(2), list.get(1).get());
    list = entity.getList("list3");
    assertEquals(1, list.size());
    assertEquals(Boolean.TRUE, list.get(0).get());
    entity = builder.set("list1", ListValue.of(list)).build();
    assertEquals(list, entity.getList("list1"));
    List<Value<?>> stringList = entity.getList("stringList");
    assertEquals(
        ImmutableList.of(StringValue.of("s1"), StringValue.of("s2"), StringValue.of("s3")),
        stringList);
    List<Value<Double>> doubleList = entity.getList("doubleList");
    assertEquals(
        ImmutableList.of(DoubleValue.of(12.3), DoubleValue.of(4.56), DoubleValue.of(.789)),
        doubleList);
    List<EntityValue> entityList = entity.getList("entityList");
    assertEquals(
        ImmutableList.of(EntityValue.of(ENTITY), EntityValue.of(PARTIAL_ENTITY)), entityList);
  }

  @Test
  public void testGetBlob() {
    BaseEntity<Key> entity = builder.build();
    assertEquals(BLOB, entity.getBlob("blob"));
    Blob blob = Blob.copyFrom(new byte[] {});
    entity = builder.set("blob", BlobValue.of(blob)).build();
    assertEquals(blob, entity.getBlob("blob"));
  }

  @Test
  public void testNames() {
    Set<String> names =
        ImmutableSet.<String>builder()
            .add("string", "stringValue", "boolean", "double", "long", "list1", "list2", "list3")
            .add("entity", "partialEntity", "null", "timestamp", "blob", "key", "blobList")
            .add(
                "booleanList", "timestampList", "doubleList", "keyList", "entityList", "stringList")
            .add("longList", "latLng", "latLngList", "vector")
            .build();
    BaseEntity<Key> entity = builder.build();
    assertEquals(names, entity.getNames());
  }

  @Test
  public void testKey() {
    builder.setKey(KEY);
    BaseEntity<Key> entity = builder.build();
    assertEquals(KEY, entity.getKey());
  }
}
