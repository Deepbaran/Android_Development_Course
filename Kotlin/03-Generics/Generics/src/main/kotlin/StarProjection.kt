//If we are not bothered about or if we have no use of the type, we can simply use Star Projection (*).
//With star projection we can take generic of any class.
//Use it, only when type of the generic does not matter.

fun printItems(items: MutableList<*>) {
    for(i in items.indices) {
        println(items.get(i))
    }
}

fun main() {
    val x: MutableList<Any> = mutableListOf(1, 2, "a")
    printItems(x)
}