package com.nhlreplay.parser.playbyplay

object TokenVisibility extends Enumeration {
  type TokenVisibility = Value
  val Public, Internal, Ignored = Value
}
import TokenVisibility._

object Token {
  val Assists = Token("", Pattern.Assists, TokenVisibility.Ignored)
  val Assist1st = Token(GameEvent.Assist1st, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val Assist2nd = Token(GameEvent.Assist2nd, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val BlockedBy = Token("", Pattern.BlockedBy, TokenVisibility.Ignored)
  val Default = Token("", Pattern.Text, TokenVisibility.Ignored)
  val Distance = Token(GameEvent.Distance, Pattern.Distance, TokenVisibility.Internal)
  val Duration = Token(GameEvent.Duration, Pattern.PenaltyDuration, trimmer = Trimmer.toInt)
  val OptionalStart = Token("", Pattern.OptionalStart, TokenVisibility.Ignored)
  val OptionalEnd = Token("", Pattern.OptionalEnd, TokenVisibility.Ignored)
  val OtherTeam = Token(GameEvent.OtherTeam, Pattern.Word, trimmer = Trimmer.removeDots)
  val OtherPlayer = Token(GameEvent.OtherPlayer, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val Player = Token(GameEvent.Player, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val Reason = Token(GameEvent.Reason, Pattern.PenaltyReason, trimmer = Trimmer.trimPenaltyReason)
  val ShotOnGoal = Token(GameEvent.ShotOnGoal, Pattern.Word, TokenVisibility.Ignored)
  val ShotType = Token(GameEvent.ShotType, Pattern.Word, TokenVisibility.Internal)
  val Team = Token(GameEvent.Team, Pattern.Word, trimmer = Trimmer.removeDots)
  val Target = Token(GameEvent.Target, Pattern.Words, trimmer = Trimmer.trimTarget)
  val Zone = Token(GameEvent.Zone, Pattern.Zone, TokenVisibility.Ignored)
}

case class Token(name: String,
                 pattern: String = "",
                 visibility: TokenVisibility = Public,
                 trimmer: (String) => Any = Trimmer.preserve,
                 optional: Boolean = false)
{
  override def toString: String = pattern
}
