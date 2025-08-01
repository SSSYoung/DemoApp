package com.example.algo.test.Algo.dongtaiguihua;

class BM64 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public int minCostClimbingStairs(int[] cost) {
        // write code here

        int length = cost.length;
        // 走到当前台阶是从哪一步，dp[i-1]和dp[i-2]
        // 加上当前当前台阶的花费
        int[] tmp = new int[length];
        tmp[0] = cost[0];
        tmp[1] = cost[1];
        for (int i = 2; i < length; i++) {
            tmp[i] = Math.min(tmp[i - 1], tmp[i - 2]) + cost[i];
        }

        return Math.min(tmp[length - 1], tmp[length - 2]);
    }
}
