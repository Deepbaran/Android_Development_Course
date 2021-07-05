//Generics is a feature, through which we imply the properties and features of a class among different data types while keeping the type safety in mind

//fun printContent(content: String) {
//    println("The content is $content")
//}

//Generic function
fun <T> printContent(content: T) {
    println("The content is $content")
}

fun main() {
//    printContent("Hello World!")
    //printContent(9) //This will give error as printContent() requires a String value. To overcome this, we need to make sure that printContent() takes a generic value

    printContent<String>("Hello World!") //Setting the type <T> as <String>
    printContent<Int>(9) //Compiler can automatically infer the type of <T>. So no need to explicitly write <Int>
}