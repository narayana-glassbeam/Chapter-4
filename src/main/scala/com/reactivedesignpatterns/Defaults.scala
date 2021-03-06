package com.reactivedesignpatterns

import scala.concurrent.duration._
import akka.actor.ActorRef
import scala.concurrent.Future
import akka.util.Timeout

object Defaults {
  
  val Timestamp = Deadline
  type Timestamp = Deadline
  
  val SynchronousEventLoop = scala.concurrent.rdpextras.SynchronousEventLoop

  implicit class AskableActorRef(val ref: ActorRef) extends AnyVal {
    def ?(f: ActorRef => Any)(implicit timeout: Timeout): Future[Any] = akka.rdpextras.AskPattern.ask(ref, timeout, f)
  }
  
}