
// 5. In the Person class of Section 5.2, “Properties with Getters 
// and Setters,” on page 65, provide a primary constructor that turns 
// negative ages to 0.
//
// class Person :
//   private var privateAge = 0 // Make private and rename
//
//   def age = privateAge
//   def age_=(newValue: Int) =
//     if newValue > privateAge then privateAge = newValue // Can't get younger

class Person(private var initialAge: Int):
    
    private var privateAge = if initialAge < 0 then 0 else initialAge

    def age = privateAge
    def age_=(newValue: Int) = if newValue > privateAge then privateAge = newValue


@main def ex5 =

    val p1 = Person(10)
    p1.age += 1
    val p2 = Person(-12)

    assert(p1.age == 11)
    assert(p2.age == 0)