fun main() {
    // String Template
    val flatNumber: Int = 25
    val address: String = "Tower 2, Flat No. " + flatNumber
    println(address) // Tower 2, Flat No. 25

    val address1: String = "Tower 2, Flat No."
    println("$address1 $flatNumber") // Tower 2, Flat No. 25

    val address2: String = "Tower 2, Flat No. $flatNumber"
    println(address2) // Tower 2, Flat No. 25

    val name: String = "John"
    println(name[0])
    println(name.get(1))
}