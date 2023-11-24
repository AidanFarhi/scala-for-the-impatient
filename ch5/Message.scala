
class Message:
    // scala provides getters and setters for every public var
    var content = ""
    // Scala provides only a getter for every public val
    val timeStamp = java.time.Instant.now

@main def message_exe =
    val m1 = Message()
    m1.content = "hello"
    println(s"content: ${m1.content} | timestamp: ${m1.timeStamp}")