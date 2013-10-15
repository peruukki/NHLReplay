package com.nhlreplay.parser.playbyplay

import com.nhlreplay.utils.FileUtils
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec
import TestGameEventJson._
import TestGameEventXhtml._

class GameEventParserSpec extends WordSpec with ShouldMatchers
{
  "GameEventParser" should {
    val xhtml = FileUtils.getResourceFileSource("playbyplay/PL020004.XHTML")
    val gameInfo = GameEventParser.parse(xhtml)

    "parse teams" in {
      gameInfo.teams.away.name shouldEqual "TORONTO MAPLE LEAFS"
      gameInfo.teams.away.abbreviation shouldEqual "TOR"
      gameInfo.teams.home.name shouldEqual "PHILADELPHIA FLYERS"
      gameInfo.teams.home.abbreviation shouldEqual "PHI"
    }

    "parse original game events" in { gameInfo.events.original.length shouldEqual 352 }
    "filter original game events" in { gameInfo.events.filtered.length shouldEqual 260 }
    "produce eventual game events" in { gameInfo.events.eventual.length shouldEqual 375 }

    "parse goal event without assists" in {
      GameEventParser.parseGameEvents(goalWithoutAssistsXhtml).head.toJson shouldEqual goalWithoutAssistsJson
    }
    "parse goal event with one assist" in {
      GameEventParser.parseGameEvents(goalWithOneAssistXhtml).head.toJson shouldEqual goalWithOneAssistJson
    }
    "parse goal event with two assists" in {
      GameEventParser.parseGameEvents(goalWithTwoAssistsXhtml).head.toJson shouldEqual goalWithTwoAssistsJson
    }
  }
}
