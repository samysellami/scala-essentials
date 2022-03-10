package lectures.part2oop

import scala.quoted.ToExpr.ArrayOfDoubleToExpr

object Exceptions extends App {

    val x: String = null
    // println(x.length) // will crach with a null pointer exception

    // 1. throwing exceptions
    // val aWeirdValue = throw new NullPointerException

    // 1. throwable classes extend the Throwable class
    // Exception and Error are the major throwable subtypes

    // 2. catching exceptions
    def getInt(withExcepions: Boolean): Int =
        if (withExcepions) throw new RuntimeException("No int for you!")
        else 42

    val potentialFail =
        try {
            // code that might throw an exception
            getInt(true)
        } catch {
            case e: RuntimeException =>
                43 //println("caught a runtime exception")
        } finally {
            // code that will get executed no matter what
            // optional, does not influence the return type of this expression
            // use finally only for side effects
            println("finally")
        }

    println(potentialFail)

    // 3. how to define your own exceptions
    class MyException extends Exception
    val exception = new MyException

    // throw exception

    /*
        1. crach your program with an OutOfMemory error
        2. crach your program with an StackOverflow error
        3. PocketCalculator
            - add(x, y)
            - multiply(x, y)
            - divide(x, y)
            - substact(x, y)

            Throw
                - OverflowException if add(x, y) exceeds Int.MAX_VALUE
                - UnderflowException if substract(x, y) exceeds Int.MIN_VALUE
                - MathCalculationException for division by zero
     */

    // OOM
    // val array = Array.ofDim(Int.MaxValue)

    def infinite: Int = 1 + infinite
    // val nolimit = infinite

    class OverflowException extends RuntimeException
    class UnderflowException extends RuntimeException
    class MathCalculationException extends RuntimeException("division by zero")
    object PocketCalculator {
        def add(x: Int, y: Int): Int = {
            val result = x + y
            if (x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
            else result
        }

        def substact(x: Int, y: Int): Int = {
            val result = x - y
            if (x > 0 && y < 0 && result < 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else result
        }

        def multiply(x: Int, y: Int): Int = {
            val result = x * y
            if (x > 0 && y > 0 && result < 0) throw new OverflowException
            else if (x < 0 && y < 0 && result < 0) throw new OverflowException
            else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
            else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
            else result
        }

        def divide(x: Int, y: Int): Int = {
            if (y == 0) throw new MathCalculationException
            else x / y
        }
    }

    // println(PocketCalculator.add(Int.MaxValue, 10))
    println(PocketCalculator.divide(2, 0))
}
