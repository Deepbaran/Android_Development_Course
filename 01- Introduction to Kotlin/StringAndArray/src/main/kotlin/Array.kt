fun main() {
    //Array
    val numbers = arrayOf(1, 2, 3, 4)

    println("The number at second position: ${numbers.get(1)}")
    println("The number at third position: ${numbers[2]}")
    numbers.set(3, 5)
    numbers[1] = 22
    println(numbers.joinToString(","))

    val numbersZero = Array(4){0}
    println(numbersZero.joinToString(","))

    val numbersArray = Array(3){33}
    println("${numbersArray.get(0)} ${numbersArray.get(1)}")

//    val checks = arrayOf("Deep", 23) // Don't do this
//    println(checks.joinToString(","))
    val arr1 = arrayOf(1, 2, 3, 4, 5)
    val arr2 = intArrayOf(1, 2, 3, 4, 5)
//    val arr3 = intArray(1, 2, 3, 4, 5)
//    val arr4 = intArray(5){3}
//    val arr5 = [1, 2, 3, 4, 5]

    val arr = arrayOf(arr1, arr2);
}