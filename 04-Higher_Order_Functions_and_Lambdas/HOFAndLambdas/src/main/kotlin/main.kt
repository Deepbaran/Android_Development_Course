//In Kotlin, functions are first class citizens.
//Which means that we can pass functions as part of arguments to another function or return a function from a function or we can store a function in a vriable.
//A Higher Order Function (HOF) is a function which takes function as a parameter or returns a function as a value.
//As functions can be stored in variables, that means the variables must have a type or as we call it, function type.
//function types defines, what kind of functions can be stored in the variable.

fun main() {
    //regular function
    val f1: (Int, Int) -> Int //according to the function type, f1 can store a function which takes two parameters of type Int and a return value of type Int
    val f2: (Int, Int) -> Boolean
    //minimal signature
    val f0: () -> Unit
    //nullable
    val f3: ((String) -> Int)? //As the function type is nullable, it means that either f3 can store a function of corresponding type or it can store a null

    //assignment
    //declared function
    f1 = ::addInt //assigning a regular function (addInt) using the "::" operator to f1. But the regular function must of the function type associated to f1.
    //function literals
    //lambda
    f2 = {x: Int, y: Int -> x > y} //The return type of a lambda can be inferred from the last expression
    //anonymous function
    f3 = fun(s: String): Int { return s.length } //anonymous functions are functions without a name

    //invoke
    f1.invoke(2, 4)
    f2(6, 5)
    f3("Mark")
}

//fun addInt(x: Int, y: Int): Int{
//    return x + y
//}

fun addInt(x: Int, y: Int) = x + y