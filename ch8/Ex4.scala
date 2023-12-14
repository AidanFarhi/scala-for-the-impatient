package ex4

import scala.collection.mutable.ArrayBuffer

/*
4. Define an abstract class Item with methods price and description. 
A SimpleItem is an item whose price and description are specified 
in the constructor. Take advantage of the fact that a val can 
override a def. A Bundle is an item that contains other items. Its 
price is the sum of the prices in the bundle. Also provide a 
mechanism for adding items to the bundle and a suitable description method. 
*/

abstract class Item:

    def price: Double
    def description: String


class SimpleItem(val price: Double, val description: String) extends Item


class Bundle extends Item:

    private val items = ArrayBuffer[Item]()

    def addItem(item: Item) = items.addOne(item)
    override def price: Double = items.map(_.price).sum
    override def description: String = items.map(_.description).mkString(sep = ",")


@main def ex4 =
    
    val bundle = Bundle()
    bundle.addItem(SimpleItem(10.0, "a helmet"))
    bundle.addItem(SimpleItem(23.0, "a sword"))
    bundle.addItem(SimpleItem(93.2, "a shield"))

    assert(bundle.price == 126.2)
    assert(bundle.description == "a helmet,a sword,a shield")