package com.nhlreplay.parser.playbyplay

import com.nhlreplay.json.HasJson
import com.typesafe.scalalogging.slf4j.Logging
import org.json4s.JsonDSL._
import util.matching.Regex
import xml.{NodeSeq, Node}

object GameEvent
{
  val EventColPeriod = 1
  val EventColStrength = 2
  val EventColTime = 3
  val EventColEvent = 4
  val EventColDescription = 5

  val Assist1st = "assist1st"
  val Assist2nd = "assist2nd"
  val Distance = "distance"
  val Duration = "duration"
  val OtherPlayer = "otherPlayer"
  val OtherTeam = "otherTeam"
  val Player = "player"
  val Reason = "reason"
  val ShotOnGoal = "shotOnGoal"
  val ShotType = "shotType"
  val Target = "target"
  val Team = "team"
  val WonTeam = "wonTeam"
  val Zone = "zone"
}

abstract class GameEvent(val columns: NodeSeq, val ignore: Boolean)
  extends HasJson
  with Logging
{
  val tokenValues: Seq[TokenValue]

  lazy val period = columns(GameEvent.EventColPeriod).text.trim.toInt
  lazy val strength = columns(GameEvent.EventColStrength).text.trim
  val eventType: String
  lazy val (minElapsed, secElapsed, minLeft, secLeft) = parseTime(columns(GameEvent.EventColTime))

  private def parseTime(timeNode: Node) = {
    val pattern = new Regex("""(\d+):(\d+).+?(\d+):(\d+)""", "minElapsed", "secElapsed", "minLeft", "secLeft")
    val time = pattern.findFirstMatchIn(timeNode.mkString).get
    (time.group("minElapsed").toInt, time.group("secElapsed").toInt,
     time.group("minLeft").toInt, time.group("secLeft").toInt)
  }

  protected def trim(text: String) = """\s+""".r.replaceAllIn(text, " ")

  def toJson: String = {
    val filteredValues = tokenValues.filter(_.token.visibility == TokenVisibility.Public)
    val json = filteredValues.foldLeft(commonPropertiesToJson)((json, tv) => json ~ (tv.token.name -> tv.toJValue))
    escape(serializeJson(json))
  }

  private def commonPropertiesToJson = {
    ("period" -> period) ~ ("minElapsed" -> minElapsed) ~ ("secElapsed" -> secElapsed) ~
      ("minLeft" -> minLeft) ~ ("secLeft" -> secLeft) ~ ("type" -> eventType) ~ ("strength" -> strength)
  }

  private def escape(text: String) = text.replaceAll("'", """\\'""")
}
