//We can constrain the type that can be passed to a generic using upperbound
//<T> means the upperbound is Any by default.
//nullable Any (Any?) is at the top hierarchy, after that is Any
//To pass a nullable, we need to set upperbound as Any?

import java.io.Serializable

//For single upperbound
//fun <T: Number> printPrice(price: T) { //T is constrained to only type Number or sub type of a Number now. We did this using the upperbound (<T: upperbound>)
//    println("The price is: $price")
//}

//For multiple upperbounds
fun <T> printPrice(price: T) where T:Number, T:Serializable { //To accept a nullable in generic with upperbound, we need to set <T: Any?>
    println("The price is: $price")
}

fun main() {
    printPrice<Int>(23) //Int is a sub type of Number
    printPrice<Double>(24.5) //Double is a sub type of Number

//    printPrice<String>("John")

    //val price: Int? = null
    //printPrice<Int?>(price) //Int? is not a sub type of Number
}