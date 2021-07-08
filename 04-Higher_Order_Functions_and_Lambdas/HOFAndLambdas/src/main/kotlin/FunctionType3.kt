//Type Alias: Give function types an alias, so that we would not need to write lengthy function types again and again
//Need to be declared at top level.
//They don't create a new type.
//Not only for function type but for any type. It is mostly used when the data type name is quite large or the function type name is quite large.
typealias intFn = (Int, Int) -> Int //No new type called intFn is created. intFn is just pointing towards the actual function type.
typealias str = String //giving type alias to String type

//fun printSum2(x: Int, y: Int, fn: (Int, Int) -> Int) {
//    val sum = fn(x, y)
//    println("Result of $x and $y is: $sum")
//}

//Replace the function type in argument with type alias
fun printSum2(x: Int, y: Int, fn: intFn) {
    val sum = fn(x, y)
    println("Result of $x and $y is: $sum")
    val x: str = "John"
}