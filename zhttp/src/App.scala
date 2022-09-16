import zhttp._
import zhttp.http._
import zhttp.service.Server
import zio._

object App extends ZIOAppDefault {

  val app: HttpApp[Any, Nothing] = Http.collect[Request] {
    case Method.GET -> !! / "hello" => Response.text("Hello!")
  }

  override val run =
    Server.start(8080, app)
}
