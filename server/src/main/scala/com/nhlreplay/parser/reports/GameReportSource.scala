package com.nhlreplay.parser.reports

import com.nhlreplay.utils.FileUtils

object GameReportSource
{
  val sourceURL = "http://www.nhl.com/ice/gamestats.htm"
  val destinationPath = "src/test/resources/reports/"

  val seasonParam = "season"
  val gameTypeParam = "gameType"
  val teamParam = "team"
  val reportTypeParam = "viewName"

  val seasonValue = "20122013"
  val gameTypeValue = "2"
  val reportTypeValue = "teamRTSSreports"

  def getReportsByTeam(team: String): String = {
    val reportURL = sourceURL + "?" +
      seasonParam + "=" + seasonValue +
      "&" + gameTypeParam + "=" + gameTypeValue +
      "&" + teamParam + "=" + team +
      "&" + reportTypeParam + "=" + reportTypeValue
    val reportContent = FileUtils.getURLContent(reportURL)
    FileUtils.writeToFile(destinationPath + team + ".HTM", List(reportContent))
  }
}
