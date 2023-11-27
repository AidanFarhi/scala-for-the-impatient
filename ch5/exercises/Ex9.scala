
// 9. Consider the class
//
// class Employee(val name: String, var salary: Double) :
//   def this() = this("John Q. Public", 0.0)
//
// Rewrite it to use explicit fields and a default primary constructor. 
// Which form do you prefer? Why?

class Employee:

    private var _name = "John Q. Public"
    var salary = 0.0

    def this(name: String, salary: Double) =
        this()
        _name = name
        this.salary = salary

    def name = _name


@main def ex9 =

    val e1 = Employee()
    e1.salary += 10_000
    val e2 = Employee("John Wick", 200_000)
    e2.salary += 100_000

    assert(e1.name == "John Q. Public")
    assert(e1.salary == 10_000)
    assert(e2.name == "John Wick")
    assert(e2.salary == 300_000)
