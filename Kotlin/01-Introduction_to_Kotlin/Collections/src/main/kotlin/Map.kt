fun main() {
    //Map -> Collection of Key-Value pairs
    val classRanks = mapOf(1 to "Sarah", 2 to "Mark", 3 to "Finn", 4 to "John")
    println("1. Students: ${classRanks.values}") //1. Students: [Sarah, Mark, Finn, John]
    println("2. Ranks: ${classRanks.keys}") //2. Ranks: [1, 2, 3, 4]
    println("3. Finn has got a rank ${classRanks.containsValue("Finn")}") //3. Finn has got a rank true
    println("4. There is a 4th rank ${classRanks.containsKey(4)}") //4. There is a 4th rank true
    println("5. The student at first rank is: ${classRanks.get(1)}") //5. The student at first rank is: Sarah
}