/**
    - Selain Properties/Atributes/Fields, kita juga dapat menambahkan Function/method/behavior pada sebuah class.
    - Function yang kita deklarasikan pada Class, secara otomatis menjadi behavior dari object yang dibuat dari class tersebut.
    - Dan object yang dibuat dari sebuah class dapat menggunakan function yang telah dibuat dari class tersebut.
    - Function/Method/Behavior adalah kumpulan baris kode yang dikelompokkan untuk menjalankan tugas tertentu.
    - Sebuah function dapat mengembalikan nilai tertentu (memiliki return value), bisa juga tidak (Unit).
    - Parameter adalah sebutan untuk nilai inputan function pada saat function itu didefinisikan. pada saat method dipanggil
      dan informasi (argument) telah diisi maka argument tersebut nantinya akan di tampung  pada parameter.
 */

class Cars(val company: String){

    // Menambahkan function tanpa parameter (Unit) pada sebuah class.
    fun nameOfCars(name: String): Unit{
        println("Car : $name")
    }

    // Menambahkan function dengan parameter (String) pada sebuah class.
    fun getCompanyName(): String{
        return this.company
    }
}

fun main() {
    // Membuat object dari class Cars.
    val toyota = Cars(company = "PT. Suska Jaya Pratama")

    // Memanggil function dengan parameter (String) dari class Cars menggunakan object 'toyota'.
    val companyName = toyota.getCompanyName()
    println(companyName)

    // Memanggil function tanpa parameter (Unit) dari class Cars menggunakan object 'toyota'.
    toyota.nameOfCars("Toyota")
}