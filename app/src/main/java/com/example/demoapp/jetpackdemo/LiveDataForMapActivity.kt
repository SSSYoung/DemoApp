package com.example.demoapp.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.MutableLiveData
import com.example.demoapp.R

class LiveDataForMapActivity : AppCompatActivity() {
    private val testLiveData = MutableLiveData<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data_formap)
//        val mapLiveData = Transformations.map(
//            testLiveData
//        ) { input -> "转换以后的数据：$input" }
//        mapLiveData.observe(this,{
//            /**
//             * 回调在主线程
//             */
//            Log.e("yangshuang", "map以后的数据：$it")
//        })

//        Transformations.switchMap(testLiveData, object : Function<Int,LiveData<String>>{
//            override fun apply(input: Int?): LiveData<String> {
//                return
//            }
//
//        })

        findViewById<Button>(R.id.bt_send_data).setOnClickListener{
            testLiveData.setValue(2)
        }
    }
}