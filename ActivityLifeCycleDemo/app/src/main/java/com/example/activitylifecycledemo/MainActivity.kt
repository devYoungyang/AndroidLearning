package com.example.activitylifecycledemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("tag","onCreate")
        setContentView(R.layout.activity_main)
        val startNoralActivity: Button = findViewById(R.id.startNormalActivity)
        val startDialogActivity: Button = findViewById(R.id.startDialogActivity)
        startNoralActivity.setOnClickListener {
            val intent = Intent(this,NormalActivity::class.java)
            startActivity(intent)
        }
        startDialogActivity.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
        Log.d("MainActivity","===onCreate===")
    }

    override fun onStart() {
        super.onStart()
        Log.d("MainActivity","===onStart===")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity","===onResume===")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity","===onPause===")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity","===onStop===")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity","===onDestroy===")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity","===onRestart===")
    }


}