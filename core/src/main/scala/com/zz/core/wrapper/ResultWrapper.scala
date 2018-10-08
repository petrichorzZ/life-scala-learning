package com.zz.core.wrapper

import com.zz.core.base.Const
import com.zz.core.protocol.Protocols.ResponseWrapper

/**
  * Created by tao.zeng on 2018/9/11.
  */
trait ResultWrapper {

  def result(code: String, message: String, data: Any) = ResponseWrapper(code, message, data)

  def successful(code: String = Const.CODE_SUCCESSFUL, message: String = Const.MESSAGE_SUCCESSFUL, data: Any): ResponseWrapper = result(code, message, data)

  def failure(code: String = Const.CODE_FAILURE, message: String = Const.MESSAGE_FAILURE, data: Any = null): ResponseWrapper = result(code, message, data)
}
