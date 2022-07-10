/**
    - Function Overloading adalah membuat beberapa function dengan nama function yang sama dalam satu class,
      tapi dibedakan dari tipe data atau jumlah parameter.
    - Jadi untuk membuat function dengan nama yang sama pada suatu class, maka kita harus membedakan jumlah parameternya
      atau tipe data parameternya tiap-tiap function yang sama namanya dalam suatu class.
    - Ketika membuat Function Overloading dengan jumlah parameter atau tipe data parameter yang sama dan memiliki return value
      yang berbeda maka akan tetap error, namun ketika jumlah parameternya berbeda atau tipe data parameternya berbeda dan memiliki
      return value yang berbeda maka tidak error.
 */

fun main(){
    // Membuat object dari class Product.
        val bengbeng = Product("PT. Suska", "Beng-Beng")

        // Memanggil function overload 'ket' yang memiliki satu parameter bertipe String.
        bengbeng.ket("Makanan")

        // Memanggil function overload 'ket' yang memiliki dua parameter bertipe String dan Int.
        bengbeng.ket("Makanan", 102022)

        // Memanggil function overload 'ket' yang memiliki satu parameter bertipe Integer.
        bengbeng.ket(102023)

        // Memanggil function overload yang tidak memiliki parameter namun memiliki return value bernilai String.
        var company = bengbeng.ket()
        println(company)



}