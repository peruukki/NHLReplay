package com.nhlreplay.parser.reports

import com.nhlreplay.utils.FileUtils
import xml.NodeSeq

class GameReportsParser
{
  def parse(filePath: String): Seq[GameReports] = {
    val document = xml.parsing.XhtmlParser(FileUtils.getFileSource(filePath))
    val reportRows = getReportRows(document)
    for { x <- reportRows } yield new GameReports(x \ "td")
  }

  private def getReportRows(document: NodeSeq) =
    ((document \\ "table") filter { x => (x \ "@class").text == "data stats" }) \ "tbody" \ "tr"
}
