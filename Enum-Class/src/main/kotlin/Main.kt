/**
    - Enum Class merupakan representasi dari class yang sudah tetap nilainya.
    - Biasanya Enum class digunakan untuk jenis data yang sudah baku/tidak dapat berubah lagi/static,
      seperti jenis kelamin ,nama hari , arah mata angin dll.
    - Untuk membuat enum class, dapat menggunakan keyword 'enum' sebelum deklarasi class-nya.
    - Kita tidak dapat membuat object dari class enum, namun kita dapat mendeklarasikan langsung object yang tersedia
      untuk enum class tersebut.

    Properties & function pada enum class
    - Enum class adalah class seperti biasa pada umumnya.
    - Enum class dapat juga memiliki properties atau function.
    - Namun jika properties-nya di set menggunakan constructor, maka saat pembuatan object enum, wajib diisi, dan jika
      terdapat abstract function, wajib di override pada saat pembuatan object enum.
 */

// Membuat Enum Class.
enum class Day {
    SENIN,
    SELASA,
    RABU,
    KAMIS,
    JUMAT,
    SABTU,
    MINGGU
}

// Membuat Enum Class dengan constructor maka pada saat pembuatan object enum wajib diisi.
enum class Gender(val description: String){
    MALE("Male"),      // Wajib menambahkan constructor description-nya.
    FEMALE("Female");  // Wajib menambahkan constructor description-nya.

    fun showDesc(): String{
       return this.description
    }
}


fun main(){
    // Contoh Memanggil object dari enum class 'Day'
        val day1 = Day.SENIN
        val day2 = Day.SELASA
        val day7 = Day.MINGGU

        // Mengambil semua data enum 'Day' dengan function 'Day.values()' dan return valuenya adalah Array<Day>.
        val allDay: Array<Day> = Day.values()

        // Membuat object dari enum class 'Day' menggunakan String value, namun harus sesuai dengan data Enum.
        val dayFromString: Day = Day.valueOf("SENIN")

        println(day1)
        println(day2)
        println(day7)
        println(dayFromString)
        println("= = = = = = =")
        println(allDay.toList())

    // Contoh Memanggil object dari enum class 'Gender'.
        val men = Gender.MALE
        val women = Gender.FEMALE

        // Mengambil semua data enum 'Gender' dengan function 'Gender.values()' dan return valuenya adalah Array<Gender>.
        val allGender: Array<Gender> = Gender.values()

        // Membuat object dari enum class 'Gender' menggunakan String value, namun harus sesuai dengan data Enum.
        val genderFromString: Gender = Gender.valueOf("FEMALE")

        println("= = = = = = =")
        println(men)
        println(women)
        println(genderFromString)
        println(allGender.toList())

        // Memanggil function yang terdapat pada enum class Gender.
        println("$men Desc : ${men.showDesc()}")
        println("$women Desc : ${women.showDesc()}")

}