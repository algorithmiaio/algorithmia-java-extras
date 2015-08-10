
name := "algorithmia-extras"

organization := "com.algorithmia"

version := "1.0.1-SNAPSHOT"

autoScalaLibrary := false

// More compiler warnings
scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint")  // "-verbose"

// resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "com.algorithmia" % "algorithmia-client" % "1.0.+",
  "com.google.code.gson" % "gson" % "2.3.1",
  "org.apache.httpcomponents" % "httpasyncclient" % "4.1",
  "commons-io" % "commons-io" % "2.4",
  "commons-codec" % "commons-codec" % "1.10",
  "com.novocode" % "junit-interface" % "0.8" % "test->default",
  "junit" % "junit" % "4.12" % "test"
)

// Disable using the Scala version in published artifacts
crossPaths := false
