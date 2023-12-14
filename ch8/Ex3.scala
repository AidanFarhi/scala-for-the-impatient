package ex3

/*
3. Consult your favorite Java, Python, or C++ textbook which is sure 
to have an example of a toy inheritance hierarchy, perhaps involving 
employees, pets, graphical shapes, or the like. Implement the example 
in Scala.
*/

class Animal(val name: String, val age: Int, val species: String):
    def makeNoise = println("Animal noise")


class Dog(name: String, age: Int,  species: String, val breed: String) 
    extends Animal(name, age, species):
    override def makeNoise = println("Bork!")


class Cat(name: String, age: Int,  species: String, val breed: String) 
    extends Animal(name, age, species):
    override def makeNoise = println("Meow!")


@main def ex3 =

    val animal = Animal("anon", 1, "snake")
    val dog = Dog("spot", 12, "dog", "poodle")
    val cat = Cat("blue", 21, "cat", "tabby")

    animal.makeNoise
    dog.makeNoise
    cat.makeNoise
