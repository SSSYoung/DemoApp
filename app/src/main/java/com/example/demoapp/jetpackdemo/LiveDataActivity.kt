package com.example.demoapp.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.demoapp.R

class LiveDataActivity : AppCompatActivity(){
    private val testLiveData = MutableLiveData<String>()
    val TAG = "yangshuang"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        val buttonSendData:Button = findViewById(R.id.bt_send_data)
        val textViewDataShow:TextView = findViewById(R.id.tv_show_data)

        buttonSendData.setOnClickListener {
            testLiveData.postValue("这是传递过来的数据")
        }

        testLiveData.value = "aaa"

        testLiveData.observe(this) {
            Log.d(TAG, "接受到的数据: $it")
            textViewDataShow.text = it
        }
    }
}