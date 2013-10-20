package com.nhlreplay.parser.playbyplay

import com.nhlreplay.json.HasJson
import com.nhlreplay.utils.FileUtils
import collection.mutable.ListBuffer

case class GameInfo(teams: GameTeams, events: GameEvents)
{
  val dataVariable = "data"
  val gameEventsName = "gameEvents"
  val teamsName = "teams"

  def writeToJsonpFile(fileName: String) {
    FileUtils.writeToFile(fileName, toJsonp)
  }

  def toJsonp: Seq[String] = {
    val jsonp = new ListBuffer[String]
    jsonp += s"""function getJsonData() {
               |  var $dataVariable = '{ ';
               |""".stripMargin
    jsonp += getJsonpEvents
    jsonp += s"\n  $dataVariable += ',';\n"
    jsonp += getJsonpTeams
    jsonp += s"""
               |  $dataVariable += '}'
               |
               |  return $dataVariable;
               |}""".stripMargin
    jsonp.toSeq
  }

  private def getJsonpEvents = getJsonp(gameEventsName, events.eventual)
  private def getJsonpTeams = getJsonp(teamsName, Seq(teams.away, teams.home))

  private def getJsonp(name: String, values: Seq[HasJson]) = {
    val builder = new StringBuilder()
    builder.append(s"""  $dataVariable += '"$name": [' +
                     |""".stripMargin)
    values.foreach(value => builder.append("    '").append(value.toJson).append(",' +\n"))
    builder.deleteCharAt(builder.lastIndexOf(","))
    builder.append("  ']';")
    builder.toString()
  }
}

case class GameTeams(away: Team, home: Team)

case class GameEvents(original: Seq[GameEvent], filtered: Seq[GameEvent], eventual: Seq[GameEvent])
