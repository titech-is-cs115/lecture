package lx14

import scala.util.Random.nextInt

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.{Group, Scene}
import scalafx.scene.canvas.{Canvas,GraphicsContext}
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color._
import scalafx.scene.shape.ArcType

object ThreadSample2 extends JFXApp {
  val W = 1200; val H = 600
  val canvas = new Canvas(W, H)
  val gc = canvas.graphicsContext2D

  var finish = false
  val lock = new AnyRef

  // 雨
  new Thread {
    override def run() {
      while (!finish) {
        lock.synchronized {
          for (i <- 0 to 3) {
            val x = nextInt(W)
            val y = nextInt(H)
            val r = nextInt(20)
            gc.fill = LightBlue
            gc.fillOval(x - r/2, y - r/2, r, r)
          }
        }
        Thread.sleep(30)
      }
    }
  }.start ()

  // ワイパー
  new Thread {
    var angle = 0
    var dir = 1
    val speed = 180 / 30
    override def run() {
      while (!finish) {
        val t1 = angle
        val t2 = angle + speed * dir
        lock.synchronized {
          gc.fill = White
          gc.fillArc(0, 0, W, H * 2, t1, speed * dir, ArcType.Round)
        }
        angle = angle + speed * dir
        if (angle < 0) { angle = 0; dir = 1 }
        if (angle > 180) { angle = 180; dir = -1 }
        Thread.sleep(50)
      }
    }
  }.start ()

  stage = new PrimaryStage {
    title = "Thread Sample 2"
    width = W
    height = H
    scene = new Scene { root = new Group(canvas) }
  }

  override def stopApp() { finish = true }
}
