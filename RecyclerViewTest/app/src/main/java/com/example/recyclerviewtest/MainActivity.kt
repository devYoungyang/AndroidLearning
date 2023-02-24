package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.listviewtest.Fruit
import com.example.recyclerviewtest.databinding.ActivityMainBinding
import com.example.recyclerviewtest.databinding.FruitItemBinding

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFruits()
        val layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        binding.recyclerView.adapter = adapter

    }
    private fun initFruits(){
        repeat(2){
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))
            fruitList.add(Fruit("Apple",R.drawable.apple))

        }
    }
}