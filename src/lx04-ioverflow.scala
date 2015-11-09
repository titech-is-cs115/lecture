package cs1.lx04

// run-main cs1.lx03.Main

object LX04A {
  def powerOf2[T](n: Int, i: Int, square: T => T, p: T) {
    if (i <= n) {
      if (i <= 3 || i >= n - 3) println(f"2^$i = $p")
      if (i == 3) println("...")
      powerOf2(n, i+1, square, square(p))
    }
  }

  def main(arguments: Array[String]) {
    println("\n2^n[Byte]")
    powerOf2[Byte] ( 8, 0,  (x: Byte) => (x + x).toByte,  1)
    println("\n2^n[Short]")
    powerOf2[Short](16, 0, (x: Short) => (x + x).toShort, 1)
    println("\n2^n[Int]")
    powerOf2[Int]  (32, 0, (x: Int)   =>  x + x,          1)
    println("\n2^n[Long]")
    powerOf2[Long] (64, 0, (x: Long)  =>  x + x,          1)
  }
}
