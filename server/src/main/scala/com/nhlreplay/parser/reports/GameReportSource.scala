package com.nhlreplay.parser.reports

import com.nhlreplay.utils.FileUtils

object GameReportSource
{
  val sourceURL = "http://www.nhl.com/ice/gamestats.htm"
  val destinationPath = "src/test/resources/reports/"

  val seasonValue = "20132014"

  val GameTypeRegularSeason = "2"
  val GameTypePlayoffs = "3"
  val gameTypeValue = GameTypeRegularSeason

  val reportTypeValue = "teamRTSSreports"

  def getReportsByTeam(team: String): String = {
    val reportURL = sourceURL +
      "?season=" + seasonValue +
      "&gameType=" + gameTypeValue +
      "&team=" + team +
      "&viewName=" + reportTypeValue
    FileUtils.retrieveFile(reportURL, destinationPath + team + ".HTM")
  }
}
