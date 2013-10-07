package com.nhlreplay.parser.playbyplay

import scala.xml.NodeSeq
import collection.mutable.ListBuffer
import com.typesafe.scalalogging.slf4j.Logging
import scala.io.Source
import scala.xml.parsing.XhtmlParser

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
    val away = new Team("away", getHtmlNameInfo(document, "Visitor"), abbrInfo.head)
    val home = new Team("home", getHtmlNameInfo(document, "Home"), abbrInfo.tail.head)
    GameTeams(away, home)
  }

  private def parseEvents(document: NodeSeq) = {
    val htmlEvents = getHtmlEvents(document)
    val gameEvents = htmlEvents map { x => GameEventParsed(x \ "td") }
    val interestingEvents = gameEvents filter { !_.ignore }
    GameEvents(gameEvents, interestingEvents, addEvents(interestingEvents))
  }

  private def getHtmlEvents(document: NodeSeq) = document \\ "body" \ "table" \\ "tr" filter { x => (x \ "@class").text == "evenColor" }
  private def getHtmlNameInfo(document: NodeSeq, attr: String) = document \\ "table" filter { x => (x \ "@id").text == attr }
  private def getHtmlAbbrInfo(document: NodeSeq) = document \\ "td" filter { _.text contains " On Ice" }

  private def addEvents(events: Seq[GameEvent]) = {
    var newEvents = new ListBuffer[GameEvent]
    events.foreach { x =>
      if (x.generateGoalAttempt) newEvents += new GameEventGoalAttempt(x)
      newEvents += x
    }
    newEvents.toSeq
  }
}
