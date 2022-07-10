/**
    - Selain membuat ulang function pada subclass, di Kotlin juga dapat membuat ulang properties.
    - Secara default, properties di class bersifat final, tidak dapat di buat ulang pada subclass-nya, untuk dapat
      membuat ulang properties (Properties Overriding) pada subclass dapat menggunakan keyword 'open'.

    Final Override properties
    - Pada saat membuat ulang Properties pada subclass, secara default, properties tersebut bersifat 'open', artinya
      properties yang telah di override pada subclass dapat dibuat ulang pada subclass dibawah-nya lagi.
    - Jika ingin membuat properties yang telah di-override tidak bisa di-override lagi oleh sub-class dibawahnya, kita dapat
      menggunakan keyword 'final'.
 */

open class Kendaraan{
    open val roda: Int = 0
}

open class Mobil : Kendaraan(){

    // Membuat properties overriding 'roda'.
    // Properties yang telah di-overriding bersifat 'open' sehingga dapat dibuat ulang pada subclass dibawah-nya lagi.
    // Ketika ingin membuat Properties yang telah di-override tidak bisa di-override lagi oleh sub-class dibawahnya, maka dapat
    // menggunakan keyword 'final' contoh 'final override val roda: Int = 4'.
    override val roda: Int = 4
}

final class Bajai : Mobil(){
    override val roda: Int = 3
}

fun main(){
    val kendaraan = Kendaraan()
    println(kendaraan.roda)

    val pajero = Mobil()
    println(pajero.roda)

    val bajai = Bajai()
    println(bajai.roda)
}