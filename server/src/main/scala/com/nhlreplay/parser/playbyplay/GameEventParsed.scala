package com.nhlreplay.parser.playbyplay

import xml.NodeSeq
import util.matching.Regex

object GameEventParsed
{
  lazy val eventTokens = Map(
    "GOAL" -> goalTokens,
    "PENL" -> penaltyTokens,
    "SHOT" -> shotOnGoalTokens,
    "MISS" -> missTokens,
    "PSTR" -> defaultTokens,
    "PEND" -> defaultTokens)

  val defaultTokens = List(Token("", Pattern.Text, TokenVisibility.Ignored))

  val goalTokens = List(
    Token(GameEvent.Team, Pattern.Word, trimmer = Trimmer.removeDots),
    Token(GameEvent.Player, Pattern.Player, trimmer = Trimmer.trimWhitespace),
    Token(GameEvent.ShotType, Pattern.Word, TokenVisibility.Internal),
    Token(GameEvent.Zone, Pattern.Words, TokenVisibility.Ignored),
    Token(GameEvent.Distance, Pattern.Distance, TokenVisibility.Internal),
    Token("", Pattern.OptionalStart, TokenVisibility.Ignored),
    Token("", Pattern.Assists, TokenVisibility.Ignored),
    Token(GameEvent.Assist1st, Pattern.Player, trimmer = Trimmer.trimWhitespace),
    Token("", Pattern.OptionalEnd, TokenVisibility.Ignored),
    Token("", Pattern.OptionalStart, TokenVisibility.Ignored),
    Token(GameEvent.Assist2nd, Pattern.Player, trimmer = Trimmer.trimWhitespace),
    Token("", Pattern.OptionalEnd, TokenVisibility.Ignored))

  val missTokens = List(
    Token(GameEvent.Team, Pattern.Word, trimmer = Trimmer.removeDots),
    Token(GameEvent.Player, Pattern.Player, trimmer = Trimmer.trimWhitespace),
    Token(GameEvent.ShotType, Pattern.Words, TokenVisibility.Internal),
    Token(GameEvent.Target, Pattern.Words, trimmer = Trimmer.trimTarget),
    Token(GameEvent.Zone, Pattern.Words, TokenVisibility.Ignored),
    Token(GameEvent.Distance, Pattern.Distance, TokenVisibility.Internal))

  val penaltyTokens = List(
    Token(GameEvent.Team, Pattern.Word, trimmer = Trimmer.removeDots),
    Token(GameEvent.Player, Pattern.Player, trimmer = Trimmer.trimWhitespace),
    Token(GameEvent.Reason, Pattern.PenaltyReason, trimmer = Trimmer.trimPenaltyReason),
    Token(GameEvent.Duration, Pattern.PenaltyDuration, trimmer = Trimmer.toInt))

  val shotOnGoalTokens = List(
    Token(GameEvent.Team, Pattern.Word, trimmer = Trimmer.removeDots),
    Token(GameEvent.ShotOnGoal, Pattern.Word, TokenVisibility.Ignored),
    Token(GameEvent.Player, Pattern.Player, trimmer = Trimmer.trimWhitespace),
    Token(GameEvent.ShotType, Pattern.Words, TokenVisibility.Internal),
    Token(GameEvent.Zone, Pattern.Words, TokenVisibility.Ignored),
    Token(GameEvent.Distance, Pattern.Distance, TokenVisibility.Internal))

  def apply(columns: NodeSeq): GameEvent = {
    val description = columns(GameEvent.EventColDescription).mkString
    val eventType = columns(GameEvent.EventColEvent).text.trim
    eventTokens.get(eventType) match {
      case Some(tokens) => new GameEventParsed(columns, description, eventType, tokens, generateGoalAttempt(eventType))
      case None => new GameEventParsed(columns, description, eventType, defaultTokens, ignore = true)
    }
  }

  private def generateGoalAttempt(eventType: String) = Array("GOAL", "SHOT", "MISS").contains(eventType)
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
