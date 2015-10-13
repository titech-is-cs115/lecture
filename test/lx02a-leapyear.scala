package cs1.lx02a

import org.scalatest._
import LX02A._

class LX02ATest extends FlatSpec with Matchers {

  "leapyear" should "be true for 4で割り切れる年" in {
    leapyear(2004) should be (true)
    leapyear(2008) should be (true)
  }
}
