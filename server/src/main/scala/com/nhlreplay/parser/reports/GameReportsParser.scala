package com.nhlreplay.parser.reports

import xml.NodeSeq
import com.typesafe.scalalogging.slf4j.Logging
import scala.io.Source
import scala.xml.parsing.XhtmlParser

object GameReportsParser extends Logging
{
  def parse(xhtmlContent: Source): Seq[GameReports] = {
    val document = XhtmlParser(xhtmlContent)
    val reportRows = getReportRows(document)
    reportRows map { x => new GameReports(x \ "td") }
  }

  private def getReportRows(document: NodeSeq) = (document \\ "table" \ "tbody" \ "tr").tail
}
