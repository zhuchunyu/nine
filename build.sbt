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
    "commons-lang" % "commons-lang" % "2.6",
    "com.typesafe.play.modules" %% "play-modules-redis" % "2.4.1"
)

// redis-server cache
//libraryDependencies += "com.github.karelcemus" %% "play-redis" % "1.0.0"

// repository with the Brando connector
//resolvers += "Brando Repository" at "http://chrisdinn.github.io/releases/"
resolvers += "google-sedis-fix" at "http://pk11-scratch.googlecode.com/svn/trunk"
