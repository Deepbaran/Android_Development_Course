fun a() {
    println("a() is called")
    b()
    println("a() is finished")
}

fun b() {
    println("b() is called")
    c()
    println("b() is finished")
}

fun c() {
    println("c() is called")
}

fun main() {
    a()
    //a() is called
    //b() is called
    //c() is called
    //b() is finished
    //a() is finished
}