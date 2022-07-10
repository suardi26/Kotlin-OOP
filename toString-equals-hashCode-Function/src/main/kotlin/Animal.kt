/**
    toString Function
    - toString() adalah function yang digunakan untuk memberitahu representasi String dari sebuah Object.
    - Pada saat melakukan println object, sebenarnya function 'toString()' akan dipanggil.
    - Secara default, function toString() akan mengembalikan referensi code unik(String) dari sebuah object yang berisi
      address memory dimana object tersebut disimpan.
    - Function toString() dapat di-Override, jika ingin mengubah representasi dari String pada sebuah object.

    equals Function
    - Pada Kotlin, semua object dapat dibandingkan menggunakan operasi '==' atau '!='.
    - Saat kita membandingkan object menggunakan operasi '==' atau '!=', sebenarnya Kotlin akan menggunakan function 'equals'
      milik class Any.
    - Untuk mengubah cara membandingkannya, kita dapat meng-override function equals milik Any.
    - Secara default, saat melakukan compare kedua buah object menggunakan function dari equals, maka kotlin akan
      membandingkan kedua referensi code unik dari kedua object yang berisi address memory dalam bentuk String, jika kedua
      nilai String sama maka dianggap kedua object tersebut sama, jika kedua nilai String beda maka kedua object tersebut berbeda.

    hashCode Function
    - hashCode adalah function yang digunakan sebagai representasi angka unik (Int) untuk object yang dibuat.
    - Function hashCode sangat berguna ketika ingin mengkonversi sebuah object menjadi angka.
    - Salah satu penggunaan hashCode yang banyak dilakukan adalah di struktur data, misal untuk memastikan tidak ada data
      duplicate, agar lebih mudah, dicek nilai hashCode-nya, jika hashCode-nya sama, maka dianggap object-nya sama.
    - Secara default return value dari function hashCode adalah referensi code unik(Int) dari sebuah object yang berisi
      address memory dimana object tersebut disimpan.


 */

// Secara default class Animal extends ':' class Any
open class Animal (val name: String){

    // meng-override function toString dari class Any
    override fun toString(): String {
        return "$name is Animal."
    }

}

class Predator(name: String) : Animal(name){

    // meng-override function equals dari class Any
    override fun equals(otherClass: Any?): Boolean {
        return when (otherClass){
            is Predator -> this.name == otherClass.name
            else -> false
        }
    }
}

class Mamalia(name: String) : Animal(name){

    // meng-override function hashCode dari class Any
    override fun hashCode(): Int {
        // pada class/tipe data String pada variable name terdapat juga function hashCode karena String pun
        // turunan dari class Any yang mempunyai function hashCode.
        return name.hashCode()
    }
}

fun main() {

    val cat = Animal("Cat")
    println(cat)                // Secara default 'cat.toString' bisa juga tanpa '.toString' jadi 'cat' saja.
    println(cat.toString())

    val dog1 = Animal("Dog")
    val dog2 = Animal("Dog")
    println("= = = = = = = ")

    // Valuenya akan false dikarenakan yang dibandingkan adalah address memory kedua buah object, dimana pasti berbeda
    // karena address memory object yang pertama 'dog1' dan object kedua 'dog2' pasti berbeda meskipun Memiliki
    // kedua data properties sama yang dikirim melalui primary constructor.
    println(dog1 == dog2)
    println(dog1 == dog1)
    println(dog2 == dog2)
    println("= = = = = = = ")

    val predator1 = Predator("Crocodile")
    val predator2 = Predator("Crocodile")

    // Meng-Override function equals pada Class Predator, dimana yang di compare adalah kedua properties name yang ada pada
    // masing-masing object dari class Predator bukan lagi dari address memory kedua buah object.
    println(predator1 == predator2)
    println(predator1 == predator1)
    println(predator2 == predator2)
    println("= = = = = = = ")

    val predator3 = Predator("Tiger")
    val predator4 = Predator("Tiger")

    // hashCode adalah function yang digunakan sebagai representasi angka unik (Int) untuk object yang dibuat.
    // Membandingkan angka unik(Int) dari kedua object yang dibuat menggunakan function hashCode().
    println(predator3.hashCode() == predator4.hashCode())
    println(predator3.hashCode() == predator3.hashCode())
    println(predator4.hashCode() == predator4.hashCode())
    println("= = = = = = = ")

    // Meng-Override function hashCode pada Class Mamalia, dimana yang di compare adalah kedua properties name yang telah
    // diubah dalam bentuk Int pada kedua object dari class Mamalia bukan lagi dari angka unik (Int) dari object yang dibuat.
    val mamalia1 = Mamalia("Monkey")
    val mamalia2 = Mamalia("Monkey")

    println(mamalia1.hashCode() == mamalia2.hashCode())
    println(mamalia1.hashCode() == mamalia1.hashCode())
    println(mamalia2.hashCode() == mamalia2.hashCode())
    println("= = = = = = = ")
}