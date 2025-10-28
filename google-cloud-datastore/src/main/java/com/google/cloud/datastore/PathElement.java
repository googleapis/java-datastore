/*
 * Copyright 2015 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.datastore;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.Objects;

/** Represents a single element in a key's path. */
public final class PathElement implements Serializable {

  private static final long serialVersionUID = -777300414390493910L;

  private final String kind;
  private final Long id;
  private final String name;

  private PathElement(String kind, String name, Long id) {
    this.kind = checkNotNull(kind, "kind must not be null");
    this.name = name;
    this.id = id;
  }

  /** Returns the kind of this path element. */
  public String getKind() {
    return kind;
  }

  public boolean hasId() {
    return id != null;
  }

  /** Returns the ID of this path element. */
  public Long getId() {
    return id;
  }

  public boolean hasName() {
    return name != null;
  }

  /** Returns the name of this path element. */
  public String getName() {
    return name;
  }

  /**
   * Returns the path element's ID (as {@link Long}) or name (as {@link String}). Never {@code
   * null}.
   */
  public Object getNameOrId() {
    return id == null ? name : id;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("kind", kind)
        .add("id", id)
        .add("name", name)
        .toString();
  }

  @Override
  public int hashCode() {
    return Objects.hash(kind, id, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof PathElement)) {
      return false;
    }
    PathElement other = (PathElement) obj;
    return Objects.equals(kind, other.kind)
        && Objects.equals(id, other.id)
        && Objects.equals(name, other.name);
  }

  public com.google.datastore.v1.Key.PathElement toPb() {
    com.google.datastore.v1.Key.PathElement.Builder pathElementPb =
        com.google.datastore.v1.Key.PathElement.newBuilder();
    pathElementPb.setKind(kind);
    if (id != null) {
      pathElementPb.setId(id);
    } else if (name != null) {
      pathElementPb.setName(name);
    }
    return pathElementPb.build();
  }

  static PathElement fromPb(com.google.datastore.v1.Key.PathElement pathElementPb) {
    String kind = pathElementPb.getKind();
    switch (pathElementPb.getIdTypeCase()) {
      case ID:
        return of(kind, pathElementPb.getId());
      case NAME:
        return of(kind, pathElementPb.getName());
      default:
        return of(kind);
    }
  }

  static PathElement of(String kind) {
    return new PathElement(kind, null, null);
  }

  public static PathElement of(String kind, String name) {
    checkArgument(!Strings.isNullOrEmpty(name), "name must not be empty or null");
    return new PathElement(kind, name, null);
  }

  public static PathElement of(String kind, long id) {
    checkArgument(id != 0, "id must not be equal to zero");
    return new PathElement(kind, null, id);
  }
}
