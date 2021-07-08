//Lambdas are function literals. Which means they are not declared but passed as a value to a variable which is of function type.
//lambda expressions can not be generic.

fun main() {
    val name: String = "John"

    val f0: (Int, Int) -> Int = {x: Int, y: Int -> x + y}
    //val f0: (Int, Int) -> Int = {x, y -> x + y}
    println(f0(4, 6)) //10

    //minimal lambda expression
    val f1 = {2} //2 is returned
    println(f1()) //2

    val f2 = {x: Int ->
        println(x) //4
        x * 2 //8 is returned as, for lambda, the last 'expression' is a returned value
    }
    println(f2(4)) //8

    //it for single parameter
//    val f3: (String) -> Int = {x: String -> x.length}
    val f3: (String) -> Int = {it.length} //If a lambda expression has only one argument then we can refer to it as "it". So here, it means that the lambda expression will take a argument which is stored in "it" and then return "it.length"
    println(f3.invoke("John")) //4

    //performOperation2(8, 2, {x, y -> x + y}) //Result of 8 and 2 is: 10
    //If the lambda is the last expression passed to a function then  we can outside the parenthesis
    performOperation2(8,2){x, y -> x + y}
    //If lambda is the only expression that is passed then we can remove the parenthesis too as without other parameters, the parenthesis will become empty ()
    //performOperation2{x, y -> x + y} //performOperation2(){x, y -> x + y} --> performOperation2{x, y -> x + y}
}

fun performOperation2(x: Int, y: Int, fn: (Int, Int) -> Int) {
    val result = fn(x, y)
    println("Result of $x and $y is: $result")
}

/*
fun<T> higherFunction(value: T, abc: (value: T) -> String) {
    println(abc(value))
}
fun main(){
    val<T> printValue : (T) -> String = {value -> "value:
    $value"}
    higherFunction("123", printValue)
}

This will give error as lambda expressions can not be generic.
 */