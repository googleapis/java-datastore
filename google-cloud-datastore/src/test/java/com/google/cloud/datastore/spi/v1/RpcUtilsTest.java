/*
 * Copyright 2023 Google LLC
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

import static com.google.api.gax.rpc.StatusCode.Code.ABORTED;
import static com.google.api.gax.rpc.StatusCode.Code.DEADLINE_EXCEEDED;
import static com.google.api.gax.rpc.StatusCode.Code.UNAVAILABLE;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.common.collect.Sets;
import org.junit.Test;

public class RpcUtilsTest {

  @Test
  public void testRetrySettingSetter() {
    DatastoreOptions datastoreOptions =
        DatastoreOptions.newBuilder().setProjectId("project-id").build();
    UnaryCallSettings.Builder<Object, Object> builder =
        UnaryCallSettings.newUnaryCallSettingsBuilder();

    RpcUtils.retrySettingSetter(datastoreOptions).apply(builder);

    assertThat(builder.getRetryableCodes())
        .isEqualTo(Sets.newHashSet(ABORTED, UNAVAILABLE, DEADLINE_EXCEEDED));
    assertThat(builder.getRetrySettings()).isEqualTo(datastoreOptions.getRetrySettings());
  }
}
