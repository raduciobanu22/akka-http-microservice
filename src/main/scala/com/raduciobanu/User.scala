package com.raduciobanu

/**
  * Created by raduciobanu on 10/26/16.
  */
case class User (id: Int, name: String, username: String, password: Option[String]) {
  require(name.length >= 5, "Name must be at least 5 characters")
}
