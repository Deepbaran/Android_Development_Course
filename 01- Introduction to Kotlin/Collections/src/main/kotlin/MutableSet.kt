fun main() {
    //MutableSet
    val names = mutableSetOf("John", "Mark", "Finn")
    println(names) //[John, Mark, Finn]
    names.add("Sarah")
    println(names) //[John, Mark, Finn, Sarah]
    names.remove("Sarah")
    println(names) //[John, Mark, Finn]
}