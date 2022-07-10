/**
    - Pada Object Oriented Programming, terdapat banyak sekali tipe data (class) dan pewarisan (inheritance)
    - Kadang kita butuh melakukan pengecekan tipe data, atau bahkan melakukan konversi tipe data.

    Operator is dan !is
    - is digunakan untuk melakukan pengecekan apakah sebuah data merupakan tipe data tertentu.
    - !is digunakan untuk melakukan pengecekan apakah sebuah data bukan merupakan tipe data tertentu.

    Smart Casts (Kotlin)
    - Kotlin memiliki mekanisme konversi data secara otomatis setelah melakukan pengecekan menggunakan operator is.
    - Setelah melakukan pengecekan menggunakan operator is, maka secara otomatis tipe data yang dicek akan berubah
      menjadi tipe data yang kita check.

    Casts pada When Expression
    - Selain menggunakan If untuk melakukan pengecekan tipe data dan konversi tipe data, kita juga dapat menggunakan
      when expression untuk melakukan pengecekan tipe data dan konversi tipe data.
    - Penggunaan when expression akan lebih sederhana dibanding if expression dalam melakukan pengecekan dan konversi tipe
      data.

    Unsafe Casts
    - Kotlin juga mendukung konversi tipe data secara paksa menggunakan keyword 'as'.
    - Namun konversi menggunakan 'as' sangat tidak aman, dikarenakan jika ternyata tipe datanya tidak sesuai maka akan
      error ClassCastException.

    Safe Nullable Casts
    - Penggunaan keyword 'as' sangat tidak aman, namun kadang dapat menjadikan-nya aman , dengan keyword 'as?'.
    - Dengan menggunakan keyword 'as?' secara otomatis jika gagal melakukan konversi, akan diubah menjadi null(kosong).
 */

// membuat function dengan paramter any dengan tipe data Any artinya dapat menampung object apapun, karena class Any
// merupakan superclass dari semua class yang ada pada kotlin.
fun printObject(any: Any){

   // Casts data type (If expression).
   if(any is Product){

       // Ketika data 'any' merupakan turunan dari superclass Any dan bertipe data Product, maka block code ini akan
       // dieksekusi.

       // Dan setelah dilakukan pengecekan menggunakan operator 'is' dan kondisi bernilai true maka kotlin
       // secara otomatis melakukan Smart Casts artinya object any dengan tipe data Any berubah menjadi tipe data Product
       println("Product : ${any.name}")

   }else if (any is Customer){

       // Ketika data 'any' merupakan turunan dari superclass Any dan bertipe data Customer, maka block code ini akan
       // dieksekusi
       // Dan setelah dilakukan pengecekan menggunakan operator 'is' dan kondisi bernilai true maka kotlin
       // secara otomatis melakukan Smart Casts artinya object any dengan tipe data Any berubah menjadi tipe data Customer.
       println("Customer : ${any.name}")


   }else{

       // Ketika kedua kondisi diatas salah maka block code ini akan dieksekusi.
       println(any)
   }

}

// membuat function dengan paramter any dengan tipe data Any artinya dapat menampung object apapun, karena class Any
// merupakan superclass dari semua class yang ada pada kotlin.
fun printObjectUseWhen(any: Any) {
    // Casts data type (When expression).
    when (any){

        is Product -> {
            // Ketika data 'any' merupakan turunan dari superclass Any dan bertipe data Product, maka block code ini akan
            // dieksekusi.

            // Dan setelah dilakukan pengecekan menggunakan operator 'is' dan kondisi bernilai true maka kotlin
            // secara otomatis melakukan Smart Casts artinya object any dengan tipe data Any berubah menjadi tipe data Product
            println("Product : ${any.name}")
        }

        is Customer -> {
            // Ketika data 'any' merupakan turunan dari superclass Any dan bertipe data Customer, maka block code ini akan
            // dieksekusi
            // Dan setelah dilakukan pengecekan menggunakan operator 'is' dan kondisi bernilai true maka kotlin
            // secara otomatis melakukan Smart Casts artinya object any dengan tipe data Any berubah menjadi tipe data Customer.
            println("Customer : ${any.name}")
        }

        else -> {
            // Ketika kedua kondisi diatas salah maka block code ini akan dieksekusi.
            println(any)
        }
    }
}

// membuat function dengan paramter any dengan tipe data Any artinya dapat menampung object apapun, karena class Any
// merupakan superclass dari semua class yang ada pada kotlin.
fun printDataString(any: Any){
    // konversi tipe data secara paksa menggunakan keyword 'as'.
    val value = any as String
    println(value)
}

// membuat function dengan paramter any dengan tipe data Any artinya dapat menampung object apapun, karena class Any
// merupakan superclass dari semua class yang ada pada kotlin.
fun printDataStringSafeNullableCasts(any: Any){
    // Konversi tipe data dengan menggunakan keyword 'as?', secara otomatis jika gagal melakukan konversi ke tipe data tertentu,
    // akan diubah menjadi null(kosong).
    val value: String? = any as? String
    println(value)
}

fun main(){
    printObject("Suardi") // Memasukan data/object String bisa.
    printObject(1) // Memasukan data/object Int bisa juga.
    printObject(Product("Baygon")) // Memasukan data/object dari class yang dibuat 'Product'
    printObject(Customer("Abraham")) // Memasukank data/object dari class yang dibuat 'Customer'

    println("= = = = = = = = = = =")

    printObjectUseWhen("Daud") // Memasukan data/object String bisa.
    printObjectUseWhen(2) // Memasukan data/object Int bisa juga.
    printObjectUseWhen(Product("Daia")) // Memasukan data/object dari class yang dibuat 'Product'.
    printObjectUseWhen(Customer("Kevin")) // Memasukan data/object dari class yang dibuat 'Customer'.

    println("= = = = = = = = = = =")

    printDataString("Dede") // Success karena data/object yang dimasukan bertipe String.
    //printDataString(5) // Error ClassCastException karena data/object yang dimasukan bertipe Int bukan String.

    println("= = = = = = = = = = =")

    printDataStringSafeNullableCasts("Esquel") // Success karena data/object yang dimasukan bertipe String.
    printDataStringSafeNullableCasts(5) // null, karena data/object yang dimasukan bertipe Int bukan String.
}