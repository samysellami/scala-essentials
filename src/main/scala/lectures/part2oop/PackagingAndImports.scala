package lectures.part2oop

import playground.Cinderella
import playground.PrinceCharming // import playground._

import java.util.Date
import java.sql.{Date => SqlDate}

object PackagingAndImports extends App {

    // package members are accessible by their symbol name
    val writer = new Writer("Daniel", "rock the jvm", 2018)

    // import the package
    val princess =
        new Cinderella // playground.Cinderella = fully qualified name

    // packages are in a hierarchy
    // match the folder structure

    // package objects
    sayHello
    println(SPEED_OF_LIGHT)

    // imports
    val prince = new PrinceCharming

    // aliasing
    val date = new Date
    val sqldate = new SqlDate(2018, 5, 4)

    // default import
    // java.lang - String, Object, Exceptions
    // Scala - Int, Nothing, Function
    // scala.predef - println, ???
}
