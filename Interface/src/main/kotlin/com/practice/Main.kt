/**
    - Pada Kotlin, deklarasi type tidak hanya dalam bentuk class, terdapat juga interface.
    - Interface adalah blueprint, prototype atau cetakan pada Kotlin.
    - Berbeda dengan Class, Interface tidak dapat langsung dibuat sebagai Object.
    - Interface hanya dapat diturunkan, dan biasanya interface digunakan sebagai kontrak untuk class-class turunan-nya.
    - secara default, semua properties dan function di interface adalah abstract dan 'open'.
    - Berbeda dengan class abstract yang menggunakan keyword abstract ketika ingin membuat properties/function, pada
      interface secara default semua function/properties adalah abstract
    - Jadi berbeda seperti class, Interface tanpa Constructor '()'.
    - Ketika mengimplement suatu interface, semua Function/Properties yang ada pada interface harus dioverride pada subclassnya.
    - Ketika sebuah class meng-extends ':' interface, maka dapat menambahkan nama interface-nya tanpa menambahkan
      constructor '()'. Contoh = 'class Predator() : Animal'.
    - Jadi ketika membuat sebuah function/properties pada interface, maka function/properties tersebut akan menjadi kontrak
      kepada subclass yang extends ':' interface tersebut, dengan kata lain subclass ketika extends ':' interface maka
      subclass wajib meng-override semua function/properties yang dimiliki oleh interface tersebut.

    Concreate Function pada Interface
    - Function pada interface memiliki pengecualian, tidak harus abstract.
    - Maka dapat membuat concreate function pada interface, artinya function tersebut tidak wajib untuk di-override pada
      pada subclass-nya.
    - Ketika membuat body function pada interface maka function tersebut bukan abstract function dan tidak
      wajib di-override pada subclass-nya.

    Multiple Inheritance dengan Interface
    - Inheritance pada class hanya boleh memiliki satu superclass, dengan kata lain sebuah class hanya boleh memiliki
      satu superclass.
    - Namun Inheritance pada interface, sebuah class boleh memiliki banyak super Interface.
        contoh : 'class Mamalia (name: String, zooName: String) : Animal, Zoo {...}'
    - Bahkan ketika menambahkan beberapa interface pada subclass, masih dapat juga menambahkan sebuah class sebagai
      superclass tapi cuma satu class yang boleh.
        contoh : 'class Mamalia (name: String, zooName: String) : Animal, Zoo, Predator(name) {...}'

    Inheritance Antar interface
    - Tidak hanya class yang punya kemampuan inheritance.
    - Interface juga dapat melakukan inheritance dengan Interface lain.
    - Meskipun class bisa extends interface namun interface tidak dapat extends sebuah class.
    - Jadi interface hanya dapat memiliki super interface lainnya dan boleh memiliki lebih dari 1 super interface
      dengan menambahkan tanda ','.

    Konflik pada interface
    - Ketika terdapat 2 function dengan nama yang sama pada kedua interface dan kedua interface tersebut di extends
      terhadap 1 class, maka dapat menggunakan keyword 'super' dan menambahkan nama interfacenya <Interface> setelah
      itu nama function-nya. contoh :   override fun drive() {
                                            super<CarA>.drive()
                                            super<CarB>.drive()
                                        }

 */
package com.practice

// Membuat Interface pada Kotlin.
interface Animal {
    // Membuat properties pada interface, secara default abstract.
    val name: String

    // Membuat function pada interface, secara default abstract.
    fun food(food: String): Unit

    // Membuat function pada interface, yang tidak abstract dengan menambahkan body function.
    // artinya function ini boleh di override pada subclass-nya, boleh juga tidak.
    fun move(numberOfFeet: Int): String{
        return "Number of Feet $numberOfFeet"
    }
}

interface Zoo {
    val zooName : String
    fun desc (location: String)
}

// Membuat Interface yang extends interface lain (Zoo), bahkan dapat memiliki lebih dari 1 super interface.
interface Staff : Zoo {
    fun staffInfo(staff: String){
        println("Staff($zooName) : $staff")
    }
}

// Membuat class tururnan dari interface Staff.
class Operational(override val zooName: String): Staff {
    override fun desc(location: String) {
        println(zooName)
    }
}

// Membuat class turunan dari interface Animal.
open class Predator( override val name: String) : Animal{
    override fun food(food: String) {
        println("${this.name} is Animal, food : $food")
    }

    // meng-override function 'move' tidak wajib boleh ya, boleh juga tidak.
    override fun move(numberOfFeet: Int): String {
        return when {
            numberOfFeet > 0 -> "${this.name} dapat berjalan menggunakan $numberOfFeet kakinya"
            else -> "-"
        }
    }
}

// Contoh Konflik pada Interface.
interface CarA{
    fun drive() = println("Car A")
}
interface CarB{
    fun drive() = println("Car B")
}
class Speed(): CarA, CarB{
    // Dapat diatasi dengan keyword 'super' beserta nama Interface-nya dan Function.
    override fun drive() {
        super<CarA>.drive()
        super<CarB>.drive()
    }
}

// Membuat Multiple Inheritance dengan Interface (2 Interface = Animal, Zoo)
// ket : dapat juga menambahkan sebuah class menjadi superclass tapi hanya boleh 1 saja (class Predator).
class Mamalia (name: String, zooName: String) : Animal, Zoo, Predator(name) {

    // override properties dari interface Animal
    override val name: String = name

    // override properties dari interface Zoo
    override val zooName: String = zooName

    // override function dari interface Animal
    override fun food(food: String) {
        println("Animal : ${this.name}, Food : $food")
    }

    // override function dari interface Zoo
    override fun desc(location: String) {
        println("${this.name} in ${this.zooName}($location) ")
    }
}

fun main() {
    val crocodile = Predator("Crocodile")
    println(crocodile.name)
    crocodile.food("Meat")
    println(crocodile.move(4))
    println("= = = = = = = = = =")

    val lion = Mamalia("Lion", "Ragunan Zoo")
    println(lion.name)
    println(lion.zooName)
    lion.food("Meat")
    lion.desc("South Jakarta")
    println("= = = = = = = = = =")

    val staff1 = Operational("Ragunan Zoo")
    staff1.staffInfo("Beni")
    println("= = = = = = = = = =")

    val speed1 = Speed()
    speed1.drive()
}