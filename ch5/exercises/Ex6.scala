
// 6. Write a class Person with a primary constructor that accepts a 
// string containing a first name, a space, and a last name, such as 
// Person("Fred Smith"). Supply read-only properties firstName and 
// lastName. Should the primary constructor parameter be a var, a val, 
// or a plain parameter? Why?

class Person(fullName: String):
    
    val firstName = fullName.split(" ")(0)
    val lastName = fullName.split(" ")(1)


@main def ex6 =

    val p1 = Person("Fred Smith")
    
    assert(p1.firstName == "Fred")
    assert(p1.lastName == "Smith")
