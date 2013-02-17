package com.nhlreplay.parser.playbyplay

import scala.xml.NodeSeq
import collection.mutable.ListBuffer

class GameEventParser
{
  def parse(filePath: String) = {
    val document = xml.parsing.XhtmlParser(io.Source.fromFile(filePath))

    val homeTeam = new Team(getHtmlInfo(document, "Home"))
    val awayTeam = new Team(getHtmlInfo(document, "Visitor"))

    val htmlEvents = getHtmlEvents(document)
    val gameEvents = htmlEvents map { x => GameEvent(x \ "td") }
    val interestingEvents = gameEvents filter { x => x.getClass.getSimpleName != "GameEvent" }
    val finalEvents = addEvents(interestingEvents)
    finalEvents foreach { _.showJson() }
    GameInfo(homeTeam, awayTeam, finalEvents)
  }

  private def getHtmlEvents(document: NodeSeq) = document \\ "body" \ "table" \\ "tr" filter { x => (x \ "@class").text == "evenColor" }
  private def getHtmlInfo(document: NodeSeq, attr: String) = document \\ "table" filter { x => (x \ "@id").text == attr }

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
