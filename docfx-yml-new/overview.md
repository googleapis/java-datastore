# google-cloud-datastore overview (2.17.1)

## Key Reference Links
is a fully managed, schemaless database for
storing non-relational data. Cloud Datastore automatically scales with
your users and supports ACID transactions, high availability of reads and
writes, strong consistency for reads and ancestor queries, and eventual
consistency for all other queries.

<table>
   <tr>
     <td><a href="https://cloud.google.com/java/docs/reference/google-cloud-datastore/latest/history">Cloud Datastore product reference</a></td>
     <td><a href="https://github.com/googleapis/java-datastore">Github repository (includes samples)</a></td>
     <td><a href="https://central.sonatype.com/artifact/com.google.cloud/google-cloud-datastore">Maven artifact</a></td>
   </tr>
 </table>

## Getting Started
In order to use this library, you first need to go through the following steps:

- [Install a JDK (Java Development Kit)](https://cloud.google.com/java/docs/setup#install_a_jdk_java_development_kit)
- [Select or create a Cloud Platform project](https://console.cloud.google.com/project)
- [Enable billing for your project]("https://cloud.google.com/billing/docs/how-to/modify-project#enable_billing_for_a_project)
- [Enable the API](https://console.cloud.google.com/apis/library/datastore.googleapis.com)
- [Set up authentication](https://cloud.google.com/docs/authentication/client-libraries)

## Use the Cloud Datastore for Java
To ensure that your project uses compatible versions of the libraries
and their component artifacts, import `com.google.cloud:libraries-bom` and use
the BOM to specify dependency versions.  Be sure to remove any versions that you
set previously. For more information about
BOMs, see [Google Cloud Platform Libraries BOM](https://cloud.google.com/java/docs/bom).

<div>
<devsite-selector>
<section>
<h3>Maven</h3>
<p>Import the BOM in the <code>dependencyManagement</code> section of your <code>pom.xml</code> file.
Include specific artifacts you depend on in the <code>dependencies</code> section, but don't
specify the artifacts' versions in the <code>dependencies</code> section.</p>

<p>The example below demonstrates how you would import the BOM and include the <code>google-cloud-apikeys</code>
artifact.</p>
<pre class="prettyprint lang-xml devsite-click-to-copy">
&lt;dependencyManagement&gt;
 &lt;dependencies&gt;
   &lt;dependency&gt;
      &lt;groupId&gt;com.google.cloud&lt;/groupId&gt;
      &lt;artifactId&gt;libraries-bom&lt;/artifactId&gt;
      &lt;version&gt;26.23.0&lt;/version&gt;
      &lt;type&gt;pom&lt;/type&gt;
      &lt;scope&gt;import&lt;/scope&gt;
   &lt;/dependency&gt;
 &lt;/dependencies&gt;
&lt;/dependencyManagement&gt;

&lt;dependencies&gt;
 &lt;dependency&gt;
   &lt;groupId&gt;com.google.cloud&lt;/groupId&gt;
   &lt;artifactId&gt;google-cloud-datastore&lt;/artifactId&gt;
 &lt;/dependency&gt;
&lt;/dependencies&gt;
</pre>
</section>
<section>
<h3>Gradle</h3>
<p>BOMs are supported by default in Gradle 5.x or later. Add a <code>platform</code>
dependency on <code>com.google.cloud:libraries-bom</code> and remove the version from the
dependency declarations in the artifact's <code>build.gradle</code> file.</p>

<p>The example below demonstrates how you would import the BOM and include the <code>google-cloud-apikeys</code>
artifact.</p>
<pre class="prettyprint lang-Groovy devsite-click-to-copy">
implementation platform(&#39;com.google.cloud:libraries-bom:26.23.0&#39;)
implementation &#39;com.google.cloud:google-cloud-datastore&#39;
</pre>
<p>The <code>platform</code> and <code>enforcedPlatform</code> keywords supply dependency versions
declared in a BOM. The <code>enforcedPlatform</code> keyword enforces the dependency
versions declared in the BOM and thus overrides what you specified.</p>

<p>For more details of the <code>platform</code> and <code>enforcedPlatform</code> keywords Gradle 5.x or higher, see
<a href="https://docs.gradle.org/current/userguide/platforms.html#sub:bom_import">Gradle: Importing Maven BOMs</a>.</p>

<p>If you're using Gradle 4.6 or later, add
<code>enableFeaturePreview('IMPROVED_POM_SUPPORT')</code> to your <code>settings.gradle</code> file. For details, see
<a href="https://docs.gradle.org/4.6/release-notes.html#bom-import">Gradle 4.6 Release Notes: BOM import</a>.
Versions of Gradle earlier than 4.6 don't support BOMs.</p>
</section>
<section>
<h3>SBT</h3>
<p>SBT <a href="https://github.com/sbt/sbt/issues/4531">doesn't support BOMs</a>. You can find
recommended versions of libraries from a particular BOM version on the
<a href="https://storage.googleapis.com/cloud-opensource-java-dashboard/com.google.cloud/libraries-bom/index.html">dashboard</a>
and set the versions manually.</p>
<p>To use the latest version of this library, add this to your dependencies:</p>
<pre class="prettyprint lang-Scala devsite-click-to-copy">
libraryDependencies += &quot;com.google.cloud&quot; % &quot;google-cloud-datastore&quot; % &quot;2.17.1&quot;
</pre>
</section>
</devsite-selector>
</div>

## Which version should I use?
For this library, we recommend using API version v1 for new applications.

Each Cloud Java client library may contain multiple packages. Each package corresponds to a published version of the service.
We recommend using the latest stable version for new production applications, which can be identified by the largest numeric version that does not contain a suffix.
For example, if a client library has two packages: `v1` and `v2alpha`, then the latest stable version is `v1`.
If you use an unstable release, breaking changes may be introduced when upgrading.

