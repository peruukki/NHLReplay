package com.nhlreplay.json

import org.json4s.JsonAST.JValue
import org.json4s.native.JsonMethods._

trait HasJson
{
  def toJson: String

  def serializeJson(json: JValue): String = compact(render(json))
}
