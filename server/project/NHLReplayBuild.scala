import sbt._
import sbt.Keys._
import de.johoop.jacoco4sbt.JacocoPlugin._
import org.scalastyle.sbt._

object NHLReplayBuild extends Build {
  import Dependency._
  import Resolvers._

  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization  := "com.nhlreplay",
    version       := "0.1",
    scalaVersion  := "2.10.3",
    scalacOptions := Seq("-deprecation", "-feature", "-unchecked"),
    resolvers     := allResolvers
  )
  lazy val jacocoSettings = jacoco.settings
  lazy val scalastyleSettings = ScalastylePlugin.Settings

  lazy val root = Project(
    id = "root",
    base = file("."),
    settings = buildSettings ++ jacocoSettings ++ scalastyleSettings ++ Seq(
      libraryDependencies ++= Seq(logback, scalaLogging, specs2)
    )
  )

  object Dependency {
    val logback = "ch.qos.logback" % "logback-classic" % "1.0.13"
    val scalaLogging = "com.typesafe" %% "scalalogging-slf4j" % "1.0.1"
    val specs2 = "org.specs2" %% "specs2" % "2.2.2" % "test"
  }

  object Resolvers {
    val allResolvers = Seq(
      "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/"
    )
  }
}
