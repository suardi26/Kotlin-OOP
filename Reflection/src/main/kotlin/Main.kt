import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties

/**
    - Reflection adalah kemampuan melihat struktur aplikasi pada saat berjalan.
    - Reflection biasanya sangat berguna pada saat kita membuat library ataupun framework, sehingga bisa
      meng-otomatisasi pekerjaan.
    - Untuk mengakses reflection class dari sebuah object, maka kita dapat menggunakan keyword '::class' sebelum nama
      object-nya atau dapat langsung dari 'NamaClass::class' tanpa harus membuat object-nya.
       contoh :  val objectRequest = CreateProductRequest()
                 val clazz = objectRequest::class

                 val properties = clazz.memberProperties => ketika ingin mengakses data properties dari sebuah class.
                 val function = clazz.constructors => ketika ingin mengakses data Constructors dari sebuah class.
                 val function = clazz.memberFunctions => ketika ingin mengakses data Functions dari sebuah class.
                 val annotations = clazz.annotations => ketika ingin mengakses annotations dari sebuah class.


 */

// Membuat data class.
@Checked(author = "Suardi")
data class CreateProductRequest(
    @NotBlank val id: String,
    @NotBlank val name: String,
    @NotBlank val price: Long,
)
data class CreateCategoryRequest(
    @NotBlank val id: String,
    @NotBlank val name: String,
)

// Membuat function validate request dari semua class (turunan semua class adalah Any).
fun validateRequest(request: Any){
    // melakukan pengecekan properties yang bernilai kosong menggunakan reflection dengan bantuan annotation.
    val clazz = request::class
    val properties = clazz.memberProperties

    // iterate satu per satu, lalu mengecek annotation @NotBlank
    for(property in properties){
        if(property.findAnnotation<NotBlank>() != null){

            // function 'call()' digunakan untuk mengambil sebuah property dari sebuah object.
            val value = property.call(request)
            when(value){
                is String -> {
                    if("" == value){
                        // property.name => memanggil nama properties-nya.
                        throw ValidationException("${property.name} is Blank.")
                    }
                }
            }

        }
    }
}

fun main() {

    // cek nama class dari class 'CreateProductRequest'
    val clazz = CreateProductRequest::class
    println(clazz)
    println("- - - - - - - - - -")

    // cek data Constructors dari class 'CreateProductRequest'
    println(clazz.constructors)
    println("- - - - - - - - - -")

    // cek data properties dari class 'CreateProductRequest'
    println(clazz.memberProperties)
    println("- - - - - - - - - -")

    // cek data functions dari class 'CreateProductRequest'
    println(clazz.memberFunctions)
    println("- - - - - - - - - -")

    // cek annotations dari class 'CreateProductRequest'
    println(clazz.annotations)
    println("- - - - - - - - - -")

    // Memanggil function dari validateRequest().
    val request1 = CreateProductRequest("101", "Daia", 10000)
    validateRequest(request1) // Success karena tidak ada properties-nya yang blank.

    val request2 = CreateProductRequest("", "Molto", 1000)
    validateRequest(request2) // Throw ValidationException 'id' is blank.

}