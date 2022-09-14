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

import static com.google.cloud.datastore.ReadOption.eventualConsistency;
import static com.google.cloud.datastore.ReadOption.readTime;
import static com.google.datastore.v1.ReadOptions.ReadConsistency.EVENTUAL;
import static java.util.Collections.singletonList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import com.google.cloud.Timestamp;
import com.google.common.collect.ImmutableList;
import com.google.datastore.v1.ReadOptions;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Test;

public class ReadOptionProtoPreparerTest {

  private ReadOptionProtoPreparer protoPreparer = new ReadOptionProtoPreparer();

  @Test
  public void shouldThrowErrorWhenUsingEventualConsistencyWithReadTime() {
    assertThrows("Can not use eventual consistency read with read time.",
        DatastoreException.class,
        () -> protoPreparer.prepare(
            Arrays.asList(eventualConsistency(), readTime(Timestamp.now()))));
  }

  @Test
  public void shouldPrepareReadOptionsWithEventualConsistency() {
    ReadOptions readOptions = protoPreparer.prepare(singletonList(eventualConsistency()));

    assertThat(readOptions.getReadConsistency(), is(EVENTUAL));
  }

  @Test
  public void shouldPrepareReadOptionsWithReadTime() {
    Timestamp timestamp = Timestamp.now();
    ReadOptions readOptions = protoPreparer.prepare(singletonList(readTime(timestamp)));

    assertThat(Timestamp.fromProto(readOptions.getReadTime()), is(timestamp));
  }

  @Test
  public void shouldReturnNullWhenReadOptionsIsNull() {
    assertNull(protoPreparer.prepare(null));
  }

  @Test
  public void shouldReturnNullWhenReadOptionsIsAnEmptyList() {
    assertNull(protoPreparer.prepare(ImmutableList.of()));
  }
}