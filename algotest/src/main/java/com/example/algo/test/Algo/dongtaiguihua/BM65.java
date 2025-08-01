package com.example.algo.test.Algo.dongtaiguihua;

/*
1、确定动态数组的维度，多加一行和一列，可以省去很多麻烦
int[][] dp = new int[chars1.length + 1][chars2.length + 1];
2、
dp含义：dp[i][j]：截取字符串Text1：[0,i-1],Text2：[0,j-1]的最长公共子序列长度

3、状态转移方程：
主要就是两大情况： text1[i-1] 与 text2[j-1]相同，text1[i - 1] 与 text2[j - 1]不相同
step1:如果text1[i - 1] 与 text2[j - 1]相同，第i个和第j个字符相同
那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;

如果text1[i - 1] 与 text2[j - 1]不相同，
那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列
和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。

if (text1[i - 1] == text2[j - 1]) {
    dp[i][j] = dp[i - 1][j - 1] + 1;
} else {
    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
}
*/


import java.util.Arrays;
import java.util.Stack;

class BM65 {
    public static String LCS(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];
        for (int i = 1; i <= chars1.length; i++) {
            boolean flag = true;
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    if (flag) {
                        flag = false;
                    }
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        //得到最长子序列矩阵，需要找出最长的子序列，只有来自左上角的才是
        int i = chars1.length;
        int j = chars2.length;
        Stack<Character> stack = new Stack<>();
        while (dp[i][j] != 0) {
            //向上寻找
            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                //向左寻找
                j--;
            } else if (dp[i][j] > dp[i - 1][j - 1]) {
                //只有左上角的才是要寻找的
                stack.push(chars1[i - 1]);
                i--;
                j--;
            }
        }

        if (stack.isEmpty()) {
            return "-1";
        }

        StringBuilder builder = new StringBuilder();
        //拼接子序列
        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        char[] chars1 = "1A2C3D4B56".toCharArray();
        char[] chars2 = "B1D23A456A".toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];

        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));

        }

        System.out.println(LCS("1A2C3D4B56", "B1D23A456A"));
        // 输出
        // [0, 0, 0, 0]
        // [0, 1, 1, 1]
        // [0, 1, 1, 1]
        // [0, 1, 2, 2]
        // [0, 1, 2, 2]
        // [0, 1, 2, 3]
    }
}
