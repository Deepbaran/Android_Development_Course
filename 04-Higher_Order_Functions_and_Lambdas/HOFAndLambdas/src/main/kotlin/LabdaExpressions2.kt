//return in lambda, is quite confusing. So, use anonymous function when you need return in a function literal where return works normally

inline fun printSum(fn: (Int?, Int) -> Unit) { //When a function is inline, then wherever it is called, the compiler copies all of it's code there only.
    val x = null
    val y = 7
    fn(x, y)
    println("Done with printSum() function")
}

fun main() {
    printSum{x: Int?, y: Int -> //As printSum() is inline, so at the call side, all of printSum() code is copied. And lambdas can return
        if(x == null) {
            //return
            //This will give error, as in Kotlin, lambdas can't return. But we can return in lambdas, if we make the function we are passing it to, inline.
            //As printSum() is a inline, so the whole code acts as a local code. So, when it returns, it returns from the main(). That's why nothing else gets executed.
            //That's why we say, lambda use non-local return. Which means, whenever a return is called from lambda, that return happens to the outer function.
            //To stop this return from happening to the outer function and happen inside the lambda, we will need to use "labeled return".
            return@printSum //This return will happen to the inline printSum function and not it's outer function.
        } else {
            println("Sum of $x and $y is: ${x + y}")
        }
    }
    println("Done")
}