package test

import com.github.houbb.pinyin.constant.enums.PinyinStyleEnum
import com.github.houbb.pinyin.util.PinyinHelper

class KtTestTmp {
    var block: (Int) -> Int = { para ->
        para * 2
    }
}

fun main() {
//    //顶层函数的写法
//    topLevelFunc("")
//    //函数对象
//    val a = ::b
//    a.invoke(1)
    //println("hello world")
//    splitPinyin("yang").also {
//        println(it)
//    }
    //println(generateFuzzyPinyinList("蓝色蓝牙真的啊收到就好","lang ya"))

}

private fun testString(input:String) {
    //input = "输出"
}

//fun main() {
//    val str = "hello, hello, world, hello"
//    val subStr = "hello"
//    var index = str.indexOf(subStr)
//
//    while (index >= 0) {
//        println("Found at index: $index")
//        index = str.indexOf(subStr, index + 1)
//    }
//}

fun b(params: Int): String {
    return params.toString()
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

private fun generateFuzzyPinyinList(target: String, inputPy:String): Boolean {
    val last = System.currentTimeMillis()
    val originPinyinList = PinyinHelper.toPinyin(target, PinyinStyleEnum.NORMAL).split(" ")
    val lists = ArrayList<List<String>>() //每个位置可能的模糊发音
    originPinyinList.forEachIndexed { index, word ->
        //分解声母和韵母
        val splitPinyin = splitPinyin(word)
        val fuzzyInitialArray = arrayListOf<String>() //可能模糊匹配的声母
        val fuzzyFinalArray = arrayListOf<String>() //可能模糊匹配的韵母
        fuzzyInitialArray.add(splitPinyin.first)
        fuzzyFinalArray.add(splitPinyin.second)

        //声母在模糊音里
        if (fuzzyInitialMap.containsKey(splitPinyin.first)) {
            fuzzyInitialMap.get(splitPinyin.first)?.apply {
                fuzzyInitialArray.add(this)
            }
        }
        //韵母在模糊音里
        if (fuzzyFinalMap.containsKey(splitPinyin.second)) {
            fuzzyFinalMap.get(splitPinyin.second)?.apply {
                fuzzyFinalArray.add(this)
            }
        }
        //在第index位置可能的模糊匹配
        //println("fuzzyInitialArray: $fuzzyInitialArray, fuzzyFinalArray: $fuzzyFinalArray")
        val pinyinAtIndex = arrayListOf<String>()
        fuzzyInitialArray.forEach { initial ->
            fuzzyFinalArray.forEach { final ->
                pinyinAtIndex.add(initial + final)
            }
        }
        lists.add(pinyinAtIndex)
    }
    val input = inputPy.split(" ")
    var match = false
    var start = 0   //开发查找的位置
    lists.filter {
        it.contains(input[0])
    }.forEach {
        val startIndex = lists.drop(start).indexOf(it) + start
        start++
        if (containsInput(lists, input, startIndex)) {
            match = true
            println(target.substring(startIndex , startIndex + input.size))
            return@forEach
        }
    }
    println(lists)

    return match
}

private fun containsInput(target: List<List<String>>, input: List<String>, startIndex: Int): Boolean {
    var index = 1
    while (index < input.size
        && ((startIndex + index) < target.size)
        && target[startIndex + index].contains(input[index])
    ) {
        index++
    }
    println(index)
    return (index == input.size).also {
        println("startIndex: $startIndex, it:$it")
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