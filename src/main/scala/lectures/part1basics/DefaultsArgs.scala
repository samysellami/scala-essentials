package lectures.part1basics

object DefaultsArgs extends App {

    def trFact(n: Int, acc: Int = 1): Int = {
        if (n <= 1) acc
        else trFact(n - 1, n * acc)
    }
    val fac10 = trFact(10)

    def savePicture(
        format: String = "jpeg",
        width: Int = 1920,
        height: Int = 1080
    ): Unit =
        println(
          "saving picture"
        )
    savePicture(width = 800)

}
