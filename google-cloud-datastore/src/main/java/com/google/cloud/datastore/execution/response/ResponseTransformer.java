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
package com.google.cloud.datastore.execution.response;

import com.google.api.core.InternalApi;

/**
 * An internal functional interface whose implementation has the responsibility to populate a Domain
 * object from a proto response.
 *
 * @param <INPUT> the type of proto response object.
 * @param <OUTPUT> the type of domain object.
 */
@InternalApi
public interface ResponseTransformer<INPUT, OUTPUT> {
  OUTPUT transform(INPUT response);
}
