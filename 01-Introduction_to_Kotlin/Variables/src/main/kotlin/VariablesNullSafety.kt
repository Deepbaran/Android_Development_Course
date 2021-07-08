fun main() {
    // Null Safety
    var name: String? = null // Nullable type

    println(name)

    // safe call operator ?.
    println(name?.length)

    // Elvis operator ?:
    println(name?.length ?: 0)
}