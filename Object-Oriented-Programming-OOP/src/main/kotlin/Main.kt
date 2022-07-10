/**
    OOP
    - Object Oriented Programming adalah salah satu teknik pemrograman yang berkonsep object.
    - Ada banyak teknik pemrograman misalnya OOP, functional Programing, Prosedural Programing. Namun OOP salah satu
      yang sangat populer.
    - Ada beberapa istilah yang perlu dimengerti dalam OOP, yaitu Object dan Class.

    Object
    - Object adalah data yang berisi properties (fields atau attributes) dan functions (methods atau behavior)
    - Semua data pada Kotlin adalah object, dari mulai Number, Boolean, Character, String dll.
      misalnya kita membuat data maka kita membuat object, oleh sebab itu data tersebut terdapat properties dan juga functionnya.

    Class
    - Class adalah wadah/blueprint/cetakan/prototype untuk menampung function/method dan variabel/atribute/properties
      yang digunakan untuk membuat object.
    - Setiap Object selalu dibuat dari Class dan sebuah Class dapat membuat Object tanpa batas.

    Example
    misalnya membuat class bernama product dan isi dari properties-nya adalah : - String nameOfProduct
                                                                                - Int price
                                                        function-nya adalah   : - String printName (String nameOfProduct)
                                                                                - Int printPrice (Int printPrice)
    Maka dapat Membuat object dari class product diatas :
      object1                       object2                   object3                   ...    object-n
      nameOfProduct : Dettol        nameOfProduct : Nuvo      nameOfProduct : Biore
      price : 12_000                price : 11_000            price : 15_000

    dan masing-masing objectnya dapat mengakses function dari class product diatas.
 */