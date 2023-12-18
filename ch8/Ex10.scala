package ex10

import java.util.ArrayList

/*
10. The file scala/collection/immutable/Stack.scala contains 
the definition

class Stack[A] protected (protected val elems: List[A])

Explain the meanings of the protected keywords. 
(Hint: Review the discussion of private constructors in Chapter 5.)
*/

/* 
A protected constructor can only be accessed by an auxiliary
constructor from same or descendant class
*/


class Stack[T] protected (protected val elems: List[T])

class DefaultStack[T](elems: List[T]) extends Stack[T](elems)