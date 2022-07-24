package com.example.lesson_1

fun main() {
    // Функция with позволяет выполнить несколько операций над одним объектом, не повторяя его имени.
    val vika = Vika()
//1
    with(vika) {
        name()
    }
    //2
    val with = with(vika) {
        name()
        1
    }
//3
    val mem = vika.apply {
        name()
    }
    //4
    vika.apply {
        name()
    }
    //let полезен при работе с объектами, которые могут принимать значение null. Вместо того, чтобы создавать длинные цепочки выражений if-else, можно просто скомбинировать оператор ?
// («оператор безопасного вызова») с let: в результате мы получим лямбду, у которой аргумент it является не nullable-версией исходного объекта.
    //5
    vika?.let { it.name() } ?: println(null)
}


class Vika() {
    val age = 23
    fun name() {
        println(name + age.toString())
    }

    companion object {
        const val name: String = "Victory"
        var numberr = 0
    }
}

fun chislo(): Int {
    return 1
}