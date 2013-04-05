package com.nhlreplay.parser.playbyplay

import xml.NodeSeq

trait GameEventGoalAttemptValues {
  val PATTERN_SHOT_TYPE = """\s*(.+?),"""
  val PATTERN_SHOT_ZONE = PATTERN_SHOT_TYPE
  val PATTERN_SHOT_DISTANCE = """\s*(.+?)\."""

  def columns: NodeSeq
  def team: String
  def shooter: String
  def shotType: String
  def shotDistance: String
}
