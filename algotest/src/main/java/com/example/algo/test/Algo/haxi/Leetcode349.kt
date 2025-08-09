package com.example.algo.test.Algo.haxi

import com.example.algo.test.Algo.haxi.Leetcode349.printCase

/**
 * @ProjectName: DemoApp
 * @Description:
 * 给定两个数组 nums1 和 nums2 ，返回 它们的 交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 * 解释：[4,9] 也是可通过的
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 * @Author: uidq9989
 * @Date: 2025/8/8
 */
object Leetcode349 {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty() || nums2.isEmpty()) {
            return IntArray(0)
        }

        val (short, long) = if (nums1.size > nums2.size) {
            nums2 to nums1  // 解构 Pair
        } else {
            nums1 to nums2  // 解构 Pair
        }

        val shortSet = short.toSet()
        val longSet = long.toSet()
        val result = mutableSetOf<Int>()

        shortSet.forEach {
            if (longSet.contains(it)) {
                result.add(it)
            }
        }

        return result.toIntArray()
    }

    fun printCase(caseName: String, a: IntArray, b: IntArray) {
        val res = intersection(a, b)
        println("$caseName")
        println("  nums1 = ${a.contentToString()}")
        println("  nums2 = ${b.contentToString()}")
        println("  result = ${res.contentToString()}")
        println()
    }
}


fun main() {
    // 示例用例
    printCase("用例1：题目示例一", intArrayOf(1,2,2,1), intArrayOf(2,2))
    printCase("用例2：题目示例二", intArrayOf(4,9,5), intArrayOf(9,4,9,8,4))

    // 其他用例
    printCase("用例3：完全相同", intArrayOf(1,2,3), intArrayOf(1,2,3))
    printCase("用例4：完全不相交", intArrayOf(1,3,5), intArrayOf(2,4,6))
    printCase("用例5：一个为空", intArrayOf(), intArrayOf(1,2,3))
    printCase("用例6：两个都为空", intArrayOf(), intArrayOf())
    printCase("用例7：有重复元素", intArrayOf(1,1,1,2,2,3), intArrayOf(2,2,2,3,3,4))
    printCase("用例8：范围边界值", intArrayOf(0,1000,500,500), intArrayOf(1000,0,0))
}