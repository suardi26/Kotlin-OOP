class Product(val company: String, val name: String) {

    // Membuat function Overload, dimana  memiliki 1 parameter yang bertipe String.
    fun ket(category: String): Unit{
        println("Name : ${this.name}, Category : $category")
    }

    // Membuat function Overload, dimana  memiliki 2 parameter yang bertipe String dan Int.
    fun ket(category: String, exp: Int): Unit{
        println("Name : ${this.name}, Category : $category, Exp. Date : $exp")
    }

    // Membuat function Overload, dimana  memiliki 1 parameter yang bertipe Int.
    fun ket(exp: Int){
        println("Name : ${this.name}, Exp. Date : $exp")
    }

    // Membuat function Overload, dimana tidak memiliki parameter namun memiliki return value.
    fun ket(): String{
        return this.company
    }

}