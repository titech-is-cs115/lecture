package cs1

// run-main cs1.LX03A

object LX03A {

  // 2^nをByte上で計算する関数
  def powerOf2B(n: Int): Byte = {
    def aux(i: Int, p: Byte): Byte = {
      println(f"2^${i} = ${p}\n")
      if (i == n) p
      else aux(i+1, (p+p).toByte)
    }
    println("\n2^n[Byte]\n")
    aux(0, 1: Byte)
  }

  // 2^nをShort上で計算する関数
  def powerOf2S(n: Int): Short = {
    def aux(i: Int, p: Short): Short = {
      println(f"2^${i} = ${p}\n")
      if (i == n) p
      else aux(i+1, (p+p).toShort)
    }
    println("\n2^n[Short]")
    aux(0, 1: Short)
  }

  // 2^nをInt上で計算する関数
  def powerOf2I(n: Int): Int = {
    def aux(i: Int, p: Int): Int = {
      println(f"2^${i} = ${p}\n")
      if (i == n) p
      else aux(i+1, p+p)
    }
    println("\n2^n[Int]")
    aux(0, 1)
  }

  // 2^nをLong上で計算する関数
  def powerOf2L(n: Int): Long = {
    def aux(i: Int, p: Long): Long = {
      println(f"2^${i} = ${p}\n")
      if (i == n) p
      else aux(i+1, p+p)
    }
    println("\n2^n[Long]")
    aux(0, 1L)
  }

  def main(arguments: Array[String]) {
    powerOf2B(8);
    powerOf2S(16);
    powerOf2I(32);
    powerOf2L(64);
  }
}
