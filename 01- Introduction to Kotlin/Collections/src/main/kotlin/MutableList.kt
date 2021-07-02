fun main() {
    //MutableList
    val names = mutableListOf("John", "Mark", "Finn")
    println(names) //[John, Mark, Finn]
    names.add("Sarah")
    println(names) //[John, Mark, Finn, Sarah]
    names.removeAt(1)
    println(names) //[John, Finn, Sarah]
    names.remove("Finn")
    println(names) //[John, Sarah]
    names.set(0, "Michael")
    names[1] = "James"
    println(names) //[Michael, James]
    names.clear()
    println(names) //[]
}