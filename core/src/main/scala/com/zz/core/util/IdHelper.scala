package com.zz.core.util

import java.util.UUID

/**
  * Created by tao.zeng on 2018/9/11.
  */
object IdHelper {

  def id(): Long = {
    Snowflake.nextId()
  }

  def uuid(): String = {
    UUID.randomUUID().toString.replaceAll("-", "").toLowerCase
  }
}
