/**
    - Kotlin mendukung operator overloading, artinya kita dapat membuat function dari operator-operator seperti
      operator metematika, dll.
    - Kamampuan ini membuat kita dapat melakukan operasi apapun di object lain seperti layaknya tipe data Interger/Number.
    - Ada banyak sekali operator yang dapat di override pada Kotlin.
    - Untuk membuat operator overloading, kita dapat menggunakan keyword 'operator' sebelum deklarasi function-nya.

    - Unary Prefix operator
            Expression      Translated to
            +a              a.unaryPlus()
            -b              a.unaryMinus()
            !a              a.not()

    - Increment & Decrement
            Expression      Translated to
            a++             a.inc() + see below
            a--             a.dec() + see below

    - Aritmatika Operator
            Expression      Translated to
            a + b           a.plus(b)
            a - b           a.minus(b)
            a * b           a.times(b)
            a / b           a.div(b)
            a % b           a.rem(b), a.mod(b) (deprecated)
            a..b            a.rangeTo(b)

    - In Operator
            Expression      Translated to
            a in  b          b.contains(a)
            a !in b          !b.contains(a)

    - Index Acces Operator
            Expression              Translated to
            a[i]                    a.get(i)
            a[i,j]                  a.get(i,j)
            a[i_1, ..., i_n]        a.get(i_1, ... , i_n)
            a[i] = b                a.set(i, b)
            a[i, j] = b             a.set(i, j, b)
            a[i_1, ... , i_n] = b   a.set(i_1, ... , i_n, b)

    - Invoke Operator
            Expression              Translated to
            a()                     a.invoke()
            a(i)                    a.invoke(i)
            a(i, j)                 a.invoke(i, j)
            a(i_1, ... , i_n)       a.invoke(i_1, ..., i_n)

    - Assignment Operator
            Expression              Translated to
            a += b                  a.plusAssign(b)
            a -= b                  a.minusAssign(b)
            a *= b                  a.timesAssign(b)
            a /= b                  a.divAssign(b)
            a %= b                  a.remAssign(b), a.modAssign(b) (deprecated)

    - Equality dan Inequality Operator
            Expression              Translated to
            a == b                  a?.equals(b) ?: (b === null)
            a != b                  !(a?.equals(b) ?: (b === null))

    - Comparison Operator.
            Expression              Translated to
            a > b                   a.compareTo(b) > 0
            a < b                   a.compareTo(b) < 0
            a >= b                  a.compareTo(b) >= 0
            a <= b                  a.compareTo(b) <= 0

 */
data class Product(val total: Int){

    // Meng-override function aritmatika '+'  a.plus(b) => 'a + b', menggunakan keyword 'operator'.
    operator fun plus(product: Product): Product{
        return Product(this.total + product.total)
    }

    // Meng-override function aritmatika '-'  a.minus(b) => 'a - b', menggunakan keyword 'operator'.
    operator fun minus(product: Product): Product{
        return Product(this.total - product.total)
    }

}

fun main() {

    // Membuat object dari class Product dan memaggil function aritmatika '+' plus yang telah di-override pada class product
    // dengan menggunakan tanda '+'.
    val product1 = Product(55)
    val product2 = Product(45)
    val totalProduct = product1 + product2
    println(totalProduct.total)

    // Membuat object dari class Product dan memaggil function aritmatika '-' minus yang telah di-override pada class product
    // dengan menggunakan tanda '-'.
    val product3 = Product(123)
    val product4 = Product(23)
    val totalProduct2 = product3 - product4
    println(totalProduct2.total)

    println(totalProduct2 - Product(50))


}