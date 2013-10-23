package com.nhlreplay.parser.reports

import com.nhlreplay.parser.InvalidContentException
import xml.NodeSeq

object GameReports {
  def apply(columns: NodeSeq): GameReports = GameReports(
    date = parseText(columns, 0, "date"),
    awayTeam = parseText(columns, 2, "away team"),
    homeTeam = parseText(columns, 3, "home team"),
    playByPlayURL = (((columns \ "a") filter { _.text == "Play by Play" }).head \ "@href").text
  )

  private def parseText(columns: NodeSeq, index: Int, label: String) = {
    if (columns.length <= index) throw new InvalidContentException(s"No $label found")
    val value = columns(index).text
    """[\w\s']+""".r.findFirstMatchIn(value) match {
      case Some(found) => value
      case None => throw new InvalidContentException(s"Invalid $label: '$value'")
    }
  }
}

case class GameReports(date: String, awayTeam: String, homeTeam: String, playByPlayURL: String)
