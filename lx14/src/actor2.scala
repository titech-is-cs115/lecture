package lx14

import akka.actor.{Actor, Props, ActorSystem}

case class AnswerS(s: String)

class Master extends Actor {

  val doubler = context.actorOf(Props[Doubler])

  def receive = {
    case i: Int => doubler ! i
    case AnswerS(msg) => println(msg); ActorSample2.stop = true
  }
}

class Doubler extends Actor {
  def receive = {
    case i: Int => sender ! AnswerS(f"$i * 2 = ${i * 2}")
  }
}

object ActorSample2 extends App {
  val system = ActorSystem("sample2")
  val master = system.actorOf(Props[Master], "master")

  var stop = false
  master ! 100

  while (!stop) Thread.sleep(500)
  system.terminate()
}
