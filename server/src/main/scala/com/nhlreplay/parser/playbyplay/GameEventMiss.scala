package com.nhlreplay.parser.playbyplay

import util.matching.Regex
import xml.NodeSeq

class GameEventMiss(columns: NodeSeq, description: String)
  extends GameEvent(columns: NodeSeq) with GameEventGoalAttemptValues
{
  val (team, shooter, target) = parseDescription(description)

  private def parseDescription(description: String) = {
    val pattern = new Regex(PATTERN_TEAM + "(" + PATTERN_PLAYER + """),.+?,\s+(.+?),""", "team", "shooter", "target")
    pattern.findFirstMatchIn(description) match {
      case Some(shotMatch) => (shotMatch.group("team"), trim(shotMatch.group("shooter")),
                               trim(shotMatch.group("target")))
      case None => throw new RuntimeException("No match in '%s'".format(description))
    }
  }

  override def getJson = {
    val builder = super.startJson()
    appendValue(builder, "team", team)
    appendValue(builder, "shooter", shooter)
    appendValue(builder, "target", target)
    super.finishJson(builder)
  }
}
