package com.nhlreplay

import converter.xhtml.XhtmlConverter
import parser.playbyplay.GameEventParser
import parser.reports.{GameReportSource, GameReportsParser}
import utils.FileUtils

object Main
{
  val playByPlayPath = "src/test/resources/playbyplay"

  def main(args: Array[String]) {
    val gameReports = retrieveGameReports()
    val playByPlayReportFile = retrievePlayByPlayReport(gameReports.head.playByPlayURL)
    parsePlayByPlay(playByPlayReportFile)
  }

  private def retrieveGameReports() = {
    val gameReportFile = GameReportSource.getReportsByTeam("TOR")
    val xhtmlFile = XhtmlConverter.convertHtml(gameReportFile)
    GameReportsParser.parse(xhtmlFile)
  }

  private def retrievePlayByPlayReport(reportURL: String) = {
    val fileName = reportURL.substring(reportURL.lastIndexOf("/"))
    FileUtils.retrieveFile(reportURL, playByPlayPath + fileName)
  }

  private def parsePlayByPlay(reportPath: String) {
    val xhtmlFile = XhtmlConverter.convertHtml(reportPath)
    val gameInfo = GameEventParser.parse(xhtmlFile)
    gameInfo.writeToJsonpFile("../client/src/main/jsonp/data.jsonp")
  }
}
