package com.nhlreplay.converter.xhtml

import com.nhlreplay.utils.FileUtils
import xml.{Node, NodeSeq, XML}
import org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl
import xml.transform.{RuleTransformer, RewriteRule}

class XhtmlConverter
{
  def convertHtml(filePath: String) = {
    val htmlContent = readHtml(filePath)
    val xhtmlContent = filterXhtml(convertToXhtml(htmlContent))
    val xhtmlFileName = filePath.take(filePath.lastIndexOf(".") + 1) + "XHTML"
    FileUtils.writeToFile(xhtmlFileName, List(xhtmlContent))
  }

  private def readHtml(filePath: String) = {
    val source = FileUtils.getFileSource(filePath)
    val htmlContent = source.mkString
    source.close()
    htmlContent
  }

  private def convertToXhtml(htmlContent: String) = {
    val parser = XML.withSAXParser(new SAXFactoryImpl().newSAXParser())
    parser.loadString(htmlContent)
  }

  private def filterXhtml(xhtmlContent: NodeSeq) = {

    val filter = new RewriteRule {
      override def transform(node: Node) = node match {
        // Filter out all script tags
        case n if (n.label == "script") => NodeSeq.Empty
        case x => x
      }
    }
    new RuleTransformer(filter).transform(xhtmlContent).mkString
  }
}
