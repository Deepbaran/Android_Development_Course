fun main() {
    //MutableMap
    val classRanks = mutableMapOf(1 to "Sarah", 2 to "Mark", 3 to "Finn", 4 to "John")
    classRanks.put(4, "Jim")
    classRanks.remove(2)
    println(classRanks) //{1=Sarah, 3=Finn, 4=Jim}
}