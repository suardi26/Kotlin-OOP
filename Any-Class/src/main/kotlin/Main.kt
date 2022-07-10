/**
   - Pada kotlin, semua class yang kita buat tanpa menambahkan superclass, maka secara ototamtis class tersebut menjadi
     subclass dari class 'Any'.
   - Jadi, 'Any' adalah superclass untuk semua class yang kita buat di Kotlin, misalnya subclass extends ':' superclass
     maka superclass yang extends ':' Class 'Any'.
   - Class Any mirip seperti class Object di Java.
   - Class Any memiliki beberapa function seperti :
        - equals(Any?): Boolean
        - hashCode(): Int
        - toString(): String
     Jadi setiap class pada kotlin memiliki function tersebut.

 */
class Product(val name: String) : Any() // => secara default Class Product : Any()
open class Customer(val name: String)   // => secara default Class Customer : Any()

// Meskipun class 'PremiumCustomer' tidak extends ':' Class Any, namun superclass-nya yaitu Customer secara default
// memiliki superclass Any, maka dari itu disimpulkan class Any adalah superclass untuk semua class di kotlin.
class PremiumCustomer(name: String, val status: String) : Customer(name)

fun main() {
    val product1 = Product("Bimoli")

    // object yang di instance dari class Product dapat menggunakan salah satu function dari class Any 'toString'.
    // function dari 'toString' berfungsi untuk menampilkan representasi String dari sebuah object.
    // ketika function 'toString' digunakan pada sebuah object dari suatu class maka akan menampilkan address memory
    // dimana object tersebut disimpan.
    println(product1.toString())

    // object yang di instance dari class Product dapat menggunakan salah satu function dari class Any 'hashCode'.
    // method 'HashCode' adalah method representasi integer suatu object. mirip dengan toString() yang merupakan representasi String,
    // hashCode adalah representasi integer. hashCode digunakan untuk mendapatkan identitas unique suatu object.
    println(product1.hashCode())
}

