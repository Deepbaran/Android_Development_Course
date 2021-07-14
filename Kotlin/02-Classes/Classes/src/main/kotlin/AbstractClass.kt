//An Abstract class is not concrete. It is left for others to implement it.
//An abstract class can have one more functions or properties which are abstract and the need to be implemented by the classes which inherit the abstract class
//Abstract class is by default open. Because Abstract classes are meant to be inherited. Because we can't create object from a abstract class.

abstract class Person1(val name: String) {
    abstract fun doWork() // Not implementation needed for abstract function, i.e., no function body is needed

    fun doTalk() {
        //a function to talk
    }
}

class Student6(name: String, val school: String): Person1(name) {
    override fun doWork() {
        println("Student is studying")
    }
}

fun main() {
    val student = Student6("John", "DP School")
    student.doWork()
}