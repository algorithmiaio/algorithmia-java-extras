
name := "algorithmia-extras"

organization := "com.algorithmia"

version := "1.0.2"

autoScalaLibrary := false

// More compiler warnings
scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-Xlint")

// resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies ++= Seq(
  "com.algorithmia" % "algorithmia-client" % "[1.0.15,2.0[",
  "com.google.code.gson" % "gson" % "2.8.6",
  "org.apache.httpcomponents" % "httpasyncclient" % "4.1.4",
  "commons-io" % "commons-io" % "2.6",
  "commons-codec" % "commons-codec" % "1.14",
  "com.novocode" % "junit-interface" % "0.11" % Test,
  "junit" % "junit" % "4.13" % Test
)

// Disable using the Scala version in published artifacts
crossPaths := false
