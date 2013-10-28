import sbt._
import sbt.Keys._
import de.johoop.jacoco4sbt.JacocoPlugin._
import org.scalastyle.sbt._
import play.Project._

object NHLReplayBuild extends Build {

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization  := "com.nhlreplay",
    version       := "0.1",
    scalaVersion  := "2.10.2",
    scalacOptions := Seq("-deprecation", "-feature", "-unchecked"),
    resolvers     := Resolvers.allResolvers
  )
  lazy val jacocoSettings = jacoco.settings
  lazy val scalastyleSettings = ScalastylePlugin.Settings
  lazy val playSettings = playScalaSettings

  lazy val root = play.Project(
    name = "NHLReplay",
    settings = buildSettings ++ jacocoSettings ++ scalastyleSettings ++ playSettings ++ Seq(
      libraryDependencies ++=
        Seq(Dependency.guice, Dependency.json4sNative, Dependency.logback, Dependency.scalaLogging, Dependency.scalaTest) ++
        Dependency.play
    )
  )

  object Dependency {
    val guice = "com.google.inject" % "guice" % "3.0"
    val json4sNative = "org.json4s" %% "json4s-native" % "3.2.5"
    val logback = "ch.qos.logback" % "logback-classic" % "1.0.13"
    val scalaLogging = "com.typesafe" %% "scalalogging-slf4j" % "1.0.1"
    val scalaTest = "org.scalatest" % "scalatest_2.10" % "1.9.2" % "test"
    val play = Seq(jdbc, anorm, cache)
  }

  object Resolvers {
    val allResolvers = Seq(
      "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
      "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"
    )
  }
}
