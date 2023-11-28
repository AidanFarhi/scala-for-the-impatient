/*
    8. Write an enumeration describing the eight corners of the RGB 
    color cube. As IDs, use the color values (for example, 0xff0000 for Red).
*/

enum RGB(val id: String):
    case Red extends RGB("0xff0000")
    case Green extends RGB("0x00ff00")
    case Blue extends RGB("0x0000ff")
    case Black extends RGB("0x000000")
    case White extends RGB("0xffffff")
    case Yellow extends RGB("0xffffcc")
    case Cyan extends RGB("0x00ffff")
    case Megenta extends RGB("0xff00ff")


@main def ex8 = RGB.values.foreach(v => println(v.id))
