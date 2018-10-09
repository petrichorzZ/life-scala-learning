package com.xxx.learn.datasource

/**
  * Created by tao.zeng on 2018/10/9.
  */
trait BaseDB {

  // mysqlProfile ，请在代码使用import driver.api._
  // 而不是 import DatabaseService.driver.api._
  // val driver: slick.jdbc.JdbcProfile = DatabaseService.databaseService.profile

  // 测试的时候 请使用h2Profile将其覆写
  // import driver.api._

  //以下为新写法，上面几行代码不引用后可以注释掉
  lazy val databaseService: DataBaseTrait = DatabaseService.databaseService

  import databaseService.profile.api._

  def db: Database = databaseService.db
}
