package com.example.fragmentbestpractice

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fragmentbestpractice.databinding.FragmentNewsTitleBinding
import com.example.fragmentbestpractice.databinding.NewsContentFragBinding
import com.example.fragmentbestpractice.databinding.NewsTitleFragBinding


class NewsTitleFragment : Fragment() {

    private var isTwoPane = false
    private lateinit var binding: NewsContentFragBinding
    private  lateinit var binding1: FragmentNewsTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = NewsContentFragBinding.inflate(layoutInflater)
        binding1 = FragmentNewsTitleBinding.inflate(layoutInflater)
        return binding1.root
//        return inflater.inflate(R.layout.fragment_news_title, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.newsContentLayout) != null
        Log.d("NewsTitleFragment","$isTwoPane")
        val layoutManager = LinearLayoutManager(activity)
        val newsTitleRecyclerView: RecyclerView = binding1.newsTitleRecyclerView
//            findViewById(R.id.newsTitleRecyclerView)
        newsTitleRecyclerView.layoutManager = layoutManager
        val adapter = NewsAdapter(getNews())
        newsTitleRecyclerView.adapter = adapter
    }

    private fun getNews(): List<News>{
        val newsList = ArrayList<News>()
        for (i in 1..50){
            val news = News("This is news title $i", getRandomLengthString("This is news content $i."))
            newsList.add(news)
        }
        return  newsList
    }
    private fun getRandomLengthString(str: String): String{
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n){
            builder.append(str)
        }
        return  builder.toString()
    }


    inner  class NewsAdapter(val newsList: List<News>): RecyclerView.Adapter<NewsAdapter.ViewHolder>(){
        inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
            val newsTitle: TextView = view.findViewById(R.id.newsTitle)
        }

        @SuppressLint("SuspiciousIndentation")
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false)
            val holder = ViewHolder(view)
            holder.itemView.setOnClickListener {
                val news = newsList[holder.absoluteAdapterPosition]
                if (isTwoPane){
                    val fragment = binding.contentLayout as NewsContentFragment
                    fragment.refresh(news.title,news.content)
                }else{
                    NewsContentActivity.actionStart(parent.context,news.title,news.content)
                }
            }
            return  holder
        }
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val news = newsList[position]
            holder.newsTitle.text = news.title
        }
        override fun getItemCount() = newsList.size


    }


}