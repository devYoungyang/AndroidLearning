package com.example.activitytest

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activitytest.databinding.SecondLayoutBinding

class SecondActivity : BaseActivity() {
    private  lateinit var binding: SecondLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = Uri.parse("https:www.baidu.com")
//            startActivity(intent)

            val intent = Intent(this,ThreeActivity::class.java)
//            startActivity(intent)
            startActivityForResult(intent,1)
        }
//        setContentView(R.layout.second_layout)

    }
    companion object{
        fun actinStart(context: Context,data: String){
            val intent = Intent(context,SecondActivity::class.java)
            intent.putExtra("data",data)
            context.startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode){
            1 -> if(resultCode == RESULT_OK){
                val returnData = data?.getStringExtra("data_return")
                Log.d("SecondActivity","$returnData")
            }
        }
    }

}