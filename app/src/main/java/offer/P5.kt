package offer

//写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
//
//F(0) = 0,   F(1) = 1
//F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
//斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
//
//答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
//
// 
//
//示例 1：
//
//输入：n = 2
//输出：1
//示例 2：
//
//输入：n = 5
//输出：5
// 
//
//提示：
//
//0 <= n <= 100
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

fun fib(n: Int): Int {
//    val cache = hashMapOf<Int, Int>()
//    var result = -1
//    //递归的解法
//    if (n == 0) {
//        result = 0
//    } else if (n == 1) {
//        result = 1
//    } else {
//        result = cache[n] ?: {
//            val res = (fib(n - 1) + fib(n - 2))
//            cache[n] = res
//            res
//        }
//    }

    //return result

    //循环的解法
    var result = -1
    if (n == 0) {
        result = 0
    } else if (n == 1) {
        result = 1
    } else {
        var prepre = 0
        var pre = 1
        for (i in 2..n) {
            result = (pre + prepre) % 1000000007
            prepre = pre
            pre = result
        }
    }

    return result
}

fun main() {
    println("一共有多少种方法爬楼梯： ${fib(10)}")
}


