import Animal.Predator

/**
    - Inner Class adalah class di dalam class sedangkan outer class adalah class yang berada di luar inner class.
    - Namun, Walapun class Inner tersebut berada di dalam class Outer, namun class Inner tidak dapat mengakses
      data yang ada dalam class Outer.
    - Agar class Inner dapat mengakses data yang ada di dalam class outer, dapat menggunakan keyword 'inner'.
    - Dan untuk mengakses properties/function dapat menggunakan keyword this dan tanda '@' diikuti nama class dan
      nama properties/function.
    - Untuk membuat object dari class inner maka harus membuat object dari class outer-nya terlebih dahulu, setelah itu
      object dari class outer dapat digunakan untuk membuat class inner.

 */

// Outer Class
class Animal(val ket: String = "Animal"){

    fun info(){
        println("Ini class Animal !!!")
    }

    // Inner Class (Keyword 'inner')
    inner class Predator(val name: String){

        fun desc(): Unit{

            // Mengakses properties/function yang ada pada outer class Animal.
            this@Animal.info()
            println("${this.name} is ${this@Animal.ket}")
        }
    }
}

fun main() {
    // Membuat object dari outer class terlebih dahulu baru membuat object dari inner class.
    val animal1 = Animal()

    // Membuat object inner class dengan bantuan object outer class.
    val crocodile = animal1.Predator("Crocodile")

    crocodile.desc()
}