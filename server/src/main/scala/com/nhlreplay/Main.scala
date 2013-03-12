package com.nhlreplay

import converter.xhtml.XhtmlConverter
import parser.playbyplay.GameEventParser
import parser.reports.{GameReportSource, GameReportsParser}

object Main
{
  def main(args: Array[String]) {
    val gameReports = retrieveGameReports()
    parsePlayByPlay()
  }

  private def retrieveGameReports() {
    val gameReportFile = GameReportSource.getReportsByTeam("TOR")
    val xhtmlFile = XhtmlConverter.convertHtml(gameReportFile)
    GameReportsParser.parse(xhtmlFile)
  }

  private def parsePlayByPlay() {
    val xhtmlFile = XhtmlConverter.convertHtml("src/test/resources/playbyplay/PL020160.HTM")
    val gameInfo = GameEventParser.parse(xhtmlFile)
    gameInfo.writeToJsonpFile("../client/src/main/jsonp/data.jsonp")
  }

}
