//Not all lambda parameters in a inline function can be made inline. That's where noinline modifier is used.

//inline lambda/anonymous function parameters can't be stored in a variable, passed to another function
inline fun printName(name: String, fn: (String) -> Unit, noinline fn1: (Int, Int) -> Unit){
    fn(name) //invoking the fn lambda function
    printSum(fn1) //passing the fn1 lambda function as a parameter
    //This gives error because, a lambda parameter can't be stored in a variable or passed to other function
    //Here we are storing a lambda function to the fn1 variable. Then we are passing that variable to another function as a parameter. It is illegal.
    //To get rid of the error, make the lambda argument received as noinline.
}

fun printSum(fn: (Int, Int) -> Unit){
    fn(4, 7)
}

fun main() {
    val name: String = "John"
    printName(name, {println(it)}) {x: Int, y: Int -> println("The sum of number is ${x + y}")}
}