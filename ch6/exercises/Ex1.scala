
/*
    1. Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, 
    and milesToKilometers.
*/

object Conversions:
    def inchesToCentimeters(inches: Double) = inches * 2.54
    def gallonsToLiters(gallons: Double) = gallons * 3.785


@main def ex1 =

    assert(Conversions.gallonsToLiters(1) == 3.785)
    assert(Conversions.inchesToCentimeters(1) == 2.54)
