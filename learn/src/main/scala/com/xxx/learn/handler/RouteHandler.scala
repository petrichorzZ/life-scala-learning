package com.xxx.learn.handler

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.xxx.learn.common.{CrossSupport, LearnConst}
import com.xxx.learn.route.{IndexRoute, MailRoute}
import org.slf4j.LoggerFactory

/**
  * Created by tao.zeng on 2018/10/8.
  */
object RouteHandler extends CrossSupport {
  private val logger = LoggerFactory.getLogger(getClass)

  def handler(): Route = {
    extractAuth(LearnConst.AUTH) {
      auth => {
        logger.info(s"auth:$auth")
        new IndexRoute().route ~ new MailRoute().route
      }
    }
  }
}
