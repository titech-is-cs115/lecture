//import org.scala_tools.time.Imports._
import net.liftweb.json._

object StudentInformation {
  val info = """{
    "family": "あなたの姓に書き換えて下さい",
    "name": "あなたの名に書き換えて下さい",
    "id": "あなたの学籍番号に書き換えて下さい",
    "login": "あなたのログインIDに書き換えて下さい",
    "email": "あなたの東工大メールのアドレスの@から左の部分に書き換えて下さい" }"""

  def main(arguments: Array[String]) {
    implicit val format = DefaultFormats
    println(Serialization.write(parse(info)))
  }
}
