package com.example.algo.test.Algo.haxi

import com.example.algo.test.Algo.haxi.Leetcode242.isAnagram

/**
 * @ProjectName: DemoApp
 * @Description:
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的 字母异位词。
 *
 *
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 *
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @Author: uidq9989
 * @Date: 2025/8/8
 */
object Leetcode242 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }

        val array = IntArray(26)
        s.forEach { c: Char ->
            array[c - 'a'] = array[c - 'a'] + 1
        }

        for (c in t) {
            if (array[c - 'a'] - 1 < 0) {
                return false
            } else {
                array[c - 'a'] = array[c - 'a'] - 1
            }
        }

        return true
    }
}

fun main() {
    val testCases = listOf(
        "anagram" to "nagaram",   // true
        "rat" to "car",       // false
        "listen" to "silent",    // true
        "apple" to "papel",     // true
        "hello" to "heloo",     // false
        "" to "",          // true
        "a" to "a",         // true
        "abc" to "cbaa"       // false（长度不同）
    )

    println("Anagram Test Results:")
    for ((s, t) in testCases) {
        val result = isAnagram(
            s,
            t
        )
        println("  \"$s\"  vs  \"$t\"  →  $result")
    }
}