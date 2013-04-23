package com.nhlreplay.parser.playbyplay

object TokenVisibility extends Enumeration {
  type TokenVisibility = Value
  val Public, Internal, Ignored = Value
}
import TokenVisibility._

object Token {
  val Distance = Token(GameEvent.Distance, Pattern.Distance, TokenVisibility.Internal)
  val Player = Token(GameEvent.Player, Pattern.Player, trimmer = Trimmer.trimWhitespace)
  val ShotType = Token(GameEvent.ShotType, Pattern.Word, TokenVisibility.Internal)
  val Team = Token(GameEvent.Team, Pattern.Word, trimmer = Trimmer.removeDots)
  val Zone = Token(GameEvent.Zone, Pattern.Words, TokenVisibility.Ignored)
}

case class Token(name: String,
                 pattern: String = "",
                 visibility: TokenVisibility = Public,
                 trimmer: (String) => Any = Trimmer.preserve,
                 optional: Boolean = false)
{
  override def toString: String = pattern
}
