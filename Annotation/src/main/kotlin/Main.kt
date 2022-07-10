/**
    - Annotation merupakan suatu tag untuk memberikan informasi pada suatu code yang dibuat.
    - Annotation merupakan penambahan metadata ke kode program yang kita buat.
    - Annotation biasanya digunakan untuk membuat library/framework.
    - Annotation dapat diakeses menggunakan reflection.
    - Untuk membuat class annotation, kita dapat menggunakan keyword 'annotation' sebelum membuat class tersebut.
    - Annotation hanya boleh memiliki properties via primary constructor, tidak boleh memiliki members lainnya
      (function atau properties pada body).
    - Jadi cuma properties yang ada pada class annotation yang hanya boleh ditambahkan pada primary constructor,
      tidak boleh ada function.
    - Attribute Annotation :
        Attribute            Keterangan
        - @Target            digunakan untuk menginformasikan annotation dapat digunakan pada class, properties,
                             function, dll.

        - @Retention         digunakan untuk menginformasikan bahwa annotation disimpan di hasil kompilasi, dan apakah
                             bisa dibaca oleh reflection ?. @Retention hanya memiliki satu value.
                                - value @Retention SOURCE => Annotation-nya cuma ada pada source code.
                                - value @Retention BINARY => Annotation-nya ada di source code serta pada Binary file
                                                             yang telah dicompilasi.
                                - value @Retention RUNTIME => Annotation-nya ada di source code serta pada Binary file
                                                              yang telah dicompilasi serta dapat dibaca oleh reflection.

        - @Repeatable        digunakan untuk menginformasikan bahwa annotation apakah dapat digunakan lebih dari sekali
                             di target yang sama ?.

        - @MustBeDocumented  digunakan untuk menginformasikan bahwa annotation apakah perlu didokumentasikan pada
                             public API ?.

    - Cara Menggunakan Annotation dengan menggunakan keyword '@' dan diikuti class annotation-nya.

    Annotation Target
    - Kotlin Annotation berjalan baik dengan Java Annotation.
    - Namun kadang kita ingin menempatkan posisi annotation sesuai dengan yang kita mau agar dapat terbaca di Java
      dengan baik.
    - Biasanya kejadian ini terjadi ketika kita menggunakan Kotlin, namun menggunakan framework Java, sehingga target
      lokasi Anotation-nya harus sesuai dengan yang biasa digunakan pada framework tersebut di java.
    - Pada kotlin kita dapat menggunakan @target:NamaAnnotation-nya untuk menentukan lokasi target Annnotation akan
      ditempatkan dimana.

    - Pemanggilan class annotation :
        - secara default penentuan target annotation :
            class ExampleTarget (@Beta val firstName: String,
                                 @Beta val middleName: String,
                                 @Beta lastName: String)
        - mengatur annotation target :
            class ExampleTarget (@field: Beta val firstName: String,
                                 @get: Beta val middleName: String,
                                 @param: Beta lastName: String)
                                 ** dan ada masih banyak lagi target specific untuk annotation ketika sudah dicompile
                                    menjadi java binary code, seperti : @set: Beta, @delegate: Beta, @property: Beta, dll.

        - Perbedaanya adalah ketika pemanggilan class annotation secara default di binary code akan menargetkan
          annotation-nya secara default pada parameter constructor sedangkan ketika mengatur annotation target maka
          annotation akan ditempatkan sesuai dengan keinginan kita ketika sudah dicompile pada java binary code.

    - Kita dapat menentukan annotation akan ditempatkan dimana ketika sudah dicompile pada java binary code.
            @field => annotation-nya akan ditambahkan pada field ketika
                      dicompile di java binary code.
            @get   => annotation-nya akan ditambahkan pada function
                      getter ketika dicompile di java binary code.
            @param => annotation-nya akan ditambahkan pada parameter
                      constructor ketika dicompile di java binary code.
 */

// Membuat class Annotation
@Target(AnnotationTarget.CLASS) // class annotation dapat digunakan pada class.
@Retention(AnnotationRetention.RUNTIME) // annotation ini dapat dibaca oleh reflection.
@MustBeDocumented // annotation ini akan didokumentasikan pada public API.
annotation class Checked(val author: String){
    //val info: String = "Checked"          // Error, class annotation tidak dapat memili members pada body.
    //fun cekAuthor(): String = this.author // Error, class annotation tidak dapat memili members pada body.
}

// Memanggil class annotation.
@Checked(author = "Suardi")
class Application(val name: String, val version: Int){
    fun info(): String = "Application $name-$version"
}

// Annotation Target.
@Target(AnnotationTarget.PROPERTY_GETTER,
        AnnotationTarget.FIELD,
        AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.RUNTIME) // annotation ini dapat dibaca oleh reflection.
@MustBeDocumented // annotation ini akan didokumentasikan pada public API.
annotation class Beta

// Memanggil class annotation.
class ExampleTarget(@field: Beta val firstName: String,  // @field => annotation-nya akan ditambahkan pada field ketika
                                                         //           dicompile di java.
                    @get: Beta val middleName: String,   // @get   => annotation-nya akan ditambahkan pada function
                                                         //           getter ketika dicompile di java.
                    @param: Beta val lastName: String)   // @param => annotation-nya akan ditambahkan pada parameter
                                                         //           constructor ketika dicompile di java.

fun main() {
    val myApplication: Application = Application("Google",22)
    val data1 = myApplication.info()
    println(data1)
}