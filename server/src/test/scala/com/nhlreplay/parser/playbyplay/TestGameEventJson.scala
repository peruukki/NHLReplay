package com.nhlreplay.parser.playbyplay

import org.json4s.JsonDSL._
import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._

object TestGameEventJson
{
  lazy val goalWithTwoAssistsJson = serialize(
    ("period" -> 1) ~ ("minElapsed" -> 19) ~ ("secElapsed" -> 53) ~ ("minLeft" -> 0) ~ ("secLeft" -> 7) ~
    ("type" -> "GOAL") ~ ("strength" -> "PP") ~ ("team" -> "PHI") ~ ("player" -> "#10 SCHENN(1)") ~
    ("assist1st" -> "#40 LECAVALIER(33)") ~ ("assist2nd" -> "#32 STREIT(10)"))

  private def serialize(json: JValue) = compact(render(json))
}
