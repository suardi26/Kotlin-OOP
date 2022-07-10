/**
    - Function Overriding adalah Proses membuat ulang function yang diwariskan oleh super class, sehingga function tersebut
      dapat digunakan oleh sub class dengan lebih spesifik sesuai dengan kebutuhan dari sub class itu sendiri.
    - Secara default, function pada class di kotlin adalah final, sehingga tidak dapat dibuat ulang pada sub class.
    - Untuk dapat membuat ulang function pada subclass, kita harus menggunakan keyword 'open'.
    - Dan ketika mendeklarasikan ulang function yang ada pada superclass di subclass dapat menggunakan keyword
      'override' diikuti keyword 'fun' dan nama function yang sama pada superclass-nya.
    - Menambahkan keyword 'open' pada function berarti function tersebut dapat dideklarasikan ulang pada subclass-nya.
    - Pembuatan function Overriding dilakukan dengan menulis nama function yang sama pada nama function yang ada pada super class.
      Sehingga function pada superclass ditimpa dengan fucntion overridding yang ada pada sub class.
    - Syarat Membuat function Overriding adalah nama function-nya harus sama dengan function yang ada pada superclass-nya,
      serta return value, jumlah paramternya serta tipe data setiap paramternya harus sama persis dengan function
      di superclass-nya dan yang boleh dibedakan cuma body/isi dari function-nya.

    Final Override function
    - Pada saat membuat ulang function pada subclass, secara default, function tersebut bersifat 'open', artinya function yang
      telah di override pada subclass dapat dibuat ulang pada subclass dibawah-nya lagi.
    - Jika ingin membuat function yang telah di-override tidak bisa di-override lagi oleh sub-class dibawahnya, kita dapat
      menggunakan keyword 'final'.

 */

// Membuat super class menggunakan keyword 'open'.
open class Vehicle(val brand: String, val type: String, val speed: Int){

    // Secara default function adalah 'final' (function tidak dapat dibuat ulang pada sub class)
    // jadi dapat menggunakan keyword final ataupun tidak, ketika function tidak ingin di overriding.
    final fun drive(type: String){
        println("Jenis Kendaraan : $type.")
        println("$brand ${this.type} dapat melaju dengan kecepatan $speed km/j.")
    }

    // Membuat function yang dapat di override pada subclass-nya.
    open fun move(wheel: Int){
        println("Jumlah roda = $wheel")
    }
}

// Secara default membuat class adalah 'final' (tidak dapat diwariskan), namun keyword ini dapat ditambahkan atau tidak.
// Membuat sub class dengan memanggil nama class dari superclass serta menambahkan paramter jika terdapat primary constructor.
open class Motorcycle(brand: String, type: String, speed: Int) : Vehicle(brand, type, speed){

    // Membuat function overriding 'move', dari super class Vehicle.
    // Function yang telah di-overriding bersifat 'open' sehingga dapat dibuat ulang pada subclass dibawah-nya lagi.
    // Ketika ingin membuat function yang telah di-override tidak bisa di-override lagi oleh sub-class dibawahnya, maka dapat
    // menggunakan keyword 'final' contoh 'final override fun move(wheel: Int){ } '.
    override fun move(wheel: Int) {
        println("${this.brand} bergerak menggunakan $wheel Roda.")
    }
}

// Secara default membuat class adalah 'final' (tidak dapat diwariskan), namun keyword ini dapat ditambahkan atau tidak.
// Membuat sub class dengan memanggil nama class dari superclass serta menambahkan paramter jika terdapat primary constructor.
open class Scooter(brand: String, type: String, speed: Int) : Motorcycle(brand, type, speed){

    // Membuat function overriding 'move', dari super class Motorcycle, dimana function 'move' pada class motorcycle
    // tanpa keyword 'open' dikarenakan secara default function yang telah di override bersifat 'open' sehingga dapat
    // dibuat ulang pada subclass dibawah-nya lagi.
    override fun move(wheel: Int) {
        println("Motor Scooter ${this.brand} bergerak menggunakan $wheel Roda.")
    }
}



fun main(){
    // Membuat object (Instance) dari Class Vehicle, dan mengisi nilai variabel 'brand', 'type', 'speed' dari class Vehicle.
    val vehicle1 = Vehicle("Toyota", "Rush", 210)

    // Memanggil function 'move' dari class Vehicle dengan object 'vehicle1'.
    vehicle1.move(4)

    // Membuat object (Instance) dari Class Motorcycle.
    val vehicle2 = Motorcycle("SupraX","125", 150)

    // Memanggil function overriding 'move' dari class Motorcycle yang merupakan turunan dari class Vehicle
    // dengan object 'vehicle2'.
    vehicle2.move(2)

    // Membuat object (instance) dari Class Scooter
    val vehicle3 = Scooter("Beat", "Stylish",110)

    // Memanggil function overriding 'move' dari class Scooter yang merupakan turunan dari class Motorcycle.
    vehicle3.move(2)
}