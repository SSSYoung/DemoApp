package com.example.algo.test.Algo.haxi

/**
 * @ProjectName: DemoApp
 * @Description:
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 * 输出：2
 * 解释：
 * 两个元组如下：
 * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 * 示例 2：
 *
 * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 * 输出：1
 * @Author: uidq9989
 * @Date: 2025/8/9
 */
class Leetcode454 {
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        val map1 = mutableMapOf<Int, Int>()

        nums1.forEach { it1->
            nums2.forEach { it2->
                val sum = it1 + it2

                if (map1.containsKey(sum) ) {
                    map1[sum] = map1[sum]!!  + 1
                } else {
                    map1[sum] = 1
                }
            }
        }

        val map2 = mutableMapOf<Int, Int>()

        nums3.forEach { it1->
            nums4.forEach { it2->
                val sum = it1 + it2

                if (map2.containsKey(sum) ) {
                    map2[sum] = map2[sum]!!  + 1
                } else {
                    map2[sum] = 1
                }
            }
        }

        var result = 0

        map1.forEach { t1, u1 ->
            if (map2.containsKey(-t1)) {
                result += u1 * map2.get(-t1)!!
            }
        }

        return result
    }
}

fun main() {
    val solver = Leetcode454()

    // 用例1：正负对称 + 两个 0（长度：3、3、1、1）
    val a1 = intArrayOf(1, 2, 3)
    val b1 = intArrayOf(-1, -2, -3)
    val c1 = intArrayOf(0)
    val d1 = intArrayOf(0)
    println(solver.fourSumCount(a1, b1, c1, d1)) // 预期: 3

    // 用例2：全 0，长度各不相等（长度：3、1、2、4）
    val a2 = intArrayOf(0, 0, 0)
    val b2 = intArrayOf(0)
    val c2 = intArrayOf(0, 0)
    val d2 = intArrayOf(0, 0, 0, 0)
    println(solver.fourSumCount(a2, b2, c2, d2)) // 预期: 24 (3*1*2*4)

    // 用例3：全为正数，无解（长度：3、2、1、3）
    val a3 = intArrayOf(1, 2, 3)
    val b3 = intArrayOf(4, 5)
    val c3 = intArrayOf(6)
    val d3 = intArrayOf(7, 8, 9)
    println(solver.fourSumCount(a3, b3, c3, d3)) // 预期: 0
}