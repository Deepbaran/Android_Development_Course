class Student8(val name: String) {
    //nested class
    /*
    class SchoolBag() {
        Student8 student = Student8("John")
        fun printBagOwner() {
            println("This school bag belongs to: ${student.name}")
        }
    }
    */

    //inner class
    inner class SchoolBag() {
        fun printBagOwner() {
            println("This school bag belongs to: $name")
        }
    }
}

fun main() {
    //Student8.SchoolBag().printBagOwner() // We access the nested class by using the outer class directly, without accessing the outer class object.
    // In nested class we cannot directly access the properties or functions of the outer class
    // To access outer class data members, we first need to instantiate the outer class inside the nested class and then use that object to access the outer class properties.

    // In inner class we can directly access the date members of the outer class
    Student8("John").SchoolBag().printBagOwner() // First we instantiate the outer class and then through it's object we access the inner class.
    // We can treat the inner class as a data member of the outer class.
}