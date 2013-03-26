package com.nhlreplay.parser.playbyplay

import util.matching.Regex
import xml.NodeSeq

class GameEventMiss(columns: NodeSeq, description: String)
  extends GameEvent(columns: NodeSeq) with GameEventGoalAttemptValues
{
  val (team, shooter, shotType, target) = parseDescription(description)

  private def parseDescription(description: String) = {
    val pattern = new Regex(PATTERN_TEAM + "(" + PATTERN_PLAYER + """),""" + PATTERN_SHOT_TYPE + """\s+(.+?),""",
                            "team", "shooter", "shotType", "target")
    pattern.findFirstMatchIn(description) match {
      case Some(shotMatch) => (Team.trimAbbreviation(shotMatch.group("team")),
                               trim(shotMatch.group("shooter")),
                               shotMatch.group("shotType"),
                               trimTarget(trim(shotMatch.group("target"))))
      case None => throw new RuntimeException("No match in '%s'".format(description))
    }
  }

  private def trimTarget(target: String) = {
    target.toLowerCase match {
      case "goalpost" => "hits the post"
      case "hit crossbar" => "hits the crossbar"
      case "over net" => "over the net"
      case "wide of net" => "wide"
      case x => x
    }
  }

  override def getJson: String = {
    val builder = super.startJson()
    appendValue(builder, "team", team)
    appendValue(builder, "shooter", shooter)
    appendValue(builder, "shotType", shotType)
    appendValue(builder, "target", target)
    super.finishJson(builder)
  }
}
