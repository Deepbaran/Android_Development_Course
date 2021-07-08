//Anonymous functions are also function literals. Which means they can be assigned to a variable of function type.
//Anonymous functions do not have a name.
//return type is explicit in anonymous function. Unlike lambda function, where the last 'expression' is returned.
//return in lambda, is quite confusing. So, use anonymous function when you need return in a function literal where return works normally
//Unlike Lambda functions, Anonymous Functions can't be moved out of the parenthesis even if they are the last expression,i.e always declared or passed within the parenthesis.

fun performOperation3(x: Int, y: Int, fn: (Int, Int) -> Int) {
    val result = fn(x, y)
    println("Result of $x and $y is: $result")
}

fun main() {
    //has a explicit return type
    //the "return" works normally
    val f0: (Int, Int) -> Int = fun(x: Int, y: Int): Int = x + y
    performOperation3(4, 8, f0)

    //passed always inside the parameter
    performOperation3(7, 2, fun(x, y) = x - y)
}