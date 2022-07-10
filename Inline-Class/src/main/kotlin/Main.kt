/**
    - Kadang kita hanya ingin membuat class yang sederhana, misal dengan satu properties saja.
    - Terlalu banyak class akan ada konsekuensinya, yaitu memakan konsumsi memory yang lebih banyak ketika
      program kita berjalan.
    - Kotlin memiliki kemampuan untuk mengubah class menjadi inline dengan menggunakan keyword 'inline'.
    - Membuat class menjadi inline syaratnya properties-nya harus cuma satu tidak boleh kurang dari satu atau lebih
      dari satu.
    - Perbedaan inline class dengan class biasa yaitu terletak pada binary code yang merupakan hasil dari compilasi
      source code kotlin-nya, pada inline class setelah di-compile maka tidak akan membuat object dari inline class
      tersebut melainkan hanya membuat object dari tipe data constructor-nya, misalnya tipe dato String maka yang dibuat
      hanyalah value dari data String tersebut sehingga ketika dijalankan program-nya lebih hemat memory dibanding
      class biasa.
 */

// Membuat inline class
 inline class Product(val name: String){

     fun toUpper(): String = this.name.uppercase()
 }

fun main(){
    // Membuat object dari inline class.
    val product1 = Product("Beng-Beng")
    println(product1.name)
    println(product1.toUpper())
}
