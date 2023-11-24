
class Counter:
    // you must initialize this field
    private var value = 0
    // methods are public by default
    def increment() = value += 1 
    def current = value
    // methods can access private fields of all objects of its class.
    def isLess(other: Counter) = value < other.value

@main def counter_exe = 
    val myCounter = Counter()
    for i <- 0 to 3 do myCounter.increment()
    println(s"Current value: ${myCounter.current}")
    val newCounter = Counter()
    println(s"Counter comparison: ${newCounter.isLess(myCounter)}")
