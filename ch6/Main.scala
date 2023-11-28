
@main def main = 

    // Singletons
    //
    // Scala has no static methods or fields. Instead, you use the object construct.
    // The main difference between objects and classes is that objects cannot have
    // constructor parameters.
    //
    // objects are used in the following cases:
    //     - As a home for utility functions or constants
    //     - When a single immutable instance can be shared efficiently
    //     - When a single instance is required to coordinate some service (the 
    //       singleton design pattern).

    object Accounts:
        // this will be called when the object is first call to
        // newAccountNumber is invoked.
        println("Accounts constructor called")
        private var lastNumber = 0
        def newAccountNumber() =
            lastNumber += 1
            lastNumber

    println(Accounts.newAccountNumber())
    println(Accounts.newAccountNumber())

    // Companion Objects
    
    class Account:
        // the class and it's companion object can
        // access each other's private members
        val id = Account.newUniqueNumber()
        private var balance = 0.0
        def deposit(amount: Double) = balance += amount
        def withdraw(amount: Double) = balance -= amount

    object Account:
        private var lastNumber = 0
        private def newUniqueNumber() =
            lastNumber += 1
            lastNumber

    // Extending a Class or Trait

    abstract class UndoableAction(val description: String):
        def undo(): Unit
        def redo(): Unit
    
    object DoNothingAction extends UndoableAction("Do nothing"):
        override def undo(): Unit = ()
        override def redo(): Unit = ()
    
    val actions = Map("open" -> DoNothingAction, "save" -> DoNothingAction)

    // The apply method
    //
    // whenever you define a class, a companion object is automatically
    // provided with an apply method for every constructor.
    //
    // ex) Array(1, 2, 3) actually means Array.apply(1, 2, 3)
    //
    // .apply is called a constructor proxy method

    class Person(val name: String, val age: Int)

    val p1 = Person("Fred", 42)
    val p2 = Person.apply("Jim", 24)

    val seasons = Map(
        "Spring" -> 1,
        "Summer" -> 2,
        "Fall" -> 3,
        "Winter" -> 4
    )
    println(seasons.getClass)
    val directions = Map(
        "Center" -> 0,
        "North" -> 1,
        "East" -> 2,
        "South" -> 3,
        "West" -> 4
    )
    println(directions.getClass)

    // Enumerations

    enum TrafficLightColor:
        case Red, Yellow, Green

    println(TrafficLightColor.Green)
    println(TrafficLightColor.Red.ordinal)
    println(TrafficLightColor.fromOrdinal(2))
