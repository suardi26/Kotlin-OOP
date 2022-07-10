/**
    - Destructuring declaration adalah membuat multiple variable dari sebuah object.
    - Destructuring tidak dapat dilakukan untuk semua object, hanya object yang memiliki function componentX() yang
      dapat dilakukan destructuring.
    - Saat kita membuat data class, secara otomatis akan dibuatkan function componentX() sesuai dengan jumlah
      paramter-nya, dan ketika tidak menggunakan data class maka kita harus membuat manual
      function componentX() dengan tambahan keyword 'operator'.
            - componentX() => component1(),component2()...componentX().
                           =>  operator fun component1(): String = this.name
                           =>  operator fun component2(): String = this.idCard
                           =>  operator fun componentX(): String = "Premium"

    Destructuring pada function.
    - Destructuring declarations juga dapat dilakukan ketika memanggil function.
    - Dengan ini, seakan-akan kita dapat mengembalikan multiple return value pada function.

    Underscore untuk variable yang tidak digunakan.
    - kadang juga kita hanya ingin melakukan destructuring pada beberapa variable, dan menghiraukan variable lain-nya.
    - Untuk menghiraukan suatu variable, kita dapat menggunakan keyword '_' (underscore).

    Destructuring Lambda parameter
    - Destructuring juga dapat dilakukan pada lambda parameter.
    - Hal ini dapat mempermudah kita saat ingin mengakses data yang ada pada paramter.
 */

// Destructuring declarations pada data class
data class Game(val name: String, val price: Int)

// Destructuring declarations pada bukan data class
class Customer(val name: String, val idCard: Int){

    // Untuk melakukan destructuring declaration pada class biasa, bukan pada data class, maka harus membuat
    // function componentX sebanyak dari destructuring variable yang akan dibuat dari object class ini.
    operator fun component1(): String = this.name
    operator fun component2(): Int = this.idCard

    // dapat membuat function component yang return value-nya bukan nilai dari properties/paramter constructor.
    operator fun component3(): String = "Premium"
}

// Destructuring declarations pada data class dan dijadikan return value sebuah function.
data class MinMax(val min: Int, val max: Int)

// Membuat Destructing pada fucntion.
fun minMax(value1: Int, value2: Int): MinMax{
    return when{
        value1 > value2 -> MinMax(value2, value1)
        else -> MinMax(value1, value2)
    }
}

// Destructuring declarations pada data class dan dijadikan parameter function dan data class ini akan diproses pada
// lambda yang menjadi paramter dari sebuah function.
data class Login(val user: String, val pwd: String)

// Destructuring pada Lambda parameter
fun login(login: Login, callback: (Login) -> Boolean): Boolean{
    return callback(login)
}

fun main() {
    val game = Game("Super Mario",700_000)

    // Membuat 2 variable dengan memanggil function component1() dan component2() pada data class Game
    // (Destructuring variable).
    val (name, price) = game
    println(name)
    println(price)
    println("= = = = = = = =")

    val customer1 = Customer("Berkam", 1001)
    // Membuat 3 variable dengan memanggil function component1() dan component2() serta component3() pada class biasa
    // (Destructuring variable).
    val (custumerName1, idCard, level) = customer1
    println(custumerName1)
    println(idCard)
    println(level)
    println("= = = = = = = =")

    // Destructuring Return function 'minMax()'
    val(valueMin, valueMax) = minMax(12,100)
    println("$valueMin < $valueMax")
    println("= = = = = = = =")

    // Underscore untuk variable yang tidak digunakan.
    val (_,valueMax2) = minMax(12, 103)
    println(valueMax2)
    println("= = = = = = = =")

    // membuat object dari class Login dan juga lambda expression sebagai paramter function 'login'.
    val request = Login("Suardi", "ghtry")

    // Tanpa (destructuring variable)
    //val success1 = login(request) {login ->
    //    login.user == "Suardi" && login.pwd == "ghtry"
    //}
    // Dengan (destructuring variable) tidak perlu lagi menggunakan cara yang biasa :
    val success = login(request) {(user, pwd) ->
        user == "Suardi" && pwd == "ghtry"
    }

}