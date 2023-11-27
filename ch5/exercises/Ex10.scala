import scala.collection.mutable.ArrayBuffer

// 10. Implement the equals method for the Member class that is nested 
// inside the Network class in Section 5.7, “Nested Classes,” on page 73. 
//
// class Network :
//   class Member(val name: String) :
//     val contacts = ArrayBuffer[Member]()
//
//   private val members = ArrayBuffer[Member]()
//
//   def join(name: String) =
//     val m = Member(name)
//     members += m
//     m
//
// For two members to be equal, they need to be in the same network.


class Network(val name: String):

    private val members = ArrayBuffer[Member]()

    def join(name: String) =
        val m = Member(name)
        members += m
        m
        
    class Member(val name: String):

        val contacts = ArrayBuffer[Member]()
        val network = Network.this.name

        def equals(other: Member) = network == other.network


@main def ex10 =
    
    val n1 = Network("social")
    val m1 = n1.join("Bob")
    val m2 = n1.join("Jim")

    assert(m1.equals(m2))
