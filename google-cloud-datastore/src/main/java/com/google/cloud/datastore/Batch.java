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

import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * An interface to represent a batch of write operations. Any write operation that is applied on a
 * batch will only be sent to the Datastore upon {@link #submit}. A usage example:
 *
 * <pre>{@code
 * Entity entity1 = datastore.get(key1);
 * Batch batch = datastore.newBatch();
 * Entity entity2 = Entity.newBuilder(key2).set("name", "John").build();
 * entity1 = Entity.newBuilder(entity1).clear().setNull("bla").build();
 * Entity entity3 = Entity.newBuilder(key3).set("title", "title").build();
 * batch.update(entity1);
 * batch.add(entity2, entity3);
 * batch.submit();
 * }</pre>
 *
 * <p><b> WARNING: THIS CLASS MAINTAINS AN INTERNAL STATE IN TERMS OF {@link
 * java.util.LinkedHashMap} AND {@link java.util.LinkedHashSet} WHICH GETS UPDATED ON EVERY METHOD
 * CALL PERFORMING CRUD OPERATIONS TO RECORD THE MUTATIONS, SINCE {@link java.util.LinkedHashMap} IS
 * NOT THREAD SAFE AS PER ITS <a
 * href="https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html">DOCUMENTATION</a>.
 * THIS CLASS TOO SHOULD NOT BE TREATED AS A THREAD SAFE CLASS. </b>
 */
@NotThreadSafe
public interface Batch extends DatastoreBatchWriter {

  interface Response {

    /** Returns a list of keys generated by a batch. */
    List<Key> getGeneratedKeys();
  }

  /**
   * {@inheritDoc}
   *
   * <p>If an entity for {@code entity.getKey()} does not exists, {@code entity} is inserted.
   * Otherwise, {@link #submit()} will throw a {@link DatastoreException} with {@link
   * DatastoreException#getReason()} equal to {@code "ALREADY_EXISTS"}.
   */
  @Override
  Entity add(FullEntity<?> entity);

  /**
   * {@inheritDoc}
   *
   * <p>If none of entities' keys exist, all entities are inserted. If any of entities' keys already
   * exists, {@link #submit()} will throw a {@link DatastoreException} with {@link
   * DatastoreException#getReason()} equal to {@code "ALREADY_EXISTS"}. All entities in {@code
   * entities} whose key did not exist are inserted.
   */
  @Override
  List<Entity> add(FullEntity<?>... entities);

  /**
   * Submit the batch to the Datastore.
   *
   * @throws DatastoreException if there was any failure or if batch is not longer active
   */
  Response submit();

  /** Returns the batch associated {@link Datastore}. */
  Datastore getDatastore();
}
