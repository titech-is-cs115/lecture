package lx14

import akka.actor.{Actor, Props, ActorSystem}

/*
case class AnswerS(s: String)

class Fibonacci extends Actor {

  val doubler = context.actorOf(Props[Doubler])

  def receive = {
    case (i: Int, adder: Adder) => doubler ! i
  }
}

class Adder extends Actor {
  var nAnswers = 0

  def receive = {
    case i: Int => sender ! AnswerS(f"$i * 2 = ${i * 2}")
  }
}

object ActorSampleF extends App {
  val system = ActorSystem("sample2")
  val master = system.actorOf(Props[Master], "master")

  var stop = false
  master ! 100

  while (!stop) Thread.sleep(500)
  system.terminate()
}
*/
