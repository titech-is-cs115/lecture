package cs1

// run-main cs1.LX03D: 浮動小数点数計算の誤差とオーバーフローの観察

object LX03D {
  def main(arguments: Array[String]) {
    def addMany(delta: Float, n: Int, v: Float): Float =
      if (n == 0) v else addMany(delta, n-1, v + delta)

    println(f"0.01 * 100 = ${addMany(0.01f, 100, 0f)}")

    val N = 10000000
    val s0 = 0f

    val s1 = addMany(1f, N, s0)
    println(f"1.0 * $N = $s1\n")

    val s2 = addMany(1f, N, s1)
    println(f"1.0 * $N = $s2\n")

    val s3 = addMany(1f, N, s2)
    println(f"1.0 * $N = $s3\n")

    val s4 = addMany(1f, N, s3)
    println(f"1.0 * $N = $s4\n")

    val s5 = addMany(1f, N, s4)
    println(f"1.0 * $N = $s5\n")
  }
}

