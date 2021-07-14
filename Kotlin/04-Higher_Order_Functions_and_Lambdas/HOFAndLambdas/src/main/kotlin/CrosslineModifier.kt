//lambda return are non local. Which means that, if we return from lambda, we return from the outer function. This is not always desirable

//crossline can be declared only for parameters of inline function
inline fun printString(crossinline fn: (String) -> Unit){
    fn("John")
    println("Data printed")
    //This line will not execute as fn has a return expression at the end
    //That means after invoking and execution, fn will return and that return will happen to printString.
    //That means, instead of the lambda, printString will return.
    //As printString is a inline function (it's code will be copied to the caller), so as printString will returns, main will return and the execution will end.
    //To overcome this we can use a labeled return inside the lambda.
    //Another way to overcome this is, we can use crossline modifier in the parameter.
    //Because, crossinline modifier makes sure that the passed lambda does not contain a return.

    //Another use of crossline modifier is if we have the lambda in another object context
    //region
//    val task = object: Runnable{
//        override fun run() = fn("Mark") //Using lambda in another object context (In a object of type Runnable)
//    }
//    task.run()
    //endregion
}

fun main() {
//    printString { println(it); return }
    printString { println(it) }
}
