/**
    Abstract Class
    - Pada Saat membuat class, kita dapat juga untuk menjadikan sebuah class sebagai abstract
    - Abstract class artinya class tersebut tidak dapat dibuat sebagai object, namun hanya dapat diturunkan.
    - Class abstract adalah class yang masih dalam bentuk abstrak atau yang isinya hanya merupakan bentuk dasar class
      yang akan di digunakan di setiap class turunannya. Karena bentuknya masih abstract maka class abstract tidak bisa
      digunakan secara langsung untuk membuat object. namun isi dari class abstract dapat diturunkan ke sub classnya
      sehingga properties dan function abstrak dari superclassnya dapat dibuat/diimlpementasikan menjadi konkrit atau
      spesifik pada subclassnya.
    - Keyword 'abstract' bukan access modifier, dan dapat digunakan pada class, properties atau function.
    - Ketika mendefenisikan keyword abstract pada sebuah class, maka class tersebut secara default adalah 'open'.

    Abstract properties & function
    - Pada saat membuat class yang abstract, maka dapat membuat properties abstract ataupun function abstract di dalam
      class tersebut.
    - Ketika ingin membuat properties atau function yang abstract maka class-nya wajib abstract.
    - Properties dan function yang bersifat abstract pada superclass, artinya wajib di-override pada subclass-nya.
    - Function abstract tidak memiliki body/isi, dan Properties abstract tidak memiliki deklarasi value-nya.
      Dan untuk deklarasi body/isi function abstract atau deklarasi value dari properties abstract, dapat diimplementasikan
      pada subclass-nya sehingga lebih spesifik sesuai dengan kebutuhan subclass tersebut.
    - Karena tidak memiliki isi/Body pada function abstract dan juga tidak memiliki deklarasi value pada properties,
      maka wajib untuk di override di subclass-nya, artinya membuat function abstract dan properties abstract
      pada superclass, memaksa class turunannya untuk override function abstract dan properties abstract.
 */
fun main() {

    // Error karena superclass Location adalah abstract (tidak dapat membuat object dari class ini).
    // val location = Location()

    val city = City("Toraja Utara",91835)
    println(city.name)
    println(city.postalcode)

    val post: Int = city.getPostalCode()
    println("Kode Post : $post")
    city.printLocation()

}