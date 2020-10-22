# Google Cloud Datastore Client for Java

Java idiomatic client for [Cloud Datastore][product-docs].

[![Maven][maven-version-image]][maven-version-link]
![Stability][stability-image]

- [Product Documentation][product-docs]
- [Client Library Documentation][javadocs]

## Quickstart

If you are using Maven with [BOM][libraries-bom], add this to your pom.xml file
```xml
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>libraries-bom</artifactId>
      <version>13.1.0</version>
      <type>pom</type>
      <scope>import</scope>
    </dependency>
  </dependencies>
</dependencyManagement>

<dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-datastore</artifactId>
  </dependency>

```

If you are using Maven without BOM, add this to your dependencies:

```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-datastore</artifactId>
  <version>1.105.0</version>
</dependency>

```

If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-datastore:1.105.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-datastore" % "1.105.0"
```

## Authentication

See the [Authentication][authentication] section in the base directory's README.

## Getting Started

### Prerequisites

You will need a [Google Cloud Platform Console][developer-console] project with the Cloud Datastore [API enabled][enable-api].

[Follow these instructions][create-project] to get your project set up. You will also need to set up the local development environment by
[installing the Google Cloud SDK][cloud-sdk] and running the following commands in command line:
`gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

### Installation and setup

You'll need to obtain the `google-cloud-datastore` library.  See the [Quickstart](#quickstart) section
to add `google-cloud-datastore` as a dependency in your code.

## About Cloud Datastore


[Cloud Datastore][product-docs] is a fully managed, schemaless database for
storing non-relational data. Cloud Datastore automatically scales with
your users and supports ACID transactions, high availability of reads and
writes, strong consistency for reads and ancestor queries, and eventual
consistency for all other queries.

See the [Cloud Datastore client library docs][javadocs] to learn how to
use this Cloud Datastore Client Library.


See the [Google Cloud Datastore docs][cloud-datastore-activation] for more details on how to activate
Cloud Datastore for your project.

See the [Datastore client library docs][datastore-client-lib-docs] to learn how to interact
with the Cloud Datastore using this Client Library.

#### Creating an authorized service object
To make authenticated requests to Google Cloud Datastore, you must create a service object with credentials. You can then make API calls by calling methods on the Datastore service object. The simplest way to authenticate is to use [Application Default Credentials](https://developers.google.com/identity/protocols/application-default-credentials). These credentials are automatically inferred from your environment, so you only need the following code to create your service object:

```java
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;

Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
```

For other authentication options, see the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) page.

#### Storing data
Objects in Datastore are known as entities. Entities are grouped by "kind" and have keys for easy access. In this code snippet, we will create a new entity representing a person and store that data by the person's email.  First, add the following imports at the top of your file:

```java
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;
import com.google.cloud.datastore.KeyFactory;
```

Then add the following code to put an entity in Datastore.

```java
KeyFactory keyFactory = datastore.newKeyFactory().setKind("Person");
Key key = keyFactory.newKey("john.doe@gmail.com");
Entity entity = Entity.newBuilder(key)
    .set("name", "John Doe")
    .set("age", 51)
    .set("favorite_food", "pizza")
    .build();
datastore.put(entity);
```

Later, if you want to get this entity back, add the following to your code:

```java
Entity johnEntity = datastore.get(key);
```

