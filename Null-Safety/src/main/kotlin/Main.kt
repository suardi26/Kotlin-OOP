/**
    - Pada bahasa pemrograman java, sering dijumpai error nullPointerException. Error ini terjadi pada saat kita
      mengakses properties atau functions pada null object.
    - Pada Kotlin, hal ini sangat jarang terjadi, karena sejak awal pada kotlin tidak direkomendasikan untuk menggunakan
      nullable type.
    - Walaupun akan menggunakan nullable type, pada Kotlin kita memberitahu secara eksplisit menggunakan karakter '?'
      (tanda tanya).
    - Ada beberapa cara agar terhindar dari error null pada Kotlin sehingga tidak sering kejadian seperti pada java.
        - Cara 1 dilakukan dengan manual checking terhadap object.
        - Cara 2 dilakukan dengan menggunakan keyword '?'
                 contoh : 'println("Price : ${product?.price}")'
        - Cara 3 dilakukan dengan Elvis Operator, dimana operator ini menggunakan keyword '?' setelah nama object-nya
          dan menggunakan keyword '?:' untuk menggantikan nilai-nya ketika null.
                 contoh : 'val stock = product?.name ?: "Kosong"'
    !! Operator
    - Ketika kita yakin bahwa variable tersebut tidak null, maka kita dapat menggunakan keyword '!!' untuk mengkonversi
      dari data yang nullable menjadi data tidak nullable.
    - Dengan kata lain, keyword '!!' untuk memaksa bahwa object yang dimasukan tidak null.
    - Tapi ingat, konsekuensinya, jika sampai ternyata datanya null, maka akan terjadi error.

 */

data class Product(val name: String, val price: Int, val stock: Int, val exp: String)

fun printProduct(product: Product?): Unit{
    // cara 1 menghindari error null pada Kotlin manual checking terhadap object.
    if(product != null){
        println("Product : ${product.name}")
    }

}

fun printPrice(product: Product?): Unit{
    // cara 2 dengan menggunakan keyword '?'
    println("Price : ${product?.price}")
}

fun printStock(product: Product?): Unit{
    // cara 3 dengan menggunakan Elvis Operator
    // ketika object dari Product kosong maka value-nya akan "Kosong".
    val stock = product?.stock ?: "Kosong"
    println("Stock : $stock")
}

fun printEXP(product: Product?): Unit{
    // keyword '!!' untuk memaksa bahwa object yang dimasukan tidak null.
    //val exp = product!!.exp
    //println("EXP : $exp")

    // bisa juga dalam variable
    val notNullObject = product!!
    val exp1 = notNullObject.exp
    println("EXP : $exp1")

}

fun main() {
    val product1 = Product(name = "Pepsodent",
                           price = 10_000,
                           stock = 100,
                           exp = "MEI 2023")

    printProduct(product1)
    printPrice(product1)
    printStock(product1)
    printEXP(product1)
}