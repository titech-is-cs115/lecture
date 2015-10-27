package cs1

import scala.math._

// run-main cs1.LX03C: 書式つき文字列の例

object LX03C {
  def fact(n: Int): Int = {
    if (n == 0) 1
    else n * fact(n - 1)
  }

  def main(arguments: Array[String]) {
    // ${...} の内側に書かれた Scala の式の評価結果が文字列に埋め込まれる
    println(f"fact(10) = ${fact(10)}")
    println(f"fact(10) は偶数か？ ${fact(10) % 2 == 0}")
    println(f"fact(10) は偶数か？ ${if (fact(10) % 2 == 0) "はい" else "いいえ"}")
    println(f"Int.MaxValue = ${Int.MaxValue}")

    // 変数の値を文字列に埋め込むときは { } を省略できる．
    val lmax = Long.MaxValue
    println(f"Long.MaxValue = $lmax")

    // %d, %x, %f, %gなどを使ってさらに細かく書式を制御できる
    //     %8x: 8桁の16進表記を埋める
    //     %08x: 8桁とするが桁が埋まらない高位の桁は0で埋める
    println(f"100> ${100},   100> ${100}%8x,   100> ${100}%08x")
    //     %f: 実数表記を埋める
    //     %1.5f: 小数点以上は1桁で，小数点以下は5桁という表記を埋める．
    //     %e: 指数表現を埋める．
    println(f"100の16進表現 = ${100}%x,   π = ${Pi}%1.5f,   e^30 = ${pow(E, 30)}%g")

    // もっと詳しいことは Java の [Formatter クラス](http://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html#syntax)．
  }
}

