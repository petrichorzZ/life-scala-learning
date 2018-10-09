package com.xxx.learn.entity

final case class MailInfoEntity(id: Long, receiver: String, mailSubject: String, mailContent: String, filePath: Option[String] = None, created: Option[java.sql.Timestamp] = None, updated: Option[java.sql.Timestamp] = None)

import slick.jdbc.JdbcProfile


class MailInfoDAO(val profile: JdbcProfile) {

  import profile.api._

  class MailInfo(tag: Tag) extends Table[MailInfoEntity](tag, "mail_info") {
    def * = (id, receiver, mailSubject, mailContent, filePath, created, updated) <> (MailInfoEntity.tupled, MailInfoEntity.unapply)

    def ? = (Rep.Some(id), Rep.Some(receiver), Rep.Some(mailSubject), Rep.Some(mailContent), filePath, created, updated).shaped.<>({ r => import r._; _1.map(_ => MailInfoEntity.tupled((_1.get, _2.get, _3.get, _4.get, _5, _6, _7))) }, (_: Any) => throw new Exception("Inserting into ? projection not supported."))

    val id: Rep[Long] = column[Long]("id", O.PrimaryKey)
    val receiver: Rep[String] = column[String]("receiver")
    val mailSubject: Rep[String] = column[String]("mail_subject")
    val mailContent: Rep[String] = column[String]("mail_content")
    val filePath: Rep[Option[String]] = column[Option[String]]("file_path", O.Default(None))
    val created: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("created", O.Default(None))
    val updated: Rep[Option[java.sql.Timestamp]] = column[Option[java.sql.Timestamp]]("updated", O.Default(None))

    def getOrder(sortByFields: String, fieldsAscDesc: String = "asc") = {
      (sortByFields, fieldsAscDesc) match {
        case ("id", "asc") => id.asc
        case ("id", _) => id.desc

        case ("receiver", "asc") => receiver.asc
        case ("receiver", _) => receiver.desc

        case ("mailSubject", "asc") => mailSubject.asc
        case ("mailSubject", _) => mailSubject.desc

        case ("mailContent", "asc") => mailContent.asc
        case ("mailContent", _) => mailContent.desc

        case ("filePath", "asc") => filePath.asc
        case ("filePath", _) => filePath.desc

        case ("created", "asc") => created.asc
        case ("created", _) => created.desc

        case ("updated", "asc") => updated.asc
        case ("updated", _) => updated.desc

      }
    }

  }

  val mailInfos = TableQuery[MailInfo]
}
