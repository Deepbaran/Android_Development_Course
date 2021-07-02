fun main() {
    //Range
    println("Line 1: ")
    for(i in 1..5) {
        print(i) //12345
    }

    println("\nLine 2:")
    if(4 !in 5..10) {
        print("Not there") //Not there
    }

    println("\nLine 3:")
    if(6 in 5..10) {
        print("There") //There
    }

    println("\nLine 4:")
    for(i in 1 until 5) {
        print(i) //1234
    }

    println("\nLine 5:")
    for(i in 1..5 step 2) {
        print(i) //135
    }

    println("\nLine 6:")
    for(i in 5 downTo 1) {
        print(i) //54321
    }
}