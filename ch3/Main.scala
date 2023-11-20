import scala.collection.mutable.ArrayBuffer

@main def main =
    
    // fixed length arrays: Array
    val strings = Array("Hello", "World")
    val moreStrings = Array.ofDim[String](5)
    val nums = Array.ofDim[Int](10)

    println(strings(0))
    strings(0) = "Goodbye"
    println(strings(0))


    // variable length arrrays: ArrayBuffer
    val buffer = ArrayBuffer[Int]()
    buffer += 1
    buffer ++= Array(2, 3, 4, 5)
    buffer.foreach(e => print(f"$e "))
    println()
    buffer.insertAll(0, Array(99, 88, 77))
    buffer.foreach(e => print(f"$e "))
    println()
    
    // sometimes you want an Array, but don't know
    // how many items will be in the Array. In that case,
    // do this:
    val itemsArrayBuffer = ArrayBuffer[String]()
    itemsArrayBuffer.addOne("Bob")
    itemsArrayBuffer.addOne("Jim")
    itemsArrayBuffer.addOne("Joe")
    // convert to an Array
    val itemsArray = itemsArrayBuffer.toArray
    itemsArray.foreach(e => print(f"$e "))
    println()

    // traversing Arrays and ArrayBuffers
    for i <- 0 until itemsArrayBuffer.length do
        println(s"$i: ${itemsArrayBuffer(i)}")

    for i <- 0 until itemsArray.length do
        println(s"$i: ${itemsArray(i)}")

    for i <- itemsArray.indices.reverse do
        println(s"$i: ${itemsArray(i)}")
    
    // transforming Arrays
    val numArr = Array(2, 4, 6, 8)
    val result = for elem <- numArr yield elem * 2
    for elem <- result do print(s"$elem ")
    println()
    val bigNumsHalved = for elem <- result if elem > 10 yield elem / 2
    bigNumsHalved.foreach(elem => print(s"$elem "))
    println()
    val moreNums = Array(1, -35, 5, -3, 24, 3, 6)
    val doubledPositives = moreNums.filter(_ >= 0).map(_ * 2).sorted
    doubledPositives.foreach(elem => print(s"$elem "))
    println()

    // filter out negative nums, two ways
    val positives = moreNums.filter(_ >= 0)
    val positives2 = for e <- moreNums if e >= 0 yield e
    positives.foreach(e => print(s"$e "))
    println()
    positives2.foreach(e => print(s"$e "))
    println()

    // remove all negative nums, in place
    val nums2 = ArrayBuffer.from(moreNums)
    val indexesToRemove = for i <- nums2.indices if nums2(i) < 0 yield i
    for i <- indexesToRemove.reverse do nums2.remove(i)
    nums2.foreach(e => print(s"$e "))
    println()

    // common algorithms
    val arr = Array(1, 2, 3, 4, 5)
    println(s"sum: ${arr.sum}")
    println(s"min: ${arr.min}")
    println(s"max: ${arr.max}")
    println(s"mean: ${arr.sum / arr.length}")
    println(s"reversed: ${arr.reverse.mkString("[", ",", "]")}")

    // multidimensional Arrays
    val matrix = Array.ofDim[Double](3, 4)
    for i <- matrix.indices do
        print("|")
        for j <- matrix(i).indices do
            print(s"${matrix(i)(j)}|")
        println()
    