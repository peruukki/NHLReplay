package controllers

import javax.inject.Singleton
import services.{Settings, GameReportService}

object TestGlobal extends Settings
{
  override val injector = createInjector(classOf[MockGameReportService])
}

@Singleton
class MockGameReportService extends GameReportService
{
  def update() {}
}
