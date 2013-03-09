package com.nhlreplay.parser.playbyplay

class GameEventGoalAttempt(resultEvent: GameEventGoalAttemptValues)
  extends GameEvent(resultEvent.columns, "GATT") with GameEventGoalAttemptValues
{
  val team = resultEvent.team
  val shooter = resultEvent.shooter

  override def getJson: String = {
    val builder = super.startJson()
    appendValue(builder, "team", team)
    appendValue(builder, "shooter", shooter)
    super.finishJson(builder)
  }
}
