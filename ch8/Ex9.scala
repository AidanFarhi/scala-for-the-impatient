/*
9. In the Creature class of Section 8.11, “Construction Order,” 
on page 105, 

- Replace val range with a def. 

- What happens when you also use a def in the Ant subclass? 

- What happens when you use a val in the subclass? Why? 
*/

class Creature:
    def range: Int = 10
    val env: Array[Int] = Array.ofDim[Int](range)


class AntA extends Creature:
    override def range = 2

class AntB extends Creature:
    override val range = 2


class AntC extends Creature:
    override lazy val range = 2


@main def ex9 =

    val a1 = AntA()
    val a2 = AntB()
    val a3 = AntC()

    assert(a1.env.size == 2)
    assert(a2.env.size == 0)
    assert(a3.env.size == 2)