/**
    - Polimorfisme (Polymorphism) terdiri dari 2 suku kata yaitu 'poly' = banyak, dan 'Morfisme' berarti bentuk,
      polimorfisme => banyak bentuk.
    - Dalam OOP, Polymorphism adalah kemampuan sebuah object berubah bentuk menjadi bentuk lain.
    - Polymorphism erat hubungannya dengan inheritance.
 */

// Superclass
open class Animal(val name: String){
    open fun printName(){
        println("Animal : ${this.name}")
    }
}

// Subclass1
class Predator(name: String) : Animal(name){
    override fun printName(){
        println("Animal (Predator) : ${this.name}")
    }
}

// Subclass2
class Mamalia(name: String) : Animal(name){
    override fun printName() {
        println("Animal (Mamalia) : ${this.name}")
    }
}

fun main(){
    // object dari Superclass
    var animal1: Animal = Animal("Tiger")
    animal1.printName()
    println("- - - - - - - - - - -")

    // Polymorphism (Perubahan bentuk object)
    animal1 = Predator("Tiger")
    animal1.printName()
    println("- - - - - - - - - - -")

    // Polymorphism (Perubahan bentuk object)
    animal1 = Mamalia("Tiger")
    animal1.printName()
    println("- - - - - - - - - - -")

}