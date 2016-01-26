package lx14

import scala.compat.Platform

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.input.{MouseEvent}
import scalafx.scene.layout.{Pane}

object Clicks extends JFXApp {

  val canvas = new Pane { }

  // 連続クリックにおけるクリック間に許容する最大の時間（ミリ秒単位）
  val DOUBLE_CLICK_WAIT_MS = 300;

  var clickedAt = Long.MinValue
  canvas.onMousePressed = { (ev: MouseEvent) =>

    // すべてのスレッドから見えている変数にそのスレッドが担当するクリックの時刻を
    // 記録する．ここには最後のクリックに対応するクリック時刻が刻まれる．
    clickedAt = Platform.currentTime

    new Thread { // 新しいスレッド（並行実行単位）を生む

      override def run {

        // このスレッドが担当するクリックの時刻
        val clicked = clickedAt

        // 自分が担当するクリックが連続クリックの最後なのか判断するため，
        // 少し寝て後続のクリックの有無を確認する．
        Thread.sleep(DOUBLE_CLICK_WAIT_MS)

        // 起きたところで，後続のクリックの有無を確認する．
        // もしも後続のクリックがいたとしたら，最後に生まれたスレッドの誕生時刻
        // (clickedAt)に，自分の誕生時刻(clicked)よりも遅い時刻が記録されるはずである．
        if (clicked == clickedAt) {

          // 最後のクリック時刻(clickedAt)と自分のクリック時刻(clicked)が一致した．
          // ということは，自分が寝ているあいだに後続のクリックはなかったことになる．
          // したがって，このクリックが連続クリックの最後のクリックである．
          val clicks = ev.clickCount match {
            case 1 => "シングル" case 2 => "ダブル" case 3 => "トリプル"
            case n => ev.clickCount + "-"
          }
          println(f"${clicks}クリックを検知しました．")

        } else
          // クリックのあと寝ている間に後続のクリックがあった．連続クリックの処理は
          // 後続のクリックを処理するスレッドに任せる．
          println(f"        ${ev.clickCount}番目のクリックを無視しました．")
      }
    }.start
  }

  stage = new PrimaryStage {
    title = "連続クリックのテスト"
    scene = new Scene(600, 400) {
      root = canvas
    }
  }
}
