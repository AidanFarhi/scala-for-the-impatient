
/*
    6. Write an enumeration describing the four playing card 
    suits so that the toString method returns: ♠ ♥ ♣ ♦.
*/

enum Suits(suit: String):
    override def toString: String = suit
    case Spade extends Suits("♠")
    case Club extends Suits("♠")
    case Heart extends Suits("♥")
    case Diamond extends Suits("♦")


@main def ex6 =

    println(Suits.Spade.toString)
    println(Suits.Club.toString)
    println(Suits.Heart.toString)
    println(Suits.Diamond.toString)
