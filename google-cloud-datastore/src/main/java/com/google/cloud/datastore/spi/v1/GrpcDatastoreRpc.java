package com.google.cloud.datastore.spi.v1;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.NoHeaderProvider;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datastore.DatastoreException;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.v1.DatastoreSettings;
import com.google.cloud.datastore.v1.stub.DatastoreStubSettings;
import com.google.cloud.datastore.v1.stub.GrpcDatastoreStub;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.common.base.Strings;
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
import io.grpc.CallOptions;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.io.IOException;
import java.util.Collections;

//TODO(gapic_upgrade): Make it implement AutoCloseable
public class GrpcDatastoreRpc implements DatastoreRpc {

  private final GrpcDatastoreStub datastoreStub;

  public GrpcDatastoreRpc(DatastoreOptions datastoreOptions) throws IOException {

    try {
      ClientContext clientContext = isEmulator(datastoreOptions) ?
          getClientContextForEmulator(datastoreOptions) :
          getClientContext(datastoreOptions);
      ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> retrySettingsSetter =
          builder -> {
            builder.setRetrySettings(datastoreOptions.getRetrySettings());
            return null;
          };
      DatastoreStubSettings datastoreStubSettings = DatastoreStubSettings.newBuilder(clientContext)
          .applyToAllUnaryMethods(retrySettingsSetter)
          .build();
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

  private boolean isEmulator(DatastoreOptions datastoreOptions) {
    return datastoreOptions.getHost().contains("localhost")
        || NoCredentials.getInstance().equals(datastoreOptions.getCredentials());
  }

  private ClientContext getClientContextForEmulator(DatastoreOptions datastoreOptions) throws IOException {
    ManagedChannel managedChannel =
        ManagedChannelBuilder.forTarget(datastoreOptions.getHost())
            .usePlaintext()
            .build();
    TransportChannel transportChannel = GrpcTransportChannel.create(managedChannel);
    return ClientContext.newBuilder()
        .setCredentials(null)
        .setTransportChannel(transportChannel)
        .setDefaultCallContext(GrpcCallContext.of(managedChannel, CallOptions.DEFAULT))
        .setBackgroundResources(Collections.singletonList(transportChannel))
        .build();
  }

  private ClientContext getClientContext(DatastoreOptions datastoreOptions) throws IOException {
    HeaderProvider internalHeaderProvider =
        DatastoreSettings.defaultApiClientHeaderProviderBuilder()
            .setClientLibToken(
                ServiceOptions.getGoogApiClientLibName(),
                GaxProperties.getLibraryVersion(datastoreOptions.getClass()))
            .setResourceToken(getResourceToken(datastoreOptions))
            .build();

    DatastoreSettingsBuilder settingsBuilder = new DatastoreSettingsBuilder(DatastoreSettings.newBuilder().build());
    settingsBuilder.setCredentialsProvider(GrpcTransportOptions.setUpCredentialsProvider(datastoreOptions));
    settingsBuilder.setTransportChannelProvider(GrpcTransportOptions.setUpChannelProvider(DatastoreSettings.defaultGrpcTransportProviderBuilder(), datastoreOptions));
    settingsBuilder.setInternalHeaderProvider(internalHeaderProvider);
    settingsBuilder.setHeaderProvider(datastoreOptions.getMergedHeaderProvider(new NoHeaderProvider()));
    ClientContext clientContext = ClientContext.create(settingsBuilder.build());
    return clientContext;
  }

  private String getResourceToken(DatastoreOptions datastoreOptions) {
    StringBuilder builder = new StringBuilder("project_id=");
    builder.append(datastoreOptions.getProjectId());
    if (!Strings.isNullOrEmpty(datastoreOptions.getDatabaseId())) {
      builder.append("&database_id=");
      builder.append(datastoreOptions.getDatabaseId());
    }
    return builder.toString();
  }

  // This class is needed solely to get access to protected method setInternalHeaderProvider()
  private static class DatastoreSettingsBuilder extends DatastoreSettings.Builder {

    private DatastoreSettingsBuilder(DatastoreSettings settings) {
      super(settings);
    }

    @Override
    protected DatastoreSettings.Builder setInternalHeaderProvider(
        HeaderProvider internalHeaderProvider) {
      return super.setInternalHeaderProvider(internalHeaderProvider);
    }

  }
}
