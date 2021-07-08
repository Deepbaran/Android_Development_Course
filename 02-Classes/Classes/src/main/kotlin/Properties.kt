// var <propertyName>[: <PropertyType>] [= <property_initializer>]
// [<getter>] <- This is called accessor
// [<setter>]

// In Kotlin each property of a class has inbuilt getters and setters that we can rewrite as per our convenience

class Student2 {
    val school: String = "DP School"
    var age: Int = 5

    val isTeenager: Boolean // When this property is accessed, the get() function is automatically called and returns the appropriate value
        get() = age > 12 // If isTeenager is accessed and if the age > 12 then true will be returned

    var name: String? = null // Initial value is null
        //        get() = name ?: "Unknown" // If name was here, then once the name property was accessed, it would call the accessor and then the name inside the accessor would again call the accessor.
//        And this would make a recursive loop. This is called recursive accessor.
//        To prevent this, Kotlin has a field called "field", which we can access instead of using the propertyName.
        get() = field ?: "Unknown" // field means the value of the property. field is called the "Backing Field". To access the value of the property, we always use the "Backing field"
        set(value) {
//            if(value != null) field = value // setting up the property value
            value?.let { field = it } // Using the scope function "let"
            // "let" makes sure that at the time of assigning value to field, the value of "value" is not null due to other threads
        }
}

fun main(args: Array<String>) {
    val student: Student2 = Student2()

    println("1. Student2 is a teenager: ${student.isTeenager}")
    student.age = 14 // This will call the setter of the age property
    println("2. Student2 is a teenager: ${student.isTeenager}")

    println("1. Student2 is a teenager: ${student.name}")
    student.name = "John"
    println("1. Student2 is a teenager: ${student.name}")

}