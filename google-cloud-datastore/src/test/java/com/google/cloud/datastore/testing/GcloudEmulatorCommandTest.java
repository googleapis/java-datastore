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
package com.google.cloud.datastore.testing;

import static com.google.common.truth.Truth.assertThat;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class GcloudEmulatorCommandTest {

  private static Path TEMP_DIR = new File(System.getProperty("java.io.tmpdir")).toPath();

  private List<String> gcloudEmulatorCommand;

  @Before
  public void setUp() throws Exception {
    LocalDatastoreHelper.Builder builder =
        LocalDatastoreHelper.newBuilder()
            .setConsistency(0.75)
            .setPort(8081)
            .setProjectId("my-project-id")
            .setDataDir(TEMP_DIR);

    gcloudEmulatorCommand = GcloudEmulatorCommand.get(builder, 8080);
  }

  @Test
  public void binNameWithDatastoreEmulatorStartOption() {
    String commandText = String.join(" ", gcloudEmulatorCommand);
    assertThat(commandText.startsWith("gcloud --quiet beta emulators datastore start")).isTrue();
  }

  @Test
  public void portFlag() {
    assertThat(gcloudEmulatorCommand.contains("--host-port=localhost:8080")).isTrue();
  }

  @Test
  public void consistencyFlag() {
    assertThat(gcloudEmulatorCommand.contains("--consistency=0.75")).isTrue();
  }

  @Test
  public void projectIdFlag() {
    assertThat(gcloudEmulatorCommand.contains("--project=my-project-id")).isTrue();
  }

  @Test
  public void defaultProjectIdFlag() {
    LocalDatastoreHelper.Builder builder = LocalDatastoreHelper.newBuilder().setProjectId(null);

    assertThat(
            GcloudEmulatorCommand.get(builder, 0).stream()
                .anyMatch(s -> s.startsWith("--project=test-project")))
        .isTrue();
  }

  @Test
  public void dataDirFlag() {
    assertThat(gcloudEmulatorCommand.contains("--data-dir=" + TEMP_DIR)).isTrue();
  }

  @Test
  public void NoStoreOnDiskFlagShouldBeAbsent() {
    assertThat(gcloudEmulatorCommand.contains("--no-store-on-disk")).isFalse();
  }

  @Test
  public void NoStoreOnDiskFlagShouldBePresent() {
    LocalDatastoreHelper.Builder builder = LocalDatastoreHelper.newBuilder().setStoreOnDisk(false);

    assertThat(GcloudEmulatorCommand.get(builder, 0).contains("--no-store-on-disk")).isTrue();
  }
}
