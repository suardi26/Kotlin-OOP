// Membuat class annotation untuk melakukan validasi nilai properties yang berisi blank (kosong).
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class NotBlank
