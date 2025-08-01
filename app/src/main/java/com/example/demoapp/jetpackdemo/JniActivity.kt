package com.example.demoapp.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.demoapp.R
import kotlinx.android.synthetic.main.activity_jni.*
import java.util.jar.Manifest
import java.util.logging.Logger

class JniActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jni)

//        Log.d("yangshuang", "stringFromJNI====${stringFromJNI()}")
        Log.d("yangshuang", "add====${add(2, 3)}")
//        Log.d("yangshuang", "sayHello====${sayHello("i am from java")}")
        var intArray = intArrayOf(1, 2, 3)
        Log.d("yangshuang", "increaseArrayEles====${increaseArrayEles(intArray).contentToString()}")
//        Log.d("yangshuang", "callBackAdd====${callBackAdd()}")
//        Log.d("yangshuang", "callStaticFromJava====${callStaticFromJava("i am from java")}")
//        Log.d("yangshuang", "getStringFromC====${getStringFromC()}")
//        Log.d("yangshuang", "addExtraString====${addExtraString("i am from java")}")
        initPermisson()
        initView()
    }

    private fun initPermisson() {
        requestPermissions(
            arrayOf(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE
            ), 200
        )
    }


    private fun initView() {
        btn_mmap_write.setOnClickListener {
            mmapWriteToJNI()
        }
    }

    /**
     * A native method that is implemented by the 'jniapp' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    external fun add(x: Int, y: Int): Int

    //从C中回调到java
    external fun callBackAdd()

    /**
     * s:从java传入的string
     */
    external fun sayHello(s: String): String

    external fun callStaticFromJava(s: String)

    /**
     * 给每个元素加上10
     */
    external fun increaseArrayEles(array: IntArray): IntArray


    external fun getStringFromC(): String

    /**
     * java传过来的string 添加额外字符再传过来
     */
    external fun addExtraString(origin: String): String

    external fun mmapReadFromJNI()

    external fun mmapWriteToJNI()

    companion object {
        // Used to load the 'jniapp' library on application startup.
        init {
            System.loadLibrary("demoapp")
        }
    }
}