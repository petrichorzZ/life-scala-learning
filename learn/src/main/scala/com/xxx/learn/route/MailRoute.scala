package com.xxx.learn.route

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives.{complete, get, path, pathPrefix, _}
import com.xxx.learn.dao.MailInfoDao
import com.zz.core.util.JsonParse._
import com.zz.core.wrapper.ResultWrapper

/**
  * Created by tao.zeng on 2018/10/9.
  */
class MailRoute extends ResultWrapper {

  val dao = new MailInfoDao

  val route: Route = pathPrefix("api") {
    path("mail") {
      get {
        complete(successful(data = dao.list()))
      }
    }
  }
}
