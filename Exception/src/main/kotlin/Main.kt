/**
    - Ada banyak sekali jenis Error, baik itu error yang sudah diduga, seperti validation error, atau error yang tidak
      terduga, seperti ada jaringan error, koneksi ke database error, dll.
    - Error pada Kotlin direpresentasikan dengan Exception, dimana semua tipe data error pasti akan selalu dibuat dari
      class turunan Throwable.
    - Untuk membuat error pada Kotlin sangatlah mudah kita dapat menggunakan keyword 'throw', diikuti dengan object
      error-nya, dimana objectnya harus dari class Throwable ataupun turunan-nya.

     Try Catch
     - Jika pada program kotlin terjadi exception, maka secara otomatis program kita akan terhenti.
     - Pada Kotlin, kita dapat menangkap exception, lalu melakukan sesuatu jika terjadi error.
     - Try Catch di Kotlin digunakan pada saat terjadi error maka error tersebut dapat ditangkap dan dapat diberi reaksi
       sesuai dengan yang kita mau.
     - Try Catch dapat digunakan untuk menangkap pesan kesalahan sehingga program tidak berhenti melainkan melanjutkan
       mengeksekusi baris code selanjutnya.
    -  Ketika terjadi error pada block try, maka code selanjutnya pada block try tidak akan dieksekusi.
        1 . Try
        try adalah keyword yang digunakan untuk mencoba menjalankan block program yang berpotensi menyebabkan error pada
        saat runtime, keyword ini dipasangkan dengan keyword catch.

        2.  Catch
        Catch adalah keyword yang digunakan untuk menangkap kesalahan yang terjadi dari block try dan dapat ditampilkan
        pada block catch ini.

        3.  Finally
        Finally adalah keyword yang digunakan untuk menjalankan block program yang akan dieksekusi setelah block program
        yang ada di dalam try dan catch. Block program yang ada di finally akan dieksekusi ketika ada kesalahan maupun tidak ada
        kesalahan, misalnya pada block try kita membaca file dan ketika proses selesai maka kita dapat menutup koneksi ke file
        tersebut melalui block finally.

        4.  throw
        throw adalah keyword yang digunakan untuk melemparkan suatu pesan kesalahan yang dibuat secara manual pada class
        Exception.
        format : ' throw validationException("Username atau Password salah !!!")'.

    - Multiple Catch
      - Pada saat mengeksekusi sebuah kode program pada block Try, bisa saja tidak hanya terjadi satu jenis exception,
        bisa saja terjadi beberapa jenis exception.
      - Pada Kotlin, dapat melakukan multiple block Catch, untuk menangkap jenis exception yang berbeda.
      - Multiple Catch artinya dapat membuat beberapa blok catch tidak ada batasnya untuk berbagai macam exception.
 */

// Membuat class Exception dari superclass Throwable(message).
class ValidationException(message: String): Throwable(message)

fun login(name: String, pwd: String){
    val dbName = "Suardi"
    val dbPwd = "1234"

    if (name == dbName && pwd == dbPwd) {
        println("Login Berhasil")
    }else{
        // Memanggil class Exception 'validationException'
        throw ValidationException("Username atau Password salah !!!")
    }

}

fun main() {
        login("Suardi","1234") // Berhasil
        // login("Suardi","1212") // Error (validationException)
        println("= = = = = = = = = = = = = = =")

    // Menggunakan try-catch
        try{

            login("Suardi", "121") // Error (validationException)
            // Ketika terjadi error maka code selanjutnya pada block try tidak dieksekusi
            println("TIDAK DI EKSEKUSI KARENA SEBELUMNYA TERJADI ERROR")
            println("TIDAK DI EKSEKUSI KARENA SEBELUMNYA TERJADI ERROR")

        }catch (error: ValidationException){
            println("Errornya pada : ${error.message}")
        }
        println("Program tidak berhenti pada saat terjadi error di block try")
        println("= = = = = = = = = = = = = = =")

    // Menggunakan Multiple catch
        try{

            login("Suardi", "121") // Error (validationException)
            // Ketika terjadi error maka code selanjutnya pada block try tidak dieksekusi
            println("TIDAK DI EKSEKUSI KARENA SEBELUMNYA TERJADI ERROR")
            println("TIDAK DI EKSEKUSI KARENA SEBELUMNYA TERJADI ERROR")

        }catch (error: ValidationException){
            println("Errornya pada : ${error.message}")
        }catch (er: Throwable){
            println("Errorny pada : ${er.message}")
        }
        println("Program tidak berhenti pada saat terjadi error di block try")
        println("= = = = = = = = = = = = = = =")

    // Menggunakan try-catch-finally
        try{

            login("Suardi", "121") // Error (validationException)
            // Ketika terjadi error maka code selanjutnya pada block try tidak dieksekusi
            println("TIDAK DI EKSEKUSI KARENA SEBELUMNYA TERJADI ERROR")
            println("TIDAK DI EKSEKUSI KARENA SEBELUMNYA TERJADI ERROR")

        }catch (error: ValidationException){
            println("Errornya pada : ${error.message}")
        }finally {
            println("Code Pada block finally akan selalu dieksekusi !!!")
        }
        println("Program tidak berhenti pada saat terjadi error di block try")
        println("= = = = = = = = = = = = = = =")
}