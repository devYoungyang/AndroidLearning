package com.example.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : BaseActivity() {

    private lateinit var binding:FirstLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = FirstLayoutBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.button1.setOnClickListener {
//
//        }

        val list = listOf("Apple","Banana","Orange","Pear","Grape")
        val result = with(StringBuilder()){
            append("Start eating fruits.\n")
            for (fruit in list){
                append(fruit).append("\n")
            }
            append("Ate all fruits")
            toString()
        }
        println(result)


        setContentView(R.layout.first_layout)
        val button1: Button = findViewById(R.id.button1)
        button1.setOnClickListener {
//            Toast.makeText(this,"HELLO,WORLD",Toast.LENGTH_SHORT).show()
//            this.finish()
//            val intent = Intent(this,SecondActivity::class.java)
//            startActivity(intent)

            var intent = Intent("com.example.activitytest.ACTION_START")
            startActivity(intent)


        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item -> Toast.makeText(this,"You clicked add",Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this,"You clicked remove",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}