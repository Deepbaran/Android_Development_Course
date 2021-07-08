fun main() {
    //For Loop
    val names = arrayOf("jack", "john", "frank")

    for(name in names) {
        println(name)
    }

    for(i in names.indices) {
        println(names[i])
    }
}