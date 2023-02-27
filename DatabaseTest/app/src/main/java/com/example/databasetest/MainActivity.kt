package com.example.databasetest

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.edit
import com.example.databasetest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val dbHelper = MyDatabaseHelper(this,"BookStore.db",3)
        val button: Button = findViewById(R.id.createDatabase)
        button.setOnClickListener {
            dbHelper.writableDatabase
        }
        binding.addData.setOnClickListener {
            val db = dbHelper.writableDatabase
//            db.execSQL("insert into Book (name,author, pages, price) values (?,?,?,?)", arrayOf("The Da Vinci Code","Dan Brown","454","16.96"))
            val values1 = ContentValues().apply {
                put("name","The Da Vinci Code")
                put("author","Dan Brown")
                put("pages","453")
                put("price",16.96)
            }
            db.insert("Book",null,values1)
            val values2 = ContentValues().apply {
                // 开始组装第二条数据
                put("name", "The Lost Symbol")
                put("author", "Dan Brown")
                put("pages", 510)
                put("price", 19.95)
            }
            db.insert("Book", null, values2) // 插入第二条数据
        }

        binding.updateData.setOnClickListener {
            val db = dbHelper.writableDatabase
//            db.execSQL("update Book set price = ? where name = ?", arrayOf("10.99","The Da Vinci code"))
            val values = ContentValues()
            values.put("price",10.99)
            db.update("Book",values,"name = ?", arrayOf("The Da Vinci Code"))

        }

        binding.deleteData.setOnClickListener {
            val db = dbHelper.writableDatabase
//            db.execSQL("delete from Book where pages > ?", arrayOf("500"))
            db.delete("Book","pages > ?", arrayOf("500"))
        }

        binding.queryData.setOnClickListener {
            val db = dbHelper.writableDatabase
//            val cursor = db.rawQuery("select * from Book",null)
            val cursor = db.query("Book",null,null,null,null,null,null)
            if (cursor.moveToFirst()){
                do {
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getString(cursor.getColumnIndex("pages"))
                    val price = cursor.getString(cursor.getColumnIndex("price"))
                } while (cursor.moveToNext())
            }
            cursor.close()
        }


        binding.replaceData.setOnClickListener {

            val db = dbHelper.writableDatabase
            db.beginTransaction()
            try {
                db.delete("Book",null,null)
                if (true){
                    throw NullPointerException()
                }
                val values = ContentValues().apply {
                    put("name","Game of Thrones")
                    put("author","George Martin")
                    put("pages",720)
                    put("price",20.85)
                }
                db.insert("Book",null,null)
                db.setTransactionSuccessful()
            } catch (err:Exception){
                err.printStackTrace()
            }finally {
                db.endTransaction()
            }
        }
    }
}