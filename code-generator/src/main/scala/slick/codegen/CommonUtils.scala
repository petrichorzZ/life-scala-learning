package slick.codegen

/**
  * Created by tao.zeng on 2018/10/9.
  */
object CommonUtils {

  /** Slick code generator string extension methods. (Warning: Not unicode-safe, uses String#apply) */
  implicit class StringExtensions(val str: String) {
    /** Lowercases the first (16 bit) character. (Warning: Not unicode-safe, uses String#apply) */
    final def uncapitalize: String = str(0).toString.toLowerCase + str.tail

    /**
      * Capitalizes the first (16 bit) character of each word separated by one or more '_'. Lower cases all other characters.
      * Removes one '_' from each sequence of one or more subsequent '_' (to avoid collision).
      * (Warning: Not unicode-safe, uses String#apply)
      */
    final def toCamelCase: String
    = str
      .split("_")
      .map { case "" => "_" case s => s } // avoid possible collisions caused by multiple '_'
      .map(_.capitalize)
      .mkString("")
  }
}
