package lectures.part3fp

import scala.util.Success
import scala.util.Failure
import scala.util.Try
import java.util.Random

object HandlingFailure extends App {

    // create success and failure
    val aSuccess = Success(3)
    val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

    println(aSuccess)
    println(aFailure)

    def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU")

    // Try objects via the apply method
    val potentialFailure = Try(unsafeMethod())
    println(potentialFailure)

    // syntax sugar
    val anotherPotentialFailure = Try {
        // code that might throw
        // this will call the apply method of Try
    }

    // utilities
    println(potentialFailure.isSuccess)
    println(potentialFailure.isFailure)

    // orElse
    def backupMethod(): String = "a valid result"
    val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
    println(fallbackTry)

    // if you design the API wrap the computation in a Try
    def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
    def betterBackupMethod(): Try[String] = Success("a valid result")
    val betterFallbackTry = betterUnsafeMethod() orElse betterBackupMethod()
    println(betterFallbackTry)

    // map, flatMap, filter
    println(aSuccess.map(_ * 2))
    println(aSuccess.flatMap(x => Success(x * 10)))
    println(aSuccess.filter(_ > 10))

    // for comprehensions
    /* exercise
     */

    val host = "localhost"
    val port = "8080"
    def renderHTML(page: String) = println(page)

    class Connection {
        def get(url: String): String = {
            val random = new Random(System.nanoTime())
            if (random.nextBoolean()) "<html> ... </html>"
            else throw new RuntimeException("Connection interrupted")
        }

        def getSafe(url: String): Try[String] = Try(get(url))
    }

    object HttpService {
        val random = new Random(System.nanoTime())
        def getConnection(host: String, port: String): Connection = {
            if (random.nextBoolean()) new Connection
            else throw new RuntimeException("Someone else took the port")
        }

        def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
    }

    // if you get the html page from the connection print it to the consol i.e call renderHTML
    val posssibleConnection = HttpService.getSafeConnection(host, port)
    val possibleHTML = posssibleConnection.flatMap(connection => connection.getSafe("/home"))
    possibleHTML.foreach(renderHTML)

    // shorthand version
    HttpService
        .getSafeConnection(host, port)
        .flatMap(connecion => connecion.getSafe("/home"))
        .foreach(renderHTML)

    // for comprehension version
    for {
        connection <- HttpService.getSafeConnection(host, port)
        html <- connection.getSafe("/home")
    } renderHTML(html)

    /*
    try {
        connection = HttpService.get(host, port)
        try {
            connection.get("/home")
            renderHTML(page)
        } catch (some other exception) {}
    } catch (exception) {}
     */

}
