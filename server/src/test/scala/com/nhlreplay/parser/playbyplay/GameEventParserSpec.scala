package com.nhlreplay.parser.playbyplay

import org.specs2.mutable.Specification
import com.nhlreplay.utils.FileUtils

class GameEventParserSpec extends Specification
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
  }
}
