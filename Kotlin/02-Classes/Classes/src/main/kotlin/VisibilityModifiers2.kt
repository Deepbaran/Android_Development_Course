// default public
// It is defined in the Top Level
private fun outsideFunction() { // even though it is private, as it is declared outside of any class, so it is visible in the file
    println("This is outsideFunction")
}

// default public
var outsideProperty: String = "outside"

class Teacher {
    private var onLeave = false
    protected var parkingSlot = 1
    internal val school = "DP School" // visible inside the module (more about module in Android)
    // default public
    val name = "John"
    // default public
    fun isAvailable() = !onLeave
}

fun main() {
    println(outsideFunction())
    val teacher = Teacher()
//    println("Teacher is on leave: ${teacher.onLeave}") // onLeave is private, so it is only visible inside the Teacher class
//    println("Teacher has parking slot: ${teacher.parkingSlot}") // parkingSlot is private, so it is only visible inside the Teacher class
    println("The school is: ${teacher.school}")
    println("Teacher's name is: ${teacher.name}")
}