package com.example.algo.test.Algo.shuzu

import com.example.algo.test.Algo.shuzu.Leetcode977.sortedSquares
import kotlin.math.absoluteValue

/**
 * @ProjectName: DemoApp
 * @Description:
 * 977. 有序数组的平方
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * 示例 2：
 *
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 *
 *
 * 进阶：
 *
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * @Author: uidq9989
 * @Date: 2025/8/4
 */
object Leetcode977 {
    fun sortedSquares(nums: IntArray): IntArray {
//        return nums.map {
//            it.times(it)
//        }.sorted().toIntArray()
        if (nums[0] >= 0) {
            for (i in 0 until nums.size) {
                nums[i] = nums[i] * nums[i]
            }
            return nums
        } else {
            val result = IntArray(nums.size)
            var start = 0
            var end = nums.size - 1
            var cur = nums.size - 1
            while (start <= end) {
                val squareStart = nums[start] * nums[start]
                val suqareEnd = nums[end] * nums[end]

                if (squareStart >= suqareEnd) {
                    result[cur] = squareStart
                    start ++
                } else {
                    result[cur] = suqareEnd
                    end --
                }

                cur--
            }

            return result
        }
    }
}

fun main() {
    // 测试用例1: 包含负数和正数（示例1）
    val nums1 = intArrayOf(-4, -1, 0, 3, 10)
    val result1 = sortedSquares(nums1)
    println(result1.joinToString(", ")) // 预期输出: 0, 1, 9, 16, 100

    // 测试用例2: 包含负数和正数（示例2）
    val nums2 = intArrayOf(-7, -3, 2, 3, 11)
    val result2 = sortedSquares(nums2)
    println(result2.joinToString(", ")) // 预期输出: 4, 9, 9, 49, 121

    // 测试用例3: 全部为非负数（直接平方）
    val nums3 = intArrayOf(0, 2, 3, 5)
    val result3 = sortedSquares(nums3)
    println(result3.joinToString(", ")) // 预期输出: 0, 4, 9, 25

    // 测试用例4: 全部为负数（平方后需逆序）
    val nums4 = intArrayOf(-5, -4, -2, -1)
    val result4 = sortedSquares(nums4)
    println(result4.joinToString(", ")) // 预期输出: 1, 4, 16, 25

    // 测试用例5: 单个元素（0）
    val nums5 = intArrayOf(0)
    val result5 = sortedSquares(nums5)
    println(result5.joinToString(", ")) // 预期输出: 0

    // 测试用例6: 单个元素（负数）
    val nums6 = intArrayOf(-2)
    val result6 = sortedSquares(nums6)
    println(result6.joinToString(", ")) // 预期输出: 4
}