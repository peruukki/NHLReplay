package com.nhlreplay.parser.playbyplay

import com.nhlreplay.utils.FileUtils
import scala.xml.NodeSeq
import collection.mutable.ListBuffer
import com.typesafe.scalalogging.slf4j.Logging

object GameEventParser extends Logging
{
  def parse(filePath: String): GameInfo = {
    logger.info(s"Parsing file '$filePath'")
    val document = xml.parsing.XhtmlParser(FileUtils.getFileSource(filePath))

    val abbrInfo = getHtmlAbbrInfo(document)
    val awayTeam = new Team("away", getHtmlNameInfo(document, "Visitor"), abbrInfo.head)
    val homeTeam = new Team("home", getHtmlNameInfo(document, "Home"), abbrInfo.tail.head)

    val htmlEvents = getHtmlEvents(document)
    val gameEvents = htmlEvents map { x => GameEventParsed(x \ "td") }
    val interestingEvents = gameEvents filter { !_.ignore }
    val finalEvents = addEvents(interestingEvents)
    GameInfo(List(awayTeam, homeTeam), finalEvents)
  }

  private def getHtmlEvents(document: NodeSeq) = document \\ "body" \ "table" \\ "tr" filter { x => (x \ "@class").text == "evenColor" }
  private def getHtmlNameInfo(document: NodeSeq, attr: String) = document \\ "table" filter { x => (x \ "@id").text == attr }
  private def getHtmlAbbrInfo(document: NodeSeq) = document \\ "td" filter { x => x.text contains " On Ice" }

  private def addEvents(events: Seq[GameEvent]) = {
    var newEvents = new ListBuffer[GameEvent]
    events.foreach { x =>
      if (x.generateGoalAttempt) newEvents += new GameEventGoalAttempt(x)
      newEvents += x
    }
    newEvents.toSeq
  }
}
