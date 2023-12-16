package ex6

/*
6. Define an abstract class Shape with an abstract 
method centerPoint and subclasses Rectangle and Circle. 
Provide appropriate constructors for the subclasses and 
override the centerPoint method in each subclass. 
*/

class Point(val x: Double, val y: Double)


abstract class Shape:
    def centerPoint: Point


class Rectangle(val centerPoint: Point) extends Shape


class Circle(val centerPoint: Point) extends Shape


@main def ex6 = 

    val rect = Rectangle(Point(1, 3))
    val circ = Circle(Point(2, 4))

    assert(rect.centerPoint.x == 1)
    assert(circ.centerPoint.y == 4)
