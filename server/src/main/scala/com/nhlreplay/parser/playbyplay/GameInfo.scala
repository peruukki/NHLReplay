package com.nhlreplay.parser.playbyplay

case class GameInfo(home: Team, away: Team, events: Seq[GameEvent])
