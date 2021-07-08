//Singleton are objects which can have only one instance.
//Singletons are useful to hold utility functions or properties which can be used by the instances of the different classes or the same class.
//Singletons are declared using the object keyword and Singletons can't have constructors.
//Singletons can be held inside another class and they are called Companion objects.

//Singleton Class
object GameScore{
    var score: Int = 0 //Singleton class's properties cannot be directly changed. They must be changed through a function
        private set //Can't set the value directly from outside of the class

    fun addScore(point: Int) {
        if(point > 0) {
            this.score += point
        }
    }
}

class Student10(val name: String) {
    //companion class (Singleton class inside another class)
//    object School{
//        const val schoolName = "DP School"
//    }

    //companion object
    companion object {
        const val schoolName = "DP School"
    }
}

fun main() {
    GameScore.addScore(10) //The Single instance of a singleton class is named after the class. So, GameScore here is the only instance of the GameScore Singleton Class.
    println("The score is ${GameScore.score}") //The score is 10

    //The singleton class inside another class, also known as Companion class, is treated as a Nested class.
    //So, here we are accessing the only instance of the School Singleton class/Companion Class just like we access a nested class.
    //School is the only instance of the School Companion Class.
//    println("The score is ${Student10.School.schoolName}") //The score is DP School

    //OuterClassName.CompanionClassInstance.property
    //It is a very lengthy way to access the companion class.
    //A better way to do it is by using the companion object.
    //By using companion object, we act like the properties of the companion object belongs to the outer class itself.
    //OuterClassName.companionObjectPropertyName
    println("The score is ${Student10.schoolName}") //The score is DP School
}