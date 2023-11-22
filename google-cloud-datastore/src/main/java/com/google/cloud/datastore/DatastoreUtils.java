package com.google.cloud.datastore;

import com.google.api.core.InternalApi;
import com.google.common.base.Strings;
import java.net.InetAddress;
import java.net.URL;

@InternalApi
public class DatastoreUtils {

  public static boolean isLocalHost(String host) {
    if (Strings.isNullOrEmpty(host)) {
      return false;
    }
    try {
      String normalizedHost = "http://" + removeScheme(host);
      InetAddress hostAddr = InetAddress.getByName(new URL(normalizedHost).getHost());
      return hostAddr.isAnyLocalAddress() || hostAddr.isLoopbackAddress();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String removeScheme(String url) {
    if (url != null) {
      if (url.startsWith("https://")) {
        return url.substring("https://".length());
      } else if (url.startsWith("http://")) {
        return url.substring("http://".length());
      }
    }
    return url;
  }
}
