name := """nine"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
    javaJdbc,
    cache,
    javaWs,
    filters,
    "mysql" % "mysql-connector-java" % "5.1.39",
    "com.typesafe.akka" %% "akka-actor" % "2.3.15",
    "com.typesafe.akka" %% "akka-agent" % "2.3.15",
    "com.typesafe.akka" %% "akka-camel" % "2.3.15",
    "com.typesafe.akka" %% "akka-cluster" % "2.3.15",
    "com.typesafe.akka" %% "akka-osgi" % "2.3.15",
    "com.typesafe.akka" %% "akka-kernel" % "2.3.15",
    "com.typesafe.akka" %% "akka-remote" % "2.3.15",
    "com.typesafe.akka" %% "akka-slf4j" % "2.3.15",
    "com.typesafe.akka" %% "akka-testkit" % "2.3.15",
    "com.typesafe.akka" %% "akka-contrib" % "2.3.15",
    "com.alibaba" % "fastjson" % "1.1.45",
    "org.mongodb" % "mongodb-driver" % "3.2.2",
    "joda-time" % "joda-time" % "2.9.4",
    "com.aliyun.oss" % "aliyun-sdk-oss" % "2.2.3",
    "commons-lang" % "commons-lang" % "2.6",
    "commons-io" % "commons-io" % "2.5",
    "org.apache.lucene" % "lucene-core" % "5.5.2",
    "org.apache.lucene" % "lucene-queryparser" % "5.5.2",
    "org.apache.lucene" % "lucene-analyzers-common" % "5.5.2",
    "org.apache.lucene" % "lucene-analyzers-icu" % "5.5.2",
    "org.apache.lucene" % "lucene-memory" % "5.5.2",
    "org.apache.lucene" % "lucene-spatial" % "5.5.2",
    "org.apache.lucene" % "lucene-join" % "5.5.2",
    "org.apache.lucene" % "lucene-grouping" % "5.5.2",
    "org.apache.lucene" % "lucene-misc" % "5.5.2",
    "org.apache.lucene" % "lucene-queries" % "5.5.2",
    "org.apache.lucene" % "lucene-sandbox" % "5.5.2",
    "org.apache.lucene" % "lucene-spatial3d" % "5.5.2",
    "org.apache.lucene" % "lucene-suggest" % "5.5.2",
    "com.typesafe.play.modules" %% "play-modules-redis" % "2.4.1"
)

// redis-server cache
//libraryDependencies += "com.github.karelcemus" %% "play-redis" % "1.0.0"

// repository with the Brando connector
//resolvers += "Brando Repository" at "http://chrisdinn.github.io/releases/"
resolvers += "google-sedis-fix" at "http://pk11-scratch.googlecode.com/svn/trunk"
