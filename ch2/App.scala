import scala.io.*
import scala.util.*
import scala.io.Source.fromFile
import scala.math.sqrt

// functions can be declared without any parameters
def getNum = BigInt(123).toString

// lazy value's initializations are deffered until they are
// accessed for the first time
lazy val words = fromFile("words.txt").mkString

// when the source file is compiled, the name of
// the class file will be "main.class"
@main def main =

    // using functions without parantheses
    println(words)
    println(getNum)

    // throwing and catching exceptions
    try
        var x = -1
        if x >= 0 then sqrt(x)
        else throw IllegalArgumentException("x should not be negative")
    catch
        case ex: IllegalArgumentException => println(ex)

    // using the Try class
    val result = 
        for
            a <- Try { StdIn.readLine("a: ").toInt }
            b <- Try { StdIn.readLine("b: ").toInt }
        yield a / b
    println(result)

