package com.example.uiwidgettest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.uiwidgettest.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val button: Button = findViewById(R.id.button)

        binding.button.setOnClickListener {
            val text = binding.editText.text.toString()
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show()
            binding.imageView.setImageResource(R.drawable.ic_launcher_foreground)
            val progressBar: ProgressBar = binding.progressBar
            progressBar.progress = progressBar.progress + 10
//            if (progressBar.visibility == View.VISIBLE){
//                progressBar.visibility = View.GONE
//            }else {
//                progressBar.visibility = View.VISIBLE
//            }
            AlertDialog.Builder(this).apply {
                setTitle("This is Dialog")
                setMessage("Something import.")
                setCancelable(false)
                setPositiveButton("OK"){dialog,which ->
                }
                setNegativeButton("Cancel"){dialog,which ->
                }
                show()
            }
        }
    }
}