// Anonymous classes are very popular with event listeners. Where we just have to override one or two functions (like "onClick" or "keyPress")
// With Anonymous class, we do not need to create a separate class just to override some data members of another class

open class Person3{
    fun walk() {
        println("Person is walking")
    }
    fun sleep(){
        println("Person is sleeping")
    }
    open fun talk(){
        println("Person is talking")
    }
}
fun main() {
    startTalking(object: Person3() { //Rather than creating a whole class and overriding the Person3 class by inheriting it, we are creating an object of a anonymous class and then overriding and then passing.
        //"object" is the object of the anonymous class. It is anonymous class object
        //": Person()" is showing that the anonymous class is inheriting the Person3 class
        override fun talk() { //overriding the talk() function in Person3
            println("I am talking")
        }
    })
}

fun startTalking(person: Person3) { //The anonymous class is a child class of Person3. So, Person3 can point to the Anonymous class object
    //code to setup the speaker
    person.talk()
}