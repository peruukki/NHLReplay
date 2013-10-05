package com.nhlreplay.converter.xhtml

import com.nhlreplay.utils.FileUtils
import org.specs2.mutable.Specification
import scala.xml.parsing.XhtmlParser

class XhtmlConverterSpec extends Specification
{
  "XhtmlConverter" should {

    "convert playbyplay file from HTML to XHTML" in {
      val xhtml = convertToXhtml("playbyplay/PL020004.HTM")
      (xhtml \\ "tr").length mustEqual 9478
    }

    "convert reports file from HTML to XHTML" in {
      val xhtml = convertToXhtml("reports/TOR.HTM")
      (xhtml \\ "tr").length mustEqual 39
    }
  }

  private def convertToXhtml(fileName: String) = {
    val html = FileUtils.getResourceFileContent(fileName)
    val xhtml = XhtmlConverter.convertHtml(html)
    XhtmlParser(xhtml)
  }
}
