package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

    def factorial(n: Int): Int = {
        if (n <= 1) 1
        else {
            println(
              "computing factorial of " + n + "I need factorial of " + (n - 1)
            )
            val result = n * factorial(n - 1)
            println("Computed factorial of " + n)
            result
        }
    }
    // println(factorial(5))

    def anotherFactorial(n: Int): BigInt = {
        @tailrec
        def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
            if (x <= 1) accumulator
            else
                factorialHelper(
                  x - 1,
                  x * accumulator
                ) // TAIL RECURSION = use recursive call as the last expression
        }
        factorialHelper(n, 1)
    }
    // when you need loops use tail recursion
    // println(anotherFactorial(5000))

    @tailrec
    def concatenateTailRec(
        aString: String,
        n: Int,
        accumulator: String
    ): String = {
        if (n < 1) accumulator
        else concatenateTailRec(aString, n - 1, accumulator + aString)
    }
    // println(concatenateTailRec("Hello ", 4, ""))

    def isPrimeTailRec(n: Int): Boolean = {
        @tailrec
        def isPrimeUntil(t: Int, accumulator: Boolean): Boolean = {
            if (t <= 1) accumulator
            else isPrimeUntil(t - 1, accumulator && n % t != 0)
        }
        isPrimeUntil(n / 2, true)
    }
    // println(isPrimeTailRec(2003))
    // println(isPrimeTailRec(629))

    def fibonacci(n: Int): Int = {
        @tailrec
        def fibTailRec(i: Int, last: Int, nextToLast: Int): Int = {
            if (i >= n) last
            else fibTailRec(i + 1, last + nextToLast, last)

        }
        if (n <= 2) 1
        else fibTailRec(2, 1, 1)
    }
    println(fibonacci(5))
}
