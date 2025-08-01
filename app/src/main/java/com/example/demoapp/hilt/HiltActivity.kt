package com.example.demoapp.hilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demoapp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {
    @Inject
    lateinit var myRepository: MyRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hilt)

        myRepository.doSomething()
    }
}