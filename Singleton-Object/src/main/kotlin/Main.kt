/**
    Singleton Object (mirip 'static' pada java)
    - Salah satu konsep Design pattern yang sangat populer adalah singleton object
    - Singleton object adalah object yang hanya dibuat satu kali.
    - Pada Kotlin, membuat object singleton sangat mudah, hanya dengan menggunakan keyword object.
    - Cara membuat singleton object pada Kotlin sama seperti membuat class.
    - Singleton object mirip dengan class, bisa extends class ataupun interface punya properties ataupun function.
    - Namun singleton object tidak memiliki constructors.
    - Ketika ingin mengakses member (function/properties) yang dimiliki oleh singleton object, maka dapat langsung
      memanggil nama objectnya diikuti dengan tanda '.' dan nama properties/function-nya.
            contoh : 'val name: String = Utilities.name'
    - Singleton object mirip dengan static keyword di java, yang hanya memiliki satu object/data untuk semua.
      jadi dimanapun atau berapa kali properties/function diakses akan tetap sama value/object-nya karena cuma 1.

    Inner Object
    - Pada Kotlin, singleton object dapat dibuat di dalam sebuah class.
    - Namun berbeda dengan inner class, singleton object tidak dapat mengakses properties atau function yang ada pada
      outer class-nya.
    - Cara mengakses member (function/properties) yang dimiliki singleton object didalam outer class ialah dengan
      memanggil nama outer classnya diikuti dengan nama singleton object-nya setelah itu baru menambahkan
      properties/function-nya. contoh : 'Application.Info.OS'
    - Nama singleton object dapat sama seperti nama dari outer class-nya.

 */

// Membuat singleton object
object Utilities {

    // Membuat properties pada singleton object
    var name = "Utilities"

    // Membuat function pada singleton object
    fun toUpper(value: String): String {
        return value.uppercase()
    }

}

// Membuat singleton object di dalam sebuah outer class
class Application(val name: String){
    object Info{

        // Membuat properties/function pada singleton object
        val OS = "Windows 11"
        fun welcome(name: String){
            println("Welcome, $name")
        }
    }
}

// Merubah properties dari singleton object Utilities
fun changePropertiesUtilities(){
    Utilities.name  = "UTIL"
}

fun main() {
    // Memanggil properties/function dari singleton object Utilities
    println("${Utilities.name} to Uppercase => ${Utilities.toUpper(Utilities.name)}")
    println("= = = = = = = = =")

    // Memanggil function yang mengubah nilai properties 'name'  dari singleton object Utilities.
    // Jadi dimanapun properties/function singleton object diakses hasilnya akan tetap sama karena cuma satu.
    changePropertiesUtilities()
    println("${Utilities.name} to Uppercase => ${Utilities.toUpper(Utilities.name)}")
    println("= = = = = = = = =")

    // Memanggil properties/function dari singleton object Data
    val dataName: String = Data.name
    val upperDataName: String = Data.toUpper(dataName)
    println("$dataName to Uppercae => $upperDataName")
    println("= = = = = = = = =")

    // Memanggil properties/function dari singleton object Info yang berada didalam outer class Application.
    println("OS = ${Application.Info.OS}")
    Application.Info.welcome("Suardi")
}