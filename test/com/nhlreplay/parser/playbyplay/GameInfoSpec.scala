package com.nhlreplay.parser.playbyplay

import org.scalatest.WordSpec
import org.scalatest.matchers.ShouldMatchers

class GameInfoSpec extends WordSpec with ShouldMatchers
{
  "GameInfo" should {

    "generate correct jsonp" in {
      val teams = GameTeams(Team(Team.away, "TORONTO", "TOR"), Team(Team.home, "MONTREAL", "MTL"))
      val events = Seq(gameEvent, gameEvent)
      val info = GameInfo(teams, GameEvents(events, events, events))
      info.toJsonp.mkString("\n") shouldEqual expectedJsonp(info.dataVariable, info.gameEventsName, info.teamsName, events, teams)
    }

    lazy val gameEvent = new GameEvent(Seq.empty, false) {
      private val tokenValue = TokenValue(Token("token"), "value")
      val tokenValues = Seq(tokenValue, tokenValue)
      val eventType = "EVENT"
      override lazy val (period, strength, minElapsed, secElapsed, minLeft, secLeft) = (1, "EV", 2, 3, 4, 5)
    }

    def expectedJsonp(dataVariable: String, gameEventsName: String, teamsName: String, events: Seq[GameEvent], teams: GameTeams) =
      s"""function getJsonData() {
        |  var $dataVariable = '{ ';
        |
        |  $dataVariable += '"$gameEventsName": [' +
        |    '${events.head.toJson},' +
        |    '${events.last.toJson}' +
        |  ']';
        |
        |  $dataVariable += ',';
        |
        |  $dataVariable += '"$teamsName": [' +
        |    '${teams.away.toJson},' +
        |    '${teams.home.toJson}' +
        |  ']';
        |
        |  $dataVariable += '}'
        |
        |  return $dataVariable;
        |}""".stripMargin
  }
}
