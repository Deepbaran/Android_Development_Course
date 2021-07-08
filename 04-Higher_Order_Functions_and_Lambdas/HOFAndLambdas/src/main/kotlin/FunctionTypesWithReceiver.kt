//A receiver is the object, on which a function is called.
//A function type with receiver is similar to extension functions.

fun main() {
    val f0: (Int) -> Unit

    //Lambda function with receiver function type
    //val printSum2: Int.(Int) -> Unit = {println("The sum of $this and $it is ${this.plus(it)}")}
    val printSum2: Int.(Int) -> Unit = {println("The sum of $this and $it is ${plus(it)}")}
    //"Int." is the receiver with type "Int".
    //Here  "it" is the single parameter of the lambda expression.
    //"this" is the receiver object and through "this" we can access all the properties of the receiver object.
    //We don't need to use "this" explicitly to use the properties of "this".
    val x: Int = 6
    x.printSum2(4) //The sum of 6 and 4 is 10

    //Anonymous function with receiver function type
    val printSum3: Int.(Int) -> Unit = fun Int.(num: Int) : Unit = println("The sum of $this and $num is ${this.plus(num)}")
    val y: Int = 6
    y.printSum3(4) //The sum of 6 and 4 is 10
}