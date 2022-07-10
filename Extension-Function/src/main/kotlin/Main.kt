/**
    - Extention function adalah Kemampuan untuk menambahkan function pada tipe data yang sudah ada. misal: String, Double, dll.
    - Dan pada dasarnya tipe data yang disediakan oleh Kotlin tidak dapat diubah-ubah lagi seperti : String, Double, dll.
      namun kita dapat menambahkan extention function pada tipe data tersebut.
    - Extention function dapat juga digunakan ketika kita ingin menambahkan function dari library/file-file Kotlin orang lain
      yang tidak dapat diubah lagi.
    - Extention function adalah salah satu fitur yang sangat powerfull, namun harap bijak dalam membuat Extention function,
      karena jika terlalu banyak digunakan, akan membuat program sulit dimengerti.
    - Untuk membuat extension function, kita cukup menambahkan tipe data pada nama function-nya,lalu diikuti dengan tanda '.'(titik).
      Contoh : 'fun String.sayHello(): String{ return "Hello $this" }'
    - Untuk mengakses data dari tipe data yang digunakan pada extension function, Maka dapat menggunakan keyword 'this'.
    - Keyword 'this' digunakan untuk mengakses data dari tipe data yang digunakan.

    Extension function sebenarnya bukanlah bagian dari class.
    - Ketika membuat Extension function, sebenarnya kita tidak memodififkasi class aslinya.
    - Extension function hanyalah sebuah function bantuan yang artinya kita tidak dapat mengakses data member (properties
      atau function) yang private atau protected dari class tersebut.

    Nullable Extension Function
    - Secara default, extension function hanya bisa untuk data yang tidak null.
    - Tapi ketika ingin membuat extension function yang dapat digunakan untuk data yang bisa null, maka kita perlu
      menggunakan keyword '?' (tanda tanya)
 */

// Contoh membuat Extention function dari tipe data String.
fun String.printOut(): Unit{
    println("Hello $this, How Are You ?")
}

class Student(val name: String, private val age: Int)
// Membuat Extention function dari tipe data Student.
// akan tetapi tidak dapat mengakses properties private dari class Student
fun Student.hello(name: String){

    // tidak error karena properties 'name' pada class Student bukan private atau protected melainkan public.
    println("Hello $name, my name is ${this.name}.")

    // tidak dapat mengakses properties 'age' pada class Student karena private.
    // println("age : ${this.age}")
}

// Nullable Extension Function
class Teacher(val name: String, val age: Int)

// Membuat Extension Function yang dapat digunakan untuk data yang bisa null.
fun Teacher?.sayHello(name: String){
        // note : bisa seperti ini
        // println("Hello $name, my name is ${this?.name}, and my age is ${this?.age}.")

        // note : bisa juga seperti ini.
        if (this != null){
            println("Hello $name, my name is ${this.name}, and my age is ${this.age}.")
        }else{
            println("Maaf Object tidak ada (null)")
        }
}

fun main() {
    // Memanggil Extention function dari tipe data String.
    val person: String = "Suardi"
    person.printOut()

    // Memanggil Extention function dari tipe data Student.
    val student1: Student = Student("Martin",20)
    student1.hello("Esquel")

    // Memanggil Extention function dari tipe data Teacher.
    val teacher1: Teacher? = null
    teacher1.sayHello("Steven")
}