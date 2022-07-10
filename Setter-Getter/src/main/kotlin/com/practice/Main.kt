/**
    - Encapsulation artinya memastikan data sensitif sebuah objek tersembunyi dari akses luar sehingga
      kita bisa menjaga agar data sebuah object tetap baik atau valid.
    - Setter adalah function untuk mengubah data properties.
    - Getter adalah function untuk mengambil data properties.
    - Pada kotlin, kita tidak perlu manual untuk membuat function Getter dan Setter-nya, dikarenakan sudah
      difasilitasi sehingga lebih mudah.
    - Pada saat membuat properties imutable 'val' maka function Setter-nya 'set(value)' tidak ada,
      hanya function Getter-nya 'get()' yang ada.
    - Dan pada saat membuat properties mutable 'var' maka function Setter-nya 'set(value)' ada,
      dan function Getter-nya 'get()' juga ada.
    - Pada function Setter dan Getter di Kotlin terdapat keyword 'field' yang mengacu pada value dari properties itu
      sendiri.
    - Dan pada function Setter terdapat parameter 'set(value)', dimana value tipe datanya tidak perlu ditambahkan
      karena akan sama pada properties tersebut.
    - Tidak seperti di java, untuk memanggil function Getter-nya hanya memanggil variable object-nya diikuti dengan
      nama properties-nya. contoh : 'student.name'.
    - Dan untuk memanggil function Setter-nya hanya memanggil variable objectnya diikuti dengan nama properties-nya
      dan tanda '=' serta tinggal memasukan value dari properties-nya. contoh : 'student.name = "Yakob"'.

    Optional Setter dan Getter
    - Function Setter dan Getter di kotlin tidak wajib dideklarasikan pada Kotlin.
    - Kita dapat juga mendeklarasikan hanya Getter atau Setter saja bahkan dapat juga tidak mendeklarasikan
      function Setter dan Getter untuk propertiesnya jika value-nya tidak ada yang ditambahkan (default) baik pada saat
      memanggil function Setter atau Getter.
    - Namun jika ingin menambahkan data properties atau validasi properties misal tidak boleh memasukan data kosong
      pada properties maka dapat menggunakan function setter dan juga function getter.

 */
package com.practice

class Student(name: String, collage: String, address: String){

    var name = name
        // function Getter
            // Ketika codenya lebih dari 1 baris, gunakan cara ini :
             get() {
                println("Memanggil function Getter")
                return field
            }
            // Ketika codenya cuma 1 baris, gunakan cara ini :
            //get() = field

        // function Setter
            set(value)  {
                // field = value
                println("Memanggil function Setter")
                if (value.isNotBlank()){
                    field = value
                }
            }

    val collage = collage
    val upperCollage
        // Function Setter ketika properties-nya imutable 'val' akan ERROR.
        // set(value) {
        //    field = value
        //}

        // Function Getter
            get() = collage.uppercase()

    // Tidak mendeklarasikan function Setter dan Getter untuk propertiesnya karena value-nya tidak ada yang ditambahkan
    // (default) baik pada saat memanggil function Setter atau Getter.
    var address = address

}

fun main() {
    val student1 = Student("Suardi", "UNDIPA MAKASSAR", "Jln. Perintis Kemerdekaan")

    // Memanggil function Setter.
    student1.name = "Daud"

    // Memanggil function Getter.
    val name1 = student1.name
    println(name1)

    // Memanggil function Setter (dimana propertiesnya 'val' imutable)
    // student1.collage = "UNHAS MAKASSAR" //ERORR

    // Memanggil Function Getter.
    val collage = student1.upperCollage
    println(collage)

    // Memanggil Function Setter dan Getter (default)
    student1.address = "Jln. Perintis Kemerdekaan, Makassar"
    val address = student1.address
    println(address)

}
