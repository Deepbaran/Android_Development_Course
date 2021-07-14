open class Person2(val name: String)
class Student2(name: String): Person2(name)

fun main() {
    val names: List<String> = listOf("John", "Sarah", "Mark")
    val ranks: List<Int> = listOf(3, 5, 6)

    val student: Student2 = Student2("John")
    val person: Person2 = student //It is possible because we can subtype a less complex type (As Student2 and Person2 both are not generics)

    //val students: MutableList<Student2> = mutableListOf(Student2("Jack"), Student2("Sarah")) //students is a more complex type of Student2 (students is a generic of type Student2)
    //val persons: MutableList<Person2> = students //This gives error, because it is not possible to sub type complex type
    //In other words, MutableList<Person2> is not a super type of MutableList<Student2>

    //In Kotlin, Complex Types or Generic Classes or Generic Types or generics and MutableList are invariants. Which means, they do not support Polymorphism.
    //It means that there is no subtyping in between Generics
}

/*
VARIANCE SUMMARY:
Dog (sub type) --> Animal (parent type)

Invariant: (Default)
MutableList<Animal> =X= MutableList<DOG>
MutableList<Dog> =X= MutableList<Animal>

Covariant: (Using the "out" modifier)
MutableList<Animal> = MutableList<DOG>
MutableList<Dog> =X= MutableList<Animal>

Contravariant: (Using the "in" modifier)
MutableList<Animal> =X= MutableList<DOG>
MutableList<Dog> = MutableList<Animal>

The above relation is valid for any Generic Class
 */