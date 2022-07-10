import util1.Product


/**
    - Type Alias adalah membuat nama berbeda dari tipe data yang telah ada.
    - Type Alias biasanya digunakan ketika ada class/tipe data dengan nama yang sama tapi pada package yang berbeda,
      atau untuk mempersingkat tipe data sehingga tidak perlu menulisnya terlalu panjang.
    - Kita dapat juga membuat type alias dari tipe alias yang sudah ada.

    Type Alias untuk function
    - Type Alias tidak hanya dapat digunakan untuk class, interface atau abstract class namun juga dapat digunakan untuk
      function.
    - Dengan menggunakan TypeAlias untuk function, maka kita dapat mengganti type data dari paramter function tersebut.
    - Type alias dapat juga digunakan pada lambda expression.
 */

class Application (val name: String)

// Membuat type Alias 'App' dari class Application.
typealias App = Application

// Membuat type Alias 'Ap' dari type Alias yang sudah ada 'App'
typealias Ap = App

// Membuat type Alias dari kedua class Product yang berbeda package.
typealias Product1 = Product // Class Product dari package 'util1'
typealias Product2 = util2.Product // Class Product dari package 'util2'

// Membuat type alias pada type data parameter sebuah function yang berupa lambda expression.
typealias StringSupplier = () -> String
fun sayHello(supplier: StringSupplier){
    println("Hello ${supplier()}")
}

// Membuat type alias pada type data parameter sebuah function.
typealias st = String
fun infoHardware(name: st, CPU: st, SSD: st){
    println("$name, CPU : $CPU, SSD : $SSD")
}

fun main(){
    // membuat object dari class Application
    val application1 = Application("Program A")
    println(application1.name)

    // membuat object dari type alias 'App' yang mewakili  class Application
    val application2 = App("Program B")
    println(application2.name)

    // membuat object dari type alias 'Product1' yang mewakili class Product dari package 'util1'
    val product1 = Product1("Molto")
    println(product1.name)
    product1.info()

    // membuat object dari type alias 'Product2' yang mewakili class Product dari package 'util2'
    val product2 = Product2("Downy")
    println(product2.name)
    product2.info()

    // Memanggil function yang tipe data paramternya berupa lambda expression yang digantikan menggunakan type alias.
    sayHello { "Michael" }

    // Memanggil function yang tipe data paramternya String diganti menjadi keyword 'st'.
    infoHardware("ASUS","AMD","512 GB")
}