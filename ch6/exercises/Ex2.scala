
/*
    2. The preceding problem wasn’t very object-oriented. Provide a general superclass 
    UnitConversion and define objects InchesToCentimeters, GallonsToLiters, and 
    MilesToKilometers that extend it.
*/

abstract class UnitConversion:
    def convert(arg: Double): Double

object InchesToCentimeters extends UnitConversion:
    override def convert(inches: Double): Double = inches * 2.75

object GallonsToLiters extends UnitConversion:
    override def convert(gallons: Double): Double = gallons * 3.785

object MilesToKilometers extends UnitConversion:
    override def convert(miles: Double): Double = miles * 1.609


@main def ex2 =

    assert(InchesToCentimeters.convert(1) == 2.75)
    assert(GallonsToLiters.convert(1) == 3.785)
    assert(MilesToKilometers.convert(1) == 1.609)
