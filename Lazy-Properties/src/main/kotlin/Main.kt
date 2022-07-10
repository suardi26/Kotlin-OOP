/**
    - Selain delegating di class, Kotlin mendukung delegating di properties.
    - Salah satu implementasi delegating properties yang sudah disediakan oleh Kotlin adalah lazy properties.
    - Lazy adalah standar library yang telah disediakan agar properties baru diinisialisasi ketika properties itu diakses.
    - Ketika membuat sebuah properties lazy maka dapat menambahkan keyword 'by' kemudian diikuti oleh function 'lazy'
      pada properties-nya.
        contoh : 'val name: String by lazy {...}
                ket : - val name => nama properties.
                      - String => tipe data properties.
                      - by => digunakan untuk melakukan delegasi pada properties.
                      - lazy => salah satu object delegasi yaitu 'lazy'.
    - Pada ujung lambda-nya harus terdapat value yang sama dengan tipe data properties-nya sebagai return value.
    - Proses assignment dari return value lambda dari function lazy ke nilai properties hanya sekali, jika memanggil
      lagi properties tersebut, maka tidak ada lagi assignment value pada properties tersebut karena telah
      diisi pada saat pemanggilan pertama.
    - Jadi lazy properties itu seperti namanya yaitu malas, artinya properties tersebut dieksekusi/di-assignment value-nya
      ketika dipanggil.
    - Berbeda dengan properties yang 'EAGER' ketika object-nya dibuat, properties-nya langsung assignment value-nya.
      contoh : '
    - Untuk materi delegating di properties yang lengkap terdapat pada repository Kotlin-Generic.

 */

class Product {
    // membuat properties lazy dengan memanggil function lazy dengan parameter lambda
    // pada ujung lambda-nya harus terdapat value yang sama dengan tipe data properties-nya sebagai return value
    // yaitu String.
    val name: String by lazy {
        println("Pemanggilan lazy function")
        "Suardi"
    }

    // variable Eager lawan dari variable lazy.
    val category: String = "Food"
}

fun main(){
    // Membuat object dari class Product
    // Proses assignment dari return value lambda dari function lazy ke nilai properties hanya sekali, jika memanggil
    // lagi properties tersebut, maka tidak ada lagi assignment value pada properties tersebut karena telah
    // diisi pada saat pemanggilan pertama.
    val product = Product()
    println(product.name)
    println(product.name)
    println(product.name)

    println(product.category)
}