package com.xxx.learn.entity

trait BaseEntityTable {

  lazy val profile: slick.jdbc.JdbcProfile = slick.jdbc.MySQLProfile

  val mailInfos = new MailInfoDAO(profile).mailInfos
}

object BaseEntityTable extends BaseEntityTable {}
