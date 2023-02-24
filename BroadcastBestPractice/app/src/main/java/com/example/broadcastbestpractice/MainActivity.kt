package com.example.broadcastbestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.broadcastbestpractice.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.forceOffline.setOnClickListener {
            val intent = Intent("com.example.broadcastbestpractice_FORCE_OFFLINE")
            sendBroadcast(intent)



        }
        val res1 = num1AndNum2(100,80, ::plus)
        val res2 = num1AndNum2(100,20,::minus)
        Log.d("MainActivity1","res1 = $res1 ---  res2 = $res2 ")
        val res3 = num1AndNum2(100,200){ n1, n2 ->
            n1+n2
        }
        val res4 = num1AndNum2(200,80){ n1, n2 ->
            n1-n2
        }


    }
    fun example(func:(String,Int) -> Unit){
        func("Hello",123)
    }
}