
/*
    8. What is the effect of
    import java.*
    import javax.*
    Is this a good idea?

    A: This will import everything from java and overwrite anything that is defined
       by scala of the same name.

       Not a good idea.
*/

@main def ex8 =
    import java.*
    import javax.*