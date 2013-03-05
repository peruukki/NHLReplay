package com.nhlreplay

import converter.xhtml.XhtmlConverter
import parser.playbyplay.GameEventParser

object Main
{
  def main(args: Array[String]) {
    parsePlayByPlay()
  }

  private def parsePlayByPlay() {
    val xhtmlFile = new XhtmlConverter().convertHtml("src/test/resources/playbyplay/PL020160.HTM")
    val gameInfo = new GameEventParser().parse(xhtmlFile)
    gameInfo.writeToJsonpFile("../client/src/main/jsonp/data.jsonp")
  }
}
