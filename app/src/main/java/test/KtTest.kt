package test

import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum
import com.github.houbb.pinyin.util.PinyinHelper
import test.sealedtest.topLevelFunc

class KtTest {
    var block:(Int)->Int = {para->
        para * 2
    }
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