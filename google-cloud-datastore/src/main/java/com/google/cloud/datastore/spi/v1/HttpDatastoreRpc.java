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

package com.google.cloud.datastore.spi.v1;

import static com.google.cloud.datastore.DatastoreUtils.isLocalHost;
import static com.google.cloud.datastore.spi.v1.RpcUtils.retrySettingSetter;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.ClientContext;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import com.google.cloud.datastore.v1.stub.HttpJsonDatastoreStub;
import com.google.datastore.v1.AllocateIdsRequest;
import com.google.datastore.v1.AllocateIdsResponse;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.ReserveIdsRequest;
import com.google.datastore.v1.ReserveIdsResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.RunAggregationQueryRequest;
import com.google.datastore.v1.RunAggregationQueryResponse;
import com.google.datastore.v1.RunQueryRequest;
import com.google.datastore.v1.RunQueryResponse;
import java.io.IOException;

@InternalApi
public class HttpDatastoreRpc implements DatastoreRpc {

  private final ClientContext clientContext;
  private final HttpJsonDatastoreStub datastoreStub;

  private boolean closed;

  public HttpDatastoreRpc(DatastoreOptions datastoreOptions) throws IOException {
    DatastoreSettings datastoreSettings =
        new DatastoreSettingsBuilder(DatastoreSettings.newBuilder().build())
            .setInternalHeaderProvider(
                DatastoreStubSettings.defaultHttpJsonApiClientHeaderProviderBuilder().build())
            .setTransportChannelProvider(
                DatastoreStubSettings.defaultHttpJsonTransportProviderBuilder().build())
            .setEndpoint(getHost(datastoreOptions))
            .build();

    clientContext = ClientContext.create(datastoreSettings);

    DatastoreStubSettings datastoreStubSettings =
        DatastoreStubSettings.newBuilder(clientContext)
            .applyToAllUnaryMethods(retrySettingSetter(datastoreOptions))
            .build();

    datastoreStub = HttpJsonDatastoreStub.create(datastoreStubSettings);
  }

  @Override
  public AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    return this.datastoreStub.allocateIdsCallable().call(request);
  }

  @Override
  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request) {
    return this.datastoreStub.beginTransactionCallable().call(request);
  }

  @Override
  public CommitResponse commit(CommitRequest request) {
    return this.datastoreStub.commitCallable().call(request);
  }

  @Override
  public LookupResponse lookup(LookupRequest request) {
    return this.datastoreStub.lookupCallable().call(request);
  }

  @Override
  public ReserveIdsResponse reserveIds(ReserveIdsRequest request) {
    return this.datastoreStub.reserveIdsCallable().call(request);
  }

  @Override
  public RollbackResponse rollback(RollbackRequest request) {
    return this.datastoreStub.rollbackCallable().call(request);
  }

  @Override
  public RunQueryResponse runQuery(RunQueryRequest request) {
    return this.datastoreStub.runQueryCallable().call(request);
  }

  @Override
  public RunAggregationQueryResponse runAggregationQuery(RunAggregationQueryRequest request) {
    return this.datastoreStub.runAggregationQueryCallable().call(request);
  }

  @Override
  public void close() throws Exception {
    if (!closed) {
      datastoreStub.close();
      for (BackgroundResource resource : clientContext.getBackgroundResources()) {
        resource.close();
      }
      closed = true;
    }
    for (BackgroundResource resource : clientContext.getBackgroundResources()) {
      resource.awaitTermination(1, SECONDS);
    }
  }

  @Override
  public boolean isClosed() {
    return closed && datastoreStub.isShutdown();
  }

  /**
   * Prefixing it with http scheme when host is localhost, otherwise {@link
   * com.google.api.gax.httpjson.HttpRequestRunnable#normalizeEndpoint(String)} will prefix it with
   * https.
   */
  private String getHost(DatastoreOptions options) {
    String host = options.getHost();
    if (isLocalHost(host) && !host.contains("://")) {
      return "http://" + host;
    }
    return host;
  }
}
