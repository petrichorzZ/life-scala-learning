package com.zz.core.conf

import java.util.concurrent.ConcurrentHashMap

/**
  * Created by tao.zeng on 2018/9/12.
  */
class DBConf extends ClientConf[DBConf] {

  override val configs: ConcurrentHashMap[String, Any] = getConfigs("dbConnection")

  def driver(): String = get[String]("drives").getOrElse("")

  def h2driver(): String = get[String]("dbConnection.h2driver").getOrElse("jdbc:h2:mem:test;MODE=MySQL;DATABASE_TO_UPPER=false;DB_CLOSE_DELAY=-1")

  def user(): String = get[String]("user").getOrElse("")

  def password(): String = get[String]("password").getOrElse("")

  def maxConnections(): Int = get[Int]("maxConnections").getOrElse(10)
}

object DBConf extends DBConf