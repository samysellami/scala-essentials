package lectures.part1basics

object Expressions extends App {

    val aCondition = true
    val aConditionedValue = if (aCondition) 5 else 3

    println(aConditionedValue)

    var i = 1
    while (i < 10) {
        println(i)
        i += 1
    }
    var aValue = 4
    val aWeirdValue = (aValue = 3)

    println(aWeirdValue)
}
