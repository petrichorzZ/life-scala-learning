package com.xxx.learn.datasource

import com.xxx.learn.injector.DBInjector
import com.zaxxer.hikari.{HikariConfig, HikariDataSource}
import com.zz.core.conf.DBConf
import slick.jdbc.MySQLProfile

/**
  * Created by tao.zeng on 2018/10/9.
  */
class DatabaseService extends DataBaseTrait {

  override val profile: MySQLProfile.type = slick.jdbc.MySQLProfile

  import profile.api._

  init

  override def init: DatabaseService.this.profile.api.Database = {
    db = Database.forDataSource(getDataSource, Some(DBConf.maxConnections()))
    db.createSession()
    db
  }

  protected def getDataSource: HikariDataSource = {
    val hikariConfig = new HikariConfig()
    val url: String = DBConf.driver()
    val user: String = DBConf.user()
    val password: String = DBConf.password()
    hikariConfig.setDriverClassName("com.mysql.jdbc.Driver")
    hikariConfig.setJdbcUrl(url)
    hikariConfig.setUsername(user)
    hikariConfig.setPassword(password)
    hikariConfig.setConnectionTimeout(30000)
    hikariConfig.setMaxLifetime(30 * 1000 * 60)
    hikariConfig.addDataSourceProperty("cachePrepStmts", "true")
    hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250")
    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")
    logger.info(s"user = $user,password len = ${password.length} url = $url")

    try {
      new HikariDataSource(hikariConfig)
    }
    catch {
      case ex: Exception =>
        logger.error("[DB connection error]", ex)
        throw ex
    }
  }
}

object DatabaseService {
  lazy val databaseService: DatabaseService = DBInjector.getInstance(classOf[DatabaseService])
}
