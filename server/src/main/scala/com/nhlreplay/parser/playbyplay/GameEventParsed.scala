package com.nhlreplay.parser.playbyplay

import xml.NodeSeq
import util.matching.Regex

object GameEventParsed
{
  lazy val eventTokens = Map(
    "BLOCK" -> blockTokens,
    "FAC" -> faceoffTokens,
    "GOAL" -> goalTokens,
    "HIT" -> hitTokens,
    "MISS" -> missTokens,
    "PEND" -> defaultTokens,
    "PENL" -> penaltyTokens,
    "PSTR" -> defaultTokens,
    "SHOT" -> shotOnGoalTokens
 )

  val defaultTokens = List(Token.Default)

  val blockTokens = List(
    Token.Team, Token.Player, Token.BlockedBy,
    Token.OtherTeam, Token.OtherPlayer, Token.ShotType, Token.Zone)

  val faceoffTokens = List(
    Token.WonTeam, Token.Won, Token.Zone, Token.Team, Token.Player,
    Token.Vs, Token.OtherTeam, Token.OtherPlayer)

  val goalTokens = List(
    Token.Team, Token.Player, Token.ShotType, Token.Zone, Token.Distance,
    Token.OptionalStart, Token.Assists, Token.Assist1st, Token.OptionalEnd,
    Token.OptionalStart, Token.Assist2nd, Token.OptionalEnd)

  val hitTokens = List(Token.Team, Token.Player, Token.Hit, Token.OtherTeam, Token.OtherPlayer, Token.Zone)

  val missTokens = List(Token.Team, Token.Player, Token.ShotType, Token.Target, Token.Zone, Token.Distance)

  val penaltyTokens = List(Token.Team, Token.Player, Token.Reason, Token.Duration)

  val shotOnGoalTokens = List(Token.Team, Token.ShotOnGoal, Token.Player, Token.ShotType, Token.Zone, Token.Distance)

  def apply(columns: NodeSeq): GameEvent = {
    val description = columns(GameEvent.EventColDescription).mkString
    val eventType = columns(GameEvent.EventColEvent).text.trim
    eventTokens.get(eventType) match {
      case Some(tokens) => new GameEventParsed(columns, description, eventType, tokens, generateGoalAttempt(eventType))
      case None => new GameEventParsed(columns, description, eventType, defaultTokens, ignore = true)
    }
  }

  private def generateGoalAttempt(eventType: String) = Array("BLOCK", "GOAL", "MISS", "SHOT").contains(eventType)
}

class GameEventParsed(columns: NodeSeq, description: String,
                      val eventType: String, val tokens: Seq[Token],
                      generateGoalAttempt: Boolean = false, ignore: Boolean = false)
  extends GameEvent(columns, generateGoalAttempt, ignore)
{
  // scalastyle:off null
  override val tokenValues = parseTokens(description).filter(_.value != null)

  private def parseTokens(description: String) = {
    val tokenPattern = tokens.mkString(Pattern.Separator)
    val tokenNames = tokens.map(_.name).filter(!_.isEmpty)
    val pattern = new Regex(tokenPattern, tokenNames:_*)

    pattern.findFirstMatchIn(description) match {
      case Some(tokenMatch) => {
        tokens.filter(_.visibility != TokenVisibility.Ignored)
              .map(x => {
          val value = tokenMatch.group(x.name)
          logger.debug(s"Token '${x.name}' has value '$value' in match '$tokenMatch'")
          // scalastyle:off null
          TokenValue(x, if (value != null) x.trimmer(value) else value)
        })
      }
      case None => throw new RuntimeException("No match in '%s'".format(description))
    }
  }
}
