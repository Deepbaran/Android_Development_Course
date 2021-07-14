fun main() {
    val name: Any = "John"
    val name1: String = name as String
    println(name1)
    println(name is Any) // true
    println(name is String) // true
    println((name as String) is String) // true

    // val x: Int = 7
    // val y: Long = x as Long //error

    // val z: Long? = x as? Long
    // println(z)
}