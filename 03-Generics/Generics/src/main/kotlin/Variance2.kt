//why invariant?
open class Person3(val name: String)
class Student3(name: String): Person3(name)
class Teacher(name: String): Person3(name)

fun add(group: MutableList<Person3>, person: Person3) = group.add(person)

fun main() {
    val students: MutableList<Student3> = mutableListOf()
    val teacher: Teacher = Teacher("John")
    //add(students, teacher) //student can't be passed as MutableList is invariant
    //If it was possible then according to the add() function, we would have added a Person3(as in the function, the Teacher object is stored in a Person3 class object) object to a Student3 type mutable list.
    //Which is not possible as Student3 is a subclass of Person3 and subclass objects cannot refer to a parent class object.

    val student: Student3 = students.get(0)
}