package com.nhlgametracker.parser.playbyplay

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
    else new GameEvent(columns)
  }
}

class GameEvent(columns: NodeSeq)
{
  protected val PATTERN_TEAM = """(\w+)\s"""
  protected val PATTERN_PLAYER = """#\d+(?s)\s+(?:\w|\s|-|')+"""
  protected val PATTERN_PLAYER_COUNT = """(#\d+(?s)\s+\w+\(\d+\))"""

  val period = columns(GameEvent.EVENT_COL_PERIOD).text.trim.toInt
  val strength = columns(GameEvent.EVENT_COL_STRENGTH).text.trim
  val eventType = columns(GameEvent.EVENT_COL_EVENT).text.trim
  val (minElapsed, secElapsed, minLeft, secLeft) = parseTime(columns(GameEvent.EVENT_COL_TIME))

  private def parseTime(timeNode: Node) = {
    val pattern = new Regex("""(\d+):(\d+).+?(\d+):(\d+)""", "minElapsed", "secElapsed", "minLeft", "secLeft")
    val time = pattern.findFirstMatchIn(timeNode.mkString).get
    (time.group("minElapsed").toInt, time.group("secElapsed").toInt,
     time.group("minLeft").toInt, time.group("secLeft").toInt)
  }

  protected def trim(text: String) = """\s+""".r.replaceAllIn(text, " ")

  def showJson() {
    val builder = startJson()
    finishJson(builder)
  }

  protected def startJson() = {
    val builder = new StringBuilder()
    builder.append("'{")
    appendValue(builder, "period", period)
    appendValue(builder, "minElapsed", minElapsed)
    appendValue(builder, "secElapsed", secElapsed)
    appendValue(builder, "minLeft", minLeft)
    appendValue(builder, "secLeft", secLeft)
    appendValue(builder, "type", eventType)
    appendValue(builder, "strength", strength)
    builder
  }

  protected def finishJson(builder: StringBuilder) {
    builder.deleteCharAt(builder.length - 1)
    builder.append(" },' +")
    println(builder.toString())
  }

  protected def appendValue(builder: StringBuilder, key: String, value: String) {
    if (value.isEmpty) return
    else builder.append(getJsonValue(key, value))
  }
  protected def appendValue(builder: StringBuilder, key: String, value: Int) {
    if (value == 0) return
    else builder.append(getJsonValue(key, value))
  }

  private def getJsonValue(key: String, value: String) = """ "%s":"%s",""".format(key, value)
  private def getJsonValue(key: String, value: Int) = """ "%s":%d,""".format(key, value)
}
