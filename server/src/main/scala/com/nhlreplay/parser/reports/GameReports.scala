package com.nhlreplay.parser.reports

import xml.NodeSeq

object GameReports {
  def apply(columns: NodeSeq): GameReports = GameReports(
    date = columns(0).text,
    awayTeam = columns(2).text,
    homeTeam = columns(3).text,
    playByPlayURL = (((columns \ "a") filter { _.text == "Play by Play" }).head \ "@href").text
  )
}

case class GameReports(date: String, awayTeam: String, homeTeam: String, playByPlayURL: String)
