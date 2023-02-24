package com.example.broadcastbestpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.broadcastbestpractice.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val prefs = getPreferences(Context.MODE_PRIVATE)
        val isRemember = prefs.getBoolean("remember_psd",false)
        if (isRemember){
            val account = prefs.getString("account","")
            val password = prefs.getString("password","")
            binding.accountEdit.setText(account)
            binding.passwordEdit.setText(password)
            binding.rememberPsd.isChecked = true
        }

        val list = listOf("Apple","Banana","Orange","Pear","Grape")
        val res = StringBuilder().build {
            append("Start eating fruits. \n")
            for (fruit in list){
                append(fruit).append("\n")
            }
            append("Ate all fruits")
        }
        Log.d("LoginActivity", res.toString())

        binding.button.setOnClickListener {
            val account = binding.accountEdit.text.toString()
            val password = binding.passwordEdit.text.toString()
            if (account == "admin" && password == "123456"){
                val editor = prefs.edit()
                if (binding.rememberPsd.isChecked){
                    editor.putBoolean("remember_psd",true)
                    editor.putString("account",account)
                    editor.putString("password",password)
                }else{
                    editor.clear()
                }
                editor.apply()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"account or password is invalid",Toast.LENGTH_SHORT).show()
            }
        }
    }
}