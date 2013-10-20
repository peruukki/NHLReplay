import sbt._
import sbt.Keys._
import de.johoop.jacoco4sbt.JacocoPlugin._
import org.scalastyle.sbt._
import play.Project._

object NHLReplayBuild extends Build {
  import Dependency._
  import Resolvers._

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization  := "com.nhlreplay",
    version       := "0.1",
    scalaVersion  := "2.10.2",
    scalacOptions := Seq("-deprecation", "-feature", "-unchecked"),
    resolvers     := allResolvers
  )
  lazy val jacocoSettings = jacoco.settings
  lazy val scalastyleSettings = ScalastylePlugin.Settings
  lazy val playSettings = playScalaSettings

  lazy val root = play.Project(
    name = "NHLReplay",
    settings = buildSettings ++ jacocoSettings ++ scalastyleSettings ++ playSettings ++ Seq(
      libraryDependencies ++= Seq(json4sNative, logback, scalaLogging, scalaTest)
    )
  )

  object Dependency {
    val json4sNative = "org.json4s" %% "json4s-native" % "3.2.5"
    val logback = "ch.qos.logback" % "logback-classic" % "1.0.13"
    val scalaLogging = "com.typesafe" %% "scalalogging-slf4j" % "1.0.1"
    val scalaTest = "org.scalatest" % "scalatest_2.10" % "1.9.2" % "test"
  }

  object Resolvers {
    val allResolvers = Seq(
      "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
    )
  }
}
