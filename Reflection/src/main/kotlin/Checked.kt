@Target(AnnotationTarget.CLASS) // class annotation dapat digunakan pada class.
@Retention(AnnotationRetention.RUNTIME) // annotation ini dapat dibaca oleh reflection.
@MustBeDocumented // annotation ini akan didokumentasikan pada public API.
annotation class Checked(val author: String){
    //val info: String = "Checked"          // Error, class annotation tidak dapat memili members pada body.
    //fun cekAuthor(): String = this.author // Error, class annotation tidak dapat memili members pada body.
}