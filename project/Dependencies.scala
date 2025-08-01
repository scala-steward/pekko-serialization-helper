import sbt._

object Dependencies {
  val scalaVersion213 = "2.13.16"
  val scalaVersion212 = "2.12.20"

  val pekkoProjectionVersion = "1.0.0"
  val pekkoGrpcRuntimeVersion = "1.1.1"
  val pekkoHttpCorsVersion = "1.1.0"
  val pekkoVersion = "1.1.2"
  val borerVersion = "1.8.0"
  val circeYamlVersion = "1.15.0"
  val circeVersion = "0.14.14"
  val circeGenericExtrasVersion = "0.14.4"

  val scalaTest = "org.scalatest" %% "scalatest" % "3.2.19"
  val logger = "org.slf4j" % "slf4j-simple" % "1.7.36"
  val reflections = "net.oneandone.reflections8" % "reflections8" % "0.11.7"
  val betterFiles = "com.github.pathikrit" %% "better-files" % "3.9.2"
  val sprayJson = "io.spray" %% "spray-json" % "1.3.6"
  val scalaCollectionCompat = "org.scala-lang.modules" %% "scala-collection-compat" % "2.13.0"

  val pekkoActor = "org.apache.pekko" %% "pekko-actor" % pekkoVersion
  val pekkoActorTyped = "org.apache.pekko" %% "pekko-actor-typed" % pekkoVersion
  val pekkoStream = "org.apache.pekko" %% "pekko-stream" % pekkoVersion
  val pekkoPersistenceTyped = "org.apache.pekko" %% "pekko-persistence-typed" % pekkoVersion
  val pekkoProjections = "org.apache.pekko" %% "pekko-projection-eventsourced" % pekkoProjectionVersion
  val pekkoTestKitTyped = "org.apache.pekko" %% "pekko-actor-testkit-typed" % pekkoVersion
  val pekkoStreamTestKit = "org.apache.pekko" %% "pekko-stream-testkit" % pekkoVersion

  val pekkoHttpCors = "org.apache.pekko" %% "pekko-http-cors" % pekkoHttpCorsVersion // required by pekko-grpc-runtime
  val pekkoGrpc = "org.apache.pekko" %% "pekko-grpc-runtime" % pekkoGrpcRuntimeVersion

  val borerCore = "io.bullet" %% "borer-core" % borerVersion
  val borerDerivation = "io.bullet" %% "borer-derivation" % borerVersion
  val borerPekko = "io.bullet" %% "borer-compat-pekko" % borerVersion

  val circeCore = "io.circe" %% "circe-core" % circeVersion
  val circeGeneric = "io.circe" %% "circe-generic" % circeVersion
  val circeGenericExtras = "io.circe" %% "circe-generic-extras" % circeGenericExtrasVersion
  val circeParser = "io.circe" %% "circe-parser" % circeVersion
  val circeYaml = "io.circe" %% "circe-yaml" % circeYamlVersion

  val scalaCompiler = "org.scala-lang" % "scala-compiler"
  val scalaReflect = "org.scala-lang" % "scala-reflect"

  private val scalaPluginDeps = Seq(scalaCompiler, scalaReflect)
  val scalaPluginDeps213: Seq[ModuleID] = scalaPluginDeps.map(_ % scalaVersion213 % Provided)
  val scalaPluginDeps212: Seq[ModuleID] = scalaPluginDeps.map(_ % scalaVersion212 % Provided)

  val commonDeps: Seq[ModuleID] = Seq(scalaTest % Test, logger % Test)
}
