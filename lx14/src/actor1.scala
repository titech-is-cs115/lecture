package lx14

import akka.actor.{Actor, Props, ActorSystem}

class PrintActor extends Actor {
  def receive = {
    case x => println(x)
  }
}

object ActorSample1 extends App {
  val system = ActorSystem("sample1")
  val printer = system.actorOf(Props[PrintActor], "printer")

  printer ! "Hello world!"

  system.terminate()
}
