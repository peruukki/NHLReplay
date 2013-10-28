import com.nhlreplay.NHLGameReportService
import services.Settings

object Global extends Settings
{
  val injector = createInjector(classOf[NHLGameReportService])
}
