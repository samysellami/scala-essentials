package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App {

    class Person(val name: String, favoriteMovie: String, val age: Int = 0) {

        def likes(movie: String): Boolean = movie == favoriteMovie

        def +(person: Person): String =
            s"${this.name} is hanging out with ${person.name}"
        def +(nickname: String): Person =
            new Person(s"$name ($nickname)", favoriteMovie)

        def unary_! : String = s"what the heck!"
        def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

        def isAlive: Boolean = true

        def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
        def apply(n: Int): String = s"$name watched $favoriteMovie $n times"

        def learns(thing: String) = s"$name is learning $thing"
        def learnsScala = this learns "Scala"
    }

    val mary = new Person("Mary", "Inception")
    println(mary.likes("Inception"))
    println(
      mary likes "Inception"
    ) // infix notation = operator notation (syntactic sugar)

    // 'operators' in Scala
    val tom = new Person("Tom", "fight club")
    println(mary + tom)
    println(mary.+(tom))

    // ALL OPERATORS ARE METHODS

    // prefix notation
    val x = -1 // equivalent to
    val y = 1.unary_- // unary_ prefix only works for - + ~ !
    println(!mary)
    println(mary.unary_!)

    // postfix notation
    println(mary.isAlive)
    // println(mary isAlive)

    // apply
    println(mary.apply())
    println(mary())

    // exercices
    println((mary + "the rockstar")())
    println((+mary).age)

    println(mary learnsScala)
    println(mary(10))
}
