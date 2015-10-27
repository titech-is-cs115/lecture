package cs1

// run-main cs1.LX03E: 浮動小数点数演算におけるアンダーフローの観察

object LX03E {
  def fpUnderflow(n: Int, f: Double) {
    def aux(i: Int, x: Double) {
      if (i != n) {
        println(f"$f * 2^-$i = $x%g")
        aux(i+1, x/2)
      }
    }
    aux(0, f)
  }

  def main(arguments: Array[String]) {
    fpUnderflow((2<<9) + 52, 1.0)
  }
  // さて，fpUnderflowの第一引数の式はあまりに恣意的だ．
  // どうやってこのコードの著者は実行の最初に 0.00000 が出現するところでプログラムを終了できたのだろう．IEEE 754標準との関連で考えるとこの謎が解ける．
}
