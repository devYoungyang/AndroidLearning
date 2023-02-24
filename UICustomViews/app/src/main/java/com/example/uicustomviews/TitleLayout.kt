package com.example.uicustomviews

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.uicustomviews.databinding.TitleBinding

class TitleLayout (context: Context,attrs:AttributeSet): LinearLayout(context,attrs){
    private  lateinit var binding: TitleBinding
    init {
        LayoutInflater.from(context).inflate(R.layout.title,this)
    }
}
