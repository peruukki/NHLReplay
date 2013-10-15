package com.nhlreplay.parser.playbyplay

import com.nhlreplay.json.HasJson
import com.nhlreplay.utils.FileUtils
import collection.mutable.ListBuffer

case class GameInfo(teams: GameTeams, events: GameEvents)
{
  val dataVariable = "data"

  def writeToJsonpFile(fileName: String) {
    val jsonp = new ListBuffer[String]
    jsonp += """function getJsonData() {
               |  var %s = '{ ';
               |""".stripMargin.format(dataVariable)
    jsonp += getJsonpEvents
    jsonp += "\n  %s += ',';\n".format(dataVariable)
    jsonp += getJsonpTeams
    jsonp += """
               |  %s += '}'
               |
               |  return %s;
               |}""".stripMargin.format(dataVariable, dataVariable)
    FileUtils.writeToFile(fileName, jsonp.toList)
  }

  private def getJsonpEvents = getJsonp("gameEvents", events.eventual)
  private def getJsonpTeams = getJsonp("teams", Seq(teams.away, teams.home))

  private def getJsonp(name: String, values: Seq[HasJson]) = {
    val builder = new StringBuilder()
    builder.append("""  %s += '"%s": [' +
                     |""".stripMargin.format(dataVariable, name))
    values foreach { v => builder.append("    '").append(v.toJson).append(",' +\n") }
    builder.deleteCharAt(builder.lastIndexOf(","))
    builder.append("  ']';")
    builder.toString()
  }
}

case class GameTeams(away: Team, home: Team)

case class GameEvents(original: Seq[GameEvent], filtered: Seq[GameEvent], eventual: Seq[GameEvent])
