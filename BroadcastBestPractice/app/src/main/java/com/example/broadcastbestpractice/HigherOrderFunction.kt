package com.example.broadcastbestpractice


fun plus(num1: Int, num2: Int): Int{
    return  num1 + num2
}

fun minus(num1: Int, num2: Int): Int{
    return  num1 - num2
}

fun num1AndNum2(num1: Int, num2: Int, operation: (Int, Int) -> Int): Int {
    return operation(num1, num2)
}

fun StringBuilder.build(block: StringBuilder.() -> Unit): StringBuilder {
    block()
    return this
}
