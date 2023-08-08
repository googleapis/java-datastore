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

import com.google.common.truth.Truth;
import com.google.datastore.v1.EntityResult;
import com.google.datastore.v1.Filter;
import com.google.datastore.v1.KindExpression;
import com.google.datastore.v1.PartitionId;
import com.google.datastore.v1.PropertyFilter;
import com.google.datastore.v1.Query;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import com.google.datastore.v1.client.Datastore;
import com.google.datastore.v1.client.DatastoreException;
import com.google.datastore.v1.client.DatastoreHelper;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITDatastoreProtoClientTest {

  private static Datastore DATASTORE;
  private static Datastore DATASTORE_WITH_NAMED_DB;

  private static PartitionId PARTITION;

  private static final String KIND = "test-kind";
  private static final String PROJECT_ID = System.getenv(DatastoreHelper.PROJECT_ID_ENV_VAR);
  private static final String DATABASE_ID = "test-db";

  @Before
  public void setUp() throws GeneralSecurityException, IOException {
    DATASTORE = DatastoreHelper.getDatastoreFromEnv();
    DATASTORE_WITH_NAMED_DB = DatastoreHelper.getDatastoreFromEnv(DATABASE_ID);
  }

  @Test
  public void testDatastoreOptionsSimpleReadWrite() throws DatastoreException {
    Query.Builder queryBuilder =
        Query.newBuilder()
            .addKind(
                KindExpression.newBuilder()
                    .setName("Task" + UUID.randomUUID().toString().substring(0, 10))
                    .build());

    RunQueryRequest request =
        RunQueryRequest.newBuilder()
            .setProjectId(PROJECT_ID)
            .setPartitionId(PartitionId.newBuilder().build())
            .setReadOptions(ReadOptions.newBuilder().build())
            .setQuery(queryBuilder)
            .build();

    RunQueryResponse runQueryResponse = DATASTORE.runQuery(request);
    List<EntityResult> entityResultsList = runQueryResponse.getBatch().getEntityResultsList();
    Truth.assertThat(entityResultsList).isNotNull();
  }

  @Test
  public void testDatastoreOptionsSimpleReadWriteWithNamedDb() throws DatastoreException {
    Query.Builder queryBuilder =
        Query.newBuilder()
            .addKind(
                KindExpression.newBuilder()
                    .setName("Task" + UUID.randomUUID().toString().substring(0, 10))
                    .build());

    RunQueryRequest request =
        RunQueryRequest.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId(DATABASE_ID)
            .setPartitionId(PartitionId.newBuilder().build())
            .setReadOptions(ReadOptions.newBuilder().build())
            .setQuery(queryBuilder)
            .build();

    RunQueryResponse runQueryResponse = DATASTORE_WITH_NAMED_DB.runQuery(request);
    List<EntityResult> entityResultsList = runQueryResponse.getBatch().getEntityResultsList();
    Truth.assertThat(entityResultsList).isNotNull();
  }

  @Test
  public void testDatastoreOptionsDbMismatch() throws DatastoreException {
    Query.Builder queryBuilder =
        Query.newBuilder().addKind(KindExpression.newBuilder().setName("Person").build());

    RunQueryRequest request =
        RunQueryRequest.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId("new-db")
            .setPartitionId(PartitionId.newBuilder().build())
            .setReadOptions(ReadOptions.newBuilder().build())
            .setQuery(queryBuilder)
            .build();

    try {
      DATASTORE.runQuery(request);
      Assert.fail("should have thrown error");
    } catch (IllegalArgumentException e) {
      Truth.assertThat(e.getMessage())
          .isEqualTo(
              "database ids mismatched: request database id: new-db, DatastoreOptions db: null");
    }
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
    Truth.assertThat(splits).isNotEmpty();
    splits.forEach(
        split -> {
          Truth.assertThat(split.getKind(0).getName()).isEqualTo(KIND);
          Truth.assertThat(split.getFilter()).isEqualTo(propertyFilter);
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

    PARTITION =
        PartitionId.newBuilder().setProjectId(PROJECT_ID).setDatabaseId(DATABASE_ID).build();

    List<Query> splits =
        DatastoreHelper.getQuerySplitter().getSplits(query, PARTITION, 2, DATASTORE_WITH_NAMED_DB);

    Truth.assertThat(splits).isNotEmpty();
    splits.forEach(
        split -> {
          Truth.assertThat(split.getKind(0).getName()).isEqualTo(KIND);
          Truth.assertThat(split.getFilter()).isEqualTo(propertyFilter);
        });
  }
}
