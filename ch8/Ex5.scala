package ex5

/*
5. Design a class Point whose x and y coordinate values can 
be provided in a constructor. Provide a subclass LabeledPoint 
whose constructor takes a label value and x and y coordinates, such as

LabeledPoint("Black Thursday", 1929, 230.07)
*/

class Point(val x: Double, val y: Double)


class LabeledPoint(val label: String, x: Double, y: Double) extends Point(x, y)


@main def ex5 =
    
    val point = LabeledPoint("Black Thursday", 1929, 230.07)
    assert(point.label == "Black Thursday")
