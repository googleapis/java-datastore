/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.datastore.models;

import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;

public class ExplainOptions {
  private final com.google.datastore.v1.ExplainOptions proto;

  private ExplainOptions(com.google.datastore.v1.ExplainOptions proto) {
    this.proto = proto;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public boolean shouldAnalyze() {
    return proto.getAnalyze();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ExplainOptions)) return false;
    ExplainOptions that = (ExplainOptions) o;
    return proto.equals(that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }

  @InternalApi
  @VisibleForTesting
  public com.google.datastore.v1.ExplainOptions toPb() {
    return this.proto;
  }

  public static class Builder {
    private boolean analyze = false;

    public Builder setAnalyze(boolean analyze) {
      this.analyze = analyze;
      return this;
    }

    public ExplainOptions build() {
      return new ExplainOptions(
          com.google.datastore.v1.ExplainOptions.newBuilder().setAnalyze(this.analyze).build());
    }
  }
}
