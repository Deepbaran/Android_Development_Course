fun parseMovieName(name: String): Int {
    return name.toInt()
}

fun main() {
//    val name: String = "300"
    val name: String = "Titanic" //It will throw an Exception (object of class NumberFormatException is thrown)
    val x = parseMovieName(name)
    println(x)
}

/*
When an Exception is thrown, what is thrown is actually a class Exception.
This Exception class is the parent class of all other Exception Classes.

Exception classes like NumberFormatException inherit the Exception Class.
 */