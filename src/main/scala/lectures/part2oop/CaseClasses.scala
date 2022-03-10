package lectures.part2oop

object CaseClasses extends App {

    /*
        equals, hashCode, toString
     */

    case class Person(name: String, age: Int)
    // 1. class parameters are fields
    val jim = new Person("Jim", 33)
    println(jim.age)

    // 2. sensible to string
    // println(instance) = println(instance.toString) // syntactic sugar
    println(jim)

    // 3. equals and hashCode implemented out of the box
    val jim2 = new Person("Jim", 33)
    println(jim == jim2)

    // 4. case classes have handy copy method
    val jim3 = jim.copy(age = 45)
    println(jim3)

    // 5. case classes have companions objects
    val thePerson = Person
    val mary = Person("mary", 23)

    // 6. case classes are serializables
    // akka

    // 7. case classes have extractors patterns == CCs can be used in pattern matching

    // 8. case objects
    case object Algeria {
        def name: String = "Algeria of Africa"
    }

    /* exercise
        expand MyList to use case classes and case objects
     */
}
