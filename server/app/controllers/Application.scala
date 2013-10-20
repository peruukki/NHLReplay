package controllers

import com.nhlreplay.Main
import play.api._
import play.api.mvc._

object Application extends Controller
{
  def index = Action {
    Main.main(Array.empty)
    Ok(views.html.index("Updated the latest game."))
  }
}