#### Running a query
In addition to retrieving entities by their keys, you can perform queries to retrieve entities by
the values of their properties. A typical query includes an entity kind, filters to select entities
with matching values, and sort orders to sequence the results. `google-cloud-datastore` supports two
types of queries: `StructuredQuery` (that allows you to construct query elements) and `GqlQuery`
(which operates using [GQL syntax](https://cloud.google.com/datastore/docs/apis/gql/gql_reference))
in string format. In this tutorial, we will use a simple `StructuredQuery`.

Suppose that you've added more people to Datastore, and now you want to find all people whose favorite food is pizza. Import the following:

```java
import com.google.cloud.datastore.Query;
import com.google.cloud.datastore.QueryResults;
import com.google.cloud.datastore.StructuredQuery;
import com.google.cloud.datastore.StructuredQuery.PropertyFilter;
```

Then add the following code to your program:

```java
Query<Entity> query = Query.newEntityQueryBuilder()
    .setKind("Person")
    .setFilter(PropertyFilter.eq("favorite_food", "pizza"))
    .build();
QueryResults<Entity> results = datastore.run(query);
while (results.hasNext()) {
  Entity currentEntity = results.next();
  System.out.println(currentEntity.getString("name") + ", you're invited to a pizza party!");
}
```

Cloud Datastore relies on indexing to run queries. Indexing is turned on by default for most types of properties. To read more about indexing, see the [Cloud Datastore Index Configuration documentation](https://cloud.google.com/datastore/docs/tools/indexconfig).

#### Updating data
Another thing you'll probably want to do is update your data. The following snippet shows how to update a Datastore entity if it exists.

``` java
KeyFactory keyFactory = datastore.newKeyFactory().setKind("keyKind");
Key key = keyFactory.newKey("keyName");
Entity entity = datastore.get(key);
if (entity != null) {
  System.out.println("Updating access_time for " + entity.getString("name"));
  entity = Entity.newBuilder(entity)
      .set("access_time", DateTime.now())
      .build();
  datastore.update(entity);
}
```

The complete source code can be found at
[UpdateEntity.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/datastore/snippets/UpdateEntity.java).

#### Complete source code

In
[AddEntitiesAndRunQuery.java](../../google-cloud-examples/src/main/java/com/google/cloud/examples/datastore/snippets/AddEntitiesAndRunQuery.java)
we put together all the code to store data and run queries into one program. The program assumes that you are
running on Compute Engine or from your own desktop. To run the example on App Engine, simply move
the code from the main method to your application's servlet class and change the print statements to
display on your webpage.

Testing
-------

This library has tools to help write tests for code that uses the Datastore.

See [TESTING.md](https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-datastore) to read more about testing.

Example Applications
--------------------
- [`Bookshelf`](https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/bookshelf) - An App Engine app that manages a virtual bookshelf.
  - This app uses `google-cloud` to interface with Cloud Datastore and Cloud Storage. It also uses Cloud SQL, another Google Cloud Platform service.
- [`Flexible Environment/Datastore example`](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/flexible/datastore) - A simple app that uses Cloud Datastore to list the last 10 IP addresses that visited your site.
- [`SparkDemo`](https://github.com/GoogleCloudPlatform/java-docs-samples/blob/master/flexible/sparkjava) - An example of using `google-cloud-datastore` from within the SparkJava and App Engine Flexible Environment frameworks.
  - Read about how it works on the example's [README page](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/flexible/sparkjava#how-does-it-work).




## Samples

Samples are in the [`samples/`](https://github.com/googleapis/java-datastore/tree/master/samples) directory. The samples' `README.md`
has instructions for running the samples.

| Sample                      | Source Code                       | Try it |
| --------------------------- | --------------------------------- | ------ |
| Quickstart Sample | [source code](https://github.com/googleapis/java-datastore/blob/master/samples/snippets/src/main/java/com/example/datastore/QuickstartSample.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/example/datastore/QuickstartSample.java) |
| Task List | [source code](https://github.com/googleapis/java-datastore/blob/master/samples/snippets/src/main/java/com/google/datastore/snippets/TaskList.java) | [![Open in Cloud Shell][shell_img]](https://console.cloud.google.com/cloudshell/open?git_repo=https://github.com/googleapis/java-datastore&page=editor&open_in_editor=samples/snippets/src/main/java/com/google/datastore/snippets/TaskList.java) |



## Troubleshooting

To get help, follow the instructions in the [shared Troubleshooting document][troubleshooting].

## Java Versions

Java 7 or above is required for using this client.

## Versioning


This library follows [Semantic Versioning](http://semver.org/).


## Contributing


Contributions to this library are always welcome and highly encouraged.

See [CONTRIBUTING][contributing] for more information how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in
this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more
information.

## License

Apache 2.0 - See [LICENSE][license] for more information.

## CI Status

Java Version | Status
------------ | ------
Java 7 | [![Kokoro CI][kokoro-badge-image-1]][kokoro-badge-link-1]
Java 8 | [![Kokoro CI][kokoro-badge-image-2]][kokoro-badge-link-2]
Java 8 OSX | [![Kokoro CI][kokoro-badge-image-3]][kokoro-badge-link-3]
Java 8 Windows | [![Kokoro CI][kokoro-badge-image-4]][kokoro-badge-link-4]
Java 11 | [![Kokoro CI][kokoro-badge-image-5]][kokoro-badge-link-5]

[product-docs]: https://cloud.google.com/datastore
[javadocs]: https://googleapis.dev/java/google-cloud-datastore/latest/index.html
[kokoro-badge-image-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java7.svg
[kokoro-badge-link-1]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java7.html
[kokoro-badge-image-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8.svg
[kokoro-badge-link-2]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8.html
[kokoro-badge-image-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8-osx.svg
[kokoro-badge-link-3]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8-osx.html
[kokoro-badge-image-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8-win.svg
[kokoro-badge-link-4]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java8-win.html
[kokoro-badge-image-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java11.svg
[kokoro-badge-link-5]: http://storage.googleapis.com/cloud-devrel-public/java/badges/java-datastore/java11.html
[stability-image]: https://img.shields.io/badge/stability-ga-green
[maven-version-image]: https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-datastore.svg
[maven-version-link]: https://search.maven.org/search?q=g:com.google.cloud%20AND%20a:google-cloud-datastore&core=gav
[authentication]: https://github.com/googleapis/google-cloud-java#authentication
[developer-console]: https://console.developers.google.com/
[create-project]: https://cloud.google.com/resource-manager/docs/creating-managing-projects
[cloud-sdk]: https://cloud.google.com/sdk/
[troubleshooting]: https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting
[contributing]: https://github.com/googleapis/java-datastore/blob/master/CONTRIBUTING.md
[code-of-conduct]: https://github.com/googleapis/java-datastore/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[license]: https://github.com/googleapis/java-datastore/blob/master/LICENSE

[enable-api]: https://console.cloud.google.com/flows/enableapi?apiid=datastore.googleapis.com
[libraries-bom]: https://github.com/GoogleCloudPlatform/cloud-opensource-java/wiki/The-Google-Cloud-Platform-Libraries-BOM
[shell_img]: https://gstatic.com/cloudssh/images/open-btn.png
