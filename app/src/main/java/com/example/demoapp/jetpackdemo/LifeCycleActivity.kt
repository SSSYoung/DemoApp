package com.example.demoapp.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.demoapp.R

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onResume() {
        super.onResume()
        lifecycle.addObserver(MyLifecycleObserver())
    }
}