//custom exception class
class ShortNameException(msg: String): Exception(msg)

fun printFirstName(name: String){
    if(name.length < 3) {
//        throw Exception("Name too short")
        throw ShortNameException("Name too short")
    }
    println(name)
}

fun main() {
    printFirstName("John")
    printFirstName("as") //ShortNameException is thrown
}