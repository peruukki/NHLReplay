package com.nhlreplay.parser.reports

import xml.NodeSeq

class GameReports(columns: NodeSeq)
{
  val date = columns(0).text
  val awayTeam = columns(2).text
  val homeTeam = columns(3).text
  val playByPlayURL = (((columns \ "a") filter { _.text == "Play by Play" }).head \ "@href").text
}
