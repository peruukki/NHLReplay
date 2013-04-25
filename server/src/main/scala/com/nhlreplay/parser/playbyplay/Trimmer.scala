package com.nhlreplay.parser.playbyplay

object Trimmer {
  def preserve(text: String): String = text
  def removeCounts(text: String): String = text.replaceAll("""\(\d+\)""", "")
  def removeDots(text: String): String = text.replaceAll("""\.""", "")
  def toInt(text: String): Int = text.toInt
  def trimWhitespace(text: String): String = """\s+""".r.replaceAllIn(text, " ")

  def trimPenaltyReason(reason: String): String = trimWhitespace(reason).toLowerCase

  def trimShotType(shotType: String): String = {
    shotType.toLowerCase match {
      case "backhand" => "shoots on his backhand"
      case "deflected" => "shoots and it's deflected"
      case "slap" => "takes a slapshot"
      case "snap" => "takes a snap shot"
      case "tip-in" => "tries to tip it in"
      case "wrap-around" => "tries a wrap-around"
      case "wrist" => "takes a wrist shot"
      case x => x
    }
  }

  def trimTarget(target: String): String = {
    target.toLowerCase match {
      case "goalpost" => "hits the post"
      case "hit crossbar" => "hits the crossbar"
      case "over net" => "over the net"
      case "wide of net" => "wide"
      case x => x
    }
  }
}
