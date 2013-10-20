package com.nhlreplay.converter.xhtml

import xml.{Node, NodeSeq, XML}
import org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl
import xml.transform.{RuleTransformer, RewriteRule}
import com.typesafe.scalalogging.slf4j.Logging
import scala.io.Source

object XhtmlConverter extends Logging
{
  def convertHtml(htmlContent: String, fileName: Option[String] = None): Source = {
    fileName.map(file => logger.info(s"Converting file '$file'"))
    filterXhtml(convertToXhtml(htmlContent))
  }

  private def convertToXhtml(htmlContent: String) = {
    val parser = XML.withSAXParser(new SAXFactoryImpl().newSAXParser())
    parser.loadString(htmlContent)
  }

  private def filterXhtml(xhtmlContent: NodeSeq) = {

    val filter = new RewriteRule {
      override def transform(node: Node): Seq[Node] = node match {
        // Filter out all script tags
        case n if n.label == "script" => NodeSeq.Empty
        case x => x
      }
    }
    Source.fromIterable(new RuleTransformer(filter).transform(xhtmlContent).mkString.toIterable)
  }
}
