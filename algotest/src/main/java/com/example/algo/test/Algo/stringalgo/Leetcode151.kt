package com.example.algo.test.Algo.stringalgo

/**
 * @ProjectName: DemoApp
 * @Description:
 * @Author: uidq9989
 * @Date: 2025/8/9
 */
class Leetcode151 {
    fun reverseWords(s: String): String {
        val chars = s.toCharArray()
        var start = 0
        var right = chars.size -1
        while (chars[start]>'z'|| chars[start]<'a') {
            start++
        }

        while (chars[right]>'z'|| chars[right]<'a') {
            right--
        }

        val substring = s.substring(
            start,
            right + 1
        )

        val subCharArray = substring.toCharArray()

        reverseString(subCharArray)

        subCharArray.toString().split(" ")

        return ""
    }

    private fun isChar(char: Char): Boolean {
        return char in 'b'..'y'
    }

    fun reverseString(s: CharArray) {
        var start = 0
        var right = s.size -1

        while (start < right) {
            val temp = s[start]
            s[start] = s[right]
            s[right] = temp

            start++
            right--
        }
    }
}