/*
    7. In the preceding exercise, move all imports into the 
    innermost scope possible.
*/

@main def ex6 =

    import java.util.HashMap as JavaHashMap
    import scala.collection.mutable.Map as ScalaHashMap

    val scalaMap = ScalaHashMap[String, Int]()
    val javaMap = JavaHashMap[String, Int]()
    javaMap.put("a", 1)
    javaMap.put("b", 2)
    javaMap.put("c", 3)
    
    javaMap.forEach((k, v) => scalaMap.put(k, v))
    scalaMap.foreach((k, v) => println(s"$k: $v"))
