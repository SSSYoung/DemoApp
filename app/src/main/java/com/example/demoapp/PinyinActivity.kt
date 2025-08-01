package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.github.houbb.heaven.util.lang.StringUtil
import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum
import com.github.houbb.pinyin.util.PinyinHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
import org.junit.Assert
import kotlin.coroutines.CoroutineContext
import kotlin.math.log
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

class PinyinActivity : AppCompatActivity() {
    private val ioScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pinyin)
//        val str = '杨'
//        ioScope.launch {
//            val currentTimeMillis = System.currentTimeMillis()
//            var count = 0
//            val measureTimeMillis = measureTimeMillis {
//
//                val samePinyinMap = PinyinHelper.samePinyinMap(str)
//                for (i in 0..100) {
//                    samePinyinMap["yang2"]?.forEach {
//                        val toPinyin = PinyinHelper.toPinyin(it)
//                        count++
//                        Log.d("yangshuang", "toPinyin: $toPinyin ")
//                    }
//                }
//            }
//            val currentTimeMillis1 = System.currentTimeMillis()
//            Log.d("yangshuang", "measureTimeMillis: ${currentTimeMillis1 - currentTimeMillis},count: $count")
//        }
//        val toPinyin = PinyinHelper.toPinyin(str, PinyinStyleEnum.DEFAULT)
//        val toPinyin1 = PinyinHelper.toPinyin(str, PinyinStyleEnum.NORMAL)
//        val toPinyin2 = PinyinHelper.toPinyin(str, PinyinStyleEnum.NUM_LAST)
//        val toPinyin3 = PinyinHelper.toPinyin(str, PinyinStyleEnum.FIRST_LETTER)
//        val toPinyin4 = PinyinHelper.toPinyin(str, PinyinStyleEnum.INPUT)
//        Log.d("yangshuang", "$toPinyin, $toPinyin1, $toPinyin2, $toPinyin3, $toPinyin4")
//
//        val str1 = "我是一个中文句子"
//        //指定特定的连接符号。
//        val toPinyin5 = PinyinHelper.toPinyin(str1, PinyinStyleEnum.FIRST_LETTER, StringUtil.EMPTY)
//        Log.d("yangshuang", "pingyin5: $toPinyin5") //返回wsygzwjz
//
//        //判断同音字
//        val str2 = '样'
//        val str3 = '杨'
//        val hasSamePinyin = PinyinHelper.hasSamePinyin(str2, str3)
//        Log.d("yangshuang", "hasSamePinyin: $hasSamePinyin") //返回wsygzwjz
    }
}