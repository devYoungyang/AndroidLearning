package com.example.fragmentbestpractice

class Money(val value: Int) {
    operator fun plus(money: Money): Money{
        val sum = value + money.value
        return Money(sum)
    }

    operator fun plus(newValue: Int): Money{
        val sum = value + newValue
        return  Money(sum)
    }

    operator fun String.times(n: Int): String{
        val builder = StringBuilder()
        repeat(n){
            builder.append(this)
        }
        return builder.toString()
    }


}