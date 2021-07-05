//When a Generic Class of Parent type can be substituted by a Generic class of it's sub type.
//It means that a Generic class of parent type can be replaced by a Generic class of sub type

open class Fruit
class Apple: Fruit()

//class Box<T> {
//    fun get(): T{TODO("Return item of type T")}
//}

//declaration-site variance | Generic Covariant
class Box<out T> {
    //The "out" modifier will make the class a covariant and this type of variance is called declaration-site variance as we are applying the variance at the declaration of he class.
    //For this class to be a covariant, there is a condition:
    //Any function inside this class can only return a value of T but we cannot have a function which takes a parameter of type T.
    //That's why we can also say that Box class is a producer of type T instead of a consumer of type T.
    fun get(): T{TODO("Return item of type T")}
}

fun main() {
    val appleBox = Box<Apple>()
    val box: Box<Fruit> = appleBox
    //Generic class of parent type (Fruit) is being replaced by a generic class of sub type (Apple).
    // That means the Generic class object of type Fruit is pointing towards a Generic class object of type Apple instead of a Generic class object of type Fruit.
    //This is not generally possible as Generic types are invariants.
    //So, we cannot store a Generic of type of the sub class to a Generic of type of the super class.
    //We can make a Generic covariant to overcome this problem.
}