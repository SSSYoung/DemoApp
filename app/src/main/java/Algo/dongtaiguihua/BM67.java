package Algo.dongtaiguihua;

import java.util.Arrays;

class BM67 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths(int m, int n) {
        // write code here
        // 递归不可取
        // if (m == 1 || n == 1) {
        //     return 1;
        // } else {
        //     return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
        // }
        int[][] steps = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    steps[i][j] = 1;
                } else {
                    steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
                }
            }
        }

        return steps[m][n];
    }

    public static void main(String[] args) {
        int m = 1;
        int n = 2;
        int[][] steps = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    steps[i][j] = 1;
                } else {
                    steps[i][j] = steps[i - 1][j] + steps[i][j - 1];
                }
            }
        }

        for (int[] array : steps) {
            System.out.println(Arrays.toString(array));
        }
    }
}
