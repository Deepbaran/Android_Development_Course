//With extension functions, we can add new features to a class, without making any changes to it's code or inheriting it or designing any pattern
//We can not only create extension classes for user-defined functions, but we can create extension functions for system defined functions too.
//Even though, extension functions are defined outside of the class, but they appear as if they are inside the class.
//So, Extension functions cannot be invoked without the corresponding class object.
//Extension functions behave as they belong to the class itself.

class Student11(val firstName: String, val lastName: String)

fun Student11.fullName() = "${this.firstName} ${this.lastName}" //Extension function for User defined class

fun Int.getEven(): Int{ //Extension function for System Defined function (Int)
//    if(this % 2 == 0) {
//        return this
//    } else {
//        return this + 1
//    }

    //As if-else is an expression in Kotlin and we can assign it to a variable, so we are modifying the above if-else code to this one and directly returning the variable value.
    return if(this % 2 == 0) {
        // this defined the Integer object
        this //return the object (Integer. As everything in Kotlin is object)  if the Integer is even
    } else {
        this + 1 //return Integer + 1, if Integer is odd.
    }
}

fun main() {
    val student = Student11("John", "Doe")
    println("The full name of student is: ${student.fullName()}") //The full name of student is: John Doe

    val x: Int = 23 //23 is a Int object
    println("The even age is: ${x.getEven()}") //The even age is: 24
}