package com.nhlreplay.parser.playbyplay

import util.matching.Regex
import xml.{NodeSeq, Node}

object GameEvent
{
  val EVENT_COL_PERIOD = 1
  val EVENT_COL_STRENGTH = 2
  val EVENT_COL_TIME = 3
  val EVENT_COL_EVENT = 4
  val EVENT_COL_DESCRIPTION = 5

  def apply(columns: NodeSeq) = {
    val description = columns(EVENT_COL_DESCRIPTION).mkString
    val eventType = columns(EVENT_COL_EVENT).text.trim

    if (eventType == "GOAL") new GameEventGoal(columns, description)
    else if (eventType == "PENL") new GameEventPenalty(columns, description)
    else if (eventType == "SHOT") new GameEventShotOnGoal(columns, description)
    else if (eventType == "MISS") new GameEventMiss(columns, description)
    else if (eventType == "PSTR") new GameEventPeriodStart(columns)
    else if (eventType == "PEND") new GameEventPeriodEnd(columns)
    else new GameEvent(columns)
  }
}

class GameEvent(val columns: NodeSeq, givenType: String = "")
{
  protected val PATTERN_TEAM = """(\w+)\s"""
  protected val PATTERN_PLAYER_NAME = """(?:\w|\s|-|')+"""
  protected val PATTERN_PLAYER = """#\d+(?s)\s+""" + PATTERN_PLAYER_NAME
  protected val PATTERN_PLAYER_COUNT = """(#\d+(?s)\s+""" + PATTERN_PLAYER_NAME + """)(\(\d+\))"""

  val period = columns(GameEvent.EVENT_COL_PERIOD).text.trim.toInt
  val strength = columns(GameEvent.EVENT_COL_STRENGTH).text.trim
  val eventType = if (givenType.isEmpty) columns(GameEvent.EVENT_COL_EVENT).text.trim else givenType
  val (minElapsed, secElapsed, minLeft, secLeft) = parseTime(columns(GameEvent.EVENT_COL_TIME))

  private def parseTime(timeNode: Node) = {
    val pattern = new Regex("""(\d+):(\d+).+?(\d+):(\d+)""", "minElapsed", "secElapsed", "minLeft", "secLeft")
    val time = pattern.findFirstMatchIn(timeNode.mkString).get
    (time.group("minElapsed").toInt, time.group("secElapsed").toInt,
     time.group("minLeft").toInt, time.group("secLeft").toInt)
  }

  protected def trim(text: String) = """\s+""".r.replaceAllIn(text, " ")

  def getJson = {
    val builder = startJson()
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

  protected def appendValue(builder: StringBuilder, key: String, value: String) {
    if (value.isEmpty) return
    else builder.append(getJsonValue(key, value))
  }
  protected def appendValue(builder: StringBuilder, key: String, value: Int) {
    builder.append(getJsonValue(key, value))
  }

  private def getJsonValue(key: String, value: String) = """ "%s":"%s",""".format(key, value)
  private def getJsonValue(key: String, value: Int) = """ "%s":%d,""".format(key, value)
}
