package lectures.part4pm

import java.util.Random
import javax.net.ssl.TrustManager
import scala.quoted.Expr

object PatternMatching extends App {

    // switch on steroids
    val random = new Random
    val x = random.nextInt(10)

    val description = x match {
        case 1 => "the one"
        case 2 => "double or nothing"
        case 3 => "third time is the charm"
        case _ => "something else" // _ = WILDCARD
    }

    println(x)
    println(description)

    // 1. decompose values
    case class Person(name: String, age: Int)
    val bob = Person("Bob", 20)

    val greeting = bob match {
        case Person(n, a) if a < 21 => s"Hi, my name is $n and I'm $a years old and I can't drink in the US"
        case Person(n, a)           => s"Hi, my name is $n and I'm $a years old"
        case _                      => "I don't know who I am"
    }
    println(greeting)

    /*
        1. cases are matched in order
        2. what if no cases matches? MatchError
        3. type of the pattern match expression? unified type of all the types in all the cases
        4. PM works really well with case classes
     */

    // PM on sealed hiearachies
    sealed class Animal
    case class Dog(breed: String) extends Animal
    case class Parrot(greeting: String) extends Animal

    val animal: Animal = new Dog("Terra Nova")
    animal match {
        case Dog(someBreed) => println(s"Matched a dog of the $someBreed breed")
    }

    //  match everything
    val isEven = x match {
        case n if n % 2 == 0 => true
        case _               => false
    } // WHY, THIS IS NOT OK
    val isEvenCond = x % 2 == 0 // this is better

    /* Exercices
        simple function uses Pattern matching
        takes an Expr => human readable from

        Sum(Number(2), Number(3)) => 2 + 3
        Sum(Number(2), Number(3), Number(4)) => 2 + 3 +4
        Prod(Sum(Number(1), Number(2)), Number(3)) => (2 + 1) * 3
        Sum(Prod(Number(1), Number(2)), Number(3)) =>   2 * 1 * 3
     */

    trait Expr
    case class Number(n: Int) extends Expr
    case class Sum(e1: Expr, e2: Expr) extends Expr
    case class Prod(e1: Expr, e2: Expr) extends Expr

    def show(e: Expr): String = e match {
        case Number(n)   => s"$n"
        case Sum(e1, e2) => show(e1) + " + " + show(e2)
        case Prod(e1, e2) => {
            def maybeShowParenthesis(exp: Expr) = exp match {
                case Prod(_, _) => show(exp)
                case Number(_)  => show(exp)
                case _          => "(" + show(exp) + ")"
            }

            maybeShowParenthesis(e1) + " * " + maybeShowParenthesis(e2)
        }
    }
    println(show(Sum(Number(2), Number(3))))
    println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
    println(show(Prod(Sum(Number(1), Number(2)), Sum(Number(3), Number(3)))))
    println(show(Sum(Prod(Number(1), Number(2)), Number(3))))
}
