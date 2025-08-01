package com.example.algo.test.Algo.dongtaiguihua;

class BM62 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param n int整型
     * @return int整型
     */
    public int Fibonacci(int n) {
        // write code here
        // switch (n) {
        //    case 1:
        //       return 1;
        //    case 2:
        //       return 1;
        //    default:
        //       return Fibonacci(n - 1) + Fibonacci(n - 2);
        // }
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
           int prepre = 1;
           int pre = 1;
           int cur = 0;
           for (int i = 3; i <= n; i++) {
              cur = prepre + pre;
              prepre = pre;
              pre = cur;
           }

           return cur;
        }
    }
}
