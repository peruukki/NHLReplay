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

    "parse faceoff" in { parse(faceoffXhtml) shouldEqual faceoffJson }

    "parse goal without assists" in { parse(goalWithoutAssistsXhtml) shouldEqual goalWithoutAssistsJson }
    "parse goal with one assist" in { parse(goalWithOneAssistXhtml) shouldEqual goalWithOneAssistJson }
    "parse goal with two assists" in { parse(goalWithTwoAssistsXhtml) shouldEqual goalWithTwoAssistsJson }

    "parse hit" in { parse(hitXhtml) shouldEqual hitJson }

    "parse penalty drawn by opponent" in { parse(penaltyDrawnXhtml) shouldEqual penaltyDrawnJson }
    "parse major penalty" in { parse(penaltyMajorXhtml) shouldEqual penaltyMajorJson }
    "parse undrawn penalty" in { parse(penaltyUndrawnXhtml) shouldEqual penaltyUndrawnJson }
    "parse penalty served by another player" in { parse(penaltyServedByXhtml) shouldEqual penaltyServedByJson }
    "parse team penalty" in { parse(penaltyTeamXhtml) shouldEqual penaltyTeamJson }

    "parse period end" in { parse(periodEndXhtml) shouldEqual periodEndJson }
    "parse period start" in { parse(periodStartXhtml) shouldEqual periodStartJson }

    "parse blocked shot" in { parse(shotBlockedXhtml) shouldEqual shotBlockedJson }

    "parse shot that missed the goal" in { parse(shotMissedXhtml) shouldEqual shotMissedJson }

    "parse shot on goal" in { parse(shotOnGoalXhtml) shouldEqual shotOnGoalJson }
    "parse penalty shot on goal" in { parse(shotOnGoalPenaltyShotXhtml) shouldEqual shotOnGoalPenaltyShotJson }

    def parse(gameEvent: NodeSeq) = GameEventParser.parseGameEvents(gameEvent).head.toJson
  }
}
