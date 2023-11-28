
/*
    4. Define a Point class with a companion object so that you can 
    construct Point instances as Point(3, 4), without using new.
*/

class Point(var x: Int, var y: Int)


@main def ex4 =
    
    val p1 = Point(3, 4)
    println(p1.x + "," + p1.y)