
class Person:
    private var privateAge = 0

    def age = privateAge
    def age_=(newValue: Int) =
        if newValue > privateAge then privateAge = newValue
@main def person_exe =
    val fred = Person()
    fred.age = 21
    println(s"Fred's age: ${fred.age}")