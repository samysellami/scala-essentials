package lectures.part4pm

import exercices.MyList
import exercices.Cons
import exercices.Empty

object AllThePatterns extends App {

    // 1. constants
    val x: Any = "Scala"
    val constants = x match {
        case 1              => "a number"
        case "Scala"        => "The Scala"
        case true           => "The Truth"
        case AllThePatterns => "A singleton object"
    }

    // 2. match anything
    // 2.1 wildcard
    val matchAnything = x match {
        case _ =>
    }

    // 2.2 variable
    val matchAVariable = x match {
        case something => s"I've found $something"
    }

    //  3. tuples
    val aTuple = (1, 2)
    val matchATuple = aTuple match {
        case (1, 1)         =>
        case (something, 2) =>
    }

    val nestedTuple = (1, (2, 3))
    val matchNestedTuple = nestedTuple match {
        case (_, (2, v)) =>
    }
    // pattern matching can be nested

    // 4. case classes - constructor pattern
    // pattern matching can be nested with case classes as well
    val aList: MyList[Int] = Cons(1, Cons(2, Empty))
    val matchAList = aList match {
        case Empty                              =>
        case Cons(head, tail)                   =>
        case Cons(head, Cons(subhead, subtail)) =>
    }

    // 5. List patterns
    val aStandardList = List(1, 2, 3, 42)
    val standardListMatching = aStandardList match {
        case List(1, _, _, _)    => // extractor -advanced
        case List(1, _*)         => // list of arbitrary length
        case 1 :: List(_)        => // infix pattern
        case List(1, 2, 3) :+ 42 => // infix pattern
    }

    // 6. type specifiers
    val unknown: Any = 2
    val unknownMatch = unknown match {
        case list: List[Int] => // explicit type specifier
        case _               =>
    }

    // 7. name biding
    val nameBidingMatch = aList match {
        case nonEmptyList @ Cons(_, _)  => // name biding => use the name here
        case Cons(1, rest @ Cons(2, _)) => // name biding inside nested patterns
    }

    // 8. multi patterns
    val multipattern = aList match {
        case Empty | Cons(0, _) => // compound pattern (multi-pattern)
    }

    // 9. if guard
    val secondElementSpecial = aList match {
        case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
    }

    // ALL thats it
    /*
    Question
     */

    val numbers = List(1, 2, 3, 4)
    val numbersMatch = numbers match {
        case listOfStrings: List[String] => "a list of strings"
        case listOfNumbers: List[Int]    => "a list of numbers"
        case _                           => ""
    }
    println(numbersMatch)
    // JVM trick questions- erasure problem
}
