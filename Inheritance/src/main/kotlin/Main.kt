/**
    - Inheritance adalah proses mewariskan properties dan function dari parent class ke child class.
    - Class yang mewariskan function dan properties-nya disebut(super class, parent class, base class).
    - Class yang mewarisi function dan properties dari super class disebut (sub class, child class, derived class).
    - Pada Kotlin, tiap subclass hanya bisa mempunyai satu superclass, namun satu superclass bisa mempunyai banyak subclass.

    - Secara default, class pada kotlin adalah final (tidak dapat diwariskan), untuk dapat diwariskan pada sub class
      dapat menggunakan keyword 'open' pada super class.
    - Untuk dapat mewarisi properties dan function dari super class dapat memanggil nama superclass setelah tanda ':' (titik dua),
      dan ketika super class memiliki primary constructor maka wajib ditambahkan data constructor pada parameter-nya.
            contoh : 'class Car(brand: String, type: String, speed: Int) : Vehicle(brand, type, speed)'
    - Tanda ':' mirip keyword 'extends' pada java yang mendeklarasikan sebuah class sebagai subclass dari superclass.
 */

// Membuat super class menggunakan keyword 'open'.
open class Vehicle(val brand: String, val type: String, val speed: Int){
    fun drive(type: String){
        println("Jenis Kendaraan : $type.")
        println("$brand ${this.type} dapat melaju dengan kecepatan $speed km/j.")
    }
}

// Secara default membuat class adalah 'final' (tidak dapat diwariskan), namun keyword ini dapat ditambahkan atau tidak.
// Membuat sub class dengan memanggil nama class dari superclass serta menambahkan paramter jika terdapat primary constructor.
final class Motorcycle(brand: String, type: String, speed: Int) : Vehicle(brand, type, speed){

}

// Membuat sub class dengan memanggil nama class dari superclass serta menambahkan paramter jika terdapat primary constructor.
class Car(brand: String, type: String, speed: Int) : Vehicle(brand, type, speed){

}

fun main(){
    // Membuat object (Instance) dari class Vehicle.
    val vehicle1 = Vehicle("Toyota","Avanza",220)

    // Memanggil function 'drive' dari class Vehicle.
    vehicle1.drive("Car")

    // Membuat object (Instance) dari class Motorcycle, meskipun class Motorcycle kosong namun dengan menambahkan keywords ':'
    // dan class Vehicle, maka class Motorcycle adalah class turunan dari Vehicle, sehingga class Motorcycle dapat mewarisi
    // Properties atau function yang ada pada super classnya yaitu class Vehicle, dengan kata lain class Motorcycle dapat
    // mengakses properties atau function yang ada pada class Vehicle.
    val vehicle2 = Motorcycle("Kawasaki","ZX-25R",300)

    // Memanggil function 'drive' dari class Motorcycle yang merupakan turunan dari class Vehicle dengan object 'vehicle2'.
    vehicle2.drive("Motorcycle")

    // Membuat object (Instance) dari class Car, meskipun class Car kosong namun dengan menambahkan keywords ':'
    // dan class Vehicle, maka class Car adalah class turunan dari Vehicle, sehingga class Car dapat mewarisi
    // Properties atau function yang ada pada super classnya yaitu class Vehicle, dengan kata lain class Car dapat
    // mengakses properties atau function yang ada pada class Vehicle.
    val vehicle3 = Car("Mercedenz-Benz","MC-1000",980)

    // Memanggil function 'drive' dari class Car yang merupakan turunan dari class Vehicle dengan object 'vehicle3'.
    vehicle3.drive("Supercar")
}