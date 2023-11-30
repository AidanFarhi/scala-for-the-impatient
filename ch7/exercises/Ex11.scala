import scala.collection.mutable.ArrayBuffer

/*
    11. One common example of improper inheritance is a stack class that 
    inherits from an ArrayBuffer. This is bad because the stack then inherits 
    many methods that are not permitted on stacks. Use composition and 
    export statements to define a Stack class that stores strings.
*/

class Stack:

    val stack = ArrayBuffer[String]()

    export stack.{append as push, last as peek}
    def pop() = if stack.isEmpty then "" else stack.remove(stack.length-1)


@main def ex11 = 

    val s = Stack()
    s.push("hello")
    s.push("world")
    println(s.peek)
    println(s.pop())
    println(s.pop())
    println(s.pop())
