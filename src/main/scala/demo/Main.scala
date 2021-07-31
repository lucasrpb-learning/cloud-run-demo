package demo

import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerOptions
import org.slf4j.LoggerFactory

object Main {

  def main(args: Array[String]): Unit = {

   // val port = System.getenv("PORT").toInt

    val port = 8080

    val logger = LoggerFactory.getLogger(this.getClass)
    val vertx = Vertx.vertx()

    val options = new HttpServerOptions()
     // .setPort(8080)
     // .setHost("localhost")

    val server = vertx.createHttpServer(options).requestHandler { req =>
      val response = req.response()
      response.putHeader("content-type", "text/plain")

      response.end("Hello, World")
    }

    server.listen(port, "0.0.0.0").onComplete { res =>
      if(res.failed()){
        logger.error(s"Server failed: ${res.cause()}")
      } else {
        logger.info(s"${Console.GREEN_B}Server running at port ${res.result().actualPort()}${Console.RESET}")
      }
    }

  }

}
