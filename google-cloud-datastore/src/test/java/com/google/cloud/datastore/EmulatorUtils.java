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
package com.google.cloud.datastore;

import com.google.common.io.CharStreams;
import org.easymock.EasyMock;
import org.easymock.IArgumentMatcher;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.function.Predicate;

public class EmulatorUtils {
  static String sendGetRequest(int port, String request) throws IOException {

    URL url = new URL("http", "localhost", port, request);
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");

    InputStream in = con.getInputStream();
    String response = CharStreams.toString(new InputStreamReader(con.getInputStream()));
    in.close();
    return response;
  }

  public static String checkHealth(int port) {
    try {
      return sendGetRequest(port, "/");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
