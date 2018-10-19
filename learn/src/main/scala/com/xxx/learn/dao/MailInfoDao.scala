package com.xxx.learn.dao

import com.xxx.learn.datasource.BaseDB
import com.xxx.learn.entity.{BaseEntityTable, MailInfoEntity}

import scala.concurrent.Future

/**
  * Created by tao.zeng on 2018/10/9.
  */
class MailInfoDao extends BaseDB with BaseEntityTable {

  import profile.api._

  import scala.concurrent.ExecutionContext.Implicits.global

  def list(): Future[Seq[MailInfoEntity]] = {
    db.run(mailInfos.result).flatMap {
      list =>
        Future(list)
    }
  }
}
