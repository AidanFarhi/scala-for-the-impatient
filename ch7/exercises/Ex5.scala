/*
    5. What is the meaning of private[com] def giveRaise(rate: Double)? Is it useful?

    A: giveRaise is only available within the com package and it's sub-packages. 
       This can be usefull if you want to restrict a function to a package and it's sub-packages.
*/

package com:

    private[com] val baseRate = 1.05
    private[com] def giveRaise(salary: Double, rate: Double) = rate * salary

    package employees:

        class Empl(val name: String, var salary: Double):
            def giveRaise = 
                salary = com.giveRaise(salary, com.baseRate)

package othercom:
    // com.giveRaise is not accessable