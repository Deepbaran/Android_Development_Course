open class Fruit4
class Apple4: Fruit4()

//Why in only?
//declaration-site variance
class Box4<in T> {
    fun put(item: T) {}
    //fun get(): T {TODO("return item of type T")}
}

fun main() {
    val fruitBox = Box4<Fruit4>()

    val appleBox: Box4<Apple4> = fruitBox

    //val apple: Apple = appleBox.get() //returns a fruit while an apple is required. which is not possible
    //We cannot store a parent type to a sub type.
    //That's why, returning T in contravariant is not allowed. As it breaks the type safety.
}