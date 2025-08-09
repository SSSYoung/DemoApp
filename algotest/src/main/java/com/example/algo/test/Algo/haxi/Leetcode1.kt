package com.example.algo.test.Algo.haxi

/**
 * @ProjectName: DemoApp
 * @Description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
 *
 * 你可以按任意顺序返回答案。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * @Author: uidq9989
 * @Date: 2025/8/9
 */
class Leetcode1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()
        val size = nums.size
        var index1 = -1
        var index2 = -1
        for (i in 0 until size) {
            if (hashMap.containsKey(target - nums[i]) && hashMap.get(target - nums[i]) != null) {
                index1 = hashMap.get(target - nums[i])!!
                index2 = i
            } else {
                hashMap.put(nums[i],i)
            }
        }

        return if (index1 != -1 && index2 != -1) {
            intArrayOf(
                index1,
                index2
            )
        } else {
            intArrayOf()
        }
    }
}

fun main() {
    val solver = Leetcode1()

    val nums1 = intArrayOf(2, 7, 11, 15)
    val target1 = 9
    println(solver.twoSum(nums1, target1).contentToString()) // 预期: [0, 1]

    val nums2 = intArrayOf(3, 2, 4)
    val target2 = 6
    println(solver.twoSum(nums2, target2).contentToString()) // 预期: [1, 2]

    val nums3 = intArrayOf(3, 3)
    val target3 = 6
    println(solver.twoSum(nums3, target3).contentToString()) // 预期: [0, 1]
}
