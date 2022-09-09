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

import static com.google.cloud.datastore.ProtoTestData.gqlQueryParameter;
import static com.google.cloud.datastore.ProtoTestData.intValue;
import static com.google.cloud.datastore.ProtoTestData.stringValue;
import static com.google.cloud.datastore.Query.newGqlQueryBuilder;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.google.datastore.v1.GqlQueryParameter;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class GqlQueryProtoPreparerTest {

  private final GqlQueryProtoPreparer protoPreparer = new GqlQueryProtoPreparer();
  private final GqlQuery.Builder<?> gqlQueryBuilder = newGqlQueryBuilder("SELECT * from Character");

  @Test
  public void testQueryString() {
    com.google.datastore.v1.GqlQuery gqlQuery = protoPreparer.prepare(gqlQueryBuilder.build());

    assertThat(gqlQuery.getQueryString(), equalTo("SELECT * from Character"));
  }

  @Test
  public void testAllowLiteral() {
    assertTrue(protoPreparer.prepare(
        gqlQueryBuilder.setAllowLiteral(true).build()).getAllowLiterals());
    assertFalse(protoPreparer.prepare(
        gqlQueryBuilder.setAllowLiteral(false).build()).getAllowLiterals());
  }

  @Test
  public void testNamedBinding() {
    com.google.datastore.v1.GqlQuery gqlQuery = protoPreparer.prepare(
        gqlQueryBuilder
            .setBinding("name", "John Doe")
            .setBinding("age", 27)
            .build()
    );

    assertThat(gqlQuery.getNamedBindingsMap(), equalTo(new HashMap<String, GqlQueryParameter>() {{
      put("name", gqlQueryParameter(stringValue("John Doe")));
      put("age", gqlQueryParameter(intValue(27)));
    }}));
  }

  @Test
  public void testPositionalBinding() {
    com.google.datastore.v1.GqlQuery gqlQuery = protoPreparer.prepare(
        gqlQueryBuilder
            .addBinding("John Doe")
            .addBinding(27)
            .build()
    );

    assertThat(gqlQuery.getPositionalBindingsList(), equalTo(asList(
        gqlQueryParameter(stringValue("John Doe")),
        gqlQueryParameter(intValue(27))
    )));
  }

}