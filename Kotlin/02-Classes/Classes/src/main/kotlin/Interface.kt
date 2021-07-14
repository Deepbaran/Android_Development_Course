// Interfaces do not have constructors. So, we cannot directly instantiate them and create an object
// Kotlin supports multi interface implementation
// Interfaces are similar to Abstract classes with one major difference. Interfaces can't have state. Which means, interfaces can't have properties with a backing field.
// In interface, all properties and functions by default open

interface Footballer {
    val position: String // Needs to be implemented
    fun dribble() // Needs to be implemented
    fun kick() {
        println("Kick the football")
    }
}

open class Person2(val name: String)

class Student7(name: String, override val position: String): Person2(name), Footballer { // Inheriting both Person class and the Footballer interface.
    // This is the concrete class of the Footballer interface
    override fun dribble() {
        println("Dribble the ball")
    }
//    override fun kick() {
//        println("Kick")
//    }
}

fun main() {
    val student = Student7("John", "Striker")
    playFootball(student)
    printName(student)
}

fun playFootball(footballer: Footballer) { // Here the footballer interface object is pointing to the student object due to polymorphism
    footballer.dribble()
    footballer.kick()
}

fun printName(person: Person2) { // Here the Person2 class object is pointing to the student object due to polymorphism
    println("Person name is: ${person.name}")
}