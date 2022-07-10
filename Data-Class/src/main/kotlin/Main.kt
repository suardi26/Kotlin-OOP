/**
    - Ketika ingin membuat sebuah class yang hanya digunakan sebagai representasi dari data maka dapat menggunakan
      Data Class.
    - Data class juga dapat digunakan sebagai representasi table data pada database.
    - Data Class merupakan class yang secara otomatis akan membuatkan function equals, hashCode, toString, dan copy
      dari semua properties yang terdapat pada primary constructors yang dimiliki oleh data class.
    - jadi untuk membuat class dalam bentuk data class maka semua properties-nya berada pada primary constructor.
    - Pada data class mirip seperti class pada umumnya di kotlin, dapat juga menambahkan body serta properties lainnya
      atau function pada body data class, dan yang menjadi perbedaan di data class dengan class biasa adalah pada
      data class yang spesial itu properties yang berada di primary constructor, dimana properties tersebut secara
      otomatis dibuatkan oleh kotlin beberapa function seperti : equals, hashCode, toString, dan copy.

     Function copy
     - Data class memiliki function copy yang dapat digunakan untuk menduplikasi sebuah object.
     - Bahkan function copy yang terdapat pada data class dapat digunakan untuk menduplikasi sekaligus mengubah
       properties-nya.
 */

fun main(){
    val animal1 = Animal("Dog", "Meat", 4)

    // Ketika melakukan print object dari data class hasilnya = 'Animal(name=Dog, food=Meat, numberOfFeet=4)'
    println(animal1)

    // Menggunakan function copy dari data class 'Animal' untuk menduplikasi object 'animal1'
    val animal2 = animal1.copy()
    println(animal2)

    // Menggunakan function copy dari data class 'Animal' untuk menduplikasi object 'animal1' dan mengubah
    // value dari properties-nya.
    val animal3 = animal1.copy(name = "Cat")
    val animal4 = animal1.copy(name = "Tiger", food = "Meat")
    val animal5 = animal1.copy(name = "Monkey", food = "Banana", numberOfFeet = 2)
    println(animal3)
    println(animal4)
    println(animal5)

    // Ketika melakukan print object dari class biasa hasilnya = 'Predator@7ba4f24f'
    val animal6 = Predator("Crocodile", "Meat", 4)
    println(animal6)
}