package com.nhlreplay

import converter.xhtml.XhtmlConverter
import javax.inject.Singleton
import parser.playbyplay.GameEventParser
import parser.reports.{GameReportSource, GameReportsParser}
import services.GameReportService
import utils.FileUtils

@Singleton
class NHLGameReportService extends GameReportService
{
  val playByPlayPath = "app/resources/playbyplay"

  def update(): Unit = {
    val playByPlayReportFile = retrievePlayByPlayReport(retrieveGameReports().head.playByPlayURL)
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
