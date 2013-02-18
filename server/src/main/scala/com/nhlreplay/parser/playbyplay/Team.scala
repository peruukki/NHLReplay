package com.nhlreplay.parser.playbyplay

import xml.NodeSeq

class Team(val teamType: String, nameColumns: NodeSeq, abbreviationColumn: NodeSeq)
  extends HasJson
{
  val teamName = getTeamName(nameColumns)
  val teamAbbreviation = getTeamAbbreviation(abbreviationColumn)

  private def getTeamName(columns: NodeSeq) = {
    val pattern = """>(.+)<br/>""".r
    val content = ((columns \ "tbody" \ "tr")(2) \ "td").mkString
    pattern.findFirstMatchIn(content) match {
      case Some(teamMatch) => teamMatch.group(1)
      case None => throw new RuntimeException("No match in '%s'".format(content))
    }
  }

  private def getTeamAbbreviation(column: NodeSeq) = {
    val pattern = """(\w+) On Ice""".r
    val content = column.mkString
    pattern.findFirstMatchIn(content) match {
      case Some(teamMatch) => teamMatch.group(1)
      case None => throw new RuntimeException("No match in '%s'".format(content))
    }
  }

  def getJson = {
    val builder = new StringBuilder()
    builder.append("""{ "type":"%s", "name":"%s", "abbreviation":"%s" }""".format(teamType, teamName, teamAbbreviation))
    builder.toString()
  }
}
