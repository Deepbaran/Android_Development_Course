fun main() {
    //Single expression function
    println(addNumbers1(3, 7))
    addNumbers2(3, 7)
}

//fun addNumbers1(x: Int, y: Int): Int {
//    return x + y
//}

fun addNumbers1(x: Int, y: Int) = x + y

fun addNumbers2(x: Int, y: Int) = println(x + y)