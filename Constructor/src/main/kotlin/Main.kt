
    fun main(){
        // Membuat Object dari class Product yang memiliki constructor
            val dettol = Product(
                "S1001",
                "Dettol",
                10_000
            )
            // Mengganti Properties dari class Product
            dettol.price = 12_000

            println(dettol.idProduct)
            println(dettol.nameOfProduct)
            println(dettol.price)
            println(dettol.ket)
            println("= = = = = = = = = = = = = =")

            val nuvo = Product(
                idProduct = "S1002",
                nameOfProduct = "Nuvo",
                price = 20_000,
                ket = "50 pcs"
            )
            println(nuvo.idProduct)
            println(nuvo.nameOfProduct)
            println(nuvo.price)
            println(nuvo.ket)
            println("= = = = = = = = = = = = = =")

        // Membuat Object dari class Animals dengan membuat properties di dalam primary constructor.
            val cat = Animals(name = "Cat",
                              food = "Meat")
            println(cat.name)
            println(cat.food)
            println("= = = = = = = = = = = = = =")

            val dog = Animals(name = "Dog",
                              food = "Meat",
                              numberOfFeet = 4)
            println(dog.name)
            println(dog.food)
            println(dog.numberOfFeet)

    }
