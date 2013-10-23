package com.nhlreplay.parser.playbyplay

import GameEventType._

object TestGameEventXhtml
{
  val faceoffXhtml = gameEvent(faceoff, "PHI won Off. Zone - PHI #43 KADRI vs MTL #8 PRUST")

  val goalWithoutAssistsXhtml = gameEvent(goal, "PHI #10 SCHENN(1), Wrist, Off. Zone, 10 ft.")

  val goalWithOneAssistXhtml = gameEvent(goal, """PHI #10 SCHENN(1), Wrist, Off. Zone, 10 ft.
    |<br clear="none"/>Assist: #40 LECAVALIER(33)""".stripMargin)

  val goalWithTwoAssistsXhtml = gameEvent(goal, """PHI #10 SCHENN(1), Wrist, Off. Zone, 10 ft.
    |<br clear="none"/>Assists: #40 LECAVALIER(33); #32 STREIT(10)""".stripMargin)

  val hitXhtml = gameEvent(hit, "PHI #76 SUBBAN HIT TOR #42 BOZAK, Off. Zone")

  val penaltyDrawnXhtml = gameEvent(penalty, "PHI #81 ELLER Tripping(2 min), Off. Zone Drawn By: TOR #19 LUPUL")

  val penaltyMajorXhtml = gameEvent(penalty, "PHI #2 FRASER Fighting (maj)(5 min), Def. Zone Drawn By: MTL #32 MOEN")

  val penaltyUndrawnXhtml = gameEvent(penalty, "PHI #2 FRASER Unsportsmanlike conduct(2 min), Def. Zone")

  val penaltyServedByXhtml = gameEvent(penalty, "PHI #2 FRASER Interference(2 min) Served By: #81 KESSEL, Def. Zone Drawn By: MTL #8 PRUST")

  val penaltyShotXhtml = gameEvent(penalty, "ANA #33 SILFVERBERG PS-Holding on breakaway(0 min), Def. Zone Drawn By: PHI #21 VAN RIEMSDYK")

  val penaltyTeamXhtml = gameEvent(penalty, "PHI TEAM Too many men/ice - bench(2 min) Served By: #48 BRIERE, Neu. Zone")

  val periodEndXhtml = gameEvent(periodEnd, "Period End- Local time: 8:07 EDT")

  val periodStartXhtml = gameEvent(periodStart, "Period Start- Local time: 7:27 EDT")

  val shotBlockedXhtml = gameEvent(block, "PHI #51 GARDINER BLOCKED BY  MTL #26 GORGES, Wrap-around, Off. Zone")

  val shotMissedXhtml = gameEvent(miss, "PHI #67 PACIORETTY, Slap, Wide of Net, Off. Zone, 30 ft.")

  val shotMissedPenaltyShotXhtml = gameEvent(miss, "PHI #36 GUNNARSSON, Penalty Shot, Backhand, Wide of Net, Off. Zone, 15 ft.")

  val shotOnGoalXhtml = gameEvent(shot, "PHI ONGOAL - #11 MCCLEMENT, Tip-In, Def. Zone, 152 ft.")

  val shotOnGoalPenaltyShotXhtml = gameEvent(shot, "PHI ONGOAL - #17 SIMMONDS, Penalty Shot, Wrist, Off. Zone, 17 ft.")

  private def gameEvent(eventType: String, description: String) =
    <tr class="evenColor"><td class="goal + bborder" rowspan="1" colspan="1" align="center">124</td>
      <td class="goal + bborder" rowspan="1" colspan="1" align="center">1</td>
      <td class="goal + bborder" rowspan="1" colspan="1" align="center">PP</td>
      <td class="goal + bborder" rowspan="1" colspan="1" align="center">19:53<br clear="none"/>0:07</td>
      <td class="goal + bborder" rowspan="1" colspan="1" align="center">{eventType}</td>
      <td class="goal + bborder" rowspan="1" colspan="1">{description}</td>
      {onIce}
    </tr>

  private lazy val onIce =
    <td class="bold + bborder + rborder" rowspan="1" colspan="1">
      <table cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Center - DAVE BOLLAND" style="cursor:hand;">63</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">C</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Left Wing - MASON RAYMOND" style="cursor:hand;">12</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">L</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Defense - MARK FRASER" style="cursor:hand;">2</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">D</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Defense - CODY FRANSON" style="cursor:hand;">4</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">D</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Goalie - JONATHAN BERNIER" style="cursor:hand;">45</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">G</td></tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
    <td class="bold + bborder" rowspan="1" colspan="1">
      <table cellspacing="0" cellpadding="0" border="0">
        <tr>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Center - BRAYDEN SCHENN" style="cursor:hand;">10</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">C</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Center - VINCENT LECAVALIER" style="cursor:hand;">40</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">C</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Right Wing - MATT READ" style="cursor:hand;">24</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">R</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Right Wing - CLAUDE GIROUX" style="cursor:hand;">28</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">R</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Defense - MARK STREIT" style="cursor:hand;">32</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">D</td></tr>
            </table>
          </td>
          <td rowspan="1" colspan="1" align="center"> </td>
          <td rowspan="1" colspan="1" align="center">
            <table cellspacing="0" cellpadding="0" border="0">
              <tr><td rowspan="1" colspan="1" align="center"><font title="Goalie - STEVE MASON" style="cursor:hand;">35</font></td></tr>
              <tr><td rowspan="1" colspan="1" align="center">G</td></tr>
            </table>
          </td>
        </tr>
      </table>
    </td>
}
