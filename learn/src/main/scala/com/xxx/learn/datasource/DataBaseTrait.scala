package com.xxx.learn.datasource

import org.slf4j.{Logger, LoggerFactory}

/**
  * Created by tao.zeng on 2018/10/9.
  */
trait DataBaseTrait {

  protected val logger: Logger = LoggerFactory.getLogger(getClass)

  val profile: slick.jdbc.JdbcProfile

  import profile.api._

  var db: Database = _

  def init: Database
}
