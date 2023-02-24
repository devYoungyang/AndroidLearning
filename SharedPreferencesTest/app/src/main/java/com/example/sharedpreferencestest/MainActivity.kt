package com.example.sharedpreferencestest

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            val editor = getSharedPreferences("data",Context.MODE_PRIVATE).edit()
            editor.putString("name","TOM")
            editor.putInt("age",19)
            editor.putBoolean("married",false)
            editor.apply()
        }

        val restoreButton: Button = findViewById(R.id.restoreButton)
        restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
            val name = prefs.getString("name","")
            val age = prefs.getInt("age",1)
            val married = prefs.getBoolean("married",false)
            Log.d("MainActivity","name is $name, age is $age, married is $married")
        }

    }
}