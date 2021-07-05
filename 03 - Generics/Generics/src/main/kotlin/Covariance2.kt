//why return only?
open class Fruit2
class Apple2: Fruit2()
class Orange: Fruit2()

//declaration-site variance
class Box2<out T> {
    fun get(): T {TODO("Return item of type T")}
    //fun put(item: T){} //violates type safety
}

fun main() {
    val appleBox = Box2<Apple2>()
    val fruitBox: Box2<Fruit2> = appleBox
    //fruitBox.put(Orange())
    //If Box was allowed to consume a type T, we would be able to put an orange in a box of apple.
    //Which should be impossible.
    //It is a violation of type safety.
    //That's why consuming type T in Box is not allowed.
}