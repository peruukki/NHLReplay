package com.nhlreplay.utils

import java.io.File
import io.Source

object FileUtils {

  def getFileSource(fileName: String): Source = Source.fromFile(fileName, "UTF-8")

  def writeToFile(fileName: String, fileContent: Seq[String]): String = {
    printToFile(new File(fileName))(p => { fileContent foreach p.println })
    fileName
  }

  private def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f, "UTF-8")
    try { op(p) } finally { p.close() }
  }
}
