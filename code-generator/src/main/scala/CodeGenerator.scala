/**
  * Created by tao.zeng on 2018/10/11.
  */
object CodeGenerator {

  def main(args: Array[String]): Unit = {
    val jdbcUrl = "jdbc:mysql://localhost:3306/life-mail?characterEncoding=utf8&useSSL=false"
    val dbUser = "root"
    val dbPassword = "root"
    val outDir = "./code"
    val pkg = "com.xxx.learn.entity"
    val as = Array[String](
      "slick.jdbc.MySQLProfile",
      "com.mysql.jdbc.Driver",
      jdbcUrl, outDir, pkg, dbUser, dbPassword, "true", "slick.codegen.SourceCodeGenerator", "true")
    slick.codegen.SourceCodeGenerator.main(as)
  }
}
