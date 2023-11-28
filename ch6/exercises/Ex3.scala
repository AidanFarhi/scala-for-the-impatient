
/*
    3. Define an Origin object that extends java.awt.Point. Why is this not actually a 
    good idea? (Have a close look at the methods of the Point class.)
*/

object Origin extends java.awt.Point


@main def ex3 =
    
    // the origin should not be movable
    Origin.move(0, 1)
