fun parseMovieName2(name: String): Int {
    return name.toInt()
}

fun main() {
    //getting the movie name from user
//    val movieName = "300"
    val movieName = "Titanic"

    try {
        val x = parseMovieName2(movieName)
        println(x)
    } catch (ex: NumberFormatException) {
        println("Exception happened because movie name was not numeric | ${ex.message}") //Exception happened because movie name was not numeric | For input string: "Titanic"
    } finally {
        //This block is mainly used for cleaning up resources or to write cleanup code. And this block will be executed regardless if there was an exception or not.
        println("--END--")
    }

    /*
    Generic Exception for the above try block:
    catch (ex: Exception) {
        //Try to catch each specific type exception individually rather than catching a generic exception
        //Catch specific exceptions rather than generic exception
        ex.printStackTrace()
        println(ex) //java.lang.NumberFormatException: For input string: "Titanic"
        println(ex.message) //For input string: "Titanic"
    }

    Among the multiple catch statements, the exception that first catches the thrown exception gets executed.
     */
}

//In Kotlin, we have only unchecked exceptions and can be caught only at run time. All the exception classes are descendants of Throwable class.

/*
fun main(args : Array<String>){
try{
    var ar = arrayOf(1,2,3,4,5)
    var int = ar[6]
    println(int)
}
finally {
    println("This block always executes")
}
}

O/P: THis block always executes ArrayIndexOutOfBoundsException
Explanation: Here as we have used try with finally block and skipped the catch block, exception is not handled by catch block but executes the finally block.
 */

