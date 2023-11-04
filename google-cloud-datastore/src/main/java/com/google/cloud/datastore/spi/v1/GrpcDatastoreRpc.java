package com.google.cloud.datastore.spi.v1;

import com.google.api.gax.rpc.ClientContext;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import com.google.cloud.datastore.v1.stub.GrpcDatastoreStub;
import com.google.cloud.grpc.GrpcTransportOptions;
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

//TODO(gapic_upgrade): Make it implement AutoCloseable
public class GrpcDatastoreRpc implements DatastoreRpc{

  private final GrpcDatastoreStub datastoreStub;

  public GrpcDatastoreRpc(DatastoreOptions datastoreOptions) throws IOException {

    try {
      DatastoreSettings datastoreSettings = DatastoreSettings.newBuilder()
          .setCredentialsProvider(GrpcTransportOptions.setUpCredentialsProvider(datastoreOptions))
          .setTransportChannelProvider(GrpcTransportOptions.setUpChannelProvider(DatastoreSettings.defaultGrpcTransportProviderBuilder(), datastoreOptions))
      //TODO(gapic_upgrade): setup internal header provider
          .build();

      ClientContext clientContext = ClientContext.create(datastoreSettings);

      //TODO(gapic_upgrade): retry settings

      DatastoreStubSettings datastoreStubSettings = DatastoreStubSettings.newBuilder(clientContext).build();
      datastoreStub = GrpcDatastoreStub.create(datastoreStubSettings);
    } catch (IOException e) {
      throw new IOException(e);
    }
  }

  @Override
  public AllocateIdsResponse allocateIds(AllocateIdsRequest request) {
    return datastoreStub.allocateIdsCallable().call(request);
  }

  @Override
  public BeginTransactionResponse beginTransaction(BeginTransactionRequest request) throws DatastoreException {
    return datastoreStub.beginTransactionCallable().call(request);
  }

  @Override
  public CommitResponse commit(CommitRequest request) {
    return datastoreStub.commitCallable().call(request);
  }

  @Override
  public LookupResponse lookup(LookupRequest request) {
    return datastoreStub.lookupCallable().call(request);
  }

  @Override
  public ReserveIdsResponse reserveIds(ReserveIdsRequest request) {
    return datastoreStub.reserveIdsCallable().call(request);
  }

  @Override
  public RollbackResponse rollback(RollbackRequest request) {
    return datastoreStub.rollbackCallable().call(request);
  }

  @Override
  public RunQueryResponse runQuery(RunQueryRequest request) {
    return datastoreStub.runQueryCallable().call(request);
  }

  @Override
  public RunAggregationQueryResponse runAggregationQuery(RunAggregationQueryRequest request) {
    return datastoreStub.runAggregationQueryCallable().call(request);
  }
}
