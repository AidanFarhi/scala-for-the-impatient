/*
    2. Write a puzzler that baffles your Scala friends, 
    using a package com that isn’t at the top level.
*/

package farhi:
    package com:

        import scala.io.StdIn
        import scala.util.Random
        import scala.sys.exit

        def guessingGame =
            val number = Random.between(1, 11)
            var userGuess = 0

            for i <- 0 to 2 do
                println("What is the number?: ")
                userGuess = StdIn.readInt()
                if userGuess == number then
                    println("you win!")
                    exit(0)

            println(s"The number was $number. You lose!")


@main def ex2 = farhi.com.guessingGame
