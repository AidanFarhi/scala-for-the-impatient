
// 1. Improve the Counter class in Section 5.1, “Simple Classes and Parameterless 
// Methods,” on page 63 so that it doesn’t turn negative at Int.MaxValue.

class Ex1Counter:

    private var value = 0

    def increment() = if value != Int.MaxValue then value += 1 
    def current = value


@main def ex1 =

    val c = Ex1Counter()
    for _ <- 0 to Int.MaxValue do c.increment()
    assert(c.current == Int.MaxValue)