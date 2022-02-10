# Datastore Sample Application with Native Image

This application uses the [Google Cloud Datastore client library](https://cloud.google.com/datastore/docs/reference/libraries) and is compatible with Native Image compilation.

This sample runs through some basic operations of creating/deleting entities, running queries, and running transaction code.

## Setup Instructions

1. Follow the [GCP Project and Native Image Setup Instructions](../../README.md).

2. If you wish to run the application against the [Datastore emulator](https://cloud.google.com/sdk/gcloud/reference/beta/emulators/datastore), ensure that you have the [Google Cloud SDK](https://cloud.google.com/sdk) installed.

   In a new terminal window, start the emulator via `gcloud`:

    ```
    gcloud beta emulators datastore start --host-port=localhost:9010
    ```

   Leave the emulator running in this terminal for now.
   In the next section, we will run the sample application against the Datastore emulator instance.

## Run with Native Image Compilation

1. Navigate to this directory and compile the application with the Native Image compiler.

    ```
    mvn package -P native -DskipTests
    ```

2. **(Optional)** If you're using the emulator, export the `DATASTORE_EMULATOR_HOST` as an environment variable in your terminal.

    ```
    export DATASTORE_EMULATOR_HOST=localhost:9010
    ``` 

   The Datastore Client Libraries will detect this environment variable and automatically connect to the emulator instance if this variable is set.

3. Run the application.

    ```
    ./target/datastore-sample
    ```

   1. The application will run through some basic Datastore operations and log some output statements.

   ```
      Successfully added entity.
      Reading entity: 1cf34cc1-2b8a-4945-9fc4-058f03dcd08e
      Successfully deleted entity: 1cf34cc1-2b8a-4945-9fc4-058f03dcd08e
      Run fake transaction code.
      Found entity:
          name=de4f36f4-3936-4252-98d3-e0d56d485254
          kind=test-kind
          namespace=nativeimage-test-namespace
          properties={description=StringValue{valueType=STRING, excludeFromIndexes=false, meaning=0, value=hello world}}
      Ran transaction callable.
    ```

### Sample Integration test with Native Image Support

In order to run the sample integration test, call the following command:

   ```
   mvn test -Pnative
   ```
