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

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.rule.SystemsOutRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
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
  @Rule
  public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  private static final void deleteTestEntity(Datastore datastore) {
    String kind = "Task";
    String name = "sampletask1";
    Key taskKey = datastore.newKeyFactory().setKind(kind).newKey(name);
    datastore.delete(taskKey);
  }

  @Before
  public void setUp() {
    regionalEndpoint = new RegionalEndpoint();
  }

  @After
  public void tearDown() {
    System.setOut(null);
  }

  @Test
  public void testRegionalEndpoint() throws Exception {
    Datastore datastoreWithEndpoint = regionalEndpoint.createClient();

    // run a few operations with the client
    deleteTestEntity(datastoreWithEndpoint);
    // The kind for the new entity
    String kind = "Task";
    // The name/ID for the new entity
    String name = "sampletask1";
    // The Cloud Datastore key for the new entity
    Key taskKey = datastoreWithEndpoint.newKeyFactory().setKind(kind).newKey(name);

    // Prepares the new entity
    Entity task = Entity.newBuilder(taskKey).set("description", "Buy milk").build();

    // Saves the entity
    datastoreWithEndpoint.put(task);

    System.out.printf("Saved %s: %s%n", task.getKey().getName(), task.getString("description"));

    // Retrieve entity
    Entity retrieved = datastoreWithEndpoint.get(taskKey);

    System.out.printf("Retrieved %s: %s%n", taskKey.getName(), retrieved.getString("description"));

    systemsOutRule.assertContains("Saved sampletask1: Buy milk");
    systemsOutRule.assertContains("Retrieved sampletask1: Buy milk");
    deleteTestEntity(datastoreWithEndpoint);
  }
}
