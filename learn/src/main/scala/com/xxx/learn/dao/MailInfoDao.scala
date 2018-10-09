package com.xxx.learn.dao

import com.xxx.learn.datasource.BaseDB
import com.xxx.learn.entity.BaseEntityTable._

import scala.concurrent.Future

/**
  * Created by tao.zeng on 2018/10/9.
  */
class MailInfoDao extends BaseDB {

  import profile.api._

  import scala.concurrent.ExecutionContext.Implicits.global

  def list(): Future[Seq[(Long, String, String)]] = {
    db.run(mailInfos.map(x => (x.id, x.mailSubject, x.mailContent)).result).flatMap {
      rows =>
        Future(rows)
    }
  }
}
