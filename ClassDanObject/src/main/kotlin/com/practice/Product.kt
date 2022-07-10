package com.practice

import com.data.Brand

/**
    Class
    - Untuk membuat class pada Kotlin, kita dapat menggunakan keyword class.
    - Membuat class di Kotlin tidak harus sama dengan nama file seperti pada java.
    - Akan tetapi agar kodenya rapi dan mudah untuk dimengerti, disarankan untuk membuat nama class dan nama file sama,
      misal : class Product pada file Product.kt
    - Penulisan nama class biasanya menggunakan format PascalCase. Dimana diawali dengan huruf kapital, dan ketika
      dua kata maka awal kata kedua huruf kapital juga.
      contohnya : class ProductList, class Product, Class Company, class FoodProduct.
    - Pada file kotlin pun dapat membuat class didalamnya.

    Object
    - Membuat object pada kotlin, mirip seperti memanggil function, dengan menggunakan nama class yang telah dibuat.
    - Pada Kotlin, tidak butuh lagi keyword khusus untuk membuat Object, misal pada java menggunakan keyword 'new' untuk
      membuat Object.
 */

// Contoh membuat class Product
class Product{

}

fun main(){

    // membuat object di kotlin tanpa harus menggunakan keyword 'new' seperti pada java.
    // contoh ketika membuat object pada java  'Product product = new Product();'
    val dettol = Product()
    val nuvo = Product()

    // Ketika variable yang menampung object di panggil pada method println(), maka mencetak address memory
    // dari masing-masing object yang dibuat.
    println(dettol)
    println(nuvo)

    val brand1 = Brand()
    val brand2 = Brand()
    println(brand1)
    println(brand2)
}
