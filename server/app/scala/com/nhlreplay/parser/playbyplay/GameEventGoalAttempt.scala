package com.nhlreplay.parser.playbyplay

class GameEventGoalAttempt(resultEvent: GameEvent)
  extends GameEventGenerated(resultEvent.columns, GameEventType.goalAttempt)
{
  val commonTokenValues = List(
    TokenValue(Token(GameEvent.Team), getTokenValue(resultEvent.tokenValues, GameEvent.Team)),
    TokenValue(Token(GameEvent.Player),
               Trimmer.removeCounts(getTokenValue(resultEvent.tokenValues, GameEvent.Player).toString)),
    TokenValue(Token(GameEvent.ShotType),
               Trimmer.trimShotType(getTokenValue(resultEvent.tokenValues, GameEvent.ShotType).toString)))

  val optionalDistanceValues = {
    val distanceValues = resultEvent.tokenValues.filter(_.token.name == GameEvent.Distance)
    if (distanceValues.isEmpty) List.empty
    else {
      val distance = distanceValues.head.value.toString
      val distanceInFeet = """(\d+)\sft""".r.findFirstMatchIn(distance).get.group(1).toInt
      // Discard long distances so that blocked shots are not the only ones without distance
      if (distanceInFeet > 40) List.empty
      else List(TokenValue(Token(GameEvent.Distance), distance))
    }
  }

  override val tokenValues: Seq[TokenValue] = commonTokenValues ++ optionalDistanceValues

  private def getTokenValue(tokenValues: Seq[TokenValue], tokenName: String) =
    tokenValues.filter(_.token.name == tokenName).head.value
}
