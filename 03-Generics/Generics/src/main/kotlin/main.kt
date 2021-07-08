//type decides, what values a variable can hold and what actions we can perform on that variable
//Other than system types (like reference types, such as Int, Boolean, Double, etc.), we also have user-defined types
//When we create a class or interface, a type is also created corresponding to it.
//For every class or interface in Kotlin, there are two types create. One is non nullable and the other is nullable.

open class Person1(val name: String)

class Student1(name: String): Person1(name)

fun main() {
    //type
    val age: Int = 22 //type Int
    val rollNumber: Int? = 4 //type nullable Int

    //subtype
    val student: Student1 = Student1("John") //type Student. Student type is a sub type of Person type as Student is a sub class of Person
    val person: Person1 = student //type Person. A type can refer to the sub type.

    //corresponding non nullable type are subtype of nullable type. String is a sub type of String?. But the opposite is not true.
    val x: String = "John" //type non nullable String
    val y: String? = x //type nullable String
}

/*
Which of the following lines prompts an error, and why?

1. open class Person(val name:String){}
2. class Student(name:String?, val
    standard:String):Person(name?: "ABC"){} //Line 2 will not give an error as the elvis operator allows Student's name to call the constructor of the Person class.
3. fun main(){
4. val person = Student(name="Karan",standard = "VIII")
5.     val student:Student = person
6.     val any = Person("ABC")
7.     val student2 = any
8. }

Ans: No Error
 */