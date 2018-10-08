package com.zz.core.protocol

/**
  * Created by tao.zeng on 2018/9/11.
  */
object Protocols {

  case class ResponseWrapper(code: String, message: String, data: Any)

  case class PageWrapper(current: Int, size: Int, total: Long, data: Any)
}
