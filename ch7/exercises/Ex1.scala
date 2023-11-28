/*
    1. Write an example program to demonstrate that:

    package com.horstmann.impatient

    is not the same as:

    package com
    package horstmann
    package impatient
*/

package com:
    package horstmann:
        val defaultName = "Bob"
        package impatient:
            case class Employee(val name: String = horstmann.defaultName)

package com.horstmann.impatient:
    case class Employee(val name: String, val age: Int):
        println("hello")
        // println(horstmann.defaultName) <- this will not work
