package com.zz.core.wrapper

import com.zz.core.enums.StatusCode
import com.zz.core.protocol.Protocols.ResponseWrapper

/**
  * Created by tao.zeng on 2018/9/11.
  */
trait ResultWrapper {

  val CODE_200 = StatusCode.CODE_200
  val CODE_400 = StatusCode.CODE_400
  val CODE_404 = StatusCode.CODE_404
  val CODE_500 = StatusCode.CODE_500

  def result(code: Int, message: String, data: Any) = ResponseWrapper(code, message, data)

  def successful(code: Int = CODE_200.getCode, message: String = CODE_200.getMessage, data: Any): ResponseWrapper = result(code, message, data)

  def failure(code: Int = CODE_500.getCode, message: String = CODE_500.getMessage, data: Any = null): ResponseWrapper = result(code, message, data)
}
