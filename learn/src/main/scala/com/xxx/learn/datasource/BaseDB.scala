package com.xxx.learn.datasource

/**
  * Created by tao.zeng on 2018/10/9.
  */
trait BaseDB {

  lazy val databaseService: DataBaseTrait = DatabaseService.databaseService

  import databaseService.profile.api._

  def db: Database = databaseService.db
}
