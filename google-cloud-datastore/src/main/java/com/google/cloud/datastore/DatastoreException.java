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

import static com.google.cloud.BaseServiceException.isRetryable;

import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ErrorDetails;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.grpc.BaseGrpcServiceException;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Datastore service exception.
 *
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes">Google Cloud
 *     Datastore error codes</a>
 */
public final class DatastoreException extends BaseGrpcServiceException {

  // see https://cloud.google.com/datastore/docs/concepts/errors#Error_Codes"
  private static final Set<Error> RETRYABLE_ERRORS =
      ImmutableSet.of(
          new Error(10, "ABORTED", false),
          new Error(4, "DEADLINE_EXCEEDED", false),
          new Error(14, "UNAVAILABLE", true));
  private static final long serialVersionUID = 2663750991205874435L;
  private String reason;
  private ApiException apiException;

  public DatastoreException(int code, String message, String reason) {
    this(code, message, reason, true, null);
    this.reason = reason;
  }

  public DatastoreException(int code, String message, String reason, Throwable cause) {
    super(message, cause, code, isRetryable(code, reason, true, RETRYABLE_ERRORS));
    this.reason = reason;
  }

  public DatastoreException(
      int code, String message, String reason, boolean idempotent, Throwable cause) {
    super(message, cause, code, isRetryable(code, reason, idempotent, RETRYABLE_ERRORS));
    this.reason = reason;
  }

  public DatastoreException(IOException exception) {
    super(exception, true);
  }

  public DatastoreException(ApiException apiException) {
    super(apiException);
    this.apiException = apiException;
  }

  /**
   * Checks the underlying reason of the exception and if it's {@link ApiException} then return the
   * specific domain otherwise null.
   *
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/error_details.proto#L125">Domain</a>
   * @return the logical grouping to which the "reason" belongs.
   */
  public String getDomain() {
    if (this.apiException != null) {
      return this.apiException.getDomain();
    }
    return null;
  }

  /**
   * Checks the underlying reason of the exception and if it's {@link ApiException} then return a
   * map of key-value pairs otherwise null.
   *
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/error_details.proto#L135">Metadata</a>
   * @return the map of additional structured details about an error.
   */
  public Map<String, String> getMetadata() {
    if (this.apiException != null) {
      return this.apiException.getMetadata();
    }
    return null;
  }

  /**
   * Checks the underlying reason of the exception and if it's {@link ApiException} then return the
   * ErrorDetails otherwise null.
   *
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/status.proto">Status</a>
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/error_details.proto">Error
   *     Details</a>
   * @return An object containing getters for structured objects from error_details.proto.
   */
  public ErrorDetails getErrorDetails() {
    if (this.apiException != null) {
      return this.apiException.getErrorDetails();
    }
    return null;
  }

  /**
   * Checks the underlying reason of the exception and if it's {@link ApiException} then return the
   * reason otherwise null/custom reason.
   *
   * @see <a
   *     href="https://github.com/googleapis/googleapis/blob/master/google/rpc/error_details.proto#L117">Reason</a>
   * @return the reason of an error.
   */
  @Override
  public String getReason() {
    if (this.apiException != null) {
      return this.apiException.getReason();
    }
    return this.reason;
  }

  /**
   * Translate RetryHelperException to the DatastoreException that caused the error. This method
   * will always throw an exception.
   *
   * @throws DatastoreException when {@code ex} was caused by a {@code DatastoreException}
   */
  static DatastoreException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translate(ex);
    if (ex.getCause() instanceof ApiException) {
      throw new DatastoreException((ApiException) ex.getCause());
    }
    throw new DatastoreException(UNKNOWN_CODE, ex.getMessage(), null, ex.getCause());
  }

  /**
   * Throw a DatastoreException with {@code FAILED_PRECONDITION} reason and the {@code message} in a
   * nested exception.
   *
   * @throws DatastoreException every time
   */
  static DatastoreException throwInvalidRequest(String massage, Object... params) {
    throw new DatastoreException(
        UNKNOWN_CODE, String.format(massage, params), "FAILED_PRECONDITION");
  }

  static DatastoreException propagateUserException(Exception ex) {
    throw new DatastoreException(BaseServiceException.UNKNOWN_CODE, ex.getMessage(), null, ex);
  }
}
