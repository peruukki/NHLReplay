package com.nhlreplay.parser.reports

import xml.NodeSeq
import com.typesafe.scalalogging.slf4j.Logging
import scala.io.Source
import scala.xml.parsing.XhtmlParser
import com.nhlreplay.parser.InvalidContentException

object GameReportsParser extends Logging
{
  def parse(xhtmlContent: Source): Seq[GameReports] = {
    val document = XhtmlParser(xhtmlContent)
    val reportRows = getReportRows(document)
    reportRows map { x => GameReports(x \ "td") }
  }

  private def getReportRows(document: NodeSeq) = {
    val reportTables = (document \\ "table").filterNot(table => (table \ "thead").isEmpty)
    if (reportTables.isEmpty) throw new InvalidContentException("No report table")
    if (reportTables.length > 1) throw new InvalidContentException(s"Too many report tables: ${reportTables.length}")

    val tableRows = reportTables.head \ "tbody" \ "tr"
    if (tableRows.isEmpty) throw new InvalidContentException("No report rows")
    tableRows
  }
}
