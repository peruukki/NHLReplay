package com.nhlreplay.parser.playbyplay

class GameEventGoalAttempt(resultEvent: GameEvent)
  extends GameEventGenerated(resultEvent.columns, "GATT")
{
  override val tokenValues: Seq[TokenValue] = List(
    TokenValue(Token(GameEvent.Team), getTokenValue(resultEvent.tokenValues, GameEvent.Team)),
    TokenValue(Token(GameEvent.Player), getTokenValue(resultEvent.tokenValues, GameEvent.Player)),
    TokenValue(Token(GameEvent.ShotType),
               Trimmer.trimShotType(getTokenValue(resultEvent.tokenValues, GameEvent.ShotType).toString)),
    TokenValue(Token(GameEvent.Distance), getTokenValue(resultEvent.tokenValues, GameEvent.Distance)))

  private def getTokenValue(tokenValues: Seq[TokenValue], tokenName: String) =
    tokenValues.filter(_.token.name == tokenName).head.value
}
