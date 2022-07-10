/**
    - Secara default, properties pada Kotlin wajib di inisialisasi di awal saat deklarasi properties tersebut.
    - Namun, pada kotlin kita juga dapat menunda inisialisasi data properties.
    - Dengan menggunakan keyword 'lateinit', kita dapat membuat properties tanpa harus langsung mengisi datanya.
        contoh : 'lateinit var name: String'
    - Keyword 'lateinit' hanya dapat digunakan pada data mutable 'var', tidak bisa pada data imutable 'val'.
    - Ketika menambahkan keyword 'lateinit' pada properties, maka properties tersebut tidak bisa di inisialisasi valuenya
      pada saat deklarasi properties tersebut. contoh : 'lateinit var name: String = "Dettol"' Error
 */

class Product{
    lateinit var name: String

    fun initName(name: String){
        this.name = name
    }
}

fun main(){

    // Mengakses lateinit properties
    val product1 = Product()

    // Error : karena belum meng-inisialisasi value dari properties name.
    //println(product1.name)

    // Memanggil function initName, maka menginisialisasi value dari properties name.
    product1.initName("Beng-Beng")

    // Succes, karena telah menginisialisasi value dari properties name.
    println(product1.name)

    // Bisa juga tanpa memanggil function initName, dengan mengisi langsung data properties dengan function Getter.
    val product2 = Product()
    product2.name = "Taro"
    println(product2.name) // Success, karena terlebih dulu melakukan inisialisasi data properties dengan function Getter.
}