import scala.collection.mutable.ArrayBuffer

class Network(val name: String):

    private val members = ArrayBuffer[Member]()

    // each instance of Network will have it's own Member class
    class Member(val name: String):
        val contacts = ArrayBuffer[Member]()
        // you can access the 'this' reference of the enclosing class
        def description = s"$name inside ${Network.this.name}"

    def join(name: String) = 
        val m = Member(name)
        members += m
        m

@main def network_exe = 

    val twitterNetwork = Network("Twitter Network")
    val facebookNetwork = Network("Facebook Network")

    val fred = twitterNetwork.join("Fred")
    val jim = twitterNetwork.join("Jim")
    fred.contacts += jim

    val joe = facebookNetwork.join("Joe")
    // this would not work because each Member class is attached to
    // it's own instance:
    // fred.contacts += joe

    println(fred.description)
    println(jim.description)
    println(joe.description)
