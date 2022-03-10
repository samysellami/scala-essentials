package lectures.part3fp

object WhatsAfunction extends App {

    // use functions as first class elements
    val doubler = new MyFunction[Int, Int] {
        override def apply(element: Int): Int = element * 2
    }

    println(doubler(2))

    // function types = Function1[A, B]
    val stringToIntConverter = new Function1[String, Int] {
        override def apply(string: String): Int = string.toInt
    }
    println(stringToIntConverter("3") + 4)

    val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
        override def apply(a: Int, b: Int): Int = a + b
    }

    // function types Funtion2[A, B, R] === (A, B) => R
    // ALL SCALA FUNCTIONS ARE OBJECTS = INSTANCES FROM CLASSES DERIVED FROM FUNCTION1,2, ...
}

trait MyFunction[A, B] {
    def apply(element: A): B = ???
}
