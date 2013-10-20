package com.nhlreplay.parser.playbyplay

import com.nhlreplay.json.HasJson
import org.json4s.JsonDSL._
import xml.NodeSeq

object Team
{
  val away = "away"
  val home = "home"

  def apply(teamType: String, nameColumns: NodeSeq, abbreviationColumn: NodeSeq): Team = {
    Team(teamType, getTeamName(nameColumns), getTeamAbbreviation(abbreviationColumn))
  }

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
      case Some(teamMatch) => trimAbbreviation(teamMatch.group(1))
      case None => throw new RuntimeException("No match in '%s'".format(content))
    }
  }

  private def trimAbbreviation(abbreviation: String): String = abbreviation.replaceAll("""\.""", "")
}

case class Team(teamType: String, name: String, abbreviation: String) extends HasJson
{
  def toJson: String = serializeJson(("type" -> teamType) ~ ("name" -> name) ~ ("abbreviation" -> abbreviation))
}
