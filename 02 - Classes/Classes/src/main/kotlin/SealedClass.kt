//Sealed classes are used to represent a restricted class hierarchy. Which means, we know how many sub classes are going to be there for a particular class.
// There can be multiple instances of sealed subclasses
//The subclasses can have their own properties
//Difference between Sealed Class and Enums:
//1. Sealed class can have it's own properties. In case of Enum, only the constructor takes the property.
//2. In Enum, every constant have same properties, albeit different values. But in Sealed Classes, all the sub classes can have different properties.
//3. We can have multiple instances of the sub classes, in case of Sealed class. It is not possible in case of Enum, because those objects are constants in Enum class

sealed class NetworkState {
    //As NetworkState is a sealed class, so all the sub classes will be in here
    data class Error(val errorText: String): NetworkState()
    object Loading: NetworkState()
    data class Loaded(val content: String): NetworkState()
}

fun main() {
    val data: NetworkState = NetworkState.Loaded("Data loaded") //Loaded is a nested as well as a sub class of NetworkState Class. So, we are creating a Loaded class object and storing it inside a NetworkState class object.
    processState(data)
}

fun processState(state: NetworkState) {
    when (state) {
        //Full Statement is "when state is NetworkState.**** -> {Execute}"
        //Here we are checking, is state and NetworkState.Error same? If it is same then it will be executed.
        is NetworkState.Error -> {println("Error occurred: ${state.errorText}")}
        //Here we are checking, is state and NetworkState.Loading same? If it is same then it will be executed.
        is NetworkState.Loading -> {/* show progressbar */}
        //Here we are checking, is state and NetworkState.Loaded same? If it is same then it will be executed.
        is NetworkState.Loaded -> {println("Content: ${state.content}")}
        //No need for else as all cases are covered
    }
}
