package com.nhlreplay.parser.playbyplay

import org.json4s.JsonDSL._
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._
import GameEventType._

object TestGameEventJson
{
  val faceoffJson = serialize(commonJson(faceoff) ~
    ("wonTeam" -> "PHI") ~ ("team" -> "PHI") ~ ("player" -> "#43 KADRI") ~ ("otherTeam" -> "MTL") ~ ("otherPlayer" -> "#8 PRUST"))

  val goalAttemptGoalJson = serialize(teamEventJson(goalAttempt) ~
    ("player" -> "#10 SCHENN") ~ ("shotType" -> "takes a wrist shot") ~ ("distance" -> "10 ft"))

  val goalAttemptShotBlockedJson = serialize(teamEventJson(goalAttempt) ~
    ("player" -> "#51 GARDINER") ~ ("shotType" -> "tries a wrap-around"))

  val goalAttemptShotMissedJson = serialize(teamEventJson(goalAttempt) ~
    ("player" -> "#67 PACIORETTY") ~ ("shotType" -> "takes a slapshot") ~ ("distance" -> "30 ft"))

  val goalAttemptShotOnGoalJson = serialize(teamEventJson(goalAttempt) ~
    ("player" -> "#11 MCCLEMENT") ~ ("shotType" -> "tries to tip it in"))

  val goalWithoutAssistsJson = serialize(teamEventJson(goal) ~
    ("player" -> "#10 SCHENN(1)"))

  val goalWithOneAssistJson = serialize(teamEventJson(goal) ~
    ("player" -> "#10 SCHENN(1)") ~ ("assist1st" -> "#40 LECAVALIER(33)"))

  val goalWithTwoAssistsJson = serialize(teamEventJson(goal) ~
    ("player" -> "#10 SCHENN(1)") ~ ("assist1st" -> "#40 LECAVALIER(33)") ~ ("assist2nd" -> "#32 STREIT(10)"))

  val hitJson = serialize(teamEventJson(hit) ~
    ("player" -> "#76 SUBBAN") ~ ("otherTeam" -> "TOR") ~ ("otherPlayer" -> "#42 BOZAK"))

  val penaltyDrawnJson = serialize(teamEventJson(penalty) ~
    ("player" -> "#81 ELLER") ~ ("reason" -> "tripping") ~ ("duration" -> 2) ~ ("otherTeam" -> "TOR") ~ ("otherPlayer" -> "#19 LUPUL"))

  val penaltyMajorJson = serialize(teamEventJson(penalty) ~
    ("player" -> "#2 FRASER") ~ ("reason" -> "fighting") ~ ("duration" -> 5) ~ ("otherTeam" -> "MTL") ~ ("otherPlayer" -> "#32 MOEN"))

  val penaltyUndrawnJson = serialize(teamEventJson(penalty) ~
    ("player" -> "#2 FRASER") ~ ("reason" -> "unsportsmanlike conduct") ~ ("duration" -> 2))

  val penaltyServedByJson = serialize(teamEventJson(penalty) ~
    ("player" -> "#2 FRASER") ~ ("reason" -> "interference") ~ ("duration" -> 2) ~ ("otherTeam" -> "MTL") ~ ("otherPlayer" -> "#8 PRUST"))

  val penaltyShotJson = serialize(teamEventJson(penaltyShot) ~
    ("player" -> "#21 VAN RIEMSDYK"))

  val penaltyTeamJson = serialize(teamEventJson(penalty) ~
    ("player" -> "TEAM") ~ ("reason" -> "too many men/ice - bench") ~ ("duration" -> 2))

  val periodEndJson = serialize(commonJson(periodEnd))

  val periodStartJson = serialize(commonJson(periodStart))

  val shotBlockedJson = serialize(teamEventJson(block) ~
    ("player" -> "#51 GARDINER") ~ ("otherTeam" -> "MTL") ~ ("otherPlayer" -> "#26 GORGES"))

  val shotMissedJson = serialize(teamEventJson(miss) ~
    ("player" -> "#67 PACIORETTY") ~ ("target" -> "wide"))

  val shotMissedPenaltyShotJson = serialize(teamEventJson(miss) ~
    ("player" -> "#36 GUNNARSSON") ~ ("target" -> "wide"))

  val shotOnGoalJson = serialize(teamEventJson(shot) ~
    ("player" -> "#11 MCCLEMENT"))

  val shotOnGoalPenaltyShotJson = serialize(teamEventJson(shot) ~
    ("player" -> "#17 SIMMONDS"))

  private def teamEventJson(eventType: String) = commonJson(eventType) ~ ("team" -> "PHI")

  private def commonJson(eventType: String) =
    ("period" -> 1) ~ ("minElapsed" -> 19) ~ ("secElapsed" -> 53) ~ ("minLeft" -> 0) ~ ("secLeft" -> 7) ~
    ("type" -> eventType) ~ ("strength" -> "PP")

  private def serialize(json: JValue) = compact(render(json))
}
