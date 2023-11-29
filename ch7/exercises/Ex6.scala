
/*
    6. Write a program that copies all elements from a Java hash map into a Scala 
    hash map. Use imports to rename both classes.
*/

import java.util.HashMap as JavaHashMap
import scala.collection.mutable.Map as ScalaHashMap

@main def ex6 =

    val scalaMap = ScalaHashMap[String, Int]()
    val javaMap = JavaHashMap[String, Int]()
    javaMap.put("a", 1)
    javaMap.put("b", 2)
    javaMap.put("c", 3)
    
    javaMap.forEach((k, v) => scalaMap.put(k, v))
    scalaMap.foreach((k, v) => println(s"$k: $v"))
