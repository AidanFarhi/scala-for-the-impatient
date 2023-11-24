
class Dog:

    var name = ""
    var age = 0

    // an auxiliary constructor
    def this(name: String) = 
        this() // calls primary constructor
        this.name = name

    // another auxiliary constructor
    def this(name: String, age: Int) = 
        this(name) // calls the above auxiliary constructor
        this.age = age


@main def dog_exe =

    // primary constructor
    val d1 = Dog() 
    // first auxiliary constructor
    val d2 = Dog("Skippy")
    // second auxiliary constructor
    val d3 = Dog("Sparky", 1)

    println(s"name: ${d1.name} | age: ${d1.age}")
    println(s"name: ${d2.name} | age: ${d2.age}")
    println(s"name: ${d3.name} | age: ${d3.age}")