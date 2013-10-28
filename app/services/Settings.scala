package services

import com.google.inject.{Injector, AbstractModule, Guice}
import play.api.GlobalSettings

abstract class Settings extends GlobalSettings
{
  val injector: Injector

  protected def createInjector[A <: GameReportService](gameReportService: Class[A]) = {
    Guice.createInjector(new AbstractModule {
      protected def configure() {
        bind(classOf[GameReportService]).to(gameReportService)
      }
    })
  }

  override def getControllerInstance[A](controllerClass: Class[A]): A = injector.getInstance(controllerClass)
}
