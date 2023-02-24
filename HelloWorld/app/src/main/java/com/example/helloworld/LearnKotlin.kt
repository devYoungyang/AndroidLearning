package com.example.helloworld

import android.util.Log
import kotlin.math.max

fun main(){
    println("Hello, Kotlin")
    for (i in 0..100 step 5){
        println(i)
    }
    for (i in 0 until 8){
        println(i)
    }
    for (i in 10 downTo 1){
        println(i)
    }
    val p = Person(name = "",age = 10)
//    p.name = "Jack"
//    p.age = 18
    p.eat()
    val s = Student("",10,"",2)

    Singleton.singletonTest()

    val list = listOf("Apple","Banana","Orange","Pear","Grape")
    for (fruit in list){
        println(fruit)
    }

    val map = mapOf("Apple" to 1, "Banana" to 2,"Orange" to 3,"Pear" to 4)
    for ((key,value) in map){
        println("fruit is $key, number is $value")
    }
    val maxLength = list.maxByOrNull { it.length }
    list.maxByOrNull { fruit: String -> fruit.length }
    list.map { it.toUpperCase()}
    list.filter { it.length<=5 }.map { it.toUpperCase() }
    Thread{
//        override fun run() {
//
//        }
    }.start()
}
fun printParams(num: Int, str: String = "HAHA"){

}
fun largerNumber(a: Int,b: Int): Int{
    return max(a,b)
}
fun checkNumber(num: Number){
    when (num) {
        is Int -> println("number is int")
        is Double -> println("number is double")
        else -> println("number not support")
    }
}