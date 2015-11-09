// package wakita.ex04b

object binary {
  def toBinary(n: Long, size: Int): String = {
    def aux(n: Long, i: Int, bits: List[String]): String = {
      if (i == 0) bits.mkString("")
      else aux(n >>> 1, i-1, (if ((n&1L) == 0L) "0" else "1") :: bits)
    }
    aux(n, size, List())
  }

  def toBinary(n: Byte) :String = toBinary(n, 8)
  def toBinary(n: Short):String = toBinary(n, 16)
  def toBinary(n: Int)  :String = toBinary(n, 32)
  def toBinary(n: Long) :String = toBinary(n, 64)

  def main(arguments: Array[String]) {
    println(f"5.toByte  => ${toBinary(5.toByte)}")
    println(f"5.toShort => ${toBinary(5.toShort)}")
    println(f"5         => ${toBinary(5)}")
    println(f"5L        => ${toBinary(5L)}")
    println(f"-5L       => ${toBinary(-5L)}")
  }
}
