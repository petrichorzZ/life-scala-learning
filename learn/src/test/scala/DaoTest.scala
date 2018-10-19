import com.xxx.learn.dao.MailInfoDao
import org.junit.Test

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by tao.zeng on 2018/10/9.
  */
class DaoTest {


  @Test
  def test1(): Unit = {

    val dao = new MailInfoDao()
    val res = Await.result(dao.list(), Duration.Inf)

    println(res)
  }
}
