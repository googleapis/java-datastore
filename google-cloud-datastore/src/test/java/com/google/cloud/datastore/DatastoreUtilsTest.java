package com.google.cloud.datastore;

import static com.google.cloud.datastore.DatastoreUtils.isLocalHost;
import static com.google.cloud.datastore.DatastoreUtils.removeScheme;
import static com.google.common.truth.Truth.assertThat;

import org.junit.Test;

public class DatastoreUtilsTest {

  @Test
  public void testIsLocalHost() {
    assertThat(isLocalHost(null)).isFalse();
    assertThat(isLocalHost("")).isFalse();
    assertThat(isLocalHost("http://localhost:9090")).isTrue();
    assertThat(isLocalHost("https://localhost:9090")).isTrue();
    assertThat(isLocalHost("10.10.10.10:9090")).isFalse();
  }

  @Test
  public void testRemoveScheme() {
    assertThat(removeScheme("http://localhost:9090")).isEqualTo("localhost:9090");
    assertThat(removeScheme("https://localhost:9090")).isEqualTo("localhost:9090");
    assertThat(removeScheme("https://localhost:9090")).isEqualTo("localhost:9090");
  }
}
