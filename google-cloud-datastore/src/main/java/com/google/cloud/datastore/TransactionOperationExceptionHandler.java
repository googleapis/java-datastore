/*
 * Copyright 2017 Google LLC
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

import com.google.api.core.BetaApi;
import com.google.cloud.BaseService;
import com.google.cloud.ExceptionHandler;
import com.google.cloud.ExceptionHandler.Interceptor;

@BetaApi
public class TransactionOperationExceptionHandler {

  public static final Interceptor TRANSACTION_OPERATION_EXCEPTION_HANDLER_INTERCEPTOR =
      new Interceptor() {

        private static final long serialVersionUID = -1240723093072535978L;

        private static final int ABORTED_CODE = 10;

        @Override
        public RetryResult beforeEval(Exception exception) {
          if (exception instanceof DatastoreException) {
            DatastoreException e = getInnerException((DatastoreException) exception);
            if (e.getCode() == ABORTED_CODE
                || e.getReason() != null && e.getReason().equals("ABORTED")) {
              return RetryResult.NO_RETRY;
            }
          }
          return BaseService.EXCEPTION_HANDLER_INTERCEPTOR.beforeEval(exception);
        }

        @Override
        public RetryResult afterEval(Exception exception, RetryResult retryResult) {
          return BaseService.EXCEPTION_HANDLER_INTERCEPTOR.afterEval(exception, retryResult);
        }

        private DatastoreException getInnerException(DatastoreException exception) {
          while (exception.getCause() instanceof DatastoreException) {
            exception = (DatastoreException) exception.getCause();
          }
          return exception;
        }
      };

  public static ExceptionHandler build() {
    return ExceptionHandler.newBuilder()
        .abortOn(RuntimeException.class)
        .addInterceptors(TRANSACTION_OPERATION_EXCEPTION_HANDLER_INTERCEPTOR)
        .build();
  }

  /** Intentionally private empty constructor to disable instantiation of this class. */
  private TransactionOperationExceptionHandler() {}
}
