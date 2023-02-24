package com.example.fragmentbestpractice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragmentbestpractice.databinding.NewsContentFragBinding

class NewsContentFragment:Fragment() {

    private lateinit var binding: NewsContentFragBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsContentFragBinding.inflate(layoutInflater)
        Log.d("NewsContentFragment","onCreateView")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("NewsContentFragment","onActivityCreated")
    }
    fun refresh(title:String,content:String){
        Log.d("NewsContentFragment",title)
        val contentLayout: LinearLayout = binding.contentLayout
        contentLayout.visibility = View.VISIBLE
        val newsTitle = binding.newsTitle
        val newsContent = binding.newsContent
        newsTitle.text = title
        newsContent.text= content
    }
}


