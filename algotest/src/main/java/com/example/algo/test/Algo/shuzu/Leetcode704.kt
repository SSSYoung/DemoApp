package com.example.algo.test.Algo.shuzu

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果 target 存在返回下标，否则返回 -1。
 *
 * 你必须编写一个具有 O(log n) 时间复杂度的算法。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 */
/**
 * @ProjectName: DemoApp
 * @Description:
 * @Author: uidq9989
 * @Date: 2025/8/1
 */
class Leetcode704 {
    fun search(nums: IntArray, target: Int): Int {
        var start = 0
        var end = nums.size - 1


        while (start <= end) {
            var mid = (start + end) / 2
            if (nums[mid] > target) {
                end = mid - 1
            } else if (nums[mid] < target) {
                start = mid + 1
            } else {
                return mid
            }
        }

        return -1
    }
}

fun main() {
    //写一些数据测试这个方法
    val leetcode = Leetcode704()

    val testCases = listOf(
        Pair(intArrayOf(-1, 0, 3, 5, 9, 12), 9),     // 预期输出：4
        Pair(intArrayOf(-1, 0, 3, 5, 9, 12), 2),     // 预期输出：-1
        Pair(intArrayOf(1, 2, 3, 4, 5), 1),          // 预期输出：0
        Pair(intArrayOf(1, 2, 3, 4, 5), 5),          // 预期输出：4
        Pair(intArrayOf(1), 1),                      // 预期输出：0
        Pair(intArrayOf(1), 0),                      // 预期输出：-1
        Pair(intArrayOf(2, 4, 6, 8, 10), 8),         // 预期输出：3
        Pair(intArrayOf(2, 4, 6, 8, 10), 7)          // 预期输出：-1
    )

    for ((nums, target) in testCases) {
        val index = leetcode.search(nums, target)
        println("输入数组：${nums.joinToString()}，目标值：$target，返回下标：$index")
    }
}