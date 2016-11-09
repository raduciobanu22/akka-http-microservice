package com.raduciobanu

import akka.http.scaladsl.server.Directives._

/**
  * Created by raduciobanu on 10/26/16.
  */
class Routes extends JsonSupport {
  val usersRoutes =
    path("users" / IntNumber) { id =>
      get {
        complete(User(id.toInt, "John Smith", "johnsmith", Some("dumb-password")))
      } ~
      put {
        complete {
          "Received PUT request for user " + id
        }
      } ~
      delete {
        complete {
          "Received DELETE request"
        }
      }
    } ~
    path("users") {
      get {
        complete {
          "Received GET request to list all users"
        }
      } ~
      post {
        entity(as[User]) { user =>
          val name = user.name
          val username = user.username
          complete(s"$name $username")
        }
      }
    }

}
