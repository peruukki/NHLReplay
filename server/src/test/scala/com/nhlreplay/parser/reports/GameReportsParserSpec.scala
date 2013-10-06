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
      gameReports.length shouldEqual 30
      gameReports.head shouldEqual GameReports("Apr 27 '13", "MONTREAL", "TORONTO", "http://www.nhl.com/scores/htmlreports/20122013/PL020708.HTM")
      gameReports.last shouldEqual GameReports("Feb 23 '13", "TORONTO",  "OTTAWA",  "http://www.nhl.com/scores/htmlreports/20122013/PL020256.HTM")
    }

    "parse playbyplay report URL correctly even when an extra column exists before it" in {
      GameReportsParser.parse(document(beforeReports = ":")) shouldEqual Seq(documentGameReports)
    }

    "reject invalid game reports date" in {
      GameReportsParser.parse(document(beforeDate = ":")) should throwA(new InvalidContentException("Invalid date: ':'"))
    }

    "reject invalid game reports away team" in {
      GameReportsParser.parse(document(beforeAway = ":")) should throwA(new InvalidContentException("Invalid away team: ':'"))
    }

    "reject invalid game reports home team" in {
      GameReportsParser.parse(document(beforeHome = ":")) should throwA(new InvalidContentException("Invalid home team: ':'"))
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

  val documentGameReports = GameReports("Apr 10 '13", "TORONTO", "NY RANGERS", "http://www.nhl.com/scores/htmlreports/20122013/PL020592.HTM")

  private def document(beforeDate: String = "", beforeAway: String = "", beforeHome: String = "", beforeReports: String = "") =
    Source.fromString(
      <html>
        <table>
          <thead/>
          <tbody>
            <tr>
              {if (!beforeDate.isEmpty) <td>{beforeDate}</td>}
              <td>{documentGameReports.date}</td>
              <td>708</td>
              {if (!beforeAway.isEmpty) <td>{beforeAway}</td>}
              <td>{documentGameReports.awayTeam}</td>
              {if (!beforeHome.isEmpty) <td>{beforeHome}</td>}
              <td>{documentGameReports.homeTeam}</td>
              {if (!beforeReports.isEmpty) <td>{beforeReports}</td>}
              <td><a href="http://www.nhl.com/scores/htmlreports/20122013/RO020592.HTM">Roster</a></td>
              <td><a href="http://www.nhl.com/scores/htmlreports/20122013/GS020592.HTM">Summary</a></td>
              <td><a href="http://www.nhl.com/scores/htmlreports/20122013/ES020592.HTM">Events</a></td>
              <td><a href="http://www.nhl.com/scores/htmlreports/20122013/FC020592.HTM">Face-offs</a></td>
              <td><a href={documentGameReports.playByPlayURL}>Play by Play</a></td>
              <td><a href="http://www.nhl.com/scores/htmlreports/20122013/SS020592.HTM">Shots</a></td>
              <td><a href="http://www.nhl.com/scores/htmlreports/20122013/TH020592.HTM">Home TOI</a></td>
              <td><a href="http://www.nhl.com/scores/htmlreports/20122013/TV020592.HTM">Vis. TOI</a></td>
              <td><a href="http://www.nhl.com/scores/htmlreports/20122013/SO020592.HTM">Shootout</a></td>
            </tr>
          </tbody>
        </table>
      </html>.mkString)

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
