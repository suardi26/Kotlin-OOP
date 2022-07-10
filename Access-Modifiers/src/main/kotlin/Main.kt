/**
    - Class, Interface, Constructor, Function, dan Properties (termasuk Setter & Getter) dapat memiliki Visibility
      Modifiers pada kotlin.
    - Ada 4 visibility modifiers pada kotlin, yaitu: public, private, protected, internal.
    - Secara default visibility modifiers pada kotlin adalah public.

        visibility Modifiers        ket
        - public               =>   Jika tidak manambahkan keyword-nya, maka secara default visibility modifiers-nya
                                    adalah public, artinya function atau properties dapat diakses dari mana saja.
                                    baik pada class-nya ataupun pada class lain baik pada package yang sama ataupun
                                    pada package yang lain. Ketika sebuah class menggunakan access modifiers dengan
                                    menggunakan keyword 'public' maka class tersebut dapat diakses dari mana saja.

        - private              =>   Artinya function atau properties hanya dapat diakses pada class dimana
                                    didekalarasikan-nya. Dan ketika sebuah class menggunakan keyword 'private' pada
                                    sebuah file kotlin maka class tersebut hanya dapat diakses pada file tersebut.

        - protected            =>   Artinya function atau properties dapat diakses pada class dimana didekalarasikan
                                    dan juga class turunan-nya. namun access modifier protected tidak dapat
                                    ditambahkan pada sebuah class.

        - internal             =>   Artinya Class, Interface, Constructor, Function, dan Properties hanya dapat diakses
                                    pada module/project yang sama. jadi ketika terdapat class, Interface, Constructor,
                                    Function, atau Properties yang dibuat menggunakan modifiers internal dan ketika
                                    source code didistribusikan pada project orang lain, maka tidak akan bisa diakses.
                                    jadi modifiers internal digunakan untuk project yang bersifat internal tanpa
                                    harus didistribusikan.

 */

// Membuat class Teacher, secara default class Teacher adalah public.
// boleh menambahkan keyword public, boleh juga tidak.
open public class Teacher{

    // properties dapat diakses dari mana saja.
    public var name = ""

    // properties hanya dapat diakses pada module/project yang sama.
    internal var nik = 0

    // properties hanya dapat diakses pada class Teacher dan class turunan-nya.
    protected val address = "Makassar"

    // properties hanya dapat diakses pada class Teacher.
    private var school = "SMP NEGERI 1"

    // membuat function teach dimana function tersebut hanya dapat diakases dalam class Teacher.
    private fun teach (){
        println("Teach")
    }

    // membuat function status dimana function tersebut hanya dapat diakses dalam class Teacher dan class turunan-nya.
    open protected fun status(){
        println("Guru")
    }

    // membuat function desc dimana function tersebut dapat diakses dari mana saja.
    fun desc(){
        println("$name adalah seorang guru pada $school $address dengan NIK : $nik")
    }

}

class SuperTeacher : Teacher(){

    // mengoverride function status dan mengubah access modifiers-nya dari protected ke public.
    override public fun status() {
        // memanggil function status dari superclass Teacher karena access modifiernya protected.
        super.status()
    }
}
fun main() {
    val teacher1 = Teacher()
    teacher1.name = "Nano" // Berhasil karena access modifier public.
    teacher1.nik  = 1001  // Berhasil karena access modifier internal.
    // teacher1.address = "Makassar-SulSel" // Error karena access modifier protected.
    // teacher1.school = "SMPN 1" // Error karena access modifier private.
    // teacher1.teach // Error karena access modifier private.
    // teacher1.status  // Error karena access modifier protected.
    teacher1.desc()  // Berhasil karena access modifier public.

    val superTeacher1 = SuperTeacher()
    superTeacher1.status() // Berhasil karena access modifier-nya public.
}