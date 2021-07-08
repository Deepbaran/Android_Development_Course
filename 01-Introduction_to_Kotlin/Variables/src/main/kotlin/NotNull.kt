fun main() {
    //Not-Null Assertion Operator
    printNameLength("John", "Doe")
    printNameLength("John", null) // Throws null pointer exception
}

fun printNameLength(firstName: String?, lastName: String?) {
    if(firstName != null) {
        //Not-Null assertion operator !!.
        println("Name ${firstName.length} ${lastName!!.length}") // Kotlin Compiler will not check lastName for null
    }
}