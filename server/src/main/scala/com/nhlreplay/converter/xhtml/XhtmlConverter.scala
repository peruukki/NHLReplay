package com.nhlreplay.converter.xhtml

import com.nhlreplay.utils.FileUtils
import xml.{Node, NodeSeq, XML}
import org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl
import xml.transform.{RuleTransformer, RewriteRule}
import com.typesafe.scalalogging.slf4j.Logging

object XhtmlConverter extends Logging
{
  def convertHtml(filePath: String): String = {
    logger.info(s"Converting file '${filePath}'")
    val htmlContent = FileUtils.getFileContent(filePath)
    val xhtmlContent = filterXhtml(convertToXhtml(htmlContent))
    val xhtmlFileName = filePath.take(filePath.lastIndexOf(".") + 1) + "XHTML"
    FileUtils.writeToFile(xhtmlFileName, List(xhtmlContent))
  }

  private def convertToXhtml(htmlContent: String) = {
    val parser = XML.withSAXParser(new SAXFactoryImpl().newSAXParser())
    parser.loadString(htmlContent)
  }

  private def filterXhtml(xhtmlContent: NodeSeq) = {

    val filter = new RewriteRule {
      override def transform(node: Node): Seq[Node] = node match {
        // Filter out all script tags
        case n if (n.label == "script") => NodeSeq.Empty
        case x => x
      }
    }
    new RuleTransformer(filter).transform(xhtmlContent).mkString
  }
}
