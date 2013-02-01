package com.nhlgametracker.parser.playbyplay

import xml.NodeSeq

class Team(columns: NodeSeq)
{
  val teamName = getTeamName(columns)

  private def getTeamName(columns: NodeSeq) = {
    val pattern = """\s+(.+)<br>""".r
    val content = ((columns \ "tbody" \ "tr")(2) \ "td").mkString
    pattern.findFirstMatchIn(content) match {
      case Some(teamMatch) => teamMatch.group(1)
      case None => throw new RuntimeException("No match in '%s'".format(content))
    }
  }
}
