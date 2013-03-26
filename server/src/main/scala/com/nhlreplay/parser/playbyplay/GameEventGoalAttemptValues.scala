package com.nhlreplay.parser.playbyplay

import xml.NodeSeq

trait GameEventGoalAttemptValues {
  val PATTERN_SHOT_TYPE = """\s*(.+?),"""

  def columns: NodeSeq
  def team: String
  def shooter: String
  def shotType: String
}
