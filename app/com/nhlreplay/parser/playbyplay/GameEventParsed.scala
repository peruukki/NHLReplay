package com.nhlreplay.parser.playbyplay

import xml.NodeSeq
import util.matching.Regex
import GameEventType._

object GameEventParsed
{
  lazy val eventTokens = Map(
    block -> blockTokens,
    faceoff -> faceoffTokens,
    goal -> goalTokens,
    hit -> hitTokens,
    miss -> missTokens,
    penalty -> penaltyTokens,
    periodEnd -> defaultTokens,
    periodStart -> defaultTokens,
    shot -> shotOnGoalTokens
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

  val missTokens = List(Token.Team, Token.Player, Token.PenaltyShot, Token.ShotType, Token.Target, Token.Zone, Token.Distance)

  val penaltyTokens = List(Token.Team, Token.Player, Token.Reason, Token.Duration,
    Token.OptionalStart, Token.ServedBy, Token.ServedByPlayer, Token.OptionalEnd, Token.Zone,
    Token.OptionalStart, Token.DrawnBy, Token.OtherTeam, Token.OtherPlayer, Token.OptionalEnd)

  val shotOnGoalTokens = List(Token.Team, Token.ShotOnGoal, Token.Player, Token.PenaltyShot, Token.ShotType, Token.Zone, Token.Distance)

  def apply(columns: NodeSeq): GameEvent = {
    val description = columns(GameEvent.EventColDescription).mkString
    val eventType = columns(GameEvent.EventColEvent).text.trim
    eventTokens.get(eventType) match {
      case Some(tokens) => new GameEventParsed(columns, description, eventType, tokens)
      case None => new GameEventParsed(columns, description, eventType, defaultTokens, ignore = true)
    }
  }

  def getTokenValue(tokenValues: Seq[TokenValue], tokenName: String): Any =
    tokenValues.find(_.token.name == tokenName).map(_.value).getOrElse("")
}

class GameEventParsed(columns: NodeSeq, description: String,
                      val eventType: String, val tokens: Seq[Token],
                      ignore: Boolean = false)
  extends GameEvent(columns, ignore)
{
  override val tokenValues = parseTokens(description)

  private def parseTokens(description: String) = {
    val tokenPattern = tokens.mkString(Pattern.Separator)
    val tokenNames = tokens.filter(token => containsCatchingGroup(token.pattern)).map(_.name)
    val pattern = new Regex(tokenPattern, tokenNames:_*)

    pattern.findFirstMatchIn(description) match {
      case Some(tokenMatch) => {
        tokens.filter(_.visibility != TokenVisibility.Ignored)
          .map { x =>
            val valueOpt = Option(tokenMatch.group(x.name))
            logger.debug(s"Token '${x.name}' has value '${valueOpt.getOrElse("")}' in match '$tokenMatch'")
            valueOpt match {
              case Some(value) => Some(TokenValue(x, x.trimmer(value)))
              case None => None
            }
          }
          .filter(_.isDefined)
          .map(_.get)
      }
      case None => throw new RuntimeException("No match in '%s'".format(description))
    }
  }

  private def containsCatchingGroup(regex: String) = """\([^?]""".r.findFirstIn(regex).isDefined
}
