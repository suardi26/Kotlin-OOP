/**
    - Selain extension function, kita juga dapat membuat extension untuk properties pada Kotlin.
    - Untuk membuat extension properties, kita dapat membuat properties dengan Setter Dan juga Getter. artinya
      jika kita ingin membuat extension properties kita tidak hanya membuat properties-nya namun juga harus membuat
      function Setter dan Getter-nya.
 */

class Student(var name: String, private val age: Int){

}

// Membuat Extension Properties
var Student.upperName: String
    get() = this.name.uppercase()
    set(value) {
         this.name = value
    }

fun main() {
    val student = Student("Daud", 23)
    println(student.upperName)
    student.upperName = "Steven"
    println(student.upperName)
}