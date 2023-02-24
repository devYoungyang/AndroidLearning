package com.example.filepersistencetest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.filepersistencetest.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOError
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)
        val text = load()
        if (text.isNotEmpty()){
            binding.editText.setText(text)
            binding.editText.setSelection(text.length)
            Toast.makeText(this,"Restoring succeeded",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val inputText = binding.editText.text.toString()
        save(inputText)

    }
    private fun load(): String{
        val content = StringBuilder()
        try {
            val inputText = openFileInput("data")
            val reader = BufferedReader(InputStreamReader(inputText))
            reader.use {
                reader.forEachLine {
                    content.append(it)
                }
            }
        }catch (err:IOError){
            err.printStackTrace()
        }
        return content.toString()
    }
    private fun save(text: String){
        try {
            val output = openFileOutput("data",Context.MODE_PRIVATE)
            val writer = BufferedWriter(OutputStreamWriter(output))
            writer.use {
                it.append(text)
            }
        }catch (err:IOError){
            err.printStackTrace()
        }
    }
}