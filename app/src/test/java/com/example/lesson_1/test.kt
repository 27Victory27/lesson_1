package com.example.lesson_1

fun main(){
    var a = 0
    var a2 = 1
    val vika :Vika = Vika()
    val vika2 = Vika()
    vika.age

    println(a+a2)
    println( Vika.numberr)

}
class Vika(){
    val age = 23


    companion object {
        const val name:String ="Victory"
        var numberr = 0
    }
}
fun  chislo():Int{
    return 1
}