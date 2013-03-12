package com.nhlreplay.parser.reports

import com.nhlreplay.utils.FileUtils
import xml.NodeSeq

object GameReportsParser
{
  def parse(filePath: String): Seq[GameReports] = {
    val document = xml.parsing.XhtmlParser(FileUtils.getFileSource(filePath))
    val reportRows = getReportRows(document)
    reportRows map { x => new GameReports(x \ "td") }
  }

  private def getReportRows(document: NodeSeq) = (document \\ "table" \ "tbody" \ "tr").tail
}
