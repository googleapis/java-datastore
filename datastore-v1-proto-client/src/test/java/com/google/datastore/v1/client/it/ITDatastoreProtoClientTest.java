/*
 * Copyright 2022 Google LLC
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
package com.google.datastore.v1.client.it;

import static com.google.datastore.v1.client.DatastoreHelper.makeFilter;
import static com.google.datastore.v1.client.DatastoreHelper.makeValue;

import com.google.datastore.v1.Filter;
import com.google.datastore.v1.KindExpression;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.PropertyFilter;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.client.Datastore;
import com.google.datastore.v1.client.DatastoreException;
import com.google.datastore.v1.client.DatastoreHelper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITDatastoreProtoClientTest {

  private static Datastore DATASTORE;

  private static PartitionId PARTITION;

  private static final String KIND = "test-kind";
  private static final String PROJECT_ID = System.getenv(DatastoreHelper.PROJECT_ID_ENV_VAR);

  @Before
  public void setUp() throws GeneralSecurityException, IOException {
    DATASTORE = DatastoreHelper.getDatastoreFromEnv();
  }

  @Test
  public void testQuerySplitterWithDefaultDb() throws DatastoreException {
    Filter propertyFilter =
        makeFilter("foo", PropertyFilter.Operator.EQUAL, makeValue("value")).build();
    Query query =
        Query.newBuilder()
            .addKind(KindExpression.newBuilder().setName(KIND).build())
            .setFilter(propertyFilter)
            .build();

    PARTITION = PartitionId.newBuilder().setProjectId(PROJECT_ID).build();

    List<Query> splits =
        DatastoreHelper.getQuerySplitter().getSplits(query, PARTITION, 2, DATASTORE);
    splits.forEach(
        split -> {
          Assert.assertEquals(KIND, split.getKind(0).getName());
          Assert.assertEquals(propertyFilter, split.getFilter());
        });
  }

  @Test
  public void testQuerySplitterWithDb() throws DatastoreException {
    Filter propertyFilter =
        makeFilter("foo", PropertyFilter.Operator.EQUAL, makeValue("value")).build();
    Query query =
        Query.newBuilder()
            .addKind(KindExpression.newBuilder().setName(KIND).build())
            .setFilter(propertyFilter)
            .build();

    PARTITION = PartitionId.newBuilder().setProjectId(PROJECT_ID).setDatabaseId("test-db").build();

    List<Query> splits =
        DatastoreHelper.getQuerySplitter().getSplits(query, PARTITION, 2, DATASTORE);
    splits.forEach(
        split -> {
          Assert.assertEquals(KIND, split.getKind(0).getName());
          Assert.assertEquals(propertyFilter, split.getFilter());
        });
  }
}
