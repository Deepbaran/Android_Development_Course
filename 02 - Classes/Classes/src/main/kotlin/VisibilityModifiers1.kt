class Student4 private constructor(val name: String="Mark") { // Primary Constructor is private. So, we cannot access it directly anymore to create an object
    constructor(firstName: String, lastName: String): this("$firstName $lastName")
}

fun main() {
//    val student: Student4 = Student4("John") // Primary Constructor is called but as the primary constructor is private, so it will give error
    val student1: Student4 = Student4("John", "Doe") // Secondary Constructor is called
}

/*
Visibility Modifier --> Class Level --> Top Level
1. public (default) --> Visible everywhere --> Visible everywhere
2. internal --> Visible in a module --> Visible in a module [module has a different meaning for Android]
3. protected -> Visible inside the class and subclass --> N/A
4. private --> Visible inside the class --> Visible inside the file
 */