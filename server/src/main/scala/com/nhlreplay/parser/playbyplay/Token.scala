package com.nhlreplay.parser.playbyplay

object TokenVisibility extends Enumeration {
  type TokenVisibility = Value
  val Public, Internal, Ignored = Value
}
import TokenVisibility._

case class Token(name: String,
                 pattern: String = "",
                 visibility: TokenVisibility = Public,
                 trimmer: (String) => Any = Trimmer.preserve,
                 optional: Boolean = false)
{
  override def toString: String = pattern
}
