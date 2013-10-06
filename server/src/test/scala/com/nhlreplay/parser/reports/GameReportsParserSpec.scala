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

    "reject game reports document without report table" in {
      GameReportsParser.parse(documentWithoutTables) should throwA(new InvalidContentException("No report table"))
    }

    "reject game reports document with too many report tables" in {
      GameReportsParser.parse(documentWithTooManyTables) should throwA(new InvalidContentException("Too many report tables: 2"))
    }

    "reject game reports document without report rows" in {
      GameReportsParser.parse(documentWithoutReportRows) should throwA(new InvalidContentException("No report rows"))
    }
  }

  private def documentWithoutTables = Source.fromString(<html/>.mkString)

  private def documentWithTooManyTables = Source.fromString(
    <html>
      <table>
        <thead/>
        <tbody><tr/></tbody>
      </table>
      <table>
        <thead/>
        <tbody><tr/></tbody>
      </table>
    </html>.mkString)

  private def documentWithoutReportRows = Source.fromString(
    <html>
      <table>
        <thead/>
        <tbody/>
      </table>
    </html>.mkString)
}
