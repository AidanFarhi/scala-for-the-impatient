
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
