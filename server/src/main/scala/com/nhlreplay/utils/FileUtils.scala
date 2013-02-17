package com.nhlreplay.utils

import java.io.File

object FileUtils {

  def writeToFile(fileName: String, fileContent: Seq[String]) {
    printToFile(new File(fileName))(p => { fileContent foreach p.println })
  }

  private def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try { op(p) } finally { p.close() }
  }
}
