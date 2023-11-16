import scala.io.Source.fromFile

// functions can be declared without any parameters
def getNum = BigInt(123).toString

// lazy value's initializations are deffered until they are
// accessed for the first time
lazy val words = fromFile("words.txt").mkString

@main def main =

    println(words)
    println(getNum)
