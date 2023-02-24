package com.example.activitytest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ThreeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.three_layout)
        val button: Button = findViewById(R.id.button3)
        button.setOnClickListener {
            val intent = Intent()
            intent.putExtra("data_return","Hello,FirstActivity")
            setResult(RESULT_OK,intent)
            finish()
        }

    }
}