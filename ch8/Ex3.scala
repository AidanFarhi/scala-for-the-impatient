/*
3. Consult your favorite Java, Python, or C++ textbook which is sure 
to have an example of a toy inheritance hierarchy, perhaps involving 
employees, pets, graphical shapes, or the like. Implement the example in Scala.
*/

class Animal(val name: String, val species: String):
    def makeNoise = println("Odd animal grunt")


class Pet(name: String, species: String, val breed: String, val owner: String) extends 
    Animal(name, species):
    override def makeNoise = println("Odd pet noise")


class Dog(name: String, breed: String, owner: String) extends
    Pet(name, "dog", breed, owner):
    override def makeNoise = println("Bork!")


@main def main =
    val animal = Animal("Bingo", "dog")
    val pet = Pet("Jimbo", "lizard", "gecko", "Joe")
    val dog = Dog("Spot", "german shepard", "Bob")
    animal.makeNoise
    pet.makeNoise
    dog.makeNoise