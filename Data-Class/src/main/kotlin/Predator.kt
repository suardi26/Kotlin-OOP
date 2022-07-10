class Predator (val name: String,
                val food: String,
                val numberOfFeet: Int) {

    lateinit var type:String

    fun move() {
        when {
            numberOfFeet > 0 ->{
                println("$name dapat bergerak menggunakan ke-$numberOfFeet kakinya.")
            }
            else ->"-"
        }
    }
}