
// 7. Make a class Car with read-only properties for manufacturer, 
// model name, and model year, and a read-write property for the 
// license plate. Supply four constructors. All require the manufacturer 
// and model name. Optionally, model year and license plate can also be 
// specified in the constructor. If not, the model year is set to -1 and 
// the license plate to the empty string. Which constructor are you 
// choosing as the primary constructor? Why?

class Car(val manufacturer: String, val modelName: String):

    private var _modelYear = -1
    var licensePlate = ""

    def this(manufacturer: String, modelName: String, modelYear: Int) =
        this(manufacturer, modelName)
        _modelYear = modelYear

    def this(manufacturer: String, modelName: String, licensePlate: String) =
        this(manufacturer, modelName)
        this.licensePlate = licensePlate

    def this(manufacturer: String, modelName: String, modelYear: Int, licensePlate: String) =
        this(manufacturer, modelName)
        _modelYear = modelYear
        this.licensePlate = licensePlate

    def modelYear = _modelYear


@main def ex7 =

    val c1 = Car("Ford", "F-150")
    val c2 = Car("KIA", "Sorento", 2015)
    val c3 = Car("Honda", "Civic", "HSL2323")
    val c4 = Car("Tesla", "M3", 2023, "GB7SD8")

    assert(c1.modelYear == -1)
    assert(c2.licensePlate == "")
    assert(c3.modelYear == -1)
