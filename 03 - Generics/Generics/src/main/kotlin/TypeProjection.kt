//It is not always possible to use covariance or contravariance as we might have functions that take and return type T.
//For that we use use-site variance or type projection.
//It is called, Use-site variance, because the variance is declared wherever we are using it.

class ListExample{
    //Use-site Variance / Type Projection
    fun copy(from: MutableList<out Any>, to: MutableList<Any>) { //Now from is a covariant generic type. This means that it can now receive generics of its sub type.
        for (i in from.indices) {
            to.add(from[i])
        }
    }
}

fun main() {
    val any: MutableList<Any> = mutableListOf("John", 7)
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    ListExample().copy(numbers, any)
    //We can't pass MutableList<Int> where MutableList<Any> is required as generics are invariant.
    //To make it possible, we need to make the MutableList<Any> that is going to be receiving the MutableList<Int> a covariant.
}