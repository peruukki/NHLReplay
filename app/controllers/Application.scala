package controllers

import javax.inject.{Singleton, Inject}
import play.api._
import play.api.mvc._
import services.GameReportService

@Singleton
class Application @Inject() (gameReportService: GameReportService) extends Controller
{
  def index: Action[AnyContent] = Action {
    gameReportService.update()
    Ok(views.html.index())
  }

  def game: Action[AnyContent] = Action {
    Ok(views.html.game())
  }
}
