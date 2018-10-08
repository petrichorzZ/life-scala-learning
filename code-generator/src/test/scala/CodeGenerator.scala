import org.junit.Test

/**
  * Created by tao.zeng on 2018/10/8.
  */
class CodeGenerator {

  @Test
  def generator(): Unit = {
    val jdbcUrl = "jdbc:mysql://localhost:3306/life-mail?characterEncoding=utf8&useSSL=false"
    // Array(profile, jdbcDriver, url, outputFolder, pkg, user, password)
    val as = Array[String](
      "slick.jdbc.MySQLProfile",
      "com.mysql.jdbc.Driver",
      jdbcUrl, "./code", "com.xxx.learn.dao", "root", "root")
    slick.codegen.SourceCodeGenerator.main(as)
  }
}
