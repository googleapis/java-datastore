/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.datastore;

import com.google.cloud.datastore.ReadOption.EventualConsistency;
import com.google.cloud.datastore.ReadOption.ReadTime;
import com.google.cloud.datastore.execution.request.ProtoPreparer;
import com.google.datastore.v1.ReadOptions;
import com.google.datastore.v1.ReadOptions.ReadConsistency;
import java.util.List;
import java.util.Map;

public class ReadOptionProtoPreparer implements ProtoPreparer<List<ReadOption>, ReadOptions> {

  @Override
  public ReadOptions prepare(List<ReadOption> options) {
    com.google.datastore.v1.ReadOptions readOptionsPb = null;
    if (options != null && !options.isEmpty()) {
      Map<Class<? extends ReadOption>, ReadOption> optionsByType =
          ReadOption.asImmutableMap(options);

      if (optionsByType.containsKey(EventualConsistency.class)
          && optionsByType.containsKey(ReadTime.class)) {
        throw DatastoreException.throwInvalidRequest(
            "Can not use eventual consistency read with read time.");
      }

      if (optionsByType.containsKey(EventualConsistency.class)) {
        readOptionsPb = ReadOptions.newBuilder()
            .setReadConsistency(ReadConsistency.EVENTUAL)
            .build();
      }

      if (optionsByType.containsKey(ReadTime.class)) {
        readOptionsPb = ReadOptions.newBuilder()
            .setReadTime(((ReadTime) optionsByType.get(ReadTime.class)).time().toProto())
            .build();
      }
    }
    return readOptionsPb;
  }
}
