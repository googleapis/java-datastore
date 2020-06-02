Google Cloud Java Client for Datastore
======================================

Java idiomatic client for [Google Cloud Datastore][cloud-datastore].

[![Kokoro CI](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.svg)](http://storage.googleapis.com/cloud-devrel-public/java/badges/google-cloud-java/master.html)
[![Maven](https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-datastore.svg)]( https://img.shields.io/maven-central/v/com.google.cloud/google-cloud-datastore.svg)
[![Codacy Badge](https://api.codacy.com/project/badge/grade/9da006ad7c3a4fe1abd142e77c003917)](https://www.codacy.com/app/mziccard/google-cloud-java)

- [Product Documentation][datastore-product-docs]
- [Client Library Documentation][datastore-client-lib-docs]

Quickstart
----------
If you are using Maven with a BOM, add this to your pom.xml file.
```xml
<dependencyManagement>
 <dependencies>
  <dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>libraries-bom</artifactId>
    <version>3.0.0</version>
    <type>pom</type>
    <scope>import</scope>
   </dependency>
 </dependencies>
</dependencyManagement>

<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-datastore</artifactId>
</dependency>
```
[//]: # ({x-version-update-start:google-cloud-datastore:released})
If you are using Maven without a BOM, add this to your dependencies.
```xml
<dependency>
  <groupId>com.google.cloud</groupId>
  <artifactId>google-cloud-datastore</artifactId>
  <version>1.103.0</version>
</dependency>
```
If you are using Gradle, add this to your dependencies
```Groovy
compile 'com.google.cloud:google-cloud-datastore:1.103.0'
```
If you are using SBT, add this to your dependencies
```Scala
libraryDependencies += "com.google.cloud" % "google-cloud-datastore" % "1.103.0"
```
[//]: # ({x-version-update-end})

Example Applications
--------------------
- [`DatastoreExample`](../../google-cloud-examples/src/main/java/com/google/cloud/examples/datastore/DatastoreExample.java) is a simple command line interface for the Cloud Datastore.
- [`Bookshelf`](https://github.com/GoogleCloudPlatform/getting-started-java/tree/master/bookshelf) - An App Engine app that manages a virtual bookshelf.
  - This app uses `google-cloud` to interface with Cloud Datastore and Cloud Storage. It also uses Cloud SQL, another Google Cloud Platform service.
- [`Flexible Environment/Datastore example`](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/flexible/datastore) - A simple app that uses Cloud Datastore to list the last 10 IP addresses that visited your site.
- [`GuestBook`](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/appengine/guestbook-cloud-datastore) - An App Engine Standard guestbook that uses Cloud Datastore.
- [`SparkDemo`](https://github.com/GoogleCloudPlatform/java-docs-samples/blob/master/flexible/sparkjava) - An example of using `google-cloud-datastore` from within the SparkJava and App Engine Flexible Environment frameworks.
  - Read about how it works on the example's [README page](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/flexible/sparkjava#how-does-it-work).
- [`TaskList`](https://github.com/GoogleCloudPlatform/java-docs-samples/blob/master/datastore/src/main/java/com/google/datastore/snippets/TaskList.java) - A command line application that uses Cloud Datastore to manage a to-do list.
  - Read about how to run the application on its [README page](https://github.com/GoogleCloudPlatform/java-docs-samples/tree/master/datastore).

Authentication
--------------

See the [Authentication](https://github.com/googleapis/google-cloud-java#authentication) section in the base directory's README.

About Google Cloud Datastore
----------------------------

Google [Cloud Datastore][cloud-datastore] is a fully managed, schemaless database for
storing non-relational data. Cloud Datastore automatically scales with
your users and supports ACID transactions, high availability of reads and
writes, strong consistency for reads and ancestor queries, and eventual
consistency for all other queries.

See the [Google Cloud Datastore docs][cloud-datastore-activation] for more details on how to activate
Cloud Datastore for your project.

See the [Datastore client library docs][datastore-client-lib-docs] to learn how to interact
with the Cloud Datastore using this Client Library.

Getting Started
---------------
#### Prerequisites
For this tutorial, you will need a [Google Developers Console](https://console.developers.google.com/) project with the Datastore API enabled. [Follow these instructions](https://cloud.google.com/resource-manager/docs/creating-managing-projects) to get your project set up. You will also need to set up the local development environment by [installing the Google Cloud SDK](https://cloud.google.com/sdk/) and running the following commands in command line: `gcloud auth login` and `gcloud config set project [YOUR PROJECT ID]`.

#### Installation and setup
You'll need to obtain the `google-cloud-datastore` library.  See the [Quickstart](#quickstart) section to add `google-cloud-datastore` as a dependency in your code.

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

Troubleshooting
---------------

To get help, follow the instructions in the [shared Troubleshooting document](https://github.com/googleapis/google-cloud-common/blob/master/troubleshooting/readme.md#troubleshooting).

Transport
---------
Datastore uses HTTP for the transport layer.

Java Versions
-------------

Java 7 or above is required for using this client.

Testing
-------

This library has tools to help write tests for code that uses the Datastore.

See [TESTING] to read more about testing.

Versioning
----------

This library follows [Semantic Versioning](http://semver.org/).

It is currently in major version one (``1.y.z``), which means that the public API should be considered stable.

Contributing
------------

Contributions to this library are always welcome and highly encouraged.

See `google-cloud`'s [CONTRIBUTING] documentation and the [shared documentation](https://github.com/googleapis/google-cloud-common/blob/master/contributing/readme.md#how-to-contribute-to-gcloud) for more information on how to get started.

Please note that this project is released with a Contributor Code of Conduct. By participating in this project you agree to abide by its terms. See [Code of Conduct][code-of-conduct] for more information.

License
-------

Apache 2.0 - See [LICENSE] for more information.


[CONTRIBUTING]:https://github.com/googleapis/google-cloud-java/blob/master/CONTRIBUTING.md
[code-of-conduct]:https://github.com/googleapis/google-cloud-java/blob/master/CODE_OF_CONDUCT.md#contributor-code-of-conduct
[LICENSE]: https://github.com/googleapis/google-cloud-java/blob/master/LICENSE
[TESTING]: https://github.com/googleapis/google-cloud-java/blob/master/TESTING.md#testing-code-that-uses-datastore
[cloud-platform]: https://cloud.google.com/
[cloud-datastore-activation]: https://cloud.google.com/datastore/docs/activate
[cloud-datastore]: https://cloud.google.com/datastore/
[datastore-product-docs]: https://cloud.google.com/datastore/docs/
[datastore-client-lib-docs]: https://googleapis.dev/java/google-cloud-clients/latest/index.html?com/google/cloud/datastore/package-summary.html
