package com.example.uicustomviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uicustomviews.databinding.TitleBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: TitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
}
