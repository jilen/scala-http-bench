import cats.syntax.all._
import cats.effect._
import com.comcast.ip4s._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.netty.server._
import org.http4s.server.Router

object App extends IOApp {

  val helloWorldService = HttpRoutes.of[IO] {
    case GET -> Root / "hello"  =>
      Ok("Hello!")
  }

  def run(args: List[String]) = {
    val httpApp = Router("/" -> helloWorldService).orNotFound
    NettyServerBuilder[IO]
      .bindHttp(8080)
      .withHttpApp(httpApp)
      .withNativeTransport
      .resource.useForever.as(ExitCode.Success)
  }
}
