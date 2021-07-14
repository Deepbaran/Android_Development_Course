//Lambdas and anonymous can access their closure.
//It means that they can access variables outside of their scope and modify them.

//useful in callbacks
fun printNext(): () -> Unit {
    var counter = 0
    return {
        //This lambda function is returned
        //This lambda is accessing the "counter" variable and also captures it from the outer scope and the outer scope is called closure for it.
        //As the lambda expression is accessing the counter variable, so even after the execution of the function, the counter variable remains in the Heap stack.
        //The garbage collector will not collect it or destroys it, as it is still in use.
        //Even in the future, if this lambda expression is invoked using the variable which stores the returned lambda expression, this counter variable's value remains unchanged.
        //And if future calls make any changes to the counter variable then the main counter variable's value in the heap memory also changes.
        //So, lambdas are great for callbacks. As they can still access the local variables even after the function returns.
        counter++
        println("The counter is $counter")
    }
}

fun main() {
    val fn = printNext()
    fn() //The counter is 1
    fn() //The counter is 2
}