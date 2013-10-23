package com.nhlreplay.parser.playbyplay

class GameEventPenaltyShot(penaltyEvent: GameEvent)
  extends GameEventGenerated(penaltyEvent.columns, GameEventType.penaltyShot)
{
  override val tokenValues: Seq[TokenValue] = List(
    TokenValue(Token(GameEvent.Team), GameEventParsed.getTokenValue(penaltyEvent.tokenValues, GameEvent.OtherTeam)),
    TokenValue(Token(GameEvent.Player),
               GameEventParsed.getTokenValue(penaltyEvent.tokenValues, GameEvent.OtherPlayer).toString))
}
