package com.example.uibestpractice
//  密封类
sealed class Result

class Success(val msg: String): com.example.uibestpractice.Result()

class Failure(val error: java.lang.Exception): com.example.uibestpractice.Result()

fun getResultMsg(result: com.example.uibestpractice.Result){
    when(result){
        is Success -> result.msg
        is Failure -> result.error.message
        else -> throw  IllegalArgumentException()
    }
}