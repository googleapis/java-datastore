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

package com.example.datastore.vectorsearch;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.VectorValue;
import com.rule.SystemsOutRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class VectorSearchSampleIT {
  private final Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

  private Key coffeeBeanKey1;
  private Key coffeeBeanKey2;
  private Key coffeeBeanKey3;

  @Rule public final SystemsOutRule systemsOutRule = new SystemsOutRule();

  @Before
  public void setUp() {
    // DatastoreOptions.getDefaultHttpTransportOptions()
    coffeeBeanKey1 = datastore.newKeyFactory().setKind("CoffeeBean").newKey("Kahawa");
    // Prepares the entity with a vector embedding
    Entity entity1 =
        Entity.newBuilder(coffeeBeanKey1)
            .set("name", "Arabica")
            .set("description", "Information about the Arabica coffee beans.")
            .set("roast", "dark")
            .set("embedding_field", VectorValue.newBuilder(1.0, 7.0, 11.1).build())
            .build();

    coffeeBeanKey2 = datastore.newKeyFactory().setKind("CoffeeBean").newKey("Robusta");
    Entity entity2 =
        Entity.newBuilder(coffeeBeanKey2)
            .set("name", "Robusta")
            .set("description", "Information about the Robusta coffee beans.")
            .set("roast", "light")
            .set("embedding_field", VectorValue.newBuilder(1.0, 9.0, 11.1).build())
            .build();

    coffeeBeanKey3 = datastore.newKeyFactory().setKind("CoffeeBean").newKey("Excelsa");
    Entity entity3 =
        Entity.newBuilder(coffeeBeanKey3)
            .set("name", "Excelsa")
            .set("description", "Information about the Excelsa coffee beans.")
            .set("roast", "dark")
            .set("embedding_field", VectorValue.newBuilder(4.0, 9.0, 11.1).build())
            .build();

    datastore.put(entity1);
    datastore.put(entity2);
    datastore.put(entity3);
  }

  @After
  public void tearDown() {
    datastore.delete(coffeeBeanKey1);
    datastore.delete(coffeeBeanKey2);
    datastore.delete(coffeeBeanKey3);
  }

  @Test
  public void testStoreVectors() throws Exception {
    // Act
    StoreVectors.invoke();
    // Assert
    systemsOutRule.assertContains("Retrieved Kahawa with embedding_field");
  }

  @Test
  public void testVectorSearchBasic() throws Exception {
    // Act
    VectorSearchBasic.invoke();
    // Assert
    systemsOutRule.assertContains("Entity: Robusta");
  }

  @Test
  public void testVectorSearchDistanceResultProperty() throws Exception {
    // Act
    VectorSearchDistanceResultProperty.invoke();
    // Assert
    systemsOutRule.assertContains("Entity: Excelsa, Distance: 208");
    systemsOutRule.assertContains("Entity: Robusta, Distance: 205");
    systemsOutRule.assertContains("Entity: Kahawa, Distance: 187");
  }

  @Test
  public void testVectorSearchDistanceResultPropertyProjection() throws Exception {
    // Act
    VectorSearchDistanceResultPropertyProjection.invoke();
    // Assert
    systemsOutRule.assertContains("Entity: Robusta, Distance: 0.0");
    systemsOutRule.assertContains("Entity: Kahawa, Distance: 2.0");
    systemsOutRule.assertContains("Entity: Excelsa, Distance: 3.0");
  }

  @Test
  public void testVectorSearchDistanceThreshold() throws Exception {
    // Act
    VectorSearchDistanceThreshold.invoke();
    // Assert
    systemsOutRule.assertContains("Entity: Robusta, Distance: 0.0");
    systemsOutRule.assertContains("Entity: Kahawa, Distance: 2.0");
  }

  @Test
  public void testVectorSearchLargeResponse() throws Exception {
    // Act
    VectorSearchLargeResponse.invoke();
    // Assert
    systemsOutRule.assertContains("Key query result size: 2");
    systemsOutRule.assertContains("Entity query result size: 2");
    systemsOutRule.assertContains("Entity: Robusta, Distance: 0.0, Roast: dark");
    systemsOutRule.assertContains("Entity: Kahawa, Distance: 2.0, Roast: light");
  }

  @Test
  public void testVectorSearchPrefilter() throws Exception {
    // Act
    VectorSearchPrefilter.invoke();
    // Assert
    systemsOutRule.assertContains("Entity: Kahawa, Distance: 2.0");
    systemsOutRule.assertContains("Entity: Excelsa, Distance: 3.0");
  }
}
