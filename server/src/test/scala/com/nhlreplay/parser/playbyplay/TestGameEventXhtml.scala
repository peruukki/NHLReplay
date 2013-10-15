package com.nhlreplay.parser.playbyplay

object TestGameEventXhtml
{
  lazy val goalWithTwoAssistsXhtml =
    <tr class="evenColor"><td class="goal + bborder" rowspan="1" colspan="1" align="center">124</td>
      <td class="goal + bborder" rowspan="1" colspan="1" align="center">1</td>
      <td class="goal + bborder" rowspan="1" colspan="1" align="center">PP</td>
      <td class="goal + bborder" rowspan="1" colspan="1" align="center">19:53<br clear="none"/>0:07</td>
      <td class="goal + bborder" rowspan="1" colspan="1" align="center">GOAL</td>
      <td class="goal + bborder" rowspan="1" colspan="1">PHI #10 SCHENN(1), Wrist, Off. Zone, 10 ft.
        <br clear="none"/>Assists: #40 LECAVALIER(33); #32 STREIT(10)
      </td>
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
