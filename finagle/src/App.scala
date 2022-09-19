import com.twitter.finagle.{Http, Service}
import com.twitter.finagle.http
import com.twitter.util.{Await, Future}

object App  {
  val service = new Service[http.Request, http.Response] {
    def apply(req: http.Request): Future[http.Response] = {
      val resp = http.Response(req.version, http.Status.Ok)
      resp.contentString = "Hello!"
      resp.setContentType("text/plain", "utf-8")
      Future.value(resp)
    }
  }

  def main(args: Array[String]): Unit = {

    val server = Http.serve(":8080", service)
    Await.ready(server)
  }
}
