package com.nhlreplay.utils

import java.io.File
import io.Source
import java.net.URL

object FileUtils {
  val encoding = "UTF-8"

  def getFileSource(fileName: String): Source = Source.fromFile(fileName, encoding)

  def getFileContent(fileName: String): String = getFileContent(getFileSource(fileName))

  def getURLContent(url: String): String = getFileContent(Source.fromURL(url, encoding))

  private def getFileContent(source: Source) = {
    val content = source.mkString
    source.close()
    content
  }

  def writeToFile(fileName: String, fileContent: Seq[String]): String = {
    printToFile(new File(fileName))(p => { fileContent foreach p.println })
    fileName
  }

  private def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f, encoding)
    try { op(p) } finally { p.close() }
  }
}
