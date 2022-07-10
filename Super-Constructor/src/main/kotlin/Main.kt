/**
    - Keyword super tidak hanya dapat digunakan untuk mengakses function dan properties pada superclass.
    - Keyword super juga dapat digunakan untuk mengakses constructor superclass.
    - Mirip seperti di java, Mengakses constructor superclass pada kotlin hanya dapat dilakukan di dalam constructor subclass-nya.
    - Untuk memanggil constructor superclass dapat dengan menambahkan ':' setelah deklarasi secondary constructor-nya diikuti
      keyword 'super' setelah itu dapat memanggil constructor yang sesuai dengan jumlah parameter/ tipe data tiap paramter yang
      ada pada superclass-nya. contoh :  'constructor(name: String) : super(name = name, wheel = 4)'

    - Ketika menambahkan primary constructor pada subclass maka ketika deklarasi superclass-nya dengan tanda ':'
      maka wajib menambahkan data constructor-nya dengan mengisi parameter-nya. contoh :
        - Menambahkan primary constructor pada subclass : 'class Motorcycle(name: String, type: String): Kendaraan(name,2,type)'
        - Tanpa menambahkan primary constructor pada subclass : 'class Car: Kendaraan'
    - Dan ketika menambahkan primary constructor maka kita tidak dapat lagi memanggil constructor dari superclass-nya
      karena dengan menggunakan primary constructor pada subclass secara otomatis akan menggunakan keyword this pada
      secandary constructor untuk memanggil primary constructor-nya.
 */

open class Vehicle(val name: String, val wheel: Int, val type: String){
    constructor(name: String, wheel: Int): this(name, wheel, "")
    constructor(name: String): this(name,0)
}

// Membuat sub class dengan menambahkan primary constructor, maka tidak dapat memanggil constructor superclass
// karena pada secondary constructor di subclass harus memanggil primary constructor dengan keyword this.
class Motorcycle(name: String, type: String): Vehicle(name,2,type){
    constructor(name: String): this(name, "-")
}

// Membuat sub class tanpa menambahkan primary constructor dengan begitu maka dapat memanggil constructor dari superclass
// dengan menambahkan keyword 'super'
class Car: Vehicle{
    constructor(name: String) : super(name = name, wheel = 4)
    constructor(name: String, type: String) : super(name, 4, type)
    constructor(): this("Car")
}

fun main() {

    val vehicle = Vehicle("Kendaraan")
    println("${vehicle.name}, type : ${vehicle.type}, wheel : ${vehicle.wheel}")

    val supra = Motorcycle("Honda", "Suprax")
    println("${supra.name}, type : ${supra.type}, wheel : ${supra.wheel}")

    var pajero = Car("Pajero","Dakar 4x4")
    println("${pajero.name}, type : ${pajero.type}, wheel : ${pajero.wheel}")
}
