package com.nhlreplay.parser.playbyplay

object Pattern {
  lazy val Assists = """.+?:"""
  lazy val Count = """\((\d+)\)"""
  lazy val Distance = """(\d+\sft)\."""
  lazy val Label = """((?:\w|\s)+)\:"""
  lazy val Name = """(?:\w|\s|\d|-|'|\(|\))+"""
  lazy val Number = """#\d+"""
  lazy val OptionalStart = """(?:"""
  lazy val OptionalEnd = """)?"""
  lazy val PenaltyDuration = """(?:\s\(maj\))?\((\d+)\smin\)"""
  lazy val PenaltyReason = """\u00a0(.+?)"""
  lazy val Player = """(""" + Number + Separator + Name + """|TEAM),?"""
  lazy val Separator = """(?:\s|,|;|\s-\s)*"""
  lazy val Text = """(.+)"""
  lazy val Word = """((?:\w|-|\.)+),?"""
  lazy val Words = """((?:\w|-|\.|\s)+),"""
}
