package com.nhlreplay.converter.xhtml

import java.io.File

class XhtmlConverter
{
  def convertHtml(filePath: String) = {
    val source = scala.io.Source.fromFile(filePath, "UTF-8")
    val htmlContent = source.mkString.replace("<html>", "")
    source.close()

    val header =
      """<?xml version="1.0" encoding="utf-8"?>
        |
        |<!DOCTYPE html
        |   PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        |   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd" >
        |
        |<html xmlns="http://www.w3.org/1999/xhtml">
        |
      """.stripMargin

    val fileName = filePath.take(filePath.lastIndexOf(".") + 1) + "XHTML"
    printToFile(new File(fileName))(p => {
      List(header, convertTags(htmlContent, "meta|img|br")) foreach p.println
    })

    fileName
  }

  private def convertTags(content: String, tag: String) = {
    """(<(?:%s).*?)(>)""".format(tag).r.replaceAllIn(content, x => { x.group(1) + " /" + x.group(2) })
  }

  private def printToFile(f: java.io.File)(op: java.io.PrintWriter => Unit) {
    val p = new java.io.PrintWriter(f)
    try { op(p) } finally { p.close() }
  }
}
