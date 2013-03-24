package com.nhlreplay.parser.reports

import com.nhlreplay.utils.FileUtils
import xml.NodeSeq
import com.typesafe.scalalogging.slf4j.Logging

object GameReportsParser extends Logging
{
  def parse(filePath: String): Seq[GameReports] = {
    logger.info(s"Parsing file '${filePath}'")
    val document = xml.parsing.XhtmlParser(FileUtils.getFileSource(filePath))
    val reportRows = getReportRows(document)
    reportRows map { x => new GameReports(x \ "td") }
  }

  private def getReportRows(document: NodeSeq) = (document \\ "table" \ "tbody" \ "tr").tail
}
