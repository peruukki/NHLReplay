package com.nhlreplay.parser.playbyplay

import org.json4s.JsonAST.{JValue, JString, JInt}

case class TokenValue(token: Token, value: Any)
{
  def toJValue: JValue = value match {
    case i: Int => JInt(i)
    case s: String => JString(s)
    case _ => throw new IllegalStateException(s"TokenValue '$value' is of unsupported type '${value.getClass}'")
  }
}
