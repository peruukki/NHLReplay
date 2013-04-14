package com.nhlreplay.parser.playbyplay

import util.matching.Regex
import xml.NodeSeq

class GameEventPenalty(columns: NodeSeq, description: String)
  extends GameEvent(columns: NodeSeq)
{
  val (team, taker, reason, duration) = parseDescription(description)

  private def parseDescription(description: String) = {
    val pattern = new Regex(PATTERN_TEAM + """(""" + PATTERN_PLAYER + """|TEAM)""" +
                            """\u00a0(.+?)(?:\s\(maj\))?\((\d+)\smin\)""", "team", "taker", "reason", "duration")
    pattern.findFirstMatchIn(description) match {
      case Some(penaltyMatch) => (Team.trimAbbreviation(penaltyMatch.group("team")),
                                  trim(penaltyMatch.group("taker")),
                                  trim(penaltyMatch.group("reason")).toLowerCase,
                                  penaltyMatch.group("duration").toInt)
      case None => throw new RuntimeException("No match in '%s'".format(description))
    }
  }

  override def getJson: String = {
    val builder = super.startJson()
    appendValue(builder, "team", team)
    appendValue(builder, "taker", taker)
    appendValue(builder, "reason", reason)
    appendValue(builder, "duration", duration)
    super.finishJson(builder)
  }
}
