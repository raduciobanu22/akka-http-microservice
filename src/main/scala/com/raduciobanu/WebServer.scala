package com.raduciobanu

/**
  * Created by raduciobanu on 10/16/16.
  */

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import scala.io.StdIn

object WebServer {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("users-service")
    implicit val  materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val routes = new Routes

    val bindingFuture = Http().bindAndHandle(routes.usersRoutes, "localhost", 5000)

    println(s"Server online at http:://localhost:5000/ \n Press RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }
}
