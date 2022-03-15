package lectures.part3fp

import java.util.Random

object Sequences extends App {

    // sequences
    val aSequence = Seq(1, 2, 3, 4)
    println(aSequence)
    println(aSequence.reverse)
    println(aSequence(2))
    println(aSequence ++ Seq(5, 6, 7))
    println(aSequence.sorted)

    val aRange: Seq[Int] = 1 to 10
    aRange.foreach(println)
    (1 to 10).foreach(x => println("Hello"))

    // lists
    val aList = List(1, 2, 3)
    val prepended = 42 +: aList :+ 89
    println(prepended)

    val apples5 = List.fill(5)("apple")
    println(apples5)
    println(aList.mkString("-|-"))

    // arrays
    val numbers = Array(1, 2, 3, 4)
    val threeElements = Array.ofDim[String](3)
    println(threeElements.foreach(println))

    // mutations
    numbers(2) = 0 // syntax sugar for numbers.update(2, 0)
    println(numbers.mkString(" "))

    // arrays and sequences
    val numbersSeq: Seq[Int] = numbers // implicite conversion
    println(numbersSeq)

    // vectors
    val vector: Vector[Int] = Vector(1, 2, 3)
    println(vector)

    // vectors vs lists
    val maxRuns = 1000
    val maxCapacity = 100000
    def getWriteTime(collection: Seq[Int]): Double = {
        val r = new Random
        val times = for {
            it <- 1 to maxRuns
        } yield {
            val currentTime = System.nanoTime()
            collection.updated(r.nextInt(maxCapacity), 0)
            System.nanoTime() - currentTime
        }
        times.sum * 1.0 / maxRuns
    }

    val numbersList = (1 to maxCapacity).toList
    val numbersVector = (1 to maxCapacity).toVector

    // keeps reference to tails
    // updating an element in the middle is long
    println(getWriteTime(numbersList))
    // depth of the tree is small
    // needs to replace an entire 32-element chunk
    println(getWriteTime(numbersVector))

}
