//used for reified type, lambda return and to prevent runtime overhead (reified type means, type is preserved during runtime)
//inline to overhead due to creation of an object
//if lambda is a closure then a new instance is created else singleton
//caveat: don't inline bigger functions. minimize the code to lambda usage
//inline functions can't access non public members of a class.

//fun performOperation4(name: String, fn: (String) -> Unit) {
//    fn(name)
//}

inline fun performOperation4(name: String, fn: (String) -> Unit) {
    fn(name)
}

fun main() {
    val name: String = "John"
    performOperation4(name){println(it)} //John
    //Everytime a lambda is passed to a function, a object is created for the lambda or the anonymous function that is passed, i.e., a class is declared. This is an overhead.
    //Putting it a loop or recursion means that we are creating a big overhead.
    //We need to overcome this.
    //Now, the lambda is a closure. Which means it has access to it's outer scope. I that case a new instance will be created for this lambda or a singleton will be created and that will be passed.
    //But that will still create an overhead. To avoid that overhead, we can make the function inline.
    //Now, whenever the lambda receiving function is called, the whole code of the function will be copied at the code site and in that case we will not need to create an object of the lambda.
    //As we are not passing it, it is already in the code.

    //println(name) //because of inline, the lambda will become something like this.
}