import scala.util.Random

@main def exercises =

    // 1. Write a code snippet that sets a to an array of n 
    // random integers between 0 (inclusive) and n (exclusive).

    val n = 10
    val a = Array.from(for i <- 0 to n yield Random.between(0, n))
    println(a.mkString("[", ",", "]"))

    // 2. Write a loop that swaps adjacent elements of an array of integers. 
    // For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).

    val a2 = Array(1, 2, 3, 4, 5)
    for i <- 1 to a2.length - 1 by 2 do
        val temp = a2(i)
        a2(i) = a2(i-1)
        a2(i-1) = temp
    println(a2.mkString("[", ",", "]"))

    // 3. Repeat the preceding assignment, but produce a new array with the 
    // swapped values. Use for/yield.
    
              