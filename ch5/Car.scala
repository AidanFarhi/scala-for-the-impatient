
// this defines a class with read-only fields and a primary constructor
class Car(val make: String, val model: String, val year: Int):
    // the primary constructor runs all statments in the class definition
    println("creating a car")
    def description = s"make: $make | model: $model | year: $year"

@main def car_exe = 
    
    val c1 = Car("KIA", "Sorento", 2015)
    val c2 = Car("Ford", "F-150", 2023)

    println(c1.description)
    println(c2.description)