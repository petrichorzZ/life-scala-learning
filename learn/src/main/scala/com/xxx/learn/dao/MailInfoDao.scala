package com.xxx.learn.dao

import com.xxx.learn.datasource.BaseDB

import scala.concurrent.Future

/**
  * Created by tao.zeng on 2018/10/9.
  */
class MailInfoDao extends BaseDB {

  import scala.concurrent.ExecutionContext.Implicits.global

  def list() = {
    db
    Future("123")
  }
}
