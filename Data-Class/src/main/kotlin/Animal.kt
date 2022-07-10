// Contoh membuat class dalam bentuk data class
// secara otomatis akan membuatkan function equals, hashCode, toString, dan copy dari semua properties yang terdapat
// pada primary constructors
data class Animal(val name: String,
                  val food: String,
                  val numberOfFeet: Int){

    lateinit var type: String
    fun move(){
        when{
            numberOfFeet > 0 -> {
                println("$name dapat bergerak menggunakan ke-$numberOfFeet kakinya.")
            }
            else -> "-"
        }
    }
}

