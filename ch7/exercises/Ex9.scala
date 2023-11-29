/*
    9. Write a program that imports the java.lang.System class, 
    reads the user name from the user.name system property, 
    reads a password from the StdIn object, and prints a message 
    to the standard error stream if the password is not "secret". 
    Otherwise, print a greeting to the standard output stream. 
    Do not use any other imports, and do not use any qualified 
    names (with dots).
*/

import java.lang.System.{getProperty, err, in}
import scala.io.StdIn

@main def ex9 =

    val userName = getProperty("user.name")
    val password = StdIn.readLine()

    if password != "secret" then err.println("error") else println(s"Hello $userName")