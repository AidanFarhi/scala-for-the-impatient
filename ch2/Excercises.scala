import scala.math.pow
import java.time.LocalDate

@main def excercises = 

    // Q: What does println(println("Hello")) print, and why?
    println(println("Hello"))
    // A: This prints out:
    // Hello
    // ()
    // The first item printed is from the inner call to println.
    // The second item printed is the object returned from the first call.

    // Q: What is the value of an empty block expression {}? What is it's type?
    var x = {}
    println(x)
    // A: The value is (). The type is Unit.

    // Q: Come up with one situation where the assignment x = y = 1 is valid in Scala.
    //    (Hint: Pick a suitable type for x)
    var y = x = 1
    println(y)
    println(x)

    // Q: Write a Scala equivalent for this loop:
    //    for (int i = 10; i >= 0; i--) System.out.println(i);
    for i <- 10 to 0 by -1 do println(i)

    // Q: The signum of a number is 1 if the number is positive, -1 if it is negative,
    //    and 0 if it is zero. Write a function that computes this value.
    def signum(num: Int) : Int =
        if num > 0 then 1
        else if num < 0 then -1
        else 0

    println(signum(1))
    println(signum(-1))
    println(signum(0))

    // Q: Write a function countdown(n: Int) that prints the number from n to 0
    //    without returning a value
    def countdown(n: Int) = for i <- n to 0 by -1 do println(i)

    countdown(5)
    countdown(3)

    // Q: Write a for loop for computing product of the Unicode codes of all
    //    letters in a string. For example, the product of the characters
    //    in "Hello" is 9415087488L
    var product: Long = 1
    for code <- "Hello" do product *= code.toInt
    println(product)

    // Q: Solve the preceding excercise without writing a loop.
    //    (Hint: Look at the StringOps Scaladoc)
    product = 1
    "Hello".foreach(ch => product *= ch.toInt)
    println(product)

    // Q: Write a function productOfString(s: String) that computes the product, 
    //    as described in the preciding exercises.
    def productOfString(s: String) : Long =
        var result: Long = 1
        s.foreach(ch => result *= ch.toInt)
        result

    println(productOfString("Hello"))

    // Q: Make the function of the previous exercise recursive
    def productOfStringRecursive(s: String, res: Long = 1) : Long =
        if s.length == 0 then
            res
        else
            val updatedRes = res * s(0).toInt
            productOfStringRecursive(s.tail.toString, updatedRes)

    println(productOfStringRecursive("Hello"))

    // Q: Write a function that computes x^n, where n is an integer.
    //    Use the following recursive definition:
    //    x^n = y ‧ y if n is even and positive, where y = x^n/2.
    //    x^n = x ‧ x^n−1 if n is odd and positive.
    //    x^0 = 1.
    //    x^n = 1/x^−n if n is negative.
    def computeXOfN(x: Int, n: Int) : Int =
        if n < 0 then
            1 / computeXOfN(x, -n)
        else if n > 0 && n % 2 == 0 then // even and positive
            computeXOfN(x, n/2) * computeXOfN(x, n/2)
        else if n > 0 && n % 2 != 0 then // odd and positive
            x * (computeXOfN(x, n-1))
        else // n == 0
            1

    println(computeXOfN(3, 2))
    println(computeXOfN(10, 2))

    // Q: Define a string interpolator date that produces a java.time.LocalDate 
    // instance from year, month, and day values given as integer expressions 
    // (such as date"$year-$month-$day"), strings (such as date"2099-12-31"), 
    // or a mixture (such as date"$year-12-31"). You need to define an “extension method,” 
    // like this:

    // extension (sc: StringContext)
    //     def date(args: Any*): LocalDate = ...

    // args(i).asInstanceOf[Int] is the value of the ith interpolated expression as an integer. 
    // You get the strings in between the expressions as sc.parts. Split along dashes and 
    // convert the strings to integers by calling toInt. Then call the LocalDate.of method.
    extension (sc: StringContext)
        def date(args: Any*): LocalDate =
            val parts = sc.parts.toString.split("-")
            val year = parts(0).toInt
            val month = parts(1).toInt
            val day = parts(2).toInt
            LocalDate.of(year, month, day)

    var year = 2020
    var month = 10
    var day = 2
    println(date"2020-$month-$day")