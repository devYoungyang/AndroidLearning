package com.example.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val data = listOf("Apple","Banana","Orange","Pear","Grape", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango")
    private val fruitList = ArrayList<Fruit>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFruits()
//        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        val adapter = FruitAdapter(this,R.layout.fruit_item,fruitList)
        binding.listView.adapter = adapter
        binding.listView.setOnItemClickListener { parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this,fruit.name,Toast.LENGTH_SHORT).show()
        }

    }
    private  fun initFruits(){
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
        }
    }
}