package com.example.uibestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uibestpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private val msgList = ArrayList<Msg>()
    private lateinit var adapter: MsgAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initMsg()
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        if (!::adapter.isInitialized){
            adapter = MsgAdapter(msgList)
        }

        binding.recyclerView.adapter = adapter
        binding.send.setOnClickListener(this)

    }
    override fun onClick(v: View?){
        when(v){
            binding.send -> {
                val content = binding.inputText.text.toString()
                if (content.isNotEmpty()){
                    val msg = Msg(content,Msg.TYPE_SEND)
                    msgList.add(msg)
                    adapter.notifyItemInserted(msgList.size-1)
                    binding.recyclerView.scrollToPosition(msgList.size-1)
                    binding.inputText.setText("")
                }
            }
        }
    }
    private fun initMsg(){
        val msg1 = Msg("Hello",Msg.TYPE_RECEIVED)
        val msg2 = Msg("Hello, who is that?",Msg.TYPE_SEND)
        val msg3 = Msg("This is Tom, Nice talking to you", Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        msgList.add(msg2)
        msgList.add(msg3)
    }
}