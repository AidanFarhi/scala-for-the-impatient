package ex7

import java.awt.Rectangle

/*
7. Provide a class Square that extends java.awt.Rectangle 
and has three constructors: 
one that constructs a square with a given corner point and width, 
one that constructs a square with corner (0, 0) and a given width, 
and one that constructs a square with corner (0, 0) and width 0.
*/

class Square(x: Int, y: Int, width: Int) extends Rectangle(x, y, width, width):
    def this(width: Int) = this(0, 0, width)
    def this() = this(0, 0, 0)


@main def ex7 =

    val s1 = Square(1, 2, 3)
    val s2 = Square(5)
    val s3 = Square()

    assert(s1.height == 3)
    assert(s2.height == 5)
    assert(s3.height == 0)
