package com.nhlgametracker.parser.playbyplay

import util.matching.Regex
import xml.NodeSeq

class GameEventGoal(columns: NodeSeq, description: String)
  extends GameEvent(columns: NodeSeq)
{
  val (team, scorer, assist_1st, assist_2nd) = parseDescription(description)

  private def parseDescription(description: String) = {
    val goalPattern = new Regex(PATTERN_TEAM + PATTERN_PLAYER_COUNT, "team", "scorer")
    val firstAssistPattern = new Regex(""".+Assists?:\s""" + PATTERN_PLAYER_COUNT, "assist_1st")
    val secondAssistPattern = new Regex(""";\s""" + PATTERN_PLAYER_COUNT, "assist_2nd")

    goalPattern.findFirstMatchIn(description) match {

      case Some(scorerMatch) => {
        val (team, scorer) = (scorerMatch.group("team"), trim(scorerMatch.group("scorer")))
        firstAssistPattern.findFirstMatchIn(scorerMatch.after) match {

          case Some(assist1stMatch) => {
            val assist_1st = trim(assist1stMatch.group("assist_1st"))
            secondAssistPattern.findFirstMatchIn(assist1stMatch.after) match {

              case Some(assist2ndMatch) => {
                val assist_2nd = trim(assist2ndMatch.group("assist_2nd"))
                (team, scorer, assist_1st, assist_2nd)
              }

              case None => (team, scorer, assist_1st, "")
            }
          }

          case None => (team, scorer, "", "")
        }
      }

      case None => throw new RuntimeException("No match in '%s'".format(description))
    }
  }

  override def showJson() {
    val builder = super.startJson()
    appendValue(builder, "team", team)
    appendValue(builder, "scorer", scorer)
    appendValue(builder, "assist_1st", assist_1st)
    appendValue(builder, "assist_2nd", assist_2nd)
    super.finishJson(builder)
  }
}
