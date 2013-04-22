package com.nhlreplay.utils

import java.io.File
import io.Source
import com.typesafe.scalalogging.slf4j.Logging

object FileUtils extends Logging {
  val encoding = "UTF-8"

  def getFileSource(fileName: String): Source = {
    logger.info(s"Reading file '$fileName'")
    Source.fromFile(fileName, encoding)
  }

  def getFileContent(fileName: String): String = getFileContent(getFileSource(fileName))

  def retrieveFile(url: String, targetFile: String): String = {
    logger.info(s"Retrieving file from URL '$url'")
    val content = getFileContent(Source.fromURL(url, encoding))
    writeToFile(targetFile, List(content))
  }

  private def getFileContent(source: Source) = {
    val content = source.mkString
    source.close()
    content
  }

  def writeToFile(fileName: String, fileContent: Seq[String]): String = {
    logger.info(s"Writing to file '$fileName'")
    printToFile(new File(fileName))(p => { fileContent foreach p.println })
    fileName
  }

  private def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f, encoding)
    try { op(p) } finally { p.close() }
  }
}
