//Contravariance are opposite of covariance.
//It means that a Generic class of sub type can be replaced by a Generic class of parent type

open class Fruit3
class Apple3: Fruit3()

//declaration-site variance
class Box3<in T> {
    //By putting a "in" modifier before T, we made the Box3 a contravariant.
    //Condition: All the functions inside the class Box3 can only consume T.
    //We can't have a function that returns T. We can only have functions that takes T as a parameter.
    //That's why Box3 is called consumer of T.
    fun put(item: T) {}
}

fun main() {
    val fruitBox = Box3<Fruit3>()

    val appleBox: Box3<Apple3> = fruitBox
    //Generic class of sub type (Apple3) is being replaced by a generic class of parent type (Fruit3).
    // That means the Generic class object of type Apple3 is pointing towards a Generic class object of type Fruit3 instead of a Generic class object of type Apple3.
    //This is opposite of covariant.
    //This is not generally possible as Generics are invariant.
    //To do this, we need to make Box3 a contravariant.
}