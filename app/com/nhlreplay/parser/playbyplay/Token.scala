package com.nhlreplay.parser.playbyplay

object TokenVisibility extends Enumeration {
  type TokenVisibility = Value
  val Public, Internal, Ignored = Value
}
import TokenVisibility._

object Token {
  val Assists = Token("", Pattern.Assists, Ignored)
  val Assist1st = Token(GameEvent.Assist1st, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val Assist2nd = Token(GameEvent.Assist2nd, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val BlockedBy = Token("", Pattern.BlockedBy, Ignored)
  val Default = Token("", Pattern.Text, Ignored)
  val Distance = Token(GameEvent.Distance, Pattern.Distance, Internal)
  val DrawnBy = Token("", Pattern.DrawnBy, Ignored)
  val Duration = Token(GameEvent.Duration, Pattern.PenaltyDuration, trimmer = Trimmer.toInt)
  val Hit = Token("", Pattern.Hit, Ignored)
  val OptionalStart = Token("", Pattern.OptionalStart, Ignored)
  val OptionalEnd = Token("", Pattern.OptionalEnd, Ignored)
  val OtherTeam = Token(GameEvent.OtherTeam, Pattern.Word, trimmer = Trimmer.removeDots)
  val OtherPlayer = Token(GameEvent.OtherPlayer, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val PenaltyShot = Token("", Pattern.PenaltyShot, Ignored)
  val Player = Token(GameEvent.Player, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val Reason = Token(GameEvent.Reason, Pattern.PenaltyReason, trimmer = Trimmer.trimPenaltyReason)
  val ServedBy = Token("", Pattern.ServedBy, Ignored)
  val ServedByPlayer = Token(GameEvent.ServedByPlayer, Pattern.Player, Internal, Trimmer.trimWhitespace)
  val ShotOnGoal = Token(GameEvent.ShotOnGoal, Pattern.Word, Ignored)
  val ShotType = Token(GameEvent.ShotType, Pattern.Word, Internal)
  val Team = Token(GameEvent.Team, Pattern.Word, trimmer = Trimmer.removeDots)
  val Target = Token(GameEvent.Target, Pattern.Words, trimmer = Trimmer.trimTarget)
  val Vs = Token("", Pattern.Vs, Ignored)
  val Won = Token("", Pattern.Won, Ignored)
  val WonTeam = Token(GameEvent.WonTeam, Pattern.Word, trimmer = Trimmer.removeDots)
  val Zone = Token(GameEvent.Zone, Pattern.Zone, Ignored)
}

case class Token(name: String,
                 pattern: String = "",
                 visibility: TokenVisibility = Public,
                 trimmer: (String) => Any = Trimmer.preserve,
                 optional: Boolean = false)
{
  override def toString: String = pattern
}
