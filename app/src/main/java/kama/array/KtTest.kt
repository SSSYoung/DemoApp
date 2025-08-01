package kama.array

/**
 *
 * @ProjectName:  DemoApp
 * @Desc:
 * @Author:  YangShuang
 * @Date:  2024/4/16
 */
class KtTest {

}

fun main() {
    val  intArrayOf = intArrayOf(-4, -1, 0, 3, 10)
    println(sortedSquares(intArrayOf).toList())
}

fun sortedSquares(nums: IntArray): IntArray {

    return nums.map {
        it * it
    }.sorted().toIntArray()

}