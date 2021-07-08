fun getSum(x: Int, y: Int): Int {
    return x + y
}

//higher order function
fun performOperation(x: Int, y: Int, fn: (Int, Int) -> Int) {
    val result = fn(x, y)
    println("Result of $x and $y is: $result")
}

//returns a function
fun getLength(): (String) -> Int {
    return {x: String -> x.length}
}

fun main() {
    //pass function as parameter
    performOperation(2, 4, ::getSum) //Result of 2 and 4 is: 6

    performOperation(8, 1, {x, y -> x - y}) //Result of 8 and 1 is: 7 //We do not need to mention the type x and y explicitly. Compiler can infer it automatically

    performOperation(7, 6, fun(x: Int, y: Int): Int = x * y) //Result of 7 and 6 is: 42

    val f: (String) -> Int = getLength()
    println("Length is: ${f("Mark")}") //Length is: 4
}