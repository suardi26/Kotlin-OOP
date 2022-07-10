// Contoh inheritance 2
// Membuat super class menggunakan keyword 'open'.
open class Product {
    // properties
    var name: String = ""
    var price: Int = 0


    fun ket(name: String, price: Int){
        this.name = name
        this.price = price
        println("Nama Product : ${this.name}, Harga barang : ${this.price}")
    }
}

class Food : Product()

fun main(){
    // Membuat object (Instance) dari class Product,
    val aqua = Product()

    // Memanggil function 'ket' dari class Product.
    aqua.ket("Aqua",5000)

    // Membuat object (Instance) dari class Food, meskipun class Food kosong namun dengan menambahkan keywords ':'
    // dan class Product, maka class Food adalah class turunan dari Product, sehingga class Food dapat mewarisi
    // Properties atau function yang ada pada super classnya yaitu class Product, dengan kata lain class Food dapat
    // mengakses properties atau function yang ada pada class Product.
    val indomie = Product()

    // Memanggil function 'ket' dari class Food yang merupakan turunan dari class Product dengan object 'indomie'.
    indomie.ket("Indomie",3000)

}