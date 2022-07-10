/**
    - Kotlin mendukung pembuatan Constructor lebih dari satu.
    - Constructor yang utama terdapat pada class, disebut primary constructor, constructor tambahan yang dapat dibuat lagi
      adalah secondary constructor.
    - Saat membuat secondary constructor, kita wajib memanggil primary constructor jika terdapat primary constructor.
    - Pada java dapat membuat lebih dari satu constructor (Constructor overload), di Kotlin juga dapat membuat lebih dari
      satu constructor.
    - Membuat secondary canstructor pada kotlin bebas artinya tidak ada batasan jumlahnya, selama jumlah
      parameter-nya berbeda.
    - Untuk membuat secondary constructor dapat menggunakan keyword 'constructor', dan untuk memanggil constructor primary-nya
      dapat menggunakan keyword 'this'.
    - Mekanisme secondary constructor adalah mengirim parameter yang ada pada secondary constructor ke primary constructor
      dengan menggunakan keyword 'this'.
    - Secondary Constructor dapat ditambahkan body atau tidak. contoh :
        - Tanpa body = 'constructor(idProduct: String, nameOfProduct: String) : this(idProduct, nameOfProduct, null)'
        - Dengan body = 'constructor(idProduct: String, nameOfProduct: String) : this(idProduct, nameOfProduct, null){...}'
    - Dan perbedaan dari primary constructor dengan secondary constructor adalah primary constructor membutuhkan
      Initializer Block untuk menambahkan code yang akan langsung dieksekusi ketika instance object sedangkan secondary
      constructor terdapat body untuk menambahkan code yang akan langsung dieksekusi ketika instance object,
      jadi mirip seperti function.
    - Secondary Constructor dapat dibuat tanpa harus membuat Primary Constructor.
    - Secondary Constructor ketika dibuat tanpa membuat primary constructor maka dapat membuat secondary constructor
      yang memiliki jumlah parameter yang sama tapi tipe datanya harus berbeda. misal :
        - secondary constructor 1 : 'constructor(name: String, food: String){}'
        - secondary constructor 2 : 'constructor(name: String, numberOfFeet: Int){}'.
    - Ketika membuat primary constructor, dapat secara langsung memasukan nilai parameter ke properties/attribute sedangkan
      ketika membuat secondary constructor tanpa primary constructor maka tidak bisa secara langsung memasukan nilai parameter
      ke properties/attribute, harus didalam block secondary constructor, sehingga harus memasukan nilai default properties
      terlebih dahulu.
    - Dan blok code yang akan dieksekusi dahulu ialah primary constructor, setelah itu secondary constructor, seperti
      pada contoh dibawah :
                secondary constructor 'B' ( block ketiga dieksekusi )
                            -> memanggil
                            secondary constructor 'A' ( block kedua dieksekusi )
                                        -> memanggil
                                                primary constructor (block pertama dieksekusi)

 */

// Primary constructor.
class Product(idProduct: String, nameOfProduct: String, price: Int){
    init {
       println("Primary Constructor")
    }

    // Secondary constructor 'A' (memiliki 2 parameter berbeda dengan primary constructor dengan 3 parameter).
    constructor(idProduct: String, nameOfProduct: String) :
    this(idProduct, nameOfProduct, 1000){              // Memanggil constructor primary menggunakan keyword 'this'.
        println("Secondary Constructor 'A'")
    }

    // Secondary constructor 'B' (memiliki 1 parameter berbeda dengan primary constructor dengan 3 parameter).
    // Dimana pada secondary constructor ini memanggil Secondary constructor 'A' dan memasukan parameter dari constructor ini
    // pada secondary constructor 'A' setelah itu secondary constructor 'A' memanggil primary constructor dan meneruskan
    // parameternya ke primary constructor.
    constructor(nameOfProduct: String) : this("",nameOfProduct){println("Secondary Constructor 'B'")}

    // Properties/Atribute
    var idProduct = idProduct
    var nameOfProduct = nameOfProduct
    var price = price

}

// Class dengan secondary constructor dan tanpa primary constructor.
class Animals{

    // Properties/Atribute
    var name = ""
    var food = ""
    var category = ""
    var numberOfFeet = 0

    // Secondary constructor 'D'
    constructor(name: String, food: String){
        this.name = name
        this.food = food
    }

    // Secondary constructor 'E'
    constructor(name: String, food: String, category: String) : // Boleh memanggil secondary constructor 'D', boleh juga tidak.
                this(name, food){                               // memanggil secondary constructor 'D' dengan keyword this.
    // constructor(name: String, food: String, category: String){
        this.category = category
    }

    // Secondary constructor 'F' => jumlah parameternya sama dengan secondary constructur 'D', namun berbeda tipe datanya.
    constructor(name: String, numberOfFeet: Int){
        this.name = name
        this.numberOfFeet = numberOfFeet
    }
}

fun main(){

    // Instance object Product 2 parameter (Primary Constructor)
    var fullo = Product(idProduct = "F001",
                        nameOfProduct = "Fullo",
                        price = 1000)
    println("id Product = ${fullo.idProduct}, product Name = ${fullo.nameOfProduct}, price = ${fullo.price}")
    println("= = = = = = = =")

    // Instance object Product 2 parameter (Secondary Constructor 'A')
    var oreo = Product(idProduct = "F002",
                       nameOfProduct = "Oreo")
    println("id Product = ${oreo.idProduct}, product Name = ${oreo.nameOfProduct}")
    println("= = = = = = = =")

    // Instance object Product 1 paremter (Secondary Constructor 'B')
    var bengbeng = Product(nameOfProduct = "Beng-Beng")
    println("product name = ${bengbeng.nameOfProduct}")
    println("= = = = = = = =")

    // Instance object Animals 2 parameter (Secondary Constructor 'B')
    val dog = Animals(name = "Dog",
                      food = "Meat")
    println("${dog.name}, food = ${dog.food}")
    println("= = = = = = = =")

    // Instance object Animals 3 parameter (Secondary Constructor 'B')
    val cat = Animals(name = "Cat",
                      food = "Meat",
                      category = "Mamalia")
    println("${cat.name}, food = ${cat.food}, category = ${cat.category}")
    println("= = = = = = = =")

    // Instance object Animals 2 parameter (Secondary Constructor 'B')
    val monkey = Animals(name = "Monkey",
                         numberOfFeet = 2)
    println("${monkey.name}, Feet = ${monkey.numberOfFeet}")
    println("= = = = = = = =")
}