package lectures.part2oop

import scala.compiletime.ops.string
import lectures.part2oop.AbstractDataTypes.Animal

object Generics extends App {

    class MyList[+A] {
        // use typ  e A
        def add[B >: A](element: B): MyList[B] = ???
        // A = Cat
        // B = Animal
    }

    class MyMap[key, value]

    val listOfIntegers = new MyList[Int]
    val listOfStrings = new MyList[String]

    // generic methods
    object MyList {
        def empty[A]: MyList[A] = ???
    }

    val enmptyListOfIntegers = MyList.empty[Int]

    // variance problem
    class Animal
    class Cat extends Animal
    class Dog extends Animal

    // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
    class CovariantList[+A]
    val animal: Animal = new Cat
    val animalList: CovariantList[Animal] = new CovariantList[Cat]
    // animalList.add(new Dog) ??? => we return a list of animals

    // 2. No, INVARIANCE
    class InvariantList[A]
    val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

    //3. No, CONTRAVARIANCE
    // class ContravariantList[-A]
    // val contravariantList: ContravariantList[Cat] =
    //     new ContravariantList[Animal]
    class Trainer[-A]
    val trainer: Trainer[Cat] = new Trainer[Animal]

    // bounded types
    class Cage[A <: Animal](animal: A) // subtype
    val cage = new Cage(new Dog)

    // exercise expand MyL  ist to be generics
}
