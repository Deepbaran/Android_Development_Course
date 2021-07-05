//Data class is a class that is used to store data that is fetched either from a api or a database or any other source.
//Data class is a special class provided by Kotlin
//Data class can only have properties inside the constructor
// Data class only considers the properties inside the constructor

data class Student9(val name: String, var section: String) {
    var age: Int = 8 //This is not allowed. It is bad practice to have properties in Data class which are outside the constructor
}

fun main() {
    val student = Student9("John", "A")
    student.age = 10
    val student1 = Student9("John", "A")

    //equals -> It is inherited from the Any class
    println("Line1: equals() function: ${student1.equals(student)}") //Line1: equals() function: true //Here only the properties inside the constructor are compared

    //toString -> It is inherited from the Any class | Only the properties inside the constructor is stringifies
    println("Line2: toString() function: ${student1.toString()}") //Line2: toString() function: Student9(name=John, section=A)
    //copy -> Copies one data class to another
    val student2 = student.copy(name="Mark") //Changed the value of the name property in the data class constructor
    println("Line3: copy() function: ${student2.toString()}") //Line3: copy() function: Student9(name=Mark, section=A)

    //destructuring //Destructure the properties inside the constructor
    val (name, section) = student
    println("Line4: destructuring: $name is in section $section") //Line4: destructuring: John is in section A
}
