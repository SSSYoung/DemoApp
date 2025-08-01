package com.example.algo.test.Algo.dongtaiguihua;

import java.util.Arrays;

class BM66 {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public static String LCS(String str1, String str2) {
        // write code here
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        //最大长度
        int maxLastIndex = 0;
        //最大的长度
        int maxLength = 0;
        //状态转移数组
        int[][] dp = new int[charArray1.length + 1][charArray2.length + 1];
        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        //更新最大的长度
                        maxLength = dp[i][j];
                        //更新最大长度时的index
                        maxLastIndex = i - 1;
                    }
                }
            }
        }

        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("maxLastIndex===" + maxLastIndex + ", maxLength===" + maxLength);

        //最大长度index-最大长度
        return str1.substring(maxLastIndex - maxLength + 1, maxLastIndex + 1);
    }

    public static void main(String[] args) {
        // char[] charArray1 = "12321".toCharArray();
        // char[] charArray2 = "32147".toCharArray();
        //
        // int result = 0;
        // //状态转移数组
        // int[][] dp = new int[charArray1.length + 1][charArray2.length + 1];
        // for (int i = 1; i <= charArray1.length; i++) {
        //     for (int j = 1; j <= charArray2.length; j++) {
        //         if (charArray1[i - 1] == charArray2[j - 1]) {
        //             dp[i][j] = dp[i - 1][j - 1] + 1;
        //         } else {
        //             //记录一个之前的最大值，就是之前的最长长度
        //             result = Math.max(result, dp[i][j]);
        //         }
        //     }
        // }
        //
        // for (int[] ints : dp) {
        //     System.out.println(Arrays.toString(ints));
        //
        // }

        System.out.println(LCS("12321","32147"));
    }
}
