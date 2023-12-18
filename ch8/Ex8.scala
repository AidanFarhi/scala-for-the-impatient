package ex8

/*
8. Compile the Person and SecretAgent classes in Section 8.8,
“Overriding Fields,” on page 102 and analyze the class files 
with javap. How many name fields are there? How many name 
getter methods are there? What do they get? 
(Hint: Use the -c and -private options.)

class Person(val name: String) :
  override def toString = s"${getClass.getName}[name=$name]"

class SecretAgent(codename: String) extends Person(codename) :
  override val name = "secret" // Don’t want to reveal name...
  override val toString = "secret" // ...or class name
*/

class Person(val name: String) :
  override def toString = s"${getClass.getName}[name=$name]"


class SecretAgent(codename: String) extends Person(codename) :
  override val name = "secret" // Don’t want to reveal name...
  override val toString = "secret" // ...or class name

/*

aidanfarhi@Aidans-MBP ex8 % javap -private SecretAgent.class 
Compiled from "Ex8.scala"
public class ex8.SecretAgent extends ex8.Person {
  private final java.lang.String name;
  private final java.lang.String toString;
  public ex8.SecretAgent(java.lang.String);
  public java.lang.String name();
  public java.lang.String toString();
}

aidanfarhi@Aidans-MBP ex8 % javap -private Person.class     
Compiled from "Ex8.scala"
public class ex8.Person {
  private final java.lang.String name;
  public ex8.Person(java.lang.String);
  public java.lang.String name();
  public java.lang.String toString();
}
*/