package com.example.algo.test.Algo.shuzu

/**
 * @ProjectName: DemoApp
 * @Description:
 *
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 *
 * @Author: uidq9989
 * @Date: 2025/8/5
 */
object Leetcode59 {
    fun generateMatrix(n: Int): Array<IntArray> {
        val array = Array(n) { IntArray(n) }
        var left = 0
        var right = n - 1
        var top = 0
        var bottom = n - 1

        var count = 1

        while (count <= n * n) {
            // 左 → 右
            for (i in left..right) {
                array[top][i] = count++
            }
            top++

            // 上 → 下
            for (i in top..bottom) {
                array[i][right] = count++
            }
            right--

            // 右 → 左
            for (i in right downTo left) {
                array[bottom][i] = count++
            }
            bottom--

            // 下 → 上
            for (i in bottom downTo top) {
                array[i][left] = count++
            }
            left++
        }

        return array
    }

}

fun main() {
    val n = 9
    val matrix = Leetcode59.generateMatrix(n)

    println("生成的螺旋矩阵为：")
    for (row in matrix) {
        println(row.joinToString(" ") { String.format("%3d", it) })
    }
}
