/**
    - Salah satu design pattern lain yang populer adalah Delegation.
    - Delegation sederhananya adalah meneruskan properties atau function ke object yang lain.
    - Jadi dengan delegation kita dapat memanggil function/properties dari object lain yang dibuat dari superclass
      yang sama dengan class yang mendelegasikan sebuah function/properties.
    - Kotlin pun mendukung delegation tanpa harus membuat code secara manual.
    - Kita juga dapat mendelegasikan properties/function secara otomatis pada kotlin dengan cara, mengextends superclass
      sebagai berikut : "class Reptil(val animal: Animal) : Animal by animal".
    - Dengan begitu semua properites/function dari interface Animal dapat di delegasikan/ditujukan ke object yang dibuat
      dari class yang memiliki superclass yang sama dengan class yang mendelegasikan sebuah function/properties.
      Dan dengan begitu kita tidak perlu mengoverride properties/function dari interface Animal karena akan memanggil
      properties/function dari object lain sebagai properties suatu class  dan yang dibuat dari class yang sama
      superclass-nya dengan class yang mendelegasikan sebuah function/properties.
    - Dan Ketika dicompile maka class yang mendelegasikan properties/function secara otomatis pada object yang ditambahkan
      pada properties suatu class, maka secara otomatis class yang mendelegasikan properties/function akan membuat baik
      itu constructor, properties, function dan didalam-nya akan memanggil constructor, properties, function dari
      class yang membentuk object yang dijadikan properties pada class yang mendelegasikan properties/function tersebut.
    - Secara default dalam delegation, semua properties & function yang sama pada class yang membentuk object yang dipilih
      maka secara otomatis akan didelegasikan ke object yang dipilih.
    - Namun ketika tidak semua properties/function ingin didelegasikan pada object lain maka dapat tetap mengoverride
      properties/function tersebut.
 */

interface Animal{
    fun info(type: String)
    fun move(feet: Int)
}

class Predator(val name: String): Animal{
    override fun info(type: String) {
        println("${this.name} adalah $type.")
    }

    override fun move(feet: Int) {
        println("${this.name} Bergerak dengan ke-$feet kakinya.")
    }

}

// Contoh mendelegasikan properties/function secara manual.
// Mendelegasikan/meneruskan function 'info' ke object lain yang dibuat dari class turunan dari class Animal.
class Mamalia(val animal: Animal) : Animal{
    override fun info(type: String) {
       animal.info(type)
    }
    override fun move(feet: Int) {
       animal.move(feet)
    }
}

// Contoh mendelegasikan properties/function secara otomatis dan tidak perlu meng-override properties/functionnya
// karena akan didelegasi ke object lain dari class yang superclass-nya sama dengan class Reptil.
class Reptil(val animal: Animal) : Animal by animal{

    // tidak ingin mendelegasikan function move ke object 'animal'
    override fun move(feet: Int) {
       when{
           feet < 1 -> "-"
           else -> println("Jumlah kaki = $feet")
       }
    }
}

fun main() {
    // Membuat object dari class Predator
    val animal1 = Predator("Serigala")
    animal1.info("Predator")
    animal1.move(4)
    println("= = = = = = = = =")

    // Membuat object dari class Mamalia dan memasukan parameter object dari class Predator
    val animal2 = Mamalia(animal1)
    animal2.info("Mamalia")
    animal2.move(4)
    println("= = = = = = = = =")

    // Membuat object dari class Predator
    val animal3 = Predator("Buaya")
    animal3.info("Predator")
    animal3.move(4)
    println("= = = = = = = = =")


    val animal4 = Reptil(animal3)
    animal4.info("Reptil")
    animal4.move(4)
    println("= = = = = = = = =")
}