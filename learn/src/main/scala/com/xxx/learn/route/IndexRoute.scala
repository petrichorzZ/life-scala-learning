package com.xxx.learn.route

import java.util.Date

import akka.http.scaladsl.server.Directives.{complete, get, path, pathPrefix, _}
import akka.http.scaladsl.server.Route
import com.xxx.learn.common.BaseDirectives
import com.xxx.learn.common.ImperativeRequestContext._
import com.zz.core.util.JsonParse._
import com.zz.core.wrapper.ResultWrapper

/**
  * Created by tao.zeng on 2018/10/8.
  */
class IndexRoute extends BaseDirectives with ResultWrapper {

  val route: Route = pathPrefix("api") {
    apiAuthentication { _ =>
      path("xxx") {
        post {
          entity(as[String]) {
            request =>
              complete(successful(message = "POST", data = request))
          }
        } ~
          get {
            imperativelyComplete {
              ctx =>
                ctx.complete(successful(message = "小花脸", data = new Date()))
            }
          }
      } ~
        path("index") {
          get {
            complete(successful(message = "GET", data = new Date()))
          } ~
            post {
              complete(successful(message = "POST", data = new Date()))
            }
        } ~
        path("index" / LongNumber) {
          id =>
            get {
              complete(successful(message = "GET", data = s"id=>$id"))
            } ~ put {
              entity(as[String]) {
                request =>
                  complete(successful(message = "PUT", data = s"id=>$id request=>$request"))
              }
            }
        }
    }
  }
}
