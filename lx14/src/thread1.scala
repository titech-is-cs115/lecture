package lx14

object ThreadSample1 {
  def main(args: Array[String]) {
    val names = List("イチゴ", "ミカン", "メロン", "リンゴ")
    for (i <- 0 to 3) {
      new Thread {
        val name = names(i)
        override def run () {
          for (i <- 0 to 3) {
            println(f"$name ($i)")
          }
        }
      }.start ()
    }
    println(f"main: ${names.length}個のスレッドを走らせています")
  }
}
