import kotlin.properties.Delegates

/**
    - Setelah lazy properties, implementasi delegating properties selanjutnya adalah observable properties.
    - Salah satu standar library yang disediakan oleh Kotlin untuk delegating di properties adalah observable
      properties.
    - Dengan observable properties, kita dapat mengetahui perubahan dari value properties sebelum dan sesudah diubah.
    - Ketika ingin men-delegating properties maka properties tersebut harus mutable 'var' artinya dapat diubah.
    - Ketika membuat sebuah observable properties maka dapat menambahkan keyword 'by' kemudian diikuti oleh
      function 'Delegates.observable(parameter)' pada properties-nya.
        contoh :  ' var name: String by Delegates.observable(name){...}'
           ket :  - var name => nama properties.
                  - String => tipe data properties.
                  - by => digunakan untuk melakukan delegasi pada properties.
                  - Delegates.observable(name) => salah satu object delegasi yaitu 'observable'.
 */

class Product (name: String){
    var name: String by Delegates.observable(name){ property, oldValue, newValue -> // 3 paramter lambda
            println("${property.name} diubah dari $oldValue ke $newValue")
    }
}

fun main() {
    // Membuat object dari class Product
    var product1: Product = Product("Daia")
    product1.name = "Rinso"
    product1.name = "Molto"

}