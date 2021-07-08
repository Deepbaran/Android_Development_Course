fun main() {
    //While
    var i = 0
    while(i < 5) {
        println("Hello, World!")
        i++
    }

    var name: String?
    do {
        name = "John"
        println(name)
    } while(name == null)
}