package com.nhlreplay.parser.playbyplay

import xml.NodeSeq

abstract class GameEventGenerated(columns: NodeSeq, override val eventType: String)
  extends GameEvent(columns, generateGoalAttempt = false, ignore = false)
{
}
