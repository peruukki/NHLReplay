package com.nhlreplay.parser.playbyplay

import util.matching.Regex
import xml.NodeSeq

class GameEventShotOnGoal(columns: NodeSeq, description: String)
  extends GameEvent(columns: NodeSeq) with GameEventGoalAttemptValues
{
  val (team, shooter, shotType) = parseDescription(description)

  private def parseDescription(description: String) = {
    val pattern = new Regex(PATTERN_TEAM + """ONGOAL\s-\s(""" + PATTERN_PLAYER + ")," + PATTERN_SHOT_TYPE,
                            "team", "shooter", "shotType")
    pattern.findFirstMatchIn(description) match {
      case Some(shotMatch) => (Team.trimAbbreviation(shotMatch.group("team")),
                               trim(shotMatch.group("shooter")),
                               shotMatch.group("shotType"))
      case None => throw new RuntimeException("No match in '%s'".format(description))
    }
  }

  override def getJson: String = {
    val builder = super.startJson()
    appendValue(builder, "team", team)
    appendValue(builder, "shooter", shooter)
    appendValue(builder, "shotType", shotType)
    super.finishJson(builder)
  }
}
