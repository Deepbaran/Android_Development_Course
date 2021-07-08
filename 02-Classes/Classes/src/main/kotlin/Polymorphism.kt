// Polymorphism, is basically an object behaving differently for the same class

open class Vehicle {
    open fun startEngine() {
        //code to start the engine
    }
}

class BMWCar(): Vehicle() {
    override fun startEngine() {
        println("BMWCar: starting the engine")
        super.startEngine()
    }
}

class AudiCar(): Vehicle() {
    override fun startEngine() {
        println("AudiCar: starting the engine")
        super.startEngine()
    }
}

fun main() {
//    val bmwCar: BMWCar = BMWCar()
//    startBmwCar(bmwCar)
//
//    val audiCar: AudiCar = AudiCar()
//    startAudiCar(audiCar)

    //More efficient way to do the above work, using polymorphism
    val bmwCar: Vehicle = BMWCar() // Vehicle is pointing to a BMWCar object and only use those properties that BMWCar inherited or overridden from Vehicle
    startVehicle(bmwCar) //BMWCar: starting the engine

    val audiCar: Vehicle = AudiCar() // Vehicle is pointing to a AudiCar object and only use those properties that AudiCar inherited or overridden from Vehicle
    startVehicle(audiCar) //AudiCar: starting the engine
}

//fun startBmwCar(car: BMWCar) {
//    //do some initial setup
//    car.startEngine()
//}
//
//fun startAudiCar(car: AudiCar) {
//    //do some initial setup
//    car.startEngine()
//}

fun startVehicle(car: Vehicle) {
    //do some initial setup
    car.startEngine() //The overridden function will be called if any
}