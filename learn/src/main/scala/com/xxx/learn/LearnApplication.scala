package com.xxx.learn

import java.io.File

import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.model.{HttpResponse, StatusCodes}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.ExceptionHandler
import ch.qos.logback.classic.LoggerContext
import ch.qos.logback.classic.joran.JoranConfigurator
import com.xxx.learn.handler.RouteHandler
import com.zz.core.conf.ServerConf
import com.zz.core.util.JsonParse
import com.zz.core.wrapper.ResultWrapper
import org.slf4j.LoggerFactory

import scala.util.{Failure, Success}

/**
  * Created by tao.zeng on 2018/10/8.
  */
object LearnApplication extends App with ResultWrapper {

  val logger = LoggerFactory.getLogger(getClass)

  import com.xxx.learn.util.ExecutionService._

  initLogConfig()

  Http().bindAndHandle(RouteHandler.handler(), ServerConf.ip(), ServerConf.port()).onComplete {
    case Success(result) =>
      logger.info(s"start ${JsonParse.toJson(result)} successful")
    case Failure(ex) => logger.error(s"starter failure！$ex")
  }

  private def initLogConfig(): Unit = {
    val logConfig = new File("./logback.xml")
    if (logConfig.exists() && logConfig.canRead) {
      val logContext = LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
      val config = new JoranConfigurator()
      config.setContext(logContext)
      logContext.reset()
      config.doConfigure(logConfig)
    }
  }

  implicit def globalExceptionHandler: ExceptionHandler =
    ExceptionHandler {
      case ex: ArithmeticException =>
        extractUri { uri =>
          logger.error(s"uri:[$uri] ,error msg:${ex.getMessage}", ex)
          complete(HttpResponse(InternalServerError, entity = ex.getMessage))
        }
      case ex: NullPointerException =>
        complete(HttpResponse(StatusCodes.NotFound, entity = JsonParse.toJson(failure(message = ex.getMessage))))
      case ex: Exception =>
        logger.error(s"error msg:${ex.getMessage}", ex)
        complete(HttpResponse(InternalServerError, entity = JsonParse.toJson(failure(message = ex.getMessage))))
    }
}
