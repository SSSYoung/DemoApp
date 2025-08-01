package com.example.algo.test.Algo.dongtaiguihua;

import java.util.Arrays;

class BM68 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public int minPathSum(int[][] matrix) {
        // write code here
       int row = matrix.length;
       int column = matrix[0].length;
       int[][] cost = new int[row + 1][column + 1];

       int minCost = 0;

       for (int i = 1; i <= row; i++) {
          for (int j = 1; j <= column; j++) {
             if (i == 1 && j == 1) {
                cost[i][j] = matrix[i - 1][j - 1];
             } else if (i == 1) {
                cost[i][j] = cost[i][j - 1] + matrix[i - 1][j - 1];
             } else if (j == 1) {
                cost[i][j] = cost[i - 1][j] + matrix[i - 1][j - 1];
             } else {
                cost[i][j] = Math.min(cost[i - 1][j] + matrix[i - 1][j - 1],
                        cost[i][j - 1] + matrix[i - 1][j - 1]);
             }
          }
       }

        return cost[row][column];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2}, {3, 4}
        };
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] cost = new int[row + 1][column + 1];

        int minCost = 0;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                if (i == 1 && j == 1) {
                    cost[i][j] = matrix[i - 1][j - 1];
                } else if (i == 1) {
                    cost[i][j] = cost[i][j - 1] + matrix[i - 1][j - 1];
                } else if (j == 1) {
                    cost[i][j] = cost[i - 1][j] + matrix[i - 1][j - 1];
                } else {
                    cost[i][j] = Math.min(cost[i - 1][j] + matrix[i - 1][j - 1],
                            cost[i][j - 1] + matrix[i - 1][j - 1]);
                }
            }
        }

        for (int[] array : cost) {
            System.out.println(Arrays.toString(array));
        }
    }
}
