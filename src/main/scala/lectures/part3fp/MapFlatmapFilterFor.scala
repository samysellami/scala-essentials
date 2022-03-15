package lectures.part3fp

object MapFlatmapFilterFor extends App {

    val list = List(1, 2, 3)
    println(list.head)
    println(list.tail)

    //  map
    println(list.map((_ + 1)))
    println(list.map(_ + "is a number"))

    // filter
    println(list.filter((_ % 2 == 0)))

    // flatMap
    val toPair = (x: Int) => List(x, x + 1)
    println(list.flatMap(toPair))

    // print all combinations between three lists
    val numbers = List(1, 2, 3, 4)
    val chars = List('a', 'b', 'c', 'd')
    val colors = List("Black", "White")
    // List("a1", "a2", ... "d4")

    // iterating
    val combinations = numbers
        .filter(_ % 2 == 0)
        .flatMap(n =>
            chars.flatMap(c => colors.map(color => "" + c + n + "-" + color))
        )
    println(combinations)

    // foreach
    list.foreach(println)
    // equivalent to
    for {
        n <- numbers
    } println(n)

    // for comprehensions
    val forCombinations = for {
        n <- numbers if n % 2 == 0
        c <- chars
        color <- colors
    } yield "" + c + n + "-" + color
    println(forCombinations)

    // syntax overload
    list.map { x =>
        x * 2
    }

    /* exercises
        1. if MyList supports for comprehension?
            - map(f: A => B) => MyList[B]
            - filter(p: A => Boolean) => MyList[A]
            - flatMap(f: A => MyList[B]) => MyList[B]

        2. A small collection of at most ONE element - Maybe[+T]
            - map, flatMpa, filter
     */
}
