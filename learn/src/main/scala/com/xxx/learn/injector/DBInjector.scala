package com.xxx.learn.injector

import com.google.inject.{AbstractModule, Guice, Injector, Singleton}
import com.xxx.learn.datasource.DatabaseService

/**
  * Created by tao.zeng on 2018/10/9.
  */
object DBInjector {

  private val inject: Injector = Guice.createInjector(new DBModule)

  def getInstance[T](clazz: Class[T]): T = {
    try
      inject.getInstance(clazz)
    catch {
      case ex: Throwable =>
        throw new Exception(s"Unable to load instance for type ${clazz.getName}!", ex)
    }
  }

  private class DBModule extends AbstractModule {
    override protected def configure(): Unit = {
      bind(classOf[DatabaseService]).in(classOf[Singleton])
    }
  }
}
