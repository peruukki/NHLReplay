package com.nhlreplay.parser.playbyplay

import scala.xml.NodeSeq
import collection.mutable.ListBuffer

class GameEventParser
{
  def parse(filePath: String) = {
    val document = xml.parsing.XhtmlParser(io.Source.fromFile(filePath))

    val abbrInfo = getHtmlAbbrInfo(document)
    val awayTeam = new Team("away", getHtmlNameInfo(document, "Visitor"), abbrInfo.head)
    val homeTeam = new Team("home", getHtmlNameInfo(document, "Home"), abbrInfo.tail.head)

    val htmlEvents = getHtmlEvents(document)
    val gameEvents = htmlEvents map { x => GameEvent(x \ "td") }
    val interestingEvents = gameEvents filter { x => x.getClass.getSimpleName != "GameEvent" }
    val finalEvents = addEvents(interestingEvents)
    GameInfo(List(awayTeam, homeTeam), finalEvents)
  }

  private def getHtmlEvents(document: NodeSeq) = document \\ "body" \ "table" \\ "tr" filter { x => (x \ "@class").text == "evenColor" }
  private def getHtmlNameInfo(document: NodeSeq, attr: String) = document \\ "table" filter { x => (x \ "@id").text == attr }
  private def getHtmlAbbrInfo(document: NodeSeq) = document \\ "td" filter { x => x.text contains " On Ice" }

  private def addEvents(events: Seq[GameEvent]) = {
    var newEvents = new ListBuffer[GameEvent]
    for (event <- events) {
      if (event.isInstanceOf[GameEventGoalAttemptValues]) {
        newEvents += new GameEventGoalAttempt(event.asInstanceOf[GameEventGoalAttemptValues])
      }
      newEvents += event
    }
    newEvents.toSeq
  }
}
