package lectures.part1basics

object StringOps extends App {

    val str: String = "Hello, I am learning Scala"

    println(str.charAt(3))
    println(str.substring(7, 11))
    println(str.substring(7, 11))
    println(str.startsWith("Hello"))
    println(str.replace(" ", "-"))
    println(str.toLowerCase())
    println(str.length)

    val aNumbreString = "2"
    val aNumbre = aNumbreString.toInt

    println(aNumbre)
    println('a' +: aNumbreString :+ 'z')
    println(str.reverse)
    println(str.take(2))

    // Scala_specific: String interpolaters
    val name = "david"
    val age = 25
    val greeding = s"Hello, my name is $name and I'm $age"

    // s- interpolators
    val anotherGreeding =
        s"Hello, my name is $name and I will be turning ${age + 1} years old"
    println(anotherGreeding)

    // f- interpolators
    val speed = 1.2f
    val myth = f"$name%s  can eat $speed%2.2f burgeres per minute"
    println(myth)

    // raw- interpolators
    val escaped = "this is a \n new line "
    println(raw"this is a \n new line ")
    println(raw"$escaped")
}
