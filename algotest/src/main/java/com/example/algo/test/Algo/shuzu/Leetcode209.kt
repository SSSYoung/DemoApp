package com.example.algo.test.Algo.shuzu

import kotlin.math.min

/**
 * @ProjectName: DemoApp
 * @Description:
 * @Author: uidq9989
 * @Date: 2025/8/4
 */

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其总和大于等于 target 的长度最小的 子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 *
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 *
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 *
 *
 * 提示：
 *
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 *
 *
 * 进阶：
 *
 * 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。
 */
object Leetcode209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var sum = 0
        var result = Int.MAX_VALUE
        for (right in nums.indices) {
            sum += nums[right]

            while (sum >= target) {
                sum -= nums[left]
                result = min(
                    result,
                    right - left + 1
                )
                left++
            }
        }

        return if (result == Int.MAX_VALUE) 0 else result
    }
//    fun minSubArrayLen(target: Int, nums: IntArray): Int {
//        var start = 0
//        var result = -1
//        var sum = 0
//
//        while (start < nums.size) {
//            var end = start
//            while (sum < target && end < nums.size) {
//                sum = sum + nums[end]
//                //一直找到
//                end++
//            }
//
//            if (sum >= target) {
//                result = end - start + 1
//            }
//
//            for (i in start until end) {
//                if (sum - nums[i] >= target) {
//                    if (end - i < result) {
//                        result = end - i
//                    }
//                } else {
//                    break
//                }
//            }
//        }
//        return result
//    }
}

fun main() {
    // 测试用例1: 示例用例（官方示例）
    val target1 = 7
    val nums1 = intArrayOf(2, 3, 1, 2, 4, 3)
    val result1 = Leetcode209.minSubArrayLen(target1, nums1)
    println(result1) // 预期输出: 2（子数组 [4,3] 或 [2,3,1,2] 等，但最小长度为2）

    // 测试用例2: 整个数组的和刚好等于目标值
    val target2 = 10
    val nums2 = intArrayOf(1, 2, 3, 4)
    val result2 = Leetcode209.minSubArrayLen(target2, nums2)
    println(result2) // 预期输出: 4（整个数组 [1,2,3,4] 和为10）

    // 测试用例3: 不存在满足条件的子数组
    val target3 = 100
    val nums3 = intArrayOf(1, 2, 3)
    val result3 = Leetcode209.minSubArrayLen(target3, nums3)
    println(result3) // 预期输出: -1（原代码逻辑返回-1，但正确逻辑应为0？需根据方法实际逻辑调整预期）

    // 测试用例4: 单个元素满足目标
    val target4 = 5
    val nums4 = intArrayOf(5)
    val result4 = Leetcode209.minSubArrayLen(target4, nums4)
    println(result4) // 预期输出: 1（子数组 [5]）

    // 测试用例5: 多个可能的子数组，寻找最小长度
    val target5 = 6
    val nums5 = intArrayOf(1, 2, 3, 4, 5)
    val result5 = Leetcode209.minSubArrayLen(target5, nums5)
    println(result5) // 预期输出: 2（子数组 [2,4] 或 [3,3] 等，但原代码逻辑可能不同）
}