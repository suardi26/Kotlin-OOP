/**
    - Sealed class merupakan jenis class yang didesain untuk inheritance.
    - Sealed class tidak dapat diinstansiasi menjadi object, dan secara default sealed class merupakan abstract class.
    - Sealed class sangat cocok digunakan sebagai class parent.

    Sealed class pada When Expression
    - Sealed class sangat berguna saat kita menggunakan when expression
    - Dengan menggunakan sealed class, kita dapat membatasi hanya class turunan-nya yang perlu di check menggunakan
      pengecekan when expression.
 */
package com.practice

// Membuat function untuk  melakukan pengecekan turunan dari sealed class menggunakan when expression.
fun checkDataTipe(product: Product): String {
    return when(product){
       is FoodProduct -> "Produk Makanan"
       is Beverage -> "Produk Minuman"
    }
}

fun main() {
    val aqua = Beverage("Aqua")
    println(checkDataTipe(aqua))
    println(aqua.name)

    val sariRoti = FoodProduct("Sari Roti")
    println(checkDataTipe(sariRoti))
    println(sariRoti.name)
}