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

import com.google.api.core.BetaApi;
import com.google.cloud.datastore.Query.ResultType;
import com.google.cloud.datastore.models.ResultSetStats;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.datastore.v1.QueryMode;
import com.google.datastore.v1.QueryResultBatch.MoreResultsType;
import com.google.datastore.v1.ReadOptions;
import com.google.protobuf.ByteString;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

class QueryResultsImpl<T> extends AbstractIterator<T> implements QueryResults<T> {

  private final DatastoreImpl datastore;
  private final Optional<ReadOptions> readOptionsPb;
  private final com.google.datastore.v1.PartitionId partitionIdPb;
  private final ResultType<T> queryResultType;
  private RecordQuery<T> query;
  private ResultType<?> actualResultType;
  private com.google.datastore.v1.RunQueryResponse runQueryResponsePb;
  private com.google.datastore.v1.Query mostRecentQueryPb;
  private boolean lastBatch;
  private Iterator<com.google.datastore.v1.EntityResult> entityResultPbIter;
  private ByteString cursor;
  private MoreResultsType moreResults;
  private QueryMode queryMode;
  private ResultSetStats resultSetStats;

  QueryResultsImpl(
      DatastoreImpl datastore,
      Optional<ReadOptions> readOptionsPb,
      RecordQuery<T> query,
      String namespace,
      QueryMode queryMode) {
    this.datastore = datastore;
    this.readOptionsPb = readOptionsPb;
    this.query = query;
    queryResultType = query.getType();
    this.queryMode = queryMode;
    com.google.datastore.v1.PartitionId.Builder pbBuilder =
        com.google.datastore.v1.PartitionId.newBuilder();
    pbBuilder.setProjectId(datastore.getOptions().getProjectId());
    pbBuilder.setDatabaseId(datastore.getOptions().getDatabaseId());
    if (namespace != null) {
      pbBuilder.setNamespaceId(namespace);
    } else if (datastore.getOptions().getNamespace() != null) {
      pbBuilder.setNamespaceId(datastore.getOptions().getNamespace());
    }
    partitionIdPb = pbBuilder.build();
    sendRequest();
    if (runQueryResponsePb.getBatch().getSkippedResults() > 0) {
      cursor = runQueryResponsePb.getBatch().getSkippedCursor();
    } else {
      cursor = mostRecentQueryPb.getStartCursor();
    }
  }

  private void sendRequest() {
    com.google.datastore.v1.RunQueryRequest.Builder requestPb =
        com.google.datastore.v1.RunQueryRequest.newBuilder();
    readOptionsPb.ifPresent(requestPb::setReadOptions);
    requestPb.setPartitionId(partitionIdPb);
    requestPb.setProjectId(datastore.getOptions().getProjectId());
    requestPb.setDatabaseId(datastore.getOptions().getDatabaseId());
    requestPb.setMode(queryMode);
    query.populatePb(requestPb);
    runQueryResponsePb = datastore.runQuery(requestPb.build());
    mostRecentQueryPb = requestPb.getQuery();
    moreResults = runQueryResponsePb.getBatch().getMoreResults();
    lastBatch = moreResults != MoreResultsType.NOT_FINISHED;
    entityResultPbIter = runQueryResponsePb.getBatch().getEntityResultsList().iterator();
    actualResultType = ResultType.fromPb(runQueryResponsePb.getBatch().getEntityResultType());
    if (Objects.equals(queryResultType, ResultType.PROJECTION_ENTITY)) {
      // projection entity can represent all type of results
      actualResultType = ResultType.PROJECTION_ENTITY;
    }
    boolean isQueryPlan = actualResultType.getQueryType() == null && queryMode == QueryMode.PLAN;
    Preconditions.checkState(
        queryResultType.isAssignableFrom(actualResultType) || isQueryPlan,
        "Unexpected result type or query mode. Result type: "
            + actualResultType
            + " vs "
            + queryResultType
            + ", query mode: "
            + queryMode);

    if (runQueryResponsePb.getStats().hasQueryPlan()
        || runQueryResponsePb.getStats().hasQueryStats()) {
      this.resultSetStats = new ResultSetStats(runQueryResponsePb.getStats());
    }
  }

  @Override
  protected T computeNext() {
    while (!entityResultPbIter.hasNext() && !lastBatch) {
      query = query.nextQuery(runQueryResponsePb);
      sendRequest();
    }
    if (!entityResultPbIter.hasNext()) {
      cursor = runQueryResponsePb.getBatch().getEndCursor();
      return endOfData();
    }
    com.google.datastore.v1.EntityResult entityResultPb = entityResultPbIter.next();
    cursor = entityResultPb.getCursor();
    @SuppressWarnings("unchecked")
    T result = (T) actualResultType.convert(entityResultPb.getEntity());
    return result;
  }

  @Override
  public Class<?> getResultClass() {
    return actualResultType.resultClass();
  }

  @Override
  public Cursor getCursorAfter() {
    return new Cursor(cursor);
  }

  @Override
  public int getSkippedResults() {
    return runQueryResponsePb.getBatch().getSkippedResults();
  }

  @Override
  public MoreResultsType getMoreResults() {
    return moreResults;
  }

  @Override
  @BetaApi
  public Optional<ResultSetStats> getResultSetStats() {
    return Optional.ofNullable(this.resultSetStats);
  }
}
