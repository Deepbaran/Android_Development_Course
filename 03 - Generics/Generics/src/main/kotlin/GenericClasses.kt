//class Printer() {
//    fun <T> printContent(content: T) {
//        println("The content is: $content")
//    }
//
//    fun <T> someOtherFunction(value: T) {
//        //code
//    }
//}

//Generic Class
class Printer<T>() {
    fun printContent(content: T) {
        println("The content is: $content")
    }

    fun someOtherFunction(value: T) {
        //code
    }
}

fun main() {
    val printer = Printer<String>()
    printer.printContent("Hello World!")

    val printer1 = Printer<Int>()
    printer1.printContent(12)
}