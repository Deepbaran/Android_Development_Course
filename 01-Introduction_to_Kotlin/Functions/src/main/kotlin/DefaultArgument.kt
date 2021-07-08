fun main() {
    // Default arguments
    printUserName1("John", "Frost")
    printUserName1("John")
}

fun printUserName1(firstName: String, lastName: String = "Doe") {
    println("The name is: $firstName $lastName")
}