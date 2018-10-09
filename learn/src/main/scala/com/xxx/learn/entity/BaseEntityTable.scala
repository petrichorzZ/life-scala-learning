package com.xxx.learn.entity

trait BaseEntityTable {

  val profile: slick.jdbc.JdbcProfile

}

object BaseEntityTable extends BaseEntityTable {
  lazy val profile = slick.jdbc.MySQLProfile
}
