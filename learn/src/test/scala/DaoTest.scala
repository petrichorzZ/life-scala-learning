import com.xxx.learn.dao.MailInfoDao
import org.junit.Test

/**
  * Created by tao.zeng on 2018/10/9.
  */
class DaoTest {

  @Test
  def test1(): Unit = {
    new MailInfoDao().list()
  }

}
