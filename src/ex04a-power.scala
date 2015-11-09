package wakita.lx04

object powerOf2 {

  // Int型のnに関して2^nを計算する関数
  def powerOf2(n: Int): Int = {
    def aux(i: Int, p: Int): Int =
      if (i == n) p
      else aux(i+1, p+p)
    aux(0, 1)
  }

  /*
  def main(arguments: Array[String]) {
    // println(f"Int: ${powerI(5)}")

    println(f"Byte:  ${powerOf2[Byte] (5, 1, (p) => (p+p).toByte)}")
    println(f"Short: ${powerOf2[Short](5, 1, (p) => (p+p).toShort)}")
    println(f"Int:   ${powerOf2[Int]  (5, 1, (p) => (p+p))}")
    println(f"Long:  ${powerOf2[Long] (5, 1, (p) => (p+p))}")
  }
  */
}
