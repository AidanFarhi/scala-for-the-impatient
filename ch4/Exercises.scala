import java.util.Scanner
import java.io.File
import java.util.TreeMap
import scala.collection.mutable
import scala.collection.immutable.SortedMap
import scala.jdk.CollectionConverters.*
import scala.collection.mutable.LinkedHashMap

@main def exercises =
    
    // 1. Set up a map of prices for a number of gizmos that you covet. 
    // Then produce a second map with the same keys and the prices at a 10 
    // percent discount.
    println("<<----1---->>")
    val myGizmos = Map("Phone" -> 500.0, "Car" -> 10000.0, "Computer" -> 5000.0)
    val reducedPriceGizmos = for (k, v) <- myGizmos yield (k, v * 0.9)
    println(reducedPriceGizmos)

    // 2. Write a program that reads words from a file. Use a mutable map to count 
    // how often each word appears. To read the words, simply use a java.util.Scanner:
    //
    // val in = java.util.Scanner(new java.io.File("myfile.txt"))
    // while in.hasNext() do process in.next()
    //
    // Or look at Chapter 9 for a Scalaesque way.
    // At the end, print out all words and their counts.
    println("<<----2---->>")
    val wordCounts = mutable.Map[String, Int]()
    var in = Scanner(new File("words.txt"))
    while in.hasNext() do
        val word = in.next()
        if wordCounts.get(word).nonEmpty then wordCounts(word) += 1 else wordCounts(word) = 1
    wordCounts.foreach(println)

    // 3. Repeat the preceding exercise with an immutable map.
    println("<<----3---->>")
    var immutableWordCounts = Map[String, Int]()
    in = Scanner(new File("words.txt"))
    while in.hasNext() do
        val word = in.next()
        if (immutableWordCounts.get(word).nonEmpty) {
            val newCount = immutableWordCounts(word) + 1
            immutableWordCounts -= word
            immutableWordCounts += (word -> newCount)
        } else {
            immutableWordCounts += (word -> 1)
        }
    immutableWordCounts.foreach(println)

    // 4. Repeat the preceding exercise with a sorted map, so that the words are printed in 
    // sorted order.
    println("<<----4---->>")
    var sortedMap = SortedMap[String, Int]()
    in = Scanner(new File("words.txt"))
    while in.hasNext() do
        val word = in.next()
        if (sortedMap.get(word).nonEmpty) {
            val newCount = sortedMap(word) + 1
            sortedMap -= word
            sortedMap += (word -> newCount)
        } else {
            sortedMap += (word -> 1)
        }
    sortedMap.foreach(println)

    // 5. Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
    println("<<----5---->>")
    val treeMap = new TreeMap[String, Int]()
    in = Scanner(new File("words.txt"))
    while in.hasNext() do
        val word = in.next()
        treeMap.put(word, treeMap.getOrDefault(word, 0) + 1)
    for entrySet <- treeMap.entrySet().asScala do println(entrySet)
    
    // 6. Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and similarly for 
    // the other weekdays. Demonstrate that the elements are visited in insertion order.
    println("<<----6---->>")
    val linkedHashMap = LinkedHashMap[String, Int](
        "Monday" -> java.util.Calendar.MONDAY,
        "Tuesday" -> java.util.Calendar.TUESDAY,
        "Wednesday" -> java.util.Calendar.WEDNESDAY,
        "Thursday" -> java.util.Calendar.THURSDAY,
        "Friday" -> java.util.Calendar.FRIDAY,
        "Saturday" -> java.util.Calendar.SATURDAY,
        "Sunday" -> java.util.Calendar.SUNDAY,
    )
    linkedHashMap.foreach(println)

    // 7. Print a table of all Java properties reported by the getProperties method of the 
    // java.lang.System class, like this:
    //
    // java.runtime.name             | Java(TM) SE Runtime Environment
    // sun.boot.library.path         | /home/apps/jdk1.6.0_21/jre/lib/i386
    // java.vm.version               | 17.0-b16
    // java.vm.vendor                | Sun Microsystems Inc.
    // java.vendor.url               | http://java.sun.com/
    // path.separator                | :
    // java.vm.name                  | Java HotSpot(TM) Server VM
    //
    // You need to find the length of the longest key before you can print the table.
    println("<<----7---->>")
    val systemProperties = java.lang.System.getProperties().asScala
    val longestKey = systemProperties.keySet.maxBy(k => k.length).length()
    systemProperties.foreach((k, v) => println(k + (" " * (longestKey - k.length))+ " | " + v))

    // 8. Write a function minmax(values: Array[Int]) that returns a pair containing the smallest 
    // and the largest values in the (nonempty) array.
    println("<<----8---->>")
    def minmax(values: Array[Int]) = (values.min, values.max)
    val arr1 = Array(4, 2, 65, 2, 1, 68, 4, -2, 4, 3)
    println(minmax(arr1))

    // 9. Reimplement the function from the preceding exercise to return an Option that is 
    // None if the array happens to be empty.
    println("<<----9---->>")
    def minmax2(values: Array[Int]): Option[Tuple] = 
        if values.isEmpty then None else Some(values.min, values.max)
    val arr2 = Array(4, 2, 65, 2, 1, 68, 4, -2, 4, 3)
    val arr3 = Array[Int]()
    println(minmax2(arr2))
    println(minmax2(arr3))

    // 10. Write a program that prompts the user for a first and last letter, then prints a 
    // matching word from scala.io.Source.fromFile("/usr/share/dict/words").mkString.split("\n"). 
    // Use find. What alternatives do you have for dealing with the returned Option?
    println("<<----10---->>")
    print("Enter the first char: ")
    val firstChar = scala.io.StdIn.readChar()
    print("Enter the second char: ")
    val secondChar = scala.io.StdIn.readChar()
    val element = scala.io.Source.fromFile("/usr/share/dict/words").mkString.split("\n").find({
        e => e(0) == firstChar && e.last == secondChar
    })
    println(element)

    // 11. Write a program that demonstrates that the argument of the getOrElse method in the 
    // Option class is evaluated lazily.
    println("<<----11---->>")
    val populatedValue = Some("hello")
    val nonPopulatedValue = None
    populatedValue.getOrElse(println("not here"))
    nonPopulatedValue.getOrElse(println("not here"))

    // 12. Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing 
    // the counts of values less than v, equal to v, and greater than v.
    println("<<----12---->>")

    // 13. What happens when you zip together two strings, such as "Hello".zip("World")? Come up 
    // with a plausible use case.
    println("<<----13---->>")