
/**
  * Created by tao.zeng on 2018/10/8.
  */
class CodeGenerator {

  @org.junit.Test
  def generator(): Unit = {
    val jdbcUrl = "jdbc:mysql://localhost:3306/life-mail?characterEncoding=utf8&useSSL=false"
    val dbUser = "root"
    val dbPassword = "root"
    val as = Array[String](
      "slick.jdbc.MySQLProfile",
      "com.mysql.jdbc.Driver",
      jdbcUrl, "./code", "com.xxx.learn.entity", dbUser, dbPassword, "true", "slick.codegen.SourceCodeGenerator", "true")
    slick.codegen.SourceCodeGenerator.main(as)

  }
}
