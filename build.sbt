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
    "com.alibaba" % "fastjson" % "1.1.45",
    "org.mongodb" % "mongodb-driver" % "3.2.2",
    "joda-time" % "joda-time" % "2.9.4",
    "com.aliyun.oss" % "aliyun-sdk-oss" % "2.2.3",
    "commons-lang" % "commons-lang" % "2.6"
)
