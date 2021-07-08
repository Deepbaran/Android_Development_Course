// In Kotlin, all classes are final by default in Kotlin. It means, we cannot inherit from it.
// To inherit a class in Kotlin, we need to use the "open" keyword
// Kotlin just like Java does not support multiple inheritance

open class Person(val name: String) {
    init {
        println("This is a person")
    }
    open var age: Int = 1
    open fun doWork() { // As doWork() is final by default, so we need to use the open keyword
        println("Person is doing work")
    }
}

class Student5(name: String, val school: String, override var age: Int): Person(name) { // This class is inheriting the Person class by passing a value to it's constructor and calling it's constructor
    // The name in Person() is the same name that the Primary Constructor of Student5 holds
    init{
        println("This is a student")
    }
    override fun doWork() { // overriding the doWork() in Person
        println("Student is Studying")
        //super.doWork() // calls the doWork() of the parent class
    }
}

// override function
// override property
// call super
fun main() {
    val student: Student5 = Student5("John", "DP School", 10)
    student.doWork()
    println("The age of student is ${student.age}") // Student5 is overriding the age property and the doWork() of the Person class
    //This is a person
    //This is a student
    //Student is Studying
    //The age of student is 10

    val x: Person = Student5("Mark", "Doe", 10) // Just like Java, in Kotlin too, a Super class can refer to a object of child class. (Student is a Person)
    // x can only access those properties of Student5 that it has inherited from Person or the properties and functions that Student5 has overridden
    println("${x.age}")
    //This is a person
    //This is a student
    //10

    //Any class in Kotlin is the parent of all the classes (Top Level Class in Kotlin) [Just like Object class in Java is the parent of all the classes]
    // hashCode() and toString() are the functions of Any class. So, these two functions are inherited by all the classes in Kotlin

//    val y: Any = 4
//    val z: Any = "Mark"
}