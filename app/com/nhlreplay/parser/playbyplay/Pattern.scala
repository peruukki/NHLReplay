package com.nhlreplay.parser.playbyplay

object Pattern {
  lazy val Assists = """.+?:"""
  lazy val BlockedBy = """\s+BLOCKED\sBY\s+"""
  lazy val Count = """\((\d+)\)"""
  lazy val Distance = """(\d+\sft)\."""
  lazy val Hit = """\s+HIT\s+"""
  lazy val Label = """((?:\w|\s)+)\:"""
  lazy val Name = """(?:\w|\s|\d|-|'|\(|\))+"""
  lazy val Number = """#\d+"""
  lazy val OptionalStart = """(?:"""
  lazy val OptionalEnd = """)?"""
  lazy val PenaltyDuration = """(?:\s\(maj\))?\((\d+)\smin\)"""
  lazy val PenaltyReason = """\u00a0(.+?)"""
  lazy val PenaltyShot = OptionalStart + """Penalty\sShot""" + OptionalEnd
  lazy val Player = """(""" + Number + Separator + Name + """|TEAM),?"""
  lazy val Separator = """(?:\s|,|;|\s-\s)*"""
  lazy val Text = """(.+)"""
  lazy val Vs = """\s+vs\s+"""
  lazy val Won = """\s+won\s+"""
  lazy val Word = """((?:\w|-|\.)+),?"""
  lazy val Words = """((?:\w|-|\.|\s)+),"""
  lazy val Zone = Word + """\sZone"""
}
