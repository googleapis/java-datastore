/*
 * Copyright 2023 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.datastore;

import static org.junit.Assert.assertEquals;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for quickstart sample.
 */
@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class RegionalEndpointIT {

  private static RegionalEndpoint regionalEndpoint;

  private static UUID uuid;

  private static final void deleteTestEntity(Datastore datastore, Key key) {
    datastore.delete(key);
  }

  @Before
  public void setUp() {

    regionalEndpoint = new RegionalEndpoint();

    uuid = UUID.randomUUID();
  }

  @Test
  public void testRegionalEndpoint() throws Exception {
    Datastore datastoreWithEndpoint = regionalEndpoint.createClient();

    // Run a few operations with the client
    // The kind for the test entity
    String kind = "Task";
    // Use uuid to create key for the test entity
    Key taskKey = datastoreWithEndpoint.newKeyFactory().setKind(kind).newKey(uuid.toString());

    // Prepare the new entity
    Entity task = Entity.newBuilder(taskKey).set("description", "Buy milk").build();

    // Save the entity
    datastoreWithEndpoint.put(task);

    // Retrieve the entity
    Entity retrieved = datastoreWithEndpoint.get(taskKey);
    assertEquals(task, retrieved);
    // Remove the test entity
    deleteTestEntity(datastoreWithEndpoint, taskKey);
  }
}
