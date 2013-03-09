package com.nhlreplay

import converter.xhtml.XhtmlConverter
import parser.playbyplay.GameEventParser
import parser.reports.GameReportsParser

object Main
{
  def main(args: Array[String]) {
    parsePlayByPlay()
    parseGameReports()
  }

  private def parsePlayByPlay() {
    val xhtmlFile = XhtmlConverter.convertHtml("src/test/resources/playbyplay/PL020160.HTM")
    val gameInfo = GameEventParser.parse(xhtmlFile)
    gameInfo.writeToJsonpFile("../client/src/main/jsonp/data.jsonp")
  }

  private def parseGameReports() {
    val xhtmlFile = XhtmlConverter.convertHtml("src/test/resources/reports/TOR.HTM")
    val gameReports = GameReportsParser.parse(xhtmlFile)
  }
}
