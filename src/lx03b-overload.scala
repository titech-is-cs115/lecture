package cs1

// run-main cs1.LX03A

object LX03B {

  // 2^nをByte上で計算する関数
  def powerOf2(n: Int, one: Byte): Byte = {
    def aux(i: Int, p: Byte): Byte = {
      println(f"2^${i} = ${p}\n")
      if (i == n) p
      else aux(i+1, (p+p).toByte)
    }
    println("\n2^n[Byte]\n")
    aux(0, one)
  }

  // 2^nをShort上で計算する関数
  def powerOf2(n: Int, one: Short): Short = {
    def aux(i: Int, p: Short): Short = {
      println(f"2^${i} = ${p}\n")
      if (i == n) p
      else aux(i+1, (p+p).toShort)
    }
    println("\n2^n[Short]")
    aux(0, one)
  }

  // 2^nをInt上で計算する関数
  def powerOf2(n: Int, one: Int): Int = {
    def aux(i: Int, p: Int): Int = {
      println(f"2^${i} = ${p}\n")
      if (i == n) p
      else aux(i+1, p+p)
    }
    println("\n2^n[Int]")
    aux(0, one)
  }

  // 2^nをLong上で計算する関数
  def powerOf2(n: Int, one: Long): Long = {
    def aux(i: Int, p: Long): Long = {
      println(f"2^${i} = ${p}\n")
      if (i == n) p
      else aux(i+1, p+p)
    }
    println("\n2^n[Long]")
    aux(0, one)
  }

  def main(arguments: Array[String]) {
    powerOf2(8,  1.toByte);
    powerOf2(16, 1.toShort);
    powerOf2(32, 1);
    powerOf2(64, 1L);
  }
}
