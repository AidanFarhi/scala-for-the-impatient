import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import java.util.TimeZone
import java.awt.datatransfer.*

@main def exercises =

    // 1. Write a code snippet that sets a to an array of n 
    // random integers between 0 (inclusive) and n (exclusive).
    val n = 10
    val a = Array.from(for i <- 0 to n yield Random.between(0, n))
    println(a.mkString("[", ",", "]"))

    // 2. Write a loop that swaps adjacent elements of an array of integers. 
    // For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
    val a2 = Array(1, 2, 3, 4, 5)
    for i <- 1 to a2.length - 1 by 2 do
        val temp = a2(i)
        a2(i) = a2(i-1)
        a2(i-1) = temp
    println(a2.mkString("[", ",", "]"))

    // 3. Repeat the preceding assignment, but produce a new array with the 
    // swapped values. Use for/yield.
    val a3 = Array(1, 2, 3, 4, 5)
    val res3 = 
        for i <- a3.indices 
        yield 
            if i % 2 == 0 && i < a3.length - 1 then a3(i+1)
            else if i % 2 != 0 && i < a3.length - 1 then a3(i-1)
            else a3(i)
    println(res3.mkString("[", ",", "]"))

    // 4. Given an array of integers, produce a new array that contains all positive 
    // values of the original array, in their original order, followed by all values 
    // that are zero or negative, in their original order.
    val a4 = Array(1, -2, 4, -5, 6, 7)
    val res4 = a4.filter(_ >= 0) ++ a4.filter(_ < 0)
    println(res4.mkString("[", ",", "]"))
    
    // 5. How do you compute the average of an Array[Double]?
    val a5 = Array(0.4, 23.2, -53.4, 41.33, 21.24)
    val res5 = a5.sum / a5.length
    println(res5)

    // 6. How do you rearrange the elements of an Array[Int] so that they appear in reverse 
    // sorted order? How do you do the same with an ArrayBuffer[Int]?
    val arr6 = Array(1, 3, 2, 4, 3, 6, 8, 1)
    val arrBuff6 = ArrayBuffer.from(arr6)
    val res6Arr = arr6.sorted.reverse
    val res6ArrBuff = arrBuff6.sorted.reverse
    println(res6Arr.mkString("[", ",", "]"))
    println(res6ArrBuff.mkString("[", ",", "]"))

    // 7. Write a code snippet that produces all values from an array with duplicates removed. 
    // (Hint: Look at Scaladoc.)
    val arr7 = Array(1, 2, 3, 3, 4, 5, 5, 6, 7, 8, 8, 9)
    val res7 = arr7.distinct
    println(res7.mkString("[", ",", "]"))

    // 8. Suppose you are given an array buffer of integers and want to remove all but the first 
    // negative number. Here is a sequential solution that sets a flag when the first negative 
    // number is called, then removes all elements beyond.
    //
    // var first = true
    // var n = a.length
    // var i = 0
    // while i < n do
    // if a(i) >= 0 then i += 1
    // else
    //     if first then
    //     first = false
    //     i += 1
    //     else
    //     a.remove(i)
    //     n -= 1
    //
    // This is a complex and inefficient solution. Rewrite it in Scala by collecting positions 
    // of the negative elements, dropping the first element, reversing the sequence, and calling 
    // a.remove(i) for each index.
    val arrBuff8 = ArrayBuffer(1, 3, -3, 5, -7, 3, 4)
    val negativePositions8 = for i <- arrBuff8.indices if arrBuff8(i) < 0 yield i
    negativePositions8.tail.reverse.foreach(i => arrBuff8.remove(i))
    println(arrBuff8.mkString("[", ",", "]"))

    // 9. Improve the solution of the preceding exercise by collecting the positions that should 
    // be moved and their target positions. Make those moves and truncate the buffer. 
    // Don’t copy any elements before the first unwanted element.
    val arrBuff9 = ArrayBuffer(1, 3, -3, 5, -7, 3, 4)
    val negativePositions9 = for i <- arrBuff9.indices if arrBuff9(i) < 0 yield i
    val indexToStart9 = if negativePositions9.length > 1 then negativePositions9(1) else arrBuff9.length
    val positionsToMove9 = for i <- indexToStart9 to arrBuff9.length - 1 if arrBuff9(i) >= 0 yield i
    val targetPositions9 = for i <- indexToStart9 to indexToStart9 + positionsToMove9.length - 1 yield i
    for i <- positionsToMove9.indices do arrBuff9(targetPositions9(i)) = arrBuff9(positionsToMove9(i))
    arrBuff9.sliceInPlace(0, targetPositions9(targetPositions9.length-1))
    println(arrBuff9.mkString("[", ",", "]"))

    // 10. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in 
    // America. Strip off the "America/" prefix and sort the result.
    val timeZones = TimeZone.getAvailableIDs()
        .filter(e => e.startsWith("America"))
        .map(e => e.stripPrefix("America/"))
    println(timeZones.mkString("[", ",", "]"))

    // 11. Import java.awt.datatransfer.* and make an object of type SystemFlavorMap with the call
    // val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    // Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get the 
    // return value as a Scala buffer. (Why this obscure class? It’s hard to find uses of java.util.List 
    // in the standard Java library.)
    val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
    val nativesForFlavor = ArrayBuffer(flavors.getNativesForFlavor(DataFlavor.imageFlavor))
    println(nativesForFlavor.mkString("[", ",", "]")) // this will open a GUI window