package com.nhlreplay.parser.playbyplay

import util.matching.Regex
import xml.{NodeSeq, Node}
import com.typesafe.scalalogging.slf4j.Logging

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
  val Zone = "zone"
}

abstract class GameEvent(val columns: NodeSeq, val generateGoalAttempt: Boolean, val ignore: Boolean)
  extends HasJson
  with Logging
{
  val tokenValues: Seq[TokenValue]

  val period = columns(GameEvent.EventColPeriod).text.trim.toInt
  val strength = columns(GameEvent.EventColStrength).text.trim
  val eventType: String
  val (minElapsed, secElapsed, minLeft, secLeft) = parseTime(columns(GameEvent.EventColTime))

  private def parseTime(timeNode: Node) = {
    val pattern = new Regex("""(\d+):(\d+).+?(\d+):(\d+)""", "minElapsed", "secElapsed", "minLeft", "secLeft")
    val time = pattern.findFirstMatchIn(timeNode.mkString).get
    (time.group("minElapsed").toInt, time.group("secElapsed").toInt,
     time.group("minLeft").toInt, time.group("secLeft").toInt)
  }

  protected def trim(text: String) = """\s+""".r.replaceAllIn(text, " ")

  def getJson: String = {
    val builder = startJson()
    tokenValues.filter(_.token.visibility == TokenVisibility.Public)
               .foreach(tv => appendValue(builder, tv.token.name, tv.value))
    finishJson(builder)
  }

  protected def startJson() = {
    val builder = new StringBuilder()
    builder.append("{")
    appendValue(builder, "period", period)
    appendValue(builder, "minElapsed", minElapsed)
    appendValue(builder, "secElapsed", secElapsed)
    appendValue(builder, "minLeft", minLeft)
    appendValue(builder, "secLeft", secLeft)
    appendValue(builder, "type", eventType)
    appendValue(builder, "strength", strength)
    builder
  }

  protected def finishJson(builder: StringBuilder) = {
    builder.deleteCharAt(builder.length - 1)
    builder.append(" }")
    builder.toString()
  }

  private def appendValue(builder: StringBuilder, key: String, value: Any) {
    builder.append(getJsonValue(key, value))
  }

  private def getJsonValue(key: String, value: Any) = {
    val format = {
      if (value.isInstanceOf[String]) """ "%s":"%s","""
      else """ "%s":%s,"""
    }
    format.format(key, value).replaceAll("'", """\\'""")
  }
}
