package com.nhlreplay.parser.playbyplay

import xml.NodeSeq

trait GameEventGoalAttemptValues {
  def columns: NodeSeq
  def team: String
  def shooter: String
}
