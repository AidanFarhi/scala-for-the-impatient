/*
    3. Write a package random with functions nextInt(): Int, nextDouble(): Double, 
    and setSeed(seed: Int): Unit. To generate random numbers, use the linear 
    congruential generator
    next = (previous × a + b) mod 2n,
    where a = 1664525, b = 1013904223, n = 32, and the initial value of previous is seed.
*/

package random:

    private var _seed = 1
    private var previous = _seed
    private val a = 1664525
    private val b = 1013904223
    private val n = 32

    def setSeed(seed: Int): Unit = _seed = seed

    def nextInt(): Int =
        val randomInt = (previous * a * b) % math.pow(2, n).toInt
        previous = randomInt
        randomInt

    def nextDouble(): Double =
        val randomDouble = (previous * a * b) % math.pow(2, n)
        previous = randomDouble.toInt
        randomDouble


@main def ex3 = 

    println(random.nextInt())
    println(random.nextInt())
    println(random.nextDouble())
    println(random.nextDouble())
    random.setSeed(100)
    println(random.nextInt())
    println(random.nextInt())
    println(random.nextDouble())
    println(random.nextDouble())
