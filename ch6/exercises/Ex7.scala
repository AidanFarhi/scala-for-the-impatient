
/*
    7. Implement a function that checks whether a card 
    suit value from the preceding exercise is red.
*/

def isRed(suit: Suits): Boolean = 
    if suit == Suits.Heart || suit == Suits.Diamond then 
        true 
    else 
        false


@main def ex7 =

    assert(!isRed(Suits.Club))
    assert(!isRed(Suits.Spade))
    assert(isRed(Suits.Heart))
    assert(isRed(Suits.Diamond))
