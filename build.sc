import mill._
import mill.scalalib._

trait ModuleBase extends ScalaModule {
  def scalaVersion = "2.13.8"
}

object http4s extends ModuleBase {

  object ember extends ModuleBase {
    def ivyDeps = Agg(
      ivy"org.http4s::http4s-dsl:0.23.16",
      ivy"org.http4s::http4s-ember-server:0.23.16"
    )
  }

  object armeria extends ModuleBase {
    def ivyDeps = Agg(
      ivy"org.http4s::http4s-dsl:1.0.0-M35",
      ivy"org.http4s::http4s-armeria-server:1.0.0-M1"
    )
  }

  object netty extends ModuleBase {
    def ivyDeps = Agg(
      ivy"org.http4s::http4s-dsl:1.0.0-M34",
      ivy"org.http4s::http4s-netty-server:0.6.0-M2",
      ivy"io.netty:netty-transport-native-epoll:4.1.81.Final;classifier=linux-x86_64"
    )
  }


}

object akka extends ModuleBase {
  def ivyDeps = Agg(
    ivy"com.typesafe.akka::akka-actor-typed:2.6.20",
    ivy"com.typesafe.akka::akka-http:10.2.10",
    ivy"com.typesafe.akka::akka-stream:2.6.20",
  )
}

object zhttp extends ModuleBase {
  def ivyDeps = Agg(
    ivy"io.d11::zhttp:2.0.0-RC11"
  )
}
