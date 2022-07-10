/**
    - Pada Saat kita membuat Object, maka kita seperti memanggil sebuah function.
    - Constructor adalah sebuah function khusus yang akan dieksekusi pada saat pembuatan Object instansiasi(instance).
    - Constructor dibuat pada sebuah class Kotlin.
    - Mirip seperti di function, Constructor juga dapat ditambahkan parameter, namun pada constructor tidak ada return value-nya.
    - Berbeda di java saat membuat constructor, dapat dilakukan dengan mengambil nama class dan digunakan sebagai nama function,
      namun pada Kotlin tidak perlu menambahkan function sebagai constructor, cukup dengan menambahkan parameter pada
      class-nya.
    - Dan pada saat menambahkan constructor pada class, maka pada saat membuat object dari class tersebut harus menambahkan
      parameter-paremeter sesuai dengan yang ada pada constructor class-nya.

    Initializer Block
    - Initializer Block adalah blok code yang akan dieksekusi ketika constructor dipanggil, artinya saat object dibuat maka
      Initializer Block akan langsung dieksekusi.
    - Kita dapat memasukan code program pada initializer block.
    - Membuat Initializer Block dapat menggunakan keyword 'init' diikuti '{ block code }'.
    - Disarankan untuk memasukan code yang perlu saja pada Initializer Block, karena pada saat membuat banyak code pada
      Initializer Block maka akan lambat ketika membuat sebuah object.

    Properties Pada Primary constructor
    - Pada Primary constructor kita dapat langsung membuat properties di dalam primary constructor.
    - Karena Kotlin mendukung deklarasi properties langsung di primary constructor.
    - Ini sangat berguna ketika ingin membuat properties, dan mengisi datanya lewat constructor.
    - Jadi kita dapat mendeklarasikan attributes pada constructor.
    - Dengan menambahkan keyword 'var' atau 'val' pada parameter primary constructor maka akan secara otomatis berubah
      menjadi properties pada class tersebut.
        contoh : 'class Animals(val name: String, val food: String, val numberOfFeet: Int? = null){...}'
    - Membuat properties pada constructor hanya dapat dilakukan pada primary constructor, dan untuk secondary constructor
      tidak dapat dilakukan.

 */

// Contoh membuat constructor pada Kotlin.
class Product(idProduct: String, nameOfProduct: String, price: Int, ket: String = "Stock Ready"){

    // Membuat Initializer Block
    init {
       println("PT. Suska Pratama")
       println("Product : $nameOfProduct")
    }

    var idProduct: String = idProduct
    var nameOfProduct: String = nameOfProduct
    var price: Int? = price
    var ket: String = ket
}

// Contoh membuat constructor pada Kotlin dengan membuat properties di dalam primary constructor.
class Animals(val name: String,
              val food: String,
              val numberOfFeet: Int? = null){

}

