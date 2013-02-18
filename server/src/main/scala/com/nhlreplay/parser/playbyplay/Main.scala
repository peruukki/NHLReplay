package com.nhlreplay.parser.playbyplay

import com.nhlreplay.converter.xhtml.XhtmlConverter

object Main
{
  def main(args: Array[String]) {
    val converter = new XhtmlConverter()
    val xhtmlFile = converter.convertHtml("src/test/resources/playbyplay/PL020160.HTM")
    val parser = new GameEventParser()
    val gameInfo = parser.parse(xhtmlFile)
    gameInfo.writeToJsonpFile("../client/src/main/jsonp/data.jsonp")
  }
}
