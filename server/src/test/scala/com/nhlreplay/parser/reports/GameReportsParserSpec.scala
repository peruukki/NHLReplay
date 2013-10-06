package com.nhlreplay.parser.reports

import com.nhlreplay.parser.InvalidContentException
import org.specs2.mutable.Specification
import com.nhlreplay.utils.FileUtils
import scala.io.Source

class GameReportsParserSpec extends Specification
{
  "GameReportsParser" should {

    "parse valid game reports document correctly" in {
      val xhtml = FileUtils.getResourceFileSource("reports/TOR.XHTML")
      val gameReports = GameReportsParser.parse(xhtml)
      gameReports.length mustEqual 30
      gameReports.head mustEqual GameReports("Apr 27 '13", "MONTREAL", "TORONTO", "http://www.nhl.com/scores/htmlreports/20122013/PL020708.HTM")
      gameReports.last mustEqual GameReports("Feb 23 '13", "TORONTO",  "OTTAWA",  "http://www.nhl.com/scores/htmlreports/20122013/PL020256.HTM")
    }

    "reject invalid game reports document" in {
      val xhtml = Source.fromString("<html/>")
      GameReportsParser.parse(xhtml) should throwAn[InvalidContentException]
    }
  }
}
