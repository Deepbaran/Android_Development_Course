// Constructor is called to create an object of a class
// In Kotlin there are two types of constructors:
// 1. Primary (Only one)
// 2. Secondary (Can have more than one)

// If no modifier or annotation we can get rid of "constructor" keyword
// constructor parameters can have default values
// primary constructor can't contain any code. Use init block for initialization
// there can be multiple init blocks
// primary constructor can have properties
// Primary constructor, and one or more secondary constructors. The primary constructor initializes the class, while the secondary constructor is used to initialize the class and introduce some extra logic.

//class Student3 constructor(firstName: String="Mark") {
//class Student3 (firstName: String="Mark") { // As there are not modifiers, so it is fine
class Student3 (val firstName: String="Mark") { // Here the Primary Constructor has a property
//    val firstName: String
    var lastName: String? = null

    init { // It initializes the primary constructor
        // This block is executed as soon as the object of this class is initialized
        println("init block called")
//        this.firstName = firstName // No need for this, as the firstName passed at the time of initialization (object creation) or passed by the Secondary Constructor using this() is assigned directly inside the firstName property defined in the primary Constructor
    }

    constructor(firstName: String, lastName: String): this(firstName) { // Using the "this" keyword, we are passing the parameter "firstName", we are calling the primary constructor. Secondary Constructor needs to call the Primary Constructor
        // the firstName first comes here, then it goes to the this(), through which it is passed to the Primary Constructor
        // Then through the init{} block firstName is assigned to the this.firstName
        // When the secondary constructor is calling the primary constructor using this(), the class in getting initialized.
        println("Secondary constructor is called")
        this.lastName = lastName
    }
}

fun main() {
    val student: Student3 = Student3("John") // Primary Constructor is called
    // val student: Student3 = Student3("John", "Doe")
    println("Name of the student is: ${student.firstName} ${student.lastName}")

    val student2: Student3 = Student3("John", "Doe") // Secondary Constructor is called
    println("Name of the student is: ${student2.firstName} ${student2.lastName}")

    // Depending on the number of parameters, Primary or Secondary constructor is called
    // If both Primary and Secondary Constructor has same number of parameters then Primary Constructor is preferred
    // We can have multiple Secondary Constructors
    // This is how Kotlin performs constructor overloading
}