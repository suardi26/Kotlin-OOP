// Membuat superclass Location yang abstract
abstract class Location() {
    abstract val name: String
    abstract val postalcode: Int
    abstract fun printLocation(): Unit
    abstract fun getPostalCode(): Int

}