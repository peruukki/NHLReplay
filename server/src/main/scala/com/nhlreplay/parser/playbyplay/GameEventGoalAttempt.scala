package com.nhlreplay.parser.playbyplay

class GameEventGoalAttempt(resultEvent: GameEventGoalAttemptValues)
  extends GameEvent(resultEvent.columns, "GATT") with GameEventGoalAttemptValues
{
  val team = resultEvent.team
  val shooter = resultEvent.shooter
  val shotType = trimShotType(resultEvent.shotType)
  val shotDistance = resultEvent.shotDistance

  private def trimShotType(shotType: String) = {
    shotType.toLowerCase match {
      case "backhand" => "shoots on his backhand"
      case "deflected" => "shoots and it's deflected"
      case "slap" => "takes a slapshot"
      case "snap" => "takes a snap shot"
      case "tip-in" => "tries to tip it in"
      case "wrap-around" => "tries a wrap-around"
      case "wrist" => "takes a wrist shot"
      case x => x
    }
  }

  override def getJson: String = {
    val builder = super.startJson()
    appendValue(builder, "team", team)
    appendValue(builder, "shooter", shooter)
    appendValue(builder, "shotType", shotType)
    appendValue(builder, "shotDistance", shotDistance)
    super.finishJson(builder)
  }
}
