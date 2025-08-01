package com.example.demoapp.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.demoapp.R

class ViewModelDemoActivity : AppCompatActivity() {
    companion object {
        private val TAG = "ViewModelDemoActivity"
    }

    private val myViewModel by lazy {
        ViewModelProvider(this).get(MyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model_demo)
        val text: TextView = findViewById(R.id.tv_show_data)
        val btnPlusOne: Button = findViewById(R.id.bt_plus_one)
        myViewModel.getTestNum().observe(this) {
            text.text = it.toString()
        }
        btnPlusOne.setOnClickListener {
            myViewModel.plusOne()
        }
    }
}