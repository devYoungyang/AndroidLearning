package com.example.helloworld

class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name,age),Study {
//    var sno = ""
//    var grade = 1
    init {
        println("sno is $sno")
        println("grade is $grade")
    }
    constructor(name: String,age: Int): this("",0,name,age)

    constructor(): this("",1)

    override fun readBooks() {
        println("$name is reading")
    }

    override fun doHomework() {

    }
}

