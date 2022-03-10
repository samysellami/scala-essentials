package lectures.part2oop

import scala.compiletime.ops.string

object AbstractDataTypes extends App {

    // abstract classes
    abstract class Animal {
        val creatureType: String = "Canine"
        def eat: Unit
    }

    class Dog extends Animal {
        override val creatureType: String = "Canine"
        override def eat: Unit = println("crunch crunch")
    }

    // traits
    trait Carnivore {
        def eat(animal: Animal): Unit
        val preferedMeal: String = "fresh meat"
    }
    trait ColdBlooded

    class Crocodile extends Animal with Carnivore with ColdBlooded {
        override val creatureType: String = "croc"
        def eat: Unit = println("nomnom nom")
        def eat(animal: Animal): Unit =
            println(s"I'm a croc and I'm eating ${animal.creatureType}")
    }

    val dog = new Dog
    val croc = new Crocodile
    croc.eat(dog)

    // trait vs abstract classes
    // 1. traits do not have constructor parameters
    // 2. multiple traits can be inherited by the same class  but only one extended class
    // 3. traits = "behavior" , abstract class = "thing"
}
