package com.example.algo.test.Algo.haxi

import com.example.algo.test.Algo.haxi.Leetcode202.isHappy
import com.example.algo.test.Algo.haxi.Leetcode202.nextNum
import com.sun.source.doctree.SummaryTree

/**
 * @ProjectName: DemoApp
 * @Description:
 * @Author: uidq9989
 * @Date: 2025/8/9
 */
object Leetcode202 {
    val set = mutableSetOf<Int>()
    fun isHappy(n: Int): Boolean {
        if (n == 1) {
            return true
        }

        if (set.contains(n)) {
            return false
        } else{
            set.add(n)
            return isHappy(nextNum(n))
        }
    }

    //计算下一个数的平方和
    fun nextNum(number: Int): Int {
        var sum = 0
        var tem = number
        while (tem > 0) {
            sum += (tem % 10) * (tem % 10)
            tem /= 10
        }

        return sum
    }
}

fun printCase(n: Int) {
    println("isHappy($n) = ${isHappy(n)}")
    //println("${nextNum(n)}")
}

fun main() {
    // 单点用例
    //println(nextNum(111))
    val cases = listOf(
        1, 7, 10, 13, 19,   // 一些常见测试点
        2, 3, 4, 5, 6, 8, 9,
        11, 12, 14, 16, 18, 20,
        0, 100, 111, 999, 1000000
    )

    println("=== 指定用例 ===")
    cases.forEach { printCase(it) }

//    // 连续区间小样本
//    println("\n=== 区间用例 1..30 ===")
//    for (i in 1..30) {
//        printCase(i)
//    }
}