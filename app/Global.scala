import com.google.inject.{Guice, AbstractModule}
import com.nhlreplay.NHLGameReportService
import play.api.GlobalSettings
import services.GameReportService

object Global extends GlobalSettings
{
  val injector = Guice.createInjector(new AbstractModule {
    protected def configure() {
      bind(classOf[GameReportService]).to(classOf[NHLGameReportService])
    }
  })

  override def getControllerInstance[A](controllerClass: Class[A]): A = injector.getInstance(controllerClass)
}
