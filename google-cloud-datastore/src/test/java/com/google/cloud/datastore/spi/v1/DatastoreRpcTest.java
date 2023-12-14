package com.google.cloud.datastore.spi.v1;

import static com.google.api.gax.rpc.StatusCode.Code.ABORTED;
import static com.google.api.gax.rpc.StatusCode.Code.DEADLINE_EXCEEDED;
import static com.google.api.gax.rpc.StatusCode.Code.UNAVAILABLE;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.common.collect.Sets;
import org.junit.Test;

public class DatastoreRpcTest {

  @Test
  public void testRetrySettingSetter() {
    DatastoreOptions datastoreOptions = DatastoreOptions.getDefaultInstance();
    UnaryCallSettings.Builder<Object, Object> builder =
        UnaryCallSettings.newUnaryCallSettingsBuilder();

    DatastoreRpc.retrySettingSetter(datastoreOptions).apply(builder);

    assertThat(builder.getRetryableCodes())
        .isEqualTo(Sets.newHashSet(ABORTED, UNAVAILABLE, DEADLINE_EXCEEDED));
    assertThat(builder.getRetrySettings()).isEqualTo(datastoreOptions.getRetrySettings());
  }
}
