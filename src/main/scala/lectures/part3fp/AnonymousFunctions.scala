package lectures.part3fp

object AnonymousFunctions extends App {

    // val doubler = new Function1[Int, Int] {
    //     override def apply(x: Int) = x * 2
    // }
    // equivalent to

    // val doubler: Int => Int = (x: Int) => x * 2 // anonymous function (LAMBDA)
    val doubler: Int => Int = x => x * 2 // anonymous function (LAMBDA)

    // multiple parameters in a lambda
    val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

    // no parameters
    val justDoSomething: () => Int = () => 3
    println(justDoSomething) // function
    println(justDoSomething()) // calls

    // curly braces with lambdas
    val stringToInt = { (str: String) =>
        str.toInt
    }

    // MORE syntactic sugar
    val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
    val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

    /*
        1. MyList: repalce all function calls with lambda
        2. rewrite the special adder as an anonymous function
     */
    // 2.
    val superAdd = (x: Int) => (y: Int) => x + y
    println(superAdd(3)(4))
}
