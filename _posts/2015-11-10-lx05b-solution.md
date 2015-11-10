---
title: 第5回解説　インタフェイスとしてのTrait (solution.scala)
layout: post
permalink: lx05/b
---

# インターフェイスとしてのTrait

ScalaのtraitはScalaのオブジェクト指向機能で重要な役割を果たしています．このため，その機能をひとことで説明することは難しいのですが，ここではその部分的な機能としてオブジェクトの仕様を表現したインタフェイスと見做します．

インタフェイスについて学ぶ前に，インタフェイスを与えられる立場にあるオブジェクトについて観察してみましょう．たとえば，solution1.scalaの定義を眺めると以下のようにさまざまな定義があることがわかります．

{% highlight scala %}
  object Solution1 extends Solution { // solution1.scala内の記述
    val name = "Solution 1"
    def c(n: Int)(nums: List[Int]): Int = ...
    def counts(...) ...
    val countsOnPaper = ...
    def satisfy(...) ...
    val N = ...
    def genCheck(...) ...
    def solve() ...
  }
{% endhighlight %}

このうち，このオブジェクトの利用者にとって興味があるのはどれでしょう．

このオブジェクトのそもそもの目的は，パズルの解を与えることがあります．このオブジェクトの利用者の立場からは，パズルの解を与えてくれる`solve`メソッドがもっとも重要といえるでしょう．

一方，リスト中に出現する数を勘定する`c`メソッドのように細かい機能は，`solve`が期待される機能を果たしている限り，あまり興味はないことになります．多くのドライバーにとって，重要なものがハンドル，アクセル，ブレーキのような直接，ドライバーの操作の対象となる部位であることにも似ています．一方，重要性は明らかでも，操作の直接的な対象というわけではないエンジンルームの部品群への意識はなかなか向かないものです．

このような利用者の目線から眺めたSolution1オブジェクトの機能を抽出したものをオブジェクトの外部仕様といい，**trait**と呼ばれる形式で表現されます．

{% gist wakita/e34f0b517a19cc23eec7 %}

ここで，Solution1オブジェクトから取り出したtraitは，`name`と`solve`で，それぞれ解法名を表す文字列と解法にあたるメソッドです．解法を与える`solve`メソッドは引数はなしで，見つかった解の集合をリストとして与えることとなっています．

今度はsolution2.scalaで定義されるSolution2オブジェクトの内容を見てみましょう．

{% gist wakita/20f076af83286a752154 %}

Solution2オブジェクトの要素としては，文字列`name`，`genCheck`メソッド，そして`solve`メソッドがあります．これらは前述の`Solution` traitを包含していることがわかりますね．逆に言えば，Solution2オブジェクトは`Solution` traitが要求する機能を提供しています．このため，Solution2オブジェクトが`Solution` traitを満足すると見做せます．このことを型として表すと，以下のように表現することができます．

~~~
Solution1: Solution

Solution2: Solution
~~~

Solution1オブジェクトもSolution2オブジェクトも異なる内容を持っていますので，厳密には型が一致するはずはありません．しかし，その部分要素に限れば，同じ型と見做しても構わないだろうというのがtraitを用いて表現されるインタフェイスの考え方です．

これらのオブジェクトをtraitを用いたインタフェイスとして抽象化することによって，これらの同質のものとして扱う技法はMain.scalaのなかで活用されていました．

{% highlight scala linenos %}
    List(Solution1, Solution2).foreach((solution: Solution) => {
      println(solution.name)
      solution.solve().foreach(println)
    })
{% endhighlight %}

上のコードの1行目の`List(Solution1, Solution2)`において，Solution1とSolution2はともにSolution型と見做されて，`List[Solution]`型のリストの要素となります．つぎに`List.foreach`によってこのリストは走査されるため，このコード中のsolutionは，Solution1オブジェクト，あるいはSolution2オブジェクトを指すこととなります．

このような技法を用いない場合，Mainオブジェクトのコードには，以下のようにSolution1を処理する部分に続いてSolution2を処理する部分を別途記述せざるを得ません．人によっては，こちらの方が見易いと思うかもしれませんが，今後，解法が増える可能性を考えると冗長性の問題を残しているといえます．

{% highlight scala linenos %}
      println(Solution1.name)
      Solution1.solve().foreach(println)

      println(Solution2.name)
      Solution2.solve().foreach(println)
{% endhighlight %}

ソフトウェアのなかに類似する機能が含まれる場合に，その類似性をtraitで表現したインタフェイスとして抽象化することによって，プログラム内の冗長性を削減する技法を覚えておきましょう．
