/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.datastore.it;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.testing.RemoteDatastoreHelper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MultiDbRule implements TestRule {

  private static final String CUSTOM_DB_ID = "test-db";
  private static final Logger logger = Logger.getLogger(MultiDbRule.class.getName());

  private final RemoteDatastoreHelper HELPER_1;
  private final DatastoreOptions OPTIONS_1;
  private final Datastore DATASTORE_1;
  private final RemoteDatastoreHelper HELPER_2;
  private final DatastoreOptions OPTIONS_2;
  private final Datastore DATASTORE_2;

  private Datastore currentDatastore;
  private DatastoreOptions currentDatastoreOptions;

  public MultiDbRule() {
    HELPER_1 = RemoteDatastoreHelper.create();
    OPTIONS_1 = HELPER_1.getOptions();

    HELPER_2 = RemoteDatastoreHelper.create(CUSTOM_DB_ID);
    OPTIONS_2 = HELPER_2.getOptions();

    DATASTORE_1 = OPTIONS_1.getService();
    DATASTORE_2 = OPTIONS_2.getService();
    this.currentDatastore = DATASTORE_1;
    this.currentDatastoreOptions = OPTIONS_1;
  }

  @Override
  public Statement apply(Statement base, Description description) {
    return new Statement() {
      @Override
      public void evaluate() throws Throwable {
        try {
          String testName = description.getDisplayName();
          // running with default Datastore
          logger.log(
              Level.INFO, "Running {0} with database {1}", new Object[] {testName, "default"});
          base.evaluate();

          // running with test-db Datastore
          logger.log(
              Level.INFO, "Running {0} with database {1}", new Object[] {testName, CUSTOM_DB_ID});
          MultiDbRule.this.currentDatastore = DATASTORE_2;
          MultiDbRule.this.currentDatastoreOptions = OPTIONS_2;
          base.evaluate();

        } finally {
          HELPER_1.deleteNamespace();
          HELPER_2.deleteNamespace();
          DATASTORE_1.close();
          DATASTORE_2.close();
        }
      }
    };
  }

  public Datastore getDatastore() {
    return this.currentDatastore;
  }

  public DatastoreOptions getCurrentOptions() {
    return this.currentDatastoreOptions;
  }
}
