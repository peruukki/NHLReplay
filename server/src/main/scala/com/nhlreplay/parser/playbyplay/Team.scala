package com.nhlreplay.parser.playbyplay

import com.nhlreplay.json.HasJson
import org.json4s.JsonDSL._
import xml.NodeSeq

class Team(val teamType: String, nameColumns: NodeSeq, abbreviationColumn: NodeSeq)
  extends HasJson
{
  val name = getTeamName(nameColumns)
  val abbreviation = getTeamAbbreviation(abbreviationColumn)

  private def getTeamName(columns: NodeSeq) = {
    val pattern = """>(.+)<br.*?>""".r
    val content = ((columns \ "tr")(2) \ "td").mkString
    pattern.findFirstMatchIn(content) match {
      case Some(teamMatch) => teamMatch.group(1)
      case None => throw new RuntimeException("No match in '%s'".format(content))
    }
  }

  private def getTeamAbbreviation(column: NodeSeq) = {
    val pattern = (Pattern.Word + Pattern.Separator + """On Ice""").r
    val content = column.mkString
    pattern.findFirstMatchIn(content) match {
      case Some(teamMatch) => Team.trimAbbreviation(teamMatch.group(1))
      case None => throw new RuntimeException("No match in '%s'".format(content))
    }
  }

  def toJson: String = serializeJson(("type" -> teamType) ~ ("name" -> name) ~ ("abbreviation" -> abbreviation))
}

object Team
{
  def trimAbbreviation(abbreviation: String): String = abbreviation.replaceAll("""\.""", "")
}
