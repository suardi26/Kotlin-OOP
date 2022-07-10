/**
    - Pada saat ingin membuat object, maka kita diwajibkan untuk menggunakan deklarasi class yang lengkap/konkrit.
    - Namun, pada kotlin mendukung pembuatan object dari class yang bahkan belum lengkap, seperti interface atau
      abstract class.
    - Anonymous Class (class tanpa nama) adalah proses instansiasi object serta mendeklarasikan sebuah class secara
      langsung tanpa nama dari class yang belum lengkap/konkrit seperti interface atau abstract class.
    - Untuk membuat anonymous class, kita dapat menggunakan keyword 'object' diikuti dengan deklarasi subclass
      seperti pada inheritance/pewarisan.

 */

// membuat interface
interface Animal{
    fun ket()
}

// Membuat function dengan parameter tipe Animal.
fun cekInfo(animal: Animal){
    animal.ket()
}

// membuat class turunan dari Animal
class Mamalia(val name: String): Animal{
    override fun ket() {
        println("$name adalah Hewan Mamalia.")
    }
}

fun main() {

    // Membuat object dari class Mamalia, turunan dari class Animal.
    val monkey = Mamalia("Monyet")
    cekInfo(monkey)

    // membuat anonymous class dari interface Animal.
    cekInfo(object : Animal{
        override fun ket() = println("Buaya adalah Hewan Predator.")
    })
}