//Làm quen với kotlin

//fun kiemTraChanLe(so: Int): String {
//    return if (so % 2 == 0) "So chan" else "So le"
//}
//
//fun loiChaoVaiTro(vaiTro: String): String {
//    return when (vaiTro) {
//        "benhnhan" -> "Chao mung benh nhan"
//        "bacsi" -> "Chao mung bac si"
//        else -> "Chao mung ban"
//    }
//}
//
//fun main() {
//    println(kiemTraChanLe(5))           // So le
//    println(loiChaoVaiTro("bacsi"))     // Chao mung bac si
//}

package com.example.study_kotlin
//
//fun loiChaoGio(gio: Int): String {
//    return when {
//        gio in 5..12 -> "Chao buoi sang"
//        gio in 13..17 -> "Chao buoi chieu"
//        gio in 18..23 -> "Chao buoi toi"
//        gio in 0..4 -> "Chao buoi dem"
//        else -> "Gio khong hop le"
//
//    }
//}
//fun main() {
//    println(loiChaoGio(5))
//    println(loiChaoGio(17))
//}

//fun cong(a:Int , b:Int):Int{
//    return a + b
//}
//
//fun main(){
//    println(cong(5, 10)) // 15
//    println(cong(20, 30)) // 50
//    println(cong(100, 200)) // 300
//}


//fun songuyen(n: Int):Int{
//    return if (n > 0) n else -n
//}
//fun main(){
//    println("nhap n:")
//    val n = readLine()!!.toInt()
//    println("n la: "+songuyen(n)) // 5
//}


//fun kiemtraTuoi(soTuoi: Int): String {
//    return if (soTuoi >=60) "Ban la nguoi cao tuoi"
//    else if (soTuoi>=18 && soTuoi<=59) "Ban la nguoi truong thanh"
//    else if (soTuoi <18 && soTuoi>=0) "Ban la tre em"
//    else "Tuoi khong hop le"}
//fun main(){
//    println(kiemtraTuoi(5))           // Ban la tre em
//    println(kiemtraTuoi(18))          // Ban la nguoi truong thanh
//    println(kiemtraTuoi(60))          // Ban la nguoi cao tuoi
//    println(kiemtraTuoi(-1))          // Tuoi khong hop le
//}


fun main() {
    // Nhập số nguyên n từ người dùng
    println("Nhap so n:")
    val n = readLine()!!.toInt()

    // Dùng vòng lặp để in ra n dòng
    repeat(n) {
        println("Xin chao Kotlin!")
    }
}