/**
  - Keyword 'this' digunakan untuk referensi dari class itu sendiri.
  - Keyword 'this' hanya dapat digunakan di dalam class itu sendiri.
  - Keyword 'this' digunakan untuk memanggil properties atau function pada class itu sendiri sehingga pada saat properties
    sebuah class memiliki nama yang sama dengan parameter suatu function (varible shadowing) dapat diatasi.
 -  Keyword 'this' bisa juga diartikan object pada saat ini.
 */
class Product(val name: String){
    // Penggunaan keyword 'this' dapat membedakan antara 'name' sebagai attribute dan name sebagai parameter suatu function
    // dimana keyword 'this' mereferensikan properties suatu class.
    fun inputStock(name: String, qty: Int): Unit{
        println("${this.name}, stock in $qty, Supervisor : $name")
    }

    fun stock(qty: Int): Unit{
        this.inputStock("Admin",qty)
    }
}

fun main() {
    val bogasari = Product("Bogasari")
    bogasari.inputStock(name = "Admin2",20)

    val segitigaBiru = Product("Segitiga Biru")
    segitigaBiru.stock(qty = 10)
}