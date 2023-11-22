import scala.collection.mutable
import scala.jdk.CollectionConverters.*
import java.awt.font.TextAttribute.* 

@main def main = 

    // constructing an immutable map with initial values
    val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
    val scores2 = Map(("Alice", 10), ("Bob", 3), ("Cindy", 8))

    // constructing a blank mutable map
    val mutableScores = mutable.Map[String, Int]()

    // accessing Map values
    println(scores("Bob"))
    val donaldScore = if scores.contains("Donald") then scores("Donald") else 0
    val donaldScore2 = scores.getOrElse("Donald", 0)
    println(donaldScore)
    println(donaldScore2)

    // adding/updating mutable Map values
    mutableScores.addOne("Jim" -> 23)
    mutableScores("Joe") = 30
    mutableScores("Jim") = 55
    mutableScores ++= Map("Bob" -> 10, "Fred" -> 7)

    // removing values
    mutableScores -= "Joe"

    // updating an immutable Map (you can't really. each op creates a new map.)
    var immutableMap = Map("Jim" -> 88)
    immutableMap = immutableMap + ("Fred" -> 100)
    immutableMap += "Bob" -> 99

    // removing from an immutable Map (same idea)
    immutableMap -= "Jim"

    // iterating over Maps
    for (k, v) <- immutableMap do println(k + ": " + v)
    
    // iterate over just the keys or values
    for k <- immutableMap.keySet do println(k)
    for v <- immutableMap.values do println(v)

    // invert a map (switch keys and values)
    val invertedImmutableMap = for (k, v) <- immutableMap yield (v, k)
    for (k, v) <- invertedImmutableMap do println(s"$k: $v")

    // Linked and Sorted Maps
    val linkedHashMap = mutable.LinkedHashMap("Jim" -> 10, "Joe" -> 14, "Bob" -> 34)
    val sortedMap = mutable.SortedMap("Fred" -> 1, "Alice" -> 2, "Bob" -> 3)
    linkedHashMap.foreach((k, v) => println(s"$k: $v")) // this visits keys in insertion order
    sortedMap.foreach((k, v) => println(s"$k: $v"))     // this visits keys in sorted order

    // interoperating with Java
    val ids = java.time.ZoneId.SHORT_IDS.asScala
    ids.foreach((k, v) => println(s"$k: $v"))

    val attrs = Map(FAMILY -> "Serif", SIZE -> 12)
    val font = java.awt.Font(attrs.asJava)

    // the Option type
    var friend: Option[String] = Some("Fred")
    friend = None

    val ages = Map("Jim" -> 23, "Bob" -> 45, "Joe" -> 53)
    val bobAge = ages.get("Bob") // Some(45)
    val samAge = ages.get("Sam") // None

    if bobAge.isEmpty
        then println("Bob's age not found")
        else println(s"Bob's age: ${bobAge.get}")

    if samAge.isEmpty
        then println("Sam's age not found")
        else println(s"Sam's age: ${samAge.get}")

    for age <- bobAge do println(age)
    for age <- samAge do println(age)

    val olderAge = bobAge.map(_ + 20)
    val minAge = bobAge.filter(_ > 21)
    olderAge.foreach(println)
    minAge.foreach(println)

    // Tuples
    val t = (1, 3.14, "Bob")
    val second = t(1)
    var i = 0
    val first = t(i)
    println(first)
    println(second)
    val (fst, scd, thr) = t // destructuring
    println(s"$fst, $scd, $thr")
    val newTup = ("x", 3) ++ ("y", 4)
    println(newTup)
    val partitionedString = "New York".partition(_.isUpper)
    println(partitionedString)

    // Zipping
    val symbols = Array("<", "-", ">")
    val counts = Array(2, 10, 2)
    val pairs = symbols.zip(counts)
    for (s, n) <- pairs do print(s * n)
    println()
    