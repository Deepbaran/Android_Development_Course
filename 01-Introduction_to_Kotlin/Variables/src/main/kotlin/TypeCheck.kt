fun main() {
    //Type Checking
    val name: Any = "John"
    if(name is String) {
        println(name is String)
        println(name.length)
    }
}