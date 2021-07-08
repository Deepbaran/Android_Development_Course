//Enums are set of constants which represent a set of values which form a variable
//Enum constants are objects and they are instances of Enum class
//Enums are lists of constants. When you need a predefined list of values which do represent some kind of numeric or textual data, you should use an enum.
//You should always use enums when a variable (especially a method parameter) can only take one out of a small set of possible values.
//Enums are a better option to create and use constants rather than creating String constants

enum class Metal(val symbol: String) { //Only the constructor will take the property and every constant should have the same properties albeit with different values.
    IRON("Fe"),
    GOLD("Au"),
    SILVER("Ag")
}

fun main() {
    for(metal in Metal.values()) {
        println("Symbol: ${metal.symbol}, Name: ${metal.name}, Ordinal: ${metal.ordinal}")
        //name and ordinal are the default properties provided to each constant.
        //name is the String representation of the String representation of the constant.
        //ordinal is the position of the constant in the Enum class
        //symbol is the value we wish to provide to the constant
    }
    //Symbol: Fe, Name: IRON, Ordinal: 0
    //Symbol: Au, Name: GOLD, Ordinal: 1
    //Symbol: Ag, Name: SILVER, Ordinal: 2
    printMetal(Metal.IRON)
}

fun printMetal(metal: Metal) {
    println(metal.name) //IRON
}