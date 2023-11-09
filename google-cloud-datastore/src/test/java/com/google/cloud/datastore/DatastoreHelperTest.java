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

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.createStrictMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class DatastoreHelperTest {

  @Test
  public void testNewKeyFactory() {
    DatastoreOptions options = createMock(DatastoreOptions.class);
    expect(options.getProjectId()).andReturn("ds1").once();
    expect(options.getNamespace()).andReturn("ns1").once();
    expect(options.getDatabaseId()).andReturn("test-db").once();
    replay(options);
    KeyFactory keyFactory = DatastoreHelper.newKeyFactory(options);
    Key key = keyFactory.setKind("k").newKey("bla");
    assertEquals("ds1", key.getProjectId());
    assertEquals("ns1", key.getNamespace());
    assertEquals("k", key.getKind());
    assertEquals("bla", key.getName());
    assertEquals("test-db", key.getDatabaseId());
    verify(options);
  }

  @Test
  public void testAllocateId() {
    Datastore datastore = createStrictMock(Datastore.class);
    IncompleteKey pKey1 = IncompleteKey.newBuilder("ds", "k").build();
    Key key1 = Key.newBuilder(pKey1, 1).build();
    expect(datastore.allocateId(new IncompleteKey[] {pKey1}))
        .andReturn(Collections.singletonList(key1));
    replay(datastore);
    assertEquals(key1, DatastoreHelper.allocateId(datastore, pKey1));
    verify(datastore);
  }

  @Test
  public void testGetWithDatastore() throws Exception {
    Datastore datastore = createStrictMock(Datastore.class);
    IncompleteKey pKey1 = IncompleteKey.newBuilder("ds", "k").build();
    Key key1 = Key.newBuilder(pKey1, 1).build();
    Entity entity1 = Entity.newBuilder(key1).build();
    Key key2 = Key.newBuilder(pKey1, 2).build();
    ReadOption eventualConsistency = ReadOption.eventualConsistency();
    expect(datastore.get(Collections.singletonList(key1)))
        .andReturn(Collections.singletonList(entity1).iterator());
    expect(datastore.get(Collections.singletonList(key2)))
        .andReturn(Collections.<Entity>emptyIterator());
    expect(datastore.get(Collections.singletonList(key1), eventualConsistency))
        .andReturn(Collections.singletonList(entity1).iterator());
    replay(datastore);
    assertEquals(entity1, DatastoreHelper.get(datastore, key1));
    assertNull(DatastoreHelper.get(datastore, key2));
    assertEquals(entity1, DatastoreHelper.get(datastore, key1, eventualConsistency));
    verify(datastore);
  }

  @Test
  public void testGetWithTransaction() throws Exception {
    Transaction transaction = createStrictMock(Transaction.class);
    IncompleteKey pKey1 = IncompleteKey.newBuilder("ds", "k").build();
    Key key1 = Key.newBuilder(pKey1, 1).build();
    Entity entity1 = Entity.newBuilder(key1).build();
    Key key2 = Key.newBuilder(pKey1, 2).build();
    expect(transaction.get(new Key[] {key1}))
        .andReturn(Collections.singletonList(entity1).iterator());
    expect(transaction.get(new Key[] {key2})).andReturn(Collections.<Entity>emptyIterator());
    replay(transaction);
    assertEquals(entity1, DatastoreHelper.get(transaction, key1));
    assertNull(DatastoreHelper.get(transaction, key2));
    verify(transaction);
  }

  @Test
  public void testAdd() throws Exception {
    Datastore datastore = createStrictMock(Datastore.class);
    IncompleteKey pKey = IncompleteKey.newBuilder("ds", "k").build();
    Key key = Key.newBuilder(pKey, 1).build();
    Entity entity = Entity.newBuilder(key).build();
    expect(datastore.add(new Entity[] {entity})).andReturn(Collections.singletonList(entity));
    replay(datastore);
    assertEquals(entity, DatastoreHelper.add(datastore, entity));
    verify(datastore);
  }

  @Test
  public void testFetchWithDatastore() throws Exception {
    Datastore datastore = createStrictMock(Datastore.class);
    IncompleteKey pKey1 = IncompleteKey.newBuilder("ds", "k").build();
    Key key1 = Key.newBuilder(pKey1, 1).build();
    Key key2 = Key.newBuilder(pKey1, "a").build();
    Entity entity1 = Entity.newBuilder(key1).build();
    Entity entity2 = Entity.newBuilder(key2).build();
    ReadOption eventualConsistency = ReadOption.eventualConsistency();
    expect(datastore.get(ImmutableList.of(key1, key2)))
        .andReturn(Iterators.forArray(entity1, entity2))
        .once();
    expect(datastore.get(ImmutableList.of(key1, key2), eventualConsistency))
        .andReturn(Iterators.forArray(entity1, entity2))
        .once();
    replay(datastore);
    List<Entity> values = DatastoreHelper.fetch(datastore, new Key[] {key1, key2});
    assertEquals(2, values.size());
    assertEquals(entity1, values.get(0));
    assertEquals(entity2, values.get(1));
    values = DatastoreHelper.fetch(datastore, new Key[] {key1, key2}, eventualConsistency);
    assertEquals(2, values.size());
    assertEquals(entity1, values.get(0));
    assertEquals(entity2, values.get(1));
    verify(datastore);
  }

  @Test
  public void testFetchWithTransaction() throws Exception {
    Transaction transaction = createStrictMock(Transaction.class);
    IncompleteKey pKey1 = IncompleteKey.newBuilder("ds", "k").build();
    Key key1 = Key.newBuilder(pKey1, 1).build();
    Key key2 = Key.newBuilder(pKey1, "a").build();
    Entity entity1 = Entity.newBuilder(key1).build();
    Entity entity2 = Entity.newBuilder(key2).build();
    expect(transaction.get(new Key[] {key1, key2}))
        .andReturn(Iterators.forArray(entity1, entity2))
        .once();
    replay(transaction);
    List<Entity> values = DatastoreHelper.fetch(transaction, new Key[] {key1, key2});
    assertEquals(2, values.size());
    assertEquals(entity1, values.get(0));
    assertEquals(entity2, values.get(1));
    verify(transaction);
  }
}
