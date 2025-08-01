package test

import android.os.Build
import androidx.annotation.RequiresApi
import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum
import com.github.houbb.pinyin.util.PinyinHelper
import test.simplefactory.EngineDataBean
import java.time.Duration

class KtTest1 {
//    var block:(Int)->Int = {para->
//        para * 2
//    }
}

fun main() {
//    //顶层函数的写法
//    topLevelFunc("")
//    //函数对象
//    val a = ::b
//    a.invoke(1)
//    println("hello world")
//    val colors = listOf("red", "brown", "grey")
//    val animals = listOf("fox", "bear", "wolf")
//    val animals1 = listOf("fox", "bear", "wolf")
//    val pairs = colors zip animals zip animals1
//    println(colors zip animals)
    //generateFuzzyPinyinList("li wen han")
//    val file = "2024_01_16_19_32_32_684_Online_sampleRate_16000_音量已经调到最小了，再小只能说悄悄话了.wav"
//    println(file.substring(file.lastIndexOf("_") + 1,file.lastIndexOf(".wav")))

    //toFloat("234/1003532")
    //val iqiyiUri = IqiyiUriBuilder.buildUri("/player", "PLAY", "default")

    // 打印生成的 iQiyi URI
    //println("Generated iQiyi URI: $iqiyiUri")
//    val timeString = "+00:00:30"
//    val seconds = parseTimeStringToSeconds(timeString)
//    println("${timeString} 解析成秒数：${seconds} 秒")
    val data1 = EngineDataBean(intentName = "exampleIntent", module = "exampleModule", action = "a", )
    val data2 = EngineDataBean(intentName = "exampleIntent", module = "exampleModule", action = "a",part = "aaaaaaa")

    // 使用类内部的扩展函数比较所有非空字符串成员变量
    val areEqual = data1.equalsNonEmptyStrings(data2)

    if (areEqual) {
        println("所有非空字符串成员变量相等")
    } else {
        println("至少一个非空字符串成员变量不相等")
    }
}

//private fun parseTimeStringToSeconds(timeString: String): Long {
//    val duration = Duration.parse("PT${timeString}")
//    return duration.toSeconds()
//}



private fun toFloat(fractionString:String):Float {
    // 使用 split 函数分离分子和分母
    val parts = fractionString.split("/")

    // 获取分子和分母
    val numerator = parts.getOrElse(0) { "0" }.toFloat()
    val denominator = parts.getOrElse(1) { "1" }.toFloat()
    val result = numerator / denominator
    println("原始分数: $fractionString")
    println("转换为 float 精度: $result")
    // 将分数转为 float 精度
    return result
}

/**
 * 声母模糊音
 * zh—z ch—c sh—s
 *   n—l h—f r—l
 */
private val fuzzyInitialMap = mapOf(
    "zh" to "z",
    "z" to "zh",
    "ch" to "c",
    "c" to "ch",
    "sh" to "s",
    "s" to "sh",
    "n" to "l",
    "l" to "n",
    "f" to "h",
    "h" to "f"
)

/**
 * 2.韵母模糊音
 * ang—an eng—en ing—in
 * iang—ian uang—uan
 */
private val fuzzyFinalMap = mapOf(
    "ang" to "an",
    "an" to "ang",
    "en" to "eng",
    "eng" to "en",
    "ing" to "in",
    "in" to "ing"
)

//"zhu guo ying ting xiong"
private fun generateFuzzyPinyinList(target: String): Set<String> {
    val targetFuzzyList = mutableSetOf(target)
    val originPinyinList = PinyinHelper.toPinyin(target, PinyinStyleEnum.NORMAL).split(" ")
    originPinyinList.forEachIndexed { index, word ->
        //println("word: $word")
        //声母在模糊音里
        val splitPinyin = splitPinyin(word)
        if (fuzzyInitialMap.containsKey(splitPinyin.first)) {
            //println("声母: $splitPinyin.first, index: $index")
            val copyList = mutableListOf<String>()
            copyList.addAll(originPinyinList)
            copyList[index] = (fuzzyInitialMap.get(splitPinyin.first) ?: "") + splitPinyin.second
            println("声母：" + copyList)
            targetFuzzyList.add(listToPinyin(copyList))
        }
        //韵母在模糊音里
        if (fuzzyFinalMap.containsKey(splitPinyin.second)) {
            //println("韵母: ${splitPinyin.second}, index: $index")
            val copyList = mutableListOf<String>()
            copyList.addAll(originPinyinList)
            copyList[index] = splitPinyin.first + (fuzzyFinalMap.get(splitPinyin.second) ?: "")
            println("韵母：" + copyList)
            targetFuzzyList.add(listToPinyin(copyList))
        }

    }

    return targetFuzzyList.also {
        println(it)
    }
}

private fun listToPinyin(list: List<String>): String {
    return list.joinToString(separator = " ").trim()
}

private fun splitPinyin(input: String): Pair<String, String> {
    val pinyin = input
    var findInit = false
    val initials = arrayOf(
        "b",
        "p",
        "m",
        "f",
        "d",
        "t",
        "n",
        "l",
        "g",
        "k",
        "h",
        "j",
        "q",
        "x",
        "zh",
        "ch",
        "sh",
        "r",
        "z",
        "c",
        "s",
        "y",
        "w"
    )
    var initial = ""
    var finalStr = ""
    for (i in initials) {
        if (pinyin.startsWith(i)) {
            initial = i
            finalStr = pinyin.substring(i.length)
            findInit = true
            break
        }
    }

    if (!findInit) {
        finalStr = pinyin
    }
    return Pair(initial, finalStr)
}