package com.nhlreplay.parser.playbyplay

import com.typesafe.scalalogging.slf4j.Logging
import scala.io.Source
import scala.xml.NodeSeq
import scala.xml.parsing.XhtmlParser
import com.nhlreplay.parser.playbyplay.GameEventType._

object GameEventParser extends Logging
{
  def parse(xhtmlContent: Source): GameInfo = {
    val document = XhtmlParser(xhtmlContent)
    val teams = parseTeams(document)
    val events = parseEvents(document)
    GameInfo(teams, events)
  }

  private def parseTeams(document: NodeSeq) = {
    val abbrInfo = getHtmlAbbrInfo(document)
    val away = Team(Team.away, getHtmlNameInfo(document, "Visitor"), abbrInfo.head)
    val home = Team(Team.home, getHtmlNameInfo(document, "Home"), abbrInfo.tail.head)
    GameTeams(away, home)
  }

  private def parseEvents(document: NodeSeq) = {
    val htmlEvents = getHtmlEvents(document)
    val gameEvents = parseGameEvents(htmlEvents)
    val interestingEvents = gameEvents.filterNot(_.ignore)
    GameEvents(gameEvents, interestingEvents, addEvents(interestingEvents))
  }

  def parseGameEvents(htmlEvents: NodeSeq): Seq[GameEvent] = htmlEvents.map(event => GameEventParsed(event \ "td"))

  private def getHtmlEvents(document: NodeSeq) = document \\ "body" \ "table" \\ "tr" filter { x => (x \ "@class").text == "evenColor" }
  private def getHtmlNameInfo(document: NodeSeq, attr: String) = document \\ "table" filter { x => (x \ "@id").text == attr }
  private def getHtmlAbbrInfo(document: NodeSeq) = document \\ "td" filter { _.text contains " On Ice" }

  def addEvents(events: Seq[GameEvent]): Seq[GameEvent] = events.flatMap(generateEvents)

  private def generateEvents(event: GameEvent): Seq[GameEvent] = {
    lazy val isPenaltyShot = GameEventParsed.getTokenValue(event.tokenValues, GameEvent.Reason).toString.startsWith("ps-")

    event.eventType match {
      case eventType if Seq(block, goal, miss, shot).contains(eventType) => new GameEventGoalAttempt(event) :: event :: Nil
      case eventType if eventType == penalty => (if (isPenaltyShot) new GameEventPenaltyShot(event) else event) :: Nil
      case _ => event :: Nil
    }
  }
}
