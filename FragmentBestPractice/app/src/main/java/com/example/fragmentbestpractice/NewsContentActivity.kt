package com.example.fragmentbestpractice

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.fragmentbestpractice.databinding.NewsContentActivityBinding

class NewsContentActivity : AppCompatActivity() {
    private  lateinit var binding: NewsContentActivityBinding
    companion object{
        fun actionStart(context: Context,title: String,content: String){
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title",title)
                putExtra("news_content",content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NewsContentActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        if (title!=null&& content!=null){
            Log.d("FragmentBestPractice","onCreate====")
            val fragment = supportFragmentManager.findFragmentById(R.id.newsContentFrag) as NewsContentFragment
            fragment.refresh(title,content)
        }
    }
}