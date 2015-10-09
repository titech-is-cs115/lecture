package cs1.lx02a

object LX02A {
  def leapyear(y: Int) = {
    !(y % 100 == 0) &&
    y % 4 == 0
  }
}
