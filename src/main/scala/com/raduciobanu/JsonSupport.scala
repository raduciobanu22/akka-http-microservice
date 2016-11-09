package com.raduciobanu

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json._

/**
  * Created by raduciobanu on 11/5/16.
  */
trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol{
  implicit val itemFormat = jsonFormat4(User.apply)
}
