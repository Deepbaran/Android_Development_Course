fun main() {
    //List
//    val names = listOf<String>("John", "Mark", "Sarah", "Finn")
    val names = listOf("John", "Mark", "Finn") // Creates an immutable List
    println("1. The size of the list is: ${names.size}") //1. The size of the list is: 3
    println("2. The second item in the list is: ${names.get(1)}") //2. The second item in the list is: Mark
    println("3. The second item in the list using index operator is: ${names[1]}") //3. The second item in the list using index operator is: Mark
    println("4. Finn is at index ${names.indexOf("Finn")} in the last") //4. Finn is at index 2 in the last //If "Finn" is not in the list then we will get -1
//    names.add("Sarah")
    println(names) //[John, Mark, Sarah, Finn]
}