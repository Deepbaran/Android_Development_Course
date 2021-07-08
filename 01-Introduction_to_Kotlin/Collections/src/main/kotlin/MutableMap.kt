fun main() {
    //MutableMap
    val classRanks = mutableMapOf(1 to "Sarah", 2 to "Mark", 3 to "Finn", 4 to "John")
    classRanks.put(4, "Jim") // classRanks[4] = "Jim"
    classRanks.remove(2)
    println(classRanks) //{1=Sarah, 3=Finn, 4=Jim}

    // Iterate through a map
    for((key, value) in classRanks.entries) {
        println("$key = $value")
    }

    for((key, value) in classRanks) {
        println("$key = $value")
    }

    for(key in classRanks.keys) {
        println("$key = ${classRanks[key]}")
    }

    val itr = classRanks.iterator()
    while(itr.hasNext()) {
        println(itr.next())
    }
}

/*
Q. Which of the following statements will prompt an error, Why?

1. fun main() {
2.      val ranks = mutableMapOf(1 to "XY",2 to "AB",3 to "WX", "x" to 12)
3.      ranks.put("x","ABC")
4.      val map = mutableMapOf(1 to "1", 2 to "2", 3 to "3")
5.      map.put("4",4)
6. }

A. 5, type mismatch error

Explanation: "ranks is a map of type <Any, Any> therefore it can have ints or strings as its keys as well as value but
"map" is a map of <int, String> type and hence can't have a string as its key or an integer as its value.

 */