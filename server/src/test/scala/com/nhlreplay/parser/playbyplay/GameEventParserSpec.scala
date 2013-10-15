package com.nhlreplay.parser.playbyplay

import com.nhlreplay.utils.FileUtils
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.WordSpec
import scala.xml.NodeSeq
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

    "parse goal event without assists" in { parse(goalWithoutAssistsXhtml) shouldEqual goalWithoutAssistsJson }
    "parse goal event with one assist" in { parse(goalWithOneAssistXhtml) shouldEqual goalWithOneAssistJson }
    "parse goal event with two assists" in { parse(goalWithTwoAssistsXhtml) shouldEqual goalWithTwoAssistsJson }

    "parse shot on goal" in { parse(shotOnGoalXhtml) shouldEqual shotOnGoalJson }

    def parse(gameEvent: NodeSeq) = GameEventParser.parseGameEvents(gameEvent).head.toJson
  }
}
