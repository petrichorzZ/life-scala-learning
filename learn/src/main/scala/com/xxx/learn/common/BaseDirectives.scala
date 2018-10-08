package com.xxx.learn.common

import java.io.InputStream

import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.server.Directive1
import akka.http.scaladsl.server.directives.{BasicDirectives, HeaderDirectives, ParameterDirectives, RouteDirectives}
import akka.stream.javadsl.StreamConverters
import com.zz.core.util.JsonParse
import com.zz.core.util.JsonParse._
import com.zz.core.wrapper.ResultWrapper
import org.apache.commons.io.IOUtils
import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by tao.zeng on 2018/9/11.
  */
trait BaseDirectives extends ResultWrapper {

  import BasicDirectives._
  import HeaderDirectives._
  import ParameterDirectives._
  import RouteDirectives._
  import com.xxx.learn.util.ExecutionService.mat

  private val log: Logger = LoggerFactory.getLogger(getClass)

  def apiAuthentication: Directive1[Option[String]] = extractRequest.flatMap {
    req => {
      val path: String = req.uri.path.toString()
      val result: InputStream = req.entity.dataBytes.runWith(StreamConverters.asInputStream())
      val params: String = IOUtils.toString(result, "utf-8")
      log.info(s"[method:${req.method.value}] - [uri:${JsonParse.toJson(path)}] - [params:${JsonParse.toJson(params)}]")
      if (path.contains("api")) {
        // 放行
        provide(None)
      } else {
        // 获取请求头信息
        optionalHeaderValueByName(LearnConst.AUTH).flatMap {
          case Some(value) =>
            // 包含token信息
            log.info(s"some:${JsonParse.toJson(value)}")
            provide(None)
          case None => parameterMap.flatMap {
            params =>
              params.get(LearnConst.AUTH) match {
                case Some(value) =>
                  log.info(s"none:${JsonParse.toJson(value)}")
                  provide(None)
                case None =>
                  complete(Unauthorized -> successful(data = "Unauthorized"))
                  provide(None)
              }
          }
        }
      }
    }
  }
}
