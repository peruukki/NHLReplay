package com.nhlreplay.parser.playbyplay

import org.json4s.JsonDSL._
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._
import GameEventType._

object TestGameEventJson
{
  val goalWithoutAssistsJson = serialize(teamEventJson(goal) ~
    ("player" -> "#10 SCHENN(1)"))

  val goalWithOneAssistJson = serialize(teamEventJson(goal) ~
    ("player" -> "#10 SCHENN(1)") ~ ("assist1st" -> "#40 LECAVALIER(33)"))

  val goalWithTwoAssistsJson = serialize(teamEventJson(goal) ~
    ("player" -> "#10 SCHENN(1)") ~ ("assist1st" -> "#40 LECAVALIER(33)") ~ ("assist2nd" -> "#32 STREIT(10)"))

  val periodStartJson = serialize(commonJson(periodStart))

  val shotBlockedJson = serialize(teamEventJson(block) ~
    ("player" -> "#51 GARDINER") ~ ("otherTeam" -> "MTL") ~ ("otherPlayer" -> "#26 GORGES"))

  val shotMissedJson = serialize(teamEventJson(miss) ~
    ("player" -> "#67 PACIORETTY") ~ ("target" -> "wide"))

  val shotOnGoalJson = serialize(teamEventJson(shot) ~
    ("player" -> "#11 MCCLEMENT"))

  private def teamEventJson(eventType: String) = commonJson(eventType) ~ ("team" -> "PHI")

  private def commonJson(eventType: String) =
    ("period" -> 1) ~ ("minElapsed" -> 19) ~ ("secElapsed" -> 53) ~ ("minLeft" -> 0) ~ ("secLeft" -> 7) ~
    ("type" -> eventType) ~ ("strength" -> "PP")

  private def serialize(json: JValue) = compact(render(json))
}
