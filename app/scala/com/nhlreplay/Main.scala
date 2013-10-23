package com.nhlreplay

import converter.xhtml.XhtmlConverter
import parser.playbyplay.GameEventParser
import parser.reports.{GameReportSource, GameReportsParser}
import utils.FileUtils

object Main
{
  val playByPlayPath = "src/main/resources/playbyplay"

  def main(args: Array[String]) {
    val playByPlayReportFile = {
      if (args.length > 0) playByPlayPath + "/" + args.head
      else retrievePlayByPlayReport(retrieveGameReports().head.playByPlayURL)
    }
    parsePlayByPlay(playByPlayReportFile)
  }

  private def retrieveGameReports() = {
    val gameReportFile = GameReportSource.getReportsByTeam("TOR")
    val html = FileUtils.getFileContent(gameReportFile)
    val xhtml = XhtmlConverter.convertHtml(html, Some(gameReportFile))
    GameReportsParser.parse(xhtml)
  }

  private def retrievePlayByPlayReport(reportURL: String) = {
    val fileName = reportURL.substring(reportURL.lastIndexOf("/"))
    FileUtils.retrieveFile(reportURL, playByPlayPath + fileName)
  }

  private def parsePlayByPlay(reportPath: String) {
    val xhtml = {
      if (reportPath.toLowerCase.endsWith(".xhtml")) FileUtils.getFileSource(reportPath)
      else {
        val html = FileUtils.getFileContent(reportPath)
        XhtmlConverter.convertHtml(html, Some(reportPath))
      }
    }
    val gameInfo = GameEventParser.parse(xhtml)
    gameInfo.writeToJsonpFile("public/jsonp/data.jsonp")
  }
}
