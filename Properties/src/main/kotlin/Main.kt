/**
    - Class menampung function/method dan variabel/atribute/properties
      yang digunakan untuk membuat object.
    - Properties/Fields/Attributes Adalah sebuah variable dari class yang dapat menampung data-data pada saat membuat object.
    - Sebelum dapat memasukan data pada properties, kita harus mendeklarasikan properties/data apa saja yang dimiliki object
      tersebut di dalam deklarasi class-nya.
    - Membuat Properties sama seperti membuat variable, bisa mutable atau immutable.

    Manipulasi Properties
    - Properties yang ada diobject, dapat kita manipulasi, tergantung mutable atau immutable.
    - Jika mutable, berarti kita dapat mengubah data pada properties-nya, namun jika immutable, kita hanya bisa mengambil data
      dari properties-nya saja.
    - Untuk mengakses properties, kita butuh tanda '.' (titik) setelah nama object dan diikuti nama properties-nya.
 */

class Product{
    val company = "PT. SUSKA JAYA PRATAMA"
    var nameOfProduct: String = ""
    var price: Int = 0
    var ket: String? = null // 'String?' => nilainya bisa null.
}

fun main(){
    var dettol = Product()
    dettol.nameOfProduct = "Dettol"
    dettol.price = 12_000
    dettol.ket = "Sabun Mandi"

    println(dettol.company)
    println(dettol.nameOfProduct)
    println(dettol.price)
    println(dettol.ket)
}