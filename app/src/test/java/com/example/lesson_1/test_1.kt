package com.example.lesson_1

fun main() {
 val numbers: Array<Int> = arrayOf(1,2,3)
 val listNumber = listOf(1,2,3)
 val mutableList = mutableListOf(1,2,3)
    //listNumber.add - нельзя
    mutableList.add(4)
}

interface Dog{
    fun eat()
}
class DogImpl(): Dog{
    var age:Int=15
    override fun eat() {
    }
}
/*
Котлин - это ООП
Инкапсуляция Полиморфизм Наследование
SOLID - дополнительные обьяснения и разъяснения этих трех

Инкапсуляция - собирание общей логики в один класс
+ изоляция реализации посредством интерфейа
+ public private protected (модификаторы доступа)

Полиморфизм - один интерфейс, множество реализаций


ктрл + шифт + эл - выравнивание

Списки:
1) Массивы Array - неизменяемый список (нет метода add)
2) Списки (изменяемые неизменяемые, открытые закрытые соотвественно)
3) Мапы, карты пар
 */