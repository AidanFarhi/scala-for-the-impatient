
// 4. Reimplement the Time class from the preceding exercise so that 
// the internal representation is the number of minutes since midnight 
// (between 0 and 24 × 60 − 1). Do not change the public interface. 
// That is, client code should be unaffected by your change.

class Time(val hours: Int = 0, val minutes: Int = 0):

    private val _minutesSinceMidnight = hours * 60 + minutes

    def before(other: Time) = _minutesSinceMidnight < other._minutesSinceMidnight


@main def ex4 =
    
    val t1 = Time(12, 55)
    val t2 = Time(12, 54)
    
    assert(t2.before(t1))
    assert(!t1.before(t2))