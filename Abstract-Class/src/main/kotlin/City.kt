class City(name: String, postCode: Int) : Location()  {

    // override abstract properties dari superclass Location
        override val name = name
        override val postalcode = postCode

    // override abstract function dari superclass Location
        override fun getPostalCode(): Int {
            return this.postalcode
        }

        override fun printLocation(): Unit {
            println("Location : $name")
        }



}