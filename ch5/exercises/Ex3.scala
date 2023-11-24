
// 3. Write a class Time with read-only properties hours and minutes and a method 
// before(other: Time): Boolean that checks whether this time comes before the other. 
// A Time object should be constructed as Time(hrs, min), where hrs is in military 
// time format (between 0 and 23).

class Time(val hours: Int = 0, val minutes: Int = 0):

    def before(other: Time) = 
        if hours > other.hours then false
        else if hours == other.hours then minutes < other.minutes
        else true


@main def ex3 =
    
    val t1 = Time(12, 55)
    val t2 = Time(12, 54)

    assert(t2.before(t1))
    assert(!t1.before(t2))