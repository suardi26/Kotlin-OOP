/**
    - Keyword 'this' digunakan untuk menyatakan Properties dan function yang ada didalam class tersebut.
    - Keyword 'super' digunakan untuk menyatakan Properties dan function yang diwariskan dari super class.
    - Mungkin kita juga ingin mengakses function atau properties milik superclass yang sudah dibuat ulang oleh subclass.
    - Untuk mengakses function atau properties milik superclass, kita dapat menggunakan keyword 'super'.

 */

open class Kendaraan{
    open val roda: Int = 0

    open fun printWheel(){
        println("(Superclass) Jumlah Roda = ${this.roda}")
    }
}

open class Mobil : Kendaraan(){

    // Membuat properties overriding 'roda'.
    // Properties yang telah di-overriding bersifat 'open' sehingga dapat dibuat ulang pada subclass dibawah-nya lagi.
    // Ketika ingin membuat Properties yang telah di-override tidak bisa di-override lagi oleh sub-class dibawahnya, maka dapat
    // menggunakan keyword 'final' contoh 'final override val roda: Int = 4'.
    override val roda: Int = 4

    // Mengambil nilai properties 'roda' dari superclass Mobil dengan menggunakan keyword 'super'
    val rodaSuperClass: Int = super.roda

    // override function
    override fun printWheel() {
        println("(Subclass) Jumlah Roda = ${this.roda}")

        // Memanggil function 'printWheel' dari superclass Mobil dengan menggunakan keyword 'super'
        super.printWheel()
    }

}

fun main(){
    val kendaraan = Kendaraan()
    println(kendaraan.roda)
    kendaraan.printWheel()

    val pajero = Mobil()
    println(pajero.roda)
    println(pajero.rodaSuperClass)
    pajero.printWheel()

}