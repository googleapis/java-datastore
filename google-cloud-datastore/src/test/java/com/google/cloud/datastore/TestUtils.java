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

import com.google.datastore.v1.RunAggregationQueryRequest;
import java.util.function.Predicate;
import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;

public class TestUtils {

  public static <T> T matches(Predicate<T> predicate) {
    EasyMock.reportMatcher(new IArgumentMatcher() {
      @Override
      public boolean matches(Object argument) {
        return predicate.test(((T) argument));
      }

      @Override
      public void appendTo(StringBuffer buffer) {
        buffer.append("matches(\"").append(predicate).append("\")");
      }
    });
    return null;
  }


}
