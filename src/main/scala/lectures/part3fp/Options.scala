package lectures.part3fp

object Options extends App {

    val myFirstOption: Option[Int] = Some(4)
    val noOption: Option[Int] = None

    println(myFirstOption)
    println(noOption)

    // unsafe API
    def unsafeMethod(): String = null
    // val result = Some(unsafeMethod()) // WRONG
    val result = Option(unsafeMethod()) // returns Some or None // safe

    println(result)

    // chained methods
    def backupMethod(): String = "A valid result"
    val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

    // design unsafe APIs
    def betterUnsafeMethod(): Option[String] = None
    def betterBackupMethod(): Option[String] = Some("a valid result")

    val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

    // functions on Options
    println(myFirstOption.isEmpty)
    // println(myFirstOption.get()) // unsafe DO NOT USE THIS
}
