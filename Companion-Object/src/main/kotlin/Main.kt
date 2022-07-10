/**
    - Companion object adalah kemampuan membuat inner object di dalam class, tanpa harus menggunakan nama object.
    - Companion object secara otomatis akan menggunakan nama Companion, atau dapat langsung diakses lewat nama class-nya.
    - Companion object harus berada didalam sebuah class.
    - Cara mengakses member (function/properties) yang dimiliki Companion object didalam sebuah class ialah dengan
      memanggil nama outer classnya, setelah itu dapat menambahkan 'Companion' ataupun tidak menambahkannya (Optional)
      setelah itu baru menambahkan properties/function yang akan diakses.
           contoh : Application.Companion.welcome("Suardi")
                    Application.welcome("Suardi")
    - Dapat juga menambahkan nama object pada saat membuat companion object, namun ketika manambahkan nama objectnya maka
      pemanggilan member dari companion object berubah menjadi nama outerclass-nya, setelah itu dapat menambahkan nama
      object-nya ataupun tidak menambahkannya (Optional) setelah itu baru menambahkan properties/function yang akan diakses.
           contoh : Hardware.Info.showBrand("ASUS")
                    Hardware.showBrand("ASUS")
 */

// Membuat Companion object di dalam sebuah class tanpa menyebutkan nama object-nya.
class Application(val name: String){
    companion object {

        // Membuat properties/function pada singleton object
        val OS = "Windows 11"
        fun welcome(name: String){
            println("Welcome, $name")
        }
    }
}
// Membuat Companion object di dalam sebuah class dengan menyebutkan nama object-nya juga.
class Hardware(val name: String){
    companion object Info {

        // Membuat properties/function pada singleton object
        val processor = "AMD"
        fun showBrand(name: String){
            println("$name ${this.processor}")
        }
    }
}

fun main() {
    // Memanggil properties/function dari companion object yang berada didalam class Application.
    Application.Companion.welcome("Suardi") // Menambahkan nama object Companion
    Application.welcome("Suardi") // tanpa menambahkan nama object Companion

    // Memanggil properties/function dari companion object dengan manambahkan nama object yang berada didalam
    // class Hardware.
    Hardware.Info.showBrand("ASUS") // Menambahkan nama object Info
    Hardware.showBrand("ASUS") // tanpa menambahkan nama object Info
}