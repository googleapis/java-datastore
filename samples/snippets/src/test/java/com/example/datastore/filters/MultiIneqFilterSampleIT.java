/*
 * Copyright 2024 Google LLC
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

package com.example.datastore.filters;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.StructuredQuery.CompositeFilter;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
import com.rule.SystemsOutRule;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class MultiIneqFilterSampleIT {
  private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
  private Key taskKey1;
  private Key taskKey2;
  private Key taskKey3;

  @Rule
  public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  @Before
  public void setUp() {
    taskKey1 = datastore.newKeyFactory().setKind("Task").newKey("key1");
    Entity task1 = Entity.newBuilder(taskKey1)
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 4)
        .set("days", 3)
        .set("description", "Learn Cloud Datastore")
        .build();

    taskKey2 = datastore.newKeyFactory().setKind("Task").newKey("key2");
    Entity task2 = Entity.newBuilder(taskKey2)
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 5)
        .set("days", 5)
        .set("description", "Integrate Cloud Datastore")
        .build();

    taskKey3 = datastore.newKeyFactory().setKind("Task").newKey("key3");
    Entity task3 = Entity.newBuilder(taskKey3)
        .set("category", "Personal")
        .set("done", false)
        .set("priority", 5)
        .set("days", 2)
        .set("description", "Set Up Cloud Datastore")
        .build();

    datastore.put(task1);
    datastore.put(task2);
    datastore.put(task3);
  }

  @After
  public void tearDown() {
    datastore.delete(taskKey1);
    datastore.delete(taskKey2);
    datastore.delete(taskKey3);
  }

  @Test
  public void testMultiIneqFilter() throws Exception {
    List<Entity> results = MultiIneqFilter.invoke();

    assertEquals(3, results.size());
    assertEquals("Learn Cloud Datastore", results.get(0).getString("description"));
  }
}
