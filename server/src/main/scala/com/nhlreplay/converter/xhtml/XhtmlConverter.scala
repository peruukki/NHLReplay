package com.nhlreplay.converter.xhtml

import com.nhlreplay.utils.FileUtils
import xml.XML
import org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl

class XhtmlConverter
{
  def convertHtml(filePath: String) = {
    val htmlContent = readHtml(filePath)
    val xhtmlContent = convertToXhtml(htmlContent)
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
    parser.loadString(htmlContent).mkString
  }
}
