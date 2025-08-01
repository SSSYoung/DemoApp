package com.example.demoapp.ipc

import android.os.Bundle
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.demoapp.R
import com.jeremyliao.liveeventbus.LiveEventBus

class IpcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ipc)
    }
}