package com.nhlreplay.parser.playbyplay

import scala.xml.NodeSeq

class GameEventParser
{
  def parse(filePath: String): Seq[GameEvent] = {
    val document = xml.parsing.XhtmlParser(io.Source.fromFile(filePath))

    val homeTeam = new Team(getHtmlInfo(document, "Home"))
    val awayTeam = new Team(getHtmlInfo(document, "Visitor"))

    val htmlEvents = getHtmlEvents(document)
    val gameEvents = htmlEvents map { x => GameEvent(x \ "td") }
    val interestingEvents = gameEvents filter { x => x.getClass().getSimpleName() != "GameEvent" }
    interestingEvents foreach { _.showJson }
    interestingEvents
  }

  private def getHtmlEvents(document: NodeSeq) = document \\ "body" \ "table" \\ "tr" filter { x => (x \ "@class").text == "evenColor" }
  private def getHtmlInfo(document: NodeSeq, attr: String) = document \\ "table" filter { x => (x \ "@id").text == attr }
}
