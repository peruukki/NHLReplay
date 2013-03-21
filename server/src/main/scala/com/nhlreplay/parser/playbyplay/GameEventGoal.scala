package com.nhlreplay.parser.playbyplay

import util.matching.Regex
import xml.NodeSeq

class GameEventGoal(columns: NodeSeq, description: String)
  extends GameEvent(columns: NodeSeq) with GameEventGoalAttemptValues
{
  val (team, shooter, goalCount, assist1st, assist1stCount, assist2nd, assist2ndCount) = parseDescription(description)

  private def parseDescription(description: String) = {
    val goalPattern = new Regex(PATTERN_TEAM + PATTERN_PLAYER_COUNT, "team", "scorer", "count")
    val firstAssistPattern = new Regex(""".+Assists?:\s""" + PATTERN_PLAYER_COUNT, "assist", "count")
    val secondAssistPattern = new Regex(""";\s""" + PATTERN_PLAYER_COUNT, "assist", "count")

    goalPattern.findFirstMatchIn(description) match {

      case Some(scorerMatch) => {
        val (team, scorer, scorerCount) = (Team.trimAbbreviation(scorerMatch.group("team")),
                                           trim(scorerMatch.group("scorer")),
                                           scorerMatch.group("count"))
        val goalCount = if (scorerCount != null) scorerCount else ""

        firstAssistPattern.findFirstMatchIn(scorerMatch.after) match {

          case Some(assist1stMatch) => {
            val (assist1st, assist1stCount) = (trim(assist1stMatch.group("assist")), assist1stMatch.group("count"))
            secondAssistPattern.findFirstMatchIn(assist1stMatch.after) match {

              case Some(assist2ndMatch) => {
                val (assist2nd, assist2ndCount) = (trim(assist2ndMatch.group("assist")), assist2ndMatch.group("count"))
                (team, scorer, goalCount, assist1st, assist1stCount, assist2nd, assist2ndCount)
              }

              case None => (team, scorer, goalCount, assist1st, assist1stCount, "", "")
            }
          }

          case None => (team, scorer, goalCount, "", "", "", "")
        }
      }

      case None => throw new RuntimeException("No match in '%s'".format(description))
    }
  }

  override def getJson: String = {
    val builder = super.startJson()
    appendValue(builder, "team", team)
    appendValue(builder, "shooter", shooter)
    appendValue(builder, "goalCount", goalCount)
    appendValue(builder, "assist1st", assist1st)
    appendValue(builder, "assist1stCount", assist1stCount)
    appendValue(builder, "assist2nd", assist2nd)
    appendValue(builder, "assist2ndCount", assist2ndCount)
    super.finishJson(builder)
  }
}
