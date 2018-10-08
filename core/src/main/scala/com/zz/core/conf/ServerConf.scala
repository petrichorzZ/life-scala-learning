package com.zz.core.conf

import java.util.concurrent.ConcurrentHashMap

/**
  * Created by tao.zeng on 2018/9/12.
  */
class ServerConf extends ClientConf[ServerConf] {

  override val configs: ConcurrentHashMap[String, Any] = getConfigs("server")

  def ip(): String = get("ip").getOrElse("0.0.0.0")

  def port(): Int = get[Int]("port").getOrElse(8088)

  def sessionTimeoutMinute(): Int = get[Int]("sessionTimeout").getOrElse(60)
}

object ServerConf extends ServerConf
