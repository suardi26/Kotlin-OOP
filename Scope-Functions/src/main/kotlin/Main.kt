/**
    - Kotlin memiliki Standar library yang berisikan beberapa function yang dapat digunakan untuk mengeksekusi
      object dengan mudah memanfaatkan lambda expression.
    - Contoh Scope Function adalah 'let','run','with','apply' serta 'also'.
        - Let function
          - Let function dapat digunakan sebagai reference block agar kita dapat lebih mudah ketika ingin memanipulasi
            sebuah object.
          - Let function memiliki parameter object itu sendiri, sehingga kita dapat menggunakan keyword 'it' untuk
            mendapatkan referensi terhadap object tersebut.
          - Let merupakan extension function dan dapat memiliki return value.

        - Run function
          - run function mirip dengan let function, yang membedakan adalah pada run function, tidak ada paramter pada
            lambda-nya sehingga kita tidak dapat mengakses reference object menggunakan keyword 'it'. Namun kita
            masih dapat menggunakan keyword 'this'.
          - run juga merupakan extension function dan dapat memiliki return value.

        - Apply Function
          - apply function hampir sama dengan run function, yang membedakan adalah return value dari apply function
            adalah reference object itu sendiri.
          - apply juga merupakan extension function dan dapat memiliki return value reference object itu sendiri.

        - Also Function
          - also function mirip dengan let function, yang membedakan adalah pada also function, return value-nya adalah
            reference ke object itu sendiri.
          - also juga merupakan extension function dan dapat memiliki return value reference object itu sendiri.

        - With Function
          - With function mirip dengan run function, menggunakan reference 'this', yang membedakan adalah with function
            bukanlah extension function, jadi tidak bisa digunakan langsung dari object-nya.
          - Kita harus memanggil with function secara manual.
          - With bukan extension function dan dapat memiliki return value.

    - Kesimpulan :

      function     object reference     return value            Is Extension Function
      - let        'it'                 Lambda result           Yes
      - run        'this'               Lambda result           Yes
      - run        '-'                  Lambda result           No: called without the context object
      - with       'this'               Lambda result           No: takes the context object os an argument.
      - apply      'this'               context object          Yes
      - also       'it'                 context object          Yes
 */
class Animal(val name: String, val food: String)
fun main() {

    // contoh extension function 'let'
        val animal1 = Animal("Monkey","Banana")
        println(animal1.name)
        println(animal1.food)
        val result1: String =    animal1.let {
              "Name : ${it.name}, Food : ${it.food}"
            }
        println(result1)
        println("= = = = = = = = = = = =")

    // contoh extension function 'run'
        val animal2 = Animal("Crocodile","Meat")
        println(animal2.name)
        println(animal2.food)
        val result2: String =    animal2.run {
            "Name : ${this.name}, Food : ${this.food}"
        }
        println(result2)
        println("= = = = = = = = = = = =")

    // contoh extension function 'apply'
        val animal3 = Animal("Tiger","Meat")
        println(animal3.name)
        println(animal3.food)

        // return value dari function apply adalah reference object itu sendiri.
        val result3: Animal =    animal3.apply {
            "Name : ${this.name}, Food : ${this.food}"
        }
        println(result3)
        println("= = = = = = = = = = = =")

    // contoh extension function 'also'
        val animal4 = Animal("Cat","Meat")
        println(animal4.name)
        println(animal4.food)

        // return value dari function also adalah reference object itu sendiri.
        val result4: Animal =    animal4.also {
            "Name : ${it.name}, Food : ${it.food}"
        }
        println(result4)
        println("= = = = = = = = = = = =")

    // contoh function 'with'
        val animal5 = Animal("Lion","Meat")
        println(animal5.name)
        println(animal5.food)

        val result5: String = with(animal5){
            "Name : ${this.name}, Food : ${this.food}"
        }
        println(result5)
        println("= = = = = = = = = = = =")
}