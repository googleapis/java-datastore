/*
 * Copyright 2024 Google LLC
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

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.protobuf.DoubleValue;
import com.google.protobuf.Int32Value;
import java.io.Serializable;
import java.util.Objects;
import javax.annotation.Nullable;

/**
 * A query that finds the entities whose vector fields are closest to a certain query vector. Create
 * an instance of `FindNearest` with {@link Query}.
 */
public final class FindNearest implements Serializable {

  /** An indexed vector property to search upon. */
  private final String vectorProperty;
  /** The query vector that we are searching on. */
  private final VectorValue queryVector;
  /** The Distance Measure to use, required. */
  private final DistanceMeasure measure;
  /** The number of nearest neighbors to return. Must be a positive integer of no more than 100. */
  private final int limit;

  /**
   * Optional. Optional name of the field to output the result of the vector distance calculation.
   */
  private final @Nullable String distanceResultField;

  /**
   * Optional. Option to specify a threshold for which no less similar documents will be returned.
   * The behavior of the specified `distance_measure` will affect the meaning of the distance
   * threshold.
   */
  private final @Nullable Double distanceThreshold;

  private static final long serialVersionUID = 4688656124180403551L;

  /** Creates a FindNearest query. */
  public FindNearest(
      String vectorProperty,
      VectorValue queryVector,
      DistanceMeasure measure,
      int limit,
      @Nullable String distanceResultField,
      @Nullable Double distanceThreshold) {
    this.vectorProperty = vectorProperty;
    this.queryVector = queryVector;
    this.measure = measure;
    this.limit = limit;
    this.distanceResultField = distanceResultField;
    this.distanceThreshold = distanceThreshold;
  }

  public FindNearest(
      String vectorProperty, VectorValue queryVector, DistanceMeasure measure, int limit) {
    this(vectorProperty, queryVector, measure, limit, null, null);
  }

  public FindNearest(
      String vectorProperty,
      VectorValue queryVector,
      DistanceMeasure measure,
      int limit,
      @Nullable String distanceResultField) {
    this(vectorProperty, queryVector, measure, limit, distanceResultField, null);
  }

  public FindNearest(
      String vectorProperty,
      VectorValue queryVector,
      DistanceMeasure measure,
      int limit,
      @Nullable Double distanceThreshold) {
    this(vectorProperty, queryVector, measure, limit, null, distanceThreshold);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        vectorProperty, queryVector, measure, limit, distanceResultField, distanceThreshold);
  }

  /**
   * Returns true if this FindNearest query is equal to the provided object.
   *
   * @param obj The object to compare against.
   * @return Whether this FindNearest query is equal to the provided object.
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || !(obj instanceof FindNearest)) {
      return false;
    }
    FindNearest otherQuery = (FindNearest) obj;
    return Objects.equals(vectorProperty, otherQuery.vectorProperty)
        && Objects.equals(queryVector, otherQuery.queryVector)
        && Objects.equals(distanceResultField, otherQuery.distanceResultField)
        && Objects.equals(distanceThreshold, otherQuery.distanceThreshold)
        && limit == otherQuery.limit
        && measure == otherQuery.measure;
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    toStringHelper.add("vectorProperty", vectorProperty);
    toStringHelper.add("queryVector", queryVector);
    toStringHelper.add("measure", measure);
    toStringHelper.add("limit", limit);
    toStringHelper.add("distanceResultField", distanceResultField);
    toStringHelper.add("distanceThreshold", distanceThreshold);
    return toStringHelper.toString();
  }

  static FindNearest fromPb(com.google.datastore.v1.FindNearest findNearestPb) {
    String vectorProperty = findNearestPb.getVectorProperty().getName();
    VectorValue queryVector =
        VectorValue.MARSHALLER.fromProto(findNearestPb.getQueryVector()).build();
    DistanceMeasure distanceMeasure =
        DistanceMeasure.valueOf(findNearestPb.getDistanceMeasure().toString());
    int limit = findNearestPb.getLimit().getValue();
    String distanceResultField =
        findNearestPb.getDistanceResultProperty() == null
                || findNearestPb.getDistanceResultProperty().isEmpty()
            ? null
            : findNearestPb.getDistanceResultProperty();
    Double distanceThreshold =
        findNearestPb.getDistanceThreshold() == null
                || findNearestPb.getDistanceThreshold() == DoubleValue.getDefaultInstance()
            ? null
            : findNearestPb.getDistanceThreshold().getValue();
    return new FindNearest(
        vectorProperty,
        queryVector,
        distanceMeasure,
        limit,
        distanceResultField,
        distanceThreshold);
  }

  com.google.datastore.v1.FindNearest toPb() {
    com.google.datastore.v1.FindNearest.Builder findNearestPb =
        com.google.datastore.v1.FindNearest.newBuilder();
    findNearestPb.getVectorPropertyBuilder().setName(vectorProperty);
    findNearestPb.setQueryVector(queryVector.toPb());
    findNearestPb.setDistanceMeasure(toProto(measure));
    findNearestPb.setLimit(Int32Value.of(limit));
    if (distanceResultField != null) {
      findNearestPb.setDistanceResultProperty(distanceResultField);
    }
    if (distanceThreshold != null) {
      findNearestPb.setDistanceThreshold(DoubleValue.of(distanceThreshold));
    }
    return findNearestPb.build();
  }

  protected static com.google.datastore.v1.FindNearest.DistanceMeasure toProto(
      DistanceMeasure distanceMeasure) {
    switch (distanceMeasure) {
      case COSINE:
        return com.google.datastore.v1.FindNearest.DistanceMeasure.COSINE;
      case EUCLIDEAN:
        return com.google.datastore.v1.FindNearest.DistanceMeasure.EUCLIDEAN;
      case DOT_PRODUCT:
        return com.google.datastore.v1.FindNearest.DistanceMeasure.DOT_PRODUCT;
      default:
        return com.google.datastore.v1.FindNearest.DistanceMeasure.UNRECOGNIZED;
    }
  }

  /** The distance measure to use when comparing vectors in a {@link FindNearest query}. */
  public enum DistanceMeasure {
    DISTANCE_MEASURE_UNSPECIFIED,
    /**
     * COSINE distance compares vectors based on the angle between them, which allows you to measure
     * similarity that isn't based on the vectors' magnitude. We recommend using DOT_PRODUCT with
     * unit normalized vectors instead of COSINE distance, which is mathematically equivalent with
     * better performance.
     */
    COSINE,
    /** Measures the EUCLIDEAN distance between the vectors. */
    EUCLIDEAN,
    /** Similar to cosine but is affected by the magnitude of the vectors. */
    DOT_PRODUCT
  }
}
