name := "cloud-run-demo"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.3" % Test,
  "ch.qos.logback" % "logback-classic" % "1.2.3",

  "com.google.guava" % "guava" % "27.1-jre",
  "org.apache.commons" % "commons-lang3" % "3.8.1",

  "com.datastax.oss" % "java-driver-core" % "4.12.0",

  "io.vertx" % "vertx-web" % "4.1.2"
)

ThisBuild / assemblyMergeStrategy := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

