package lectures.part2oop

object Inheritence extends App {

    // single class inheritence
    sealed class Animal {
        val creatureType = "wild"
        def eat = println("eating")
    }

    class Cat extends Animal {
        def crnuch = {
            eat
            println("crunching")
        }
    }
    val cat = new Cat
    cat.crnuch

    // constuctors
    class Person(name: String, age: Int) {
        def this(name: String) = this(name, 0)
    }
    class Adult(name: String, age: Int, idCard: String) extends Person(name)

    // overriding
    class Dog(override val creatureType: String) extends Animal {
        // override val creatureType = "domestic"
        override def eat = {
            super.eat
            println("crunch crunch")
        }
    }

    // class Dog(dogType: String) extends Animal {
    //     override val creatureType = dogType
    //     override def eat = println("crunch crunch")
    // }

    val dog = new Dog("K9")
    dog.eat
    // println(dog.creatureType)

    //type substitution (broad sense : polymorphism)
    val unkownAnimal: Animal = new Dog("K9")
    unkownAnimal.eat

    //overriding vs overloading
    // super

    // preventing overrides
    // 1. use final on member
    // 2. use final on the entire class
    // 3. seal the class = extends the class in this file, prevent extensions in other files

}
